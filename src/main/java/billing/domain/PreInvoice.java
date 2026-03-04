package billing.domain;

import java.math.BigDecimal;

public final class PreInvoice {
	
	private final String authorizationId;
	private final BigDecimal totalAmount;
	private final BigDecimal coPayment;
	
	public PreInvoice(
			final String authorizationId, 
			final BigDecimal totalAmount, 
			final BigDecimal coPayment) {
		this.authorizationId = authorizationId;
		this.totalAmount = totalAmount;
		this.coPayment = coPayment;
	}

	public String getAuthorizationId() {
		return authorizationId;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public BigDecimal getCoPayment() {
		return coPayment;
	}
	
}
