package com.duoc.Scoutball.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.duoc.Scoutball.model.Postulacion;
import com.duoc.Scoutball.repository.PostulacionRepository;
import org.springframework.stereotype.Service;

@Service
public class PostulacionService {
    @Autowired
    private PostulacionRepository   postulacionRepository  ;

    public Postulacion savePostulacion(Postulacion postulacion){
        return postulacionRepository .save(postulacion);
    }

    public List<Postulacion> getAllPostulacion(){
        return postulacionRepository .findAll();
    }

        public Postulacion getPostulacionId(Integer postulacion_id) {
        return postulacionRepository .findById(postulacion_id).orElse(null);
    }

    public Postulacion updatePostulacion(Postulacion postulacion) {
        if (!postulacionRepository .existsById(postulacion.getPostulacion_id())) {
            return null;
        }
        return postulacionRepository .save(postulacion);
    }

    public void deletePostulacion(Integer id) {
        postulacionRepository .deleteById(id);
    }
}
