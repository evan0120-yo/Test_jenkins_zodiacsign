package com.zodiac.model.id;

import lombok.Data;

@Data
public class PersonSignId implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private String personId;
	
	private String signId;
	
	private int personScopeNumber;
}
