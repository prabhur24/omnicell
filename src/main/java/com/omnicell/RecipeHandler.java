package com.omnicell;

import com.omnicell.data.Recipe;
import com.omnicell.entity.DbRecipe;
import com.omnicell.repository.RecipeRepository;
import com.omnicell.rest.RecipeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeHandler {

	@Autowired
	RecipeRepository recipeRepository;

	public RecipeResponse addRecipe(Recipe recipe) {
		RecipeResponse recipeResponse = RecipeResponse.builder().build();
		DbRecipe dbRecipe = new DbRecipe().toDbModel(recipe);
		dbRecipe = recipeRepository.save(dbRecipe);
		recipeResponse.getRecipes().add(dbRecipe.toDataModel());
		return recipeResponse;
	}

	public RecipeResponse listRecipes() {
		RecipeResponse recipeResponse = RecipeResponse.builder().build();
		List<DbRecipe> dbRecipeList = recipeRepository.findAll();
		dbRecipeList.stream().forEach(dbRecipe -> {
			recipeResponse.getRecipes().add(dbRecipe.toDataModel());
		});
		return recipeResponse;
	}

	public RecipeResponse getRecipeById(Long id) {
		RecipeResponse recipeResponse = RecipeResponse.builder().build();
		Optional<DbRecipe> dbRecipe = recipeRepository.findById(id);
		if (dbRecipe.isPresent()) {
			recipeResponse.getRecipes().add(dbRecipe.get().toDataModel());
		}
		return recipeResponse;
	}
}
