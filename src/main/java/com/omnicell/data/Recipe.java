package com.omnicell.data;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
public class Recipe {

	private Long id;

	@NotNull
	private String name;

	private String image;

	private String category;

	private String label;

	private Double price;

	private String description;

}
