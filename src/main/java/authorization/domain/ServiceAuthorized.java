package authorization.domain;

import java.math.BigDecimal;

public final class ServiceAuthorized {

	private final String authorizationId;
	private final String memberId;
	private final BigDecimal authorizationAmount;

	public ServiceAuthorized(
			final String authorizationId, 
			final String memberId, 
			final BigDecimal authorizedAmount) {
		
		this.authorizationId = authorizationId;
		this.memberId = memberId;
		this.authorizationAmount = authorizedAmount;
	}

	public String getAuthorizationId() {
		return authorizationId;
	}

	public String getMemberId() {
		return memberId;
	}

	public BigDecimal getAuthorizationAmount() {
		return authorizationAmount;
	}

	
	
}
