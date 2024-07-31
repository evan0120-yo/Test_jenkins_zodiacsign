package com.zodiac.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonSign implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String personId;
	
	private String signId;
	
//	private int personScopeNumber;
	private int personSignNumber;
	
	private Integer percent;
	
	// ================
	
	private Sign sign;

}
