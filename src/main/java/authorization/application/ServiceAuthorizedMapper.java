package authorization.application;

import authorization.domain.ServiceAuthorized;
import integration.ServiceAuthorizedV1;

public class ServiceAuthorizedMapper {

	public ServiceAuthorizedV1 toContract(
			final ServiceAuthorized event) {
		return new ServiceAuthorizedV1(
				event.getAuthorizationId(), 
				event.getMemberId(), 
				"PROC-001", 
				event.getAuthorizationAmount(), 
				"GOLD_PLAN", 
				"v1");
	}
	
}
