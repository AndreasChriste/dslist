package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service
//ou @component
public class GameListService {
	//injeta uma instancia com @Autowired do gameListRepository no gameService cada instancia tem seu devido conteúdo
	@Autowired
	private GameListRepository gameListRepository;
		
	@Transactional(readOnly = true)
	//função que retorna uma lista de games
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		//o stream permite realizar algumas operações com sequnecias de dados 
		//o map seleiona cada item e transforma em uma instancia GameminDTO de acordo com cada item
		//toList retorna o stream para lista normal 
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
		
	}
}
