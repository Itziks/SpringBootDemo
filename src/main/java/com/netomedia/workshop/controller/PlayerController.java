package com.netomedia.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netomedia.workshop.entity.Player;
import com.netomedia.workshop.repository.PlayerRepository;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;

	@GetMapping("/{id}")
	public Player getPlayer(@PathVariable Long id) throws Exception {
		return playerRepository.findById(id)
				.orElseThrow(() -> new Exception("Player with id: " + id + " doesn't exist"));
	}

	@PostMapping
	public Player createPlayer(@RequestBody Player player) throws Exception {
		if (playerRepository.findById(player.getId()).isPresent()) {
			throw new Exception("Player with id: " + player.getId() + " already exists");
		}
		return playerRepository.save(player);
	}

	@PutMapping
	public Player updatePlayer(@RequestBody Player player) throws Exception {
		playerRepository.findById(player.getId())
				.orElseThrow(() -> new Exception("Player with id: " + player.getId() + " doesn't exist"));
		return playerRepository.save(player);
	}
	
	@DeleteMapping("/{id}")
	public void deletePlayer(@PathVariable final Long id) throws Exception {
		Player player = playerRepository.findById(id)
				.orElseThrow(() -> new Exception("Player with id: " + id + " doesn't exist"));
		 
		playerRepository.delete(player);
	}
}
