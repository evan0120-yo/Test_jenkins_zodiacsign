package com.zodiac.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Element implements java.io.Serializable {
	// 水火風土
	
	private static final long serialVersionUID = 1L;
	
	private String elementId;
	
	private String elementName;
	
	private String mentalImage;
	
	private Set<ElementTrait> elementTraits;
	
}
