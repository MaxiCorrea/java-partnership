package authorization.domain;

import java.math.BigDecimal;

public class Authorization {

	private final AuthorizationId id;
	private final MemberId memberId;
	private AuthorizationStatus status;
	private BigDecimal authorizedAmount;
	
	public Authorization(
			final MemberId memberId) {
		this.id = new AuthorizationId();
		this.memberId = memberId;
		this.status = AuthorizationStatus.PENDING;
	}
	
	public ServiceAuthorized authorized(
			final BigDecimal amount) {
		this.status = AuthorizationStatus.APPROVED;
		this.authorizedAmount = amount;
		return new ServiceAuthorized(
				id.getId(),
				memberId.getId(),
				authorizedAmount
		);
	}
	
	public AuthorizationStatus getStatus() {
		return status;
	}
	
	
}
