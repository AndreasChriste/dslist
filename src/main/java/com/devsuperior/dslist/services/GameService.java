package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
//ou @component
public class GameService {
	//injeta uma instancia com @Autowired do gameRepository no gameService cada instancia tem seu devido conteúdo
	@Autowired
	private GameRepository gameRepository;
	
	//função que retorna uma lista de games
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		//o stream permite realizar algumas operações com sequnecias de dados 
		//o map seleiona cada item e transforma em uma instancia GameminDTO de acordo com cada item
		//toList retorna o stream para lista normal 
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
	}
}
