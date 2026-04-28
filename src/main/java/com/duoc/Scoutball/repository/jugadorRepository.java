package com.duoc.Scoutball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.Scoutball.model.Jugador;

@Repository
public interface JugadorRepository  extends JpaRepository<Jugador, Integer> {


}
