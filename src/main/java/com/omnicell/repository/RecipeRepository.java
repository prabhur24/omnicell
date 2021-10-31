package com.omnicell.repository;

import com.omnicell.entity.DbRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipeRepository extends JpaRepository<DbRecipe, Long> {
}
