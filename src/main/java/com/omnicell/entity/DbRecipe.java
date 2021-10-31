package com.omnicell.entity;


import com.google.gson.Gson;
import com.omnicell.data.Recipe;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "recipe")
public class DbRecipe {

	@Id
	@SequenceGenerator(allocationSize = 1, name = "recipe_sequence", sequenceName = "recipe_sequence")
	@GeneratedValue(generator = "recipe_sequence", strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Column(name = "name", length = 255)
	private String name;

	@Column(name = "image")
	private String image;

	@Column(name = "category")
	private String category;

	@Column(name = "label")
	private String label;

	@Column(name = "price", precision = 2)
	private Double price;

	@Column(name = "description")
	private String description;

	public DbRecipe toDbModel(Recipe recipe) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(recipe), DbRecipe.class);
	}

	public Recipe toDataModel() {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(this), Recipe.class);
	}
}
