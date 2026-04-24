package com.duoc.Scoutball.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.duoc.Scoutball.model.Oferta;
import com.duoc.Scoutball.repository.ofertaRepository;
import org.springframework.stereotype.Service;

@Service
public class OfertaService {
    @Autowired
    private ofertaRepository   ofertaRepository  ;

    public Oferta saveOferta(Oferta oferta){
        return ofertaRepository .save(oferta);
    }

    public List<Oferta> getAllOferta(){
        return ofertaRepository .findAll();
    }
        public Oferta getOfertaId(Integer oferta_id) {
        return ofertaRepository .findById(oferta_id).orElse(null);
    }

    public Oferta updateOferta(Oferta oferta) {
        if (!ofertaRepository .existsById(oferta.getOferta_id())) {
            return null;
        }
        return ofertaRepository .save(oferta);
    }
    public void deleteOferta(Integer id) {
        ofertaRepository .deleteById(id);
    }
}

