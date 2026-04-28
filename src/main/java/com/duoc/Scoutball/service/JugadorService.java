package com.duoc.Scoutball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.Scoutball.model.Jugador;
import com.duoc.Scoutball.repository.JugadorRepository;


@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public Jugador saveJugador(Jugador jugador){
        return jugadorRepository.save(jugador);
    }

    public List<Jugador> getAllJugadores(){
        return jugadorRepository.findAll();
    }
        public Jugador getJugadorId(Integer jugador_id) {
        return jugadorRepository.findById(jugador_id).orElse(null);
    }

    public Jugador updateJugador(Jugador jugador) {
        if (!jugadorRepository.existsById(jugador.getJugador_id())) {
            return null;
        }
        return jugadorRepository.save(jugador);
    }
    public void deleteJugador(Integer id) {
        jugadorRepository.deleteById(id);
    }
}
