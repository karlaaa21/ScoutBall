package com.duoc.Scoutball.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.Scoutball.model.Equipo;

@Repository
public interface EquipoRepository  extends JpaRepository<Equipo, Integer> {


}