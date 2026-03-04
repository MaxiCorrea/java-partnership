package authorization.domain;

import java.util.UUID;

public class MemberId {

	private final String id;

	public MemberId() {
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

}
