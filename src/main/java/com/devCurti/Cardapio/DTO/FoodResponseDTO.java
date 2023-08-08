package com.devCurti.Cardapio.DTO;

import com.devCurti.Cardapio.entities.Food;
//DTO ou Data Transfer Object Serve como uma classe que armazena os dados que serão dados como resposta
public record FoodResponseDTO(Long id, String title, String img, int price) {
	public FoodResponseDTO(Food food) {
		this(food.getId(), food.getTitle(), food.getImg(), food.getPrice());
	}
}
