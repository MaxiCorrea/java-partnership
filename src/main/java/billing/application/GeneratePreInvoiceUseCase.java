package billing.application;

import java.math.BigDecimal;

import billing.domain.PreInvoice;
import integration.ServiceAuthorizedV1;

public class GeneratePreInvoiceUseCase {

	public void handle(
			final ServiceAuthorizedV1 event) {
		
		BigDecimal coPayment = calculateCoPayment(event);
		
		PreInvoice invoice = new PreInvoice(
				event.getAuthorizationId(), 
				event.getAuthorizationAmount(), 
				coPayment);
		
		persist(invoice);
	}

	private BigDecimal calculateCoPayment(
			final ServiceAuthorizedV1 event) {
		return event.getAuthorizationAmount().multiply(new BigDecimal("0.20"));
	}
	
	private void persist(
			final PreInvoice invoice) {
		
	}
	
}
