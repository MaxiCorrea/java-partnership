package authorization.application;

import integration.ServiceAuthorizedV1;

public interface EventPublisher {

	void publish(ServiceAuthorizedV1 authorizedV1);
	
}
