package com.duoc.Scoutball.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.duoc.Scoutball.model.Postulacion;

@Repository
public interface postulacionRepository  extends JpaRepository<Postulacion, Integer> {


}