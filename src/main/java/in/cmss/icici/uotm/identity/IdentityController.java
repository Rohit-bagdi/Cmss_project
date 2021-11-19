package in.cmss.icici.uotm.identity;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.cmss.icici.uotm.identity.service.IdentityServiceFactory;
import in.cmss.icici.uotm.identity.vo.EngageResponse;
import in.cmss.icici.uotm.identity.vo.device.DeviceResponseVO;
import in.cmss.icici.uotm.identity.vo.login.LoginRequestVO;
import in.cmss.icici.uotm.identity.vo.login.LoginResponseVO;
import in.cmss.icici.uotm.identity.vo.pin.create.CreatePinRequestVO;
import in.cmss.icici.uotm.identity.vo.pin.create.CreatePinResponseVO;
import in.cmss.icici.uotm.identity.vo.pin.reset.ResetPinRequestVO;
import in.cmss.icici.uotm.identity.vo.pin.reset.ResetPinResponseVO;
import in.cmss.icici.uotm.identity.vo.register.RegisterRequestVO;
import in.cmss.icici.uotm.identity.vo.register.RegisterResponseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/identity")
@Tag(description = "features of Identity like register, create pin, login, etc.", name = "Identity")
@Slf4j
public class IdentityController {

	@Autowired
	IdentityServiceFactory identityServiceFactory;

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful Registration", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = RegisterResponseVO.class)) }),
			@ApiResponse(responseCode = "400", description = "Client Validation Errors", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EngageResponse.class)) }) })
	@Operation(summary = "Registration API with username and password")
	@PostMapping(path = "/regsiter", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Mono<RegisterResponseVO> register(
			@Valid @RequestBody RegisterRequestVO payload) {
		RegisterResponseVO response = RegisterResponseVO.builder()
				.message("Registration Successful")
				.build();
		return Mono.just(response);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "PIN creation successful", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CreatePinResponseVO.class)) }),
			@ApiResponse(responseCode = "400", description = "Client Validation Errors", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EngageResponse.class)) }) })
	@Operation(summary = "Create 4 digit PIN")
	@PostMapping(path = "/create-pin", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Mono<CreatePinResponseVO> createPin(
			@Valid @RequestBody CreatePinRequestVO payload) {
		CreatePinResponseVO response = CreatePinResponseVO.builder()
				.employee(IdentityServiceFactory.employee())
				.message("PIN creation Successful")
				.pin("c8gjbR2igVE7Et15eaJGdg%253D%253D")
				.build();
		return Mono.just(response);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "PIN reset successful", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ResetPinResponseVO.class)) }),
			@ApiResponse(responseCode = "400", description = "Client Validation Errors", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EngageResponse.class)) }) })
	@Operation(summary = "Reset 4 digit PIN")
	@PostMapping(path = "/reset-pin", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Mono<ResetPinResponseVO> resetPin(
			@Valid @RequestBody ResetPinRequestVO payload) {
		ResetPinResponseVO response = ResetPinResponseVO.builder()
				.message("PIN Registration Successful")
				.pin("c8gjbR2igVE7Et15eaJGdg%253D%253D")
				.build();
		return Mono.just(response);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Login successful response", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = LoginResponseVO.class)) }),
			@ApiResponse(responseCode = "400", description = "Client Validation Errors", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EngageResponse.class)) }) })
	@Operation(summary = "Login API with central validation demonstration")
	@PostMapping(path = "/login", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Mono<LoginResponseVO> login(
			@RequestParam(name = "type", defaultValue = "web") String type,
			@Valid @RequestBody LoginRequestVO payload) {
		log.info("Request Type: {} payload: {}", type, payload);
		return identityServiceFactory.get(type)
				.login(payload.getUsername(), payload.getPassword())
				.log();
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Registered Device List", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = DeviceResponseVO.class)) }),
			@ApiResponse(responseCode = "400", description = "Client Validation Errors", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EngageResponse.class)) }) })
	@Operation(summary = "Device API for list of devices registrated with employee id")
	@GetMapping(path = "/{employee_id}/devices", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Mono<DeviceResponseVO> devices(
			@PathVariable("employee_id") String employeeId) {
		DeviceResponseVO response = DeviceResponseVO.builder()
				.devices(IdentityServiceFactory.devices())
				.build();
		return Mono.just(response);
	}

}
