package com.netomedia.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netomedia.workshop.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
