package in.cmss.icici.uotm.identity.service;

import in.cmss.icici.uotm.identity.vo.login.LoginResponseVO;
import reactor.core.publisher.Mono;

public interface IdentityService {

	Mono<LoginResponseVO> login(String username, String password);
}
