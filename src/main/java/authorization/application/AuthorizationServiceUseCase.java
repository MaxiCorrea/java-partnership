package authorization.application;

import java.math.BigDecimal;

import authorization.domain.Authorization;
import authorization.domain.ServiceAuthorized;
import integration.ServiceAuthorizedV1;

public class AuthorizationServiceUseCase {

	private final EventPublisher eventPublisher;
	private final ServiceAuthorizedMapper authorizedMapper;
	
	public AuthorizationServiceUseCase(
			final EventPublisher eventPublisher,
			final ServiceAuthorizedMapper authorizedMapper) {
		this.eventPublisher = eventPublisher;
		this.authorizedMapper = authorizedMapper;
	}
	
	public void execute(
			final Authorization authorization,
			final BigDecimal amount) {
		ServiceAuthorized event = authorization.authorized(amount);
		ServiceAuthorizedV1 eventContract = authorizedMapper.toContract(event);
		eventPublisher.publish(eventContract);
	}
	
}
