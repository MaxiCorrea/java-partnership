package integration;

import java.math.BigDecimal;

public class ServiceAuthorizedV1 {

	private final String authorizationId;
	private final String memberId;
	private final String procedureCode;
	private final BigDecimal authorizationAmount;
	private final String planCode;
	private final String eventVersion;

	public ServiceAuthorizedV1(String authorizationId, String memberId, String procedureCode,
			BigDecimal authorizationAmount, String planCode, String eventVersion) {
		super();
		this.authorizationId = authorizationId;
		this.memberId = memberId;
		this.procedureCode = procedureCode;
		this.authorizationAmount = authorizationAmount;
		this.planCode = planCode;
		this.eventVersion = eventVersion;
	}

	public String getAuthorizationId() {
		return authorizationId;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getProcedureCode() {
		return procedureCode;
	}

	public BigDecimal getAuthorizationAmount() {
		return authorizationAmount;
	}

	public String getPlanCode() {
		return planCode;
	}

	public String getEventVersion() {
		return eventVersion;
	}

}
