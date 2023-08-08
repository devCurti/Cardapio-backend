package com.devCurti.Cardapio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devCurti.Cardapio.DTO.FoodRequestDTO;
import com.devCurti.Cardapio.DTO.FoodResponseDTO;
import com.devCurti.Cardapio.entities.Food;
import com.devCurti.Cardapio.repositories.FoodRepository;

@RestController //Informando ao spring que essa classe é um Controller
@RequestMapping(value = "foods") //Informando ao spring que o endpoint é o /foods
public class FoodController {
	
	@Autowired // Injeção de dependencia
	private FoodRepository repository;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping //Indicando que toda vez que o endpoint foods for alcançado será executado esse método
	public List<FoodResponseDTO> getAll() {
		List<FoodResponseDTO> result = repository.findAll().stream().map(FoodResponseDTO::new).toList();
		return result;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping //Indicando que será feito um método POST ou seja, adicionado algo.
	//RequestBody significa que será passado como parametro aquilo que estiver no body.
	public void insert(@RequestBody FoodRequestDTO data) {
		Food foodData = new Food(data);
		repository.save(foodData);
	}
}
