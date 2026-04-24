package com.duoc.Scoutball.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.duoc.Scoutball.model.Oferta;

@Repository
public interface ofertaRepository  extends JpaRepository<Oferta, Integer> {


}