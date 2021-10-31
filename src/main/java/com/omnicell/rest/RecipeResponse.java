package com.omnicell.rest;

import com.omnicell.data.Recipe;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
public class RecipeResponse {

	private List<Recipe> recipes;

	public List<Recipe> getRecipes() {
		if (recipes == null || recipes.isEmpty()) {
			recipes = new ArrayList<>();
		}
		return recipes;
	}
}
