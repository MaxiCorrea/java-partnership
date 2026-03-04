package authorization.domain;

import java.util.UUID;

public final class AuthorizationId {

	private final String id;
	
	public AuthorizationId() {
		id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	
}
