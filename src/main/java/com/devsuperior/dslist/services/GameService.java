package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
//ou @component
public class GameService {
	//injeta uma instancia com @Autowired do gameRepository no gameService cada instancia tem seu devido conteúdo
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	
	@Transactional(readOnly = true)
	//função que retorna uma lista de games
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		//o stream permite realizar algumas operações com sequnecias de dados 
		//o map seleiona cada item e transforma em uma instancia GameminDTO de acordo com cada item
		//toList retorna o stream para lista normal 
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	//função que retorna uma lista de games
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		//o stream permite realizar algumas operações com sequnecias de dados 
		//o map seleiona cada item e transforma em uma instancia GameminDTO de acordo com cada item
		//toList retorna o stream para lista normal 
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}
