package com.devCurti.Cardapio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devCurti.Cardapio.entities.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
	
}
