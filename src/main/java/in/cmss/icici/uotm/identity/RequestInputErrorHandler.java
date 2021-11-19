package in.cmss.icici.uotm.identity;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.cmss.icici.uotm.core.database.ErrorMessage;
import in.cmss.icici.uotm.core.database.ErrorService;
import in.cmss.icici.uotm.identity.vo.EngageError;
import in.cmss.icici.uotm.identity.vo.EngageResponse;

@RestControllerAdvice
public class RequestInputErrorHandler {

	@Autowired
	private ErrorService errorService;

	// TODO: decide HTTP response code
	// HttpStatus.BAD_REQUEST or HttpStatus.UNPROCESSABLE_ENTITY
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@NewSpan("error_resolution")
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected EngageResponse handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex) {
		List<ObjectError> errors = ex.getBindingResult().getAllErrors();

		List<Integer> codes = errors.stream()
				.map(e -> Integer.valueOf(e.getDefaultMessage()))
				.collect(Collectors.toList());

		List<ErrorMessage> errorsDb = errorService.getErrorwithCodes(codes);

		List<EngageError> lstErrors = errorsDb.stream()
				.map(error -> EngageError.toError(error))
				.collect(Collectors.toList());

		EngageResponse response = EngageResponse.builder()
				.message("Bad Request")
				.error(lstErrors)
				.build();

		return response;
	}

}
