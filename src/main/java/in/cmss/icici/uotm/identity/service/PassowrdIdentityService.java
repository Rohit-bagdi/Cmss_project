package in.cmss.icici.uotm.identity.service;

import org.springframework.stereotype.Component;

import in.cmss.icici.uotm.identity.vo.login.LoginResponseVO;
import reactor.core.publisher.Mono;

@Component
public class PassowrdIdentityService implements IdentityService {

	@Override
	public Mono<LoginResponseVO> login(String username, String password) {
		return Mono.just(IdentityServiceFactory.sample());
		
	}

}
