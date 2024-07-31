package com.zodiac.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElementTrait implements java.io.Serializable {
	// 四大像系的特徵

	private static final long serialVersionUID = 1L;
	
	private String elementTraitId;
	
	private String elementId;
	
	private String content;
}
