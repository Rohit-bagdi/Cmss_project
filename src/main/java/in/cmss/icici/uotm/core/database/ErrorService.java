package in.cmss.icici.uotm.core.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;

@Service
public class ErrorService {

	@Autowired
	ErrorRepository errorRepository;
	
	@NewSpan("db")
	public List<ErrorMessage> getErrorwithCodes(List<Integer> codes) {
		return errorRepository.findAllById(codes);
	}
}
