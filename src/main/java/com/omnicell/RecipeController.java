package com.omnicell;

import com.omnicell.data.Recipe;
import com.omnicell.rest.RecipeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotNull;

@RequestMapping("recipe")
@RestController
public class RecipeController {

	@Autowired
	RecipeHandler recipeHandler;


	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public RecipeResponse addRecipe(@RequestBody @NotNull Recipe recipe) {
		return recipeHandler.addRecipe(recipe);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public RecipeResponse getRecipe(@PathVariable("id") @NotNull Long id) {
		return recipeHandler.getRecipeById(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public RecipeResponse listRecipes() {
		return recipeHandler.listRecipes();
	}
}
