package com.duoc.Scoutball.service;

import com.duoc.Scoutball.dto.EquipoDetalleDTO;
import com.duoc.Scoutball.model.Equipo;
import com.duoc.Scoutball.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EquipoService {
    @Autowired
    private EquipoRepository  equipoRepository ;

    public Equipo saveEquipo(Equipo equipo){
        return equipoRepository.save(equipo);
    }

    public List<Equipo> getAllEquipos(){
        return equipoRepository.findAll();
    }
        public Equipo getEquipoId(Integer equipo_id) {
        return equipoRepository.findById(equipo_id).orElse(null);
    }

    public Equipo updateEquipo(Equipo equipo) {
        if (!equipoRepository.existsById(equipo.getId())) {
            return null;
        }
        return equipoRepository.save(equipo);
    }
    public void deleteEquipo(Integer id) {
        equipoRepository.deleteById(id);
    }

     public List<EquipoDetalleDTO> getEquipoDetalleDTO() {
        return equipoRepository.findAll().stream()
                .map(equipo -> new EquipoDetalleDTO(
                        equipo.getTecnico(),
                        equipo.getNombre_equipo()
                ))
                .toList();
    }



}




