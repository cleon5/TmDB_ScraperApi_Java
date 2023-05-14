package com.example.MongoPrueba.Service;

import com.example.MongoPrueba.Entity.Credits;
import com.example.MongoPrueba.Entity.Pelicula;
import com.example.MongoPrueba.Entity.Videos;
import com.example.MongoPrueba.Entity.Watch;
import com.example.MongoPrueba.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicePeliculas {
    private final RepoPeliculas repoPeliculas;
    private final RepoCreditos repoCreditos;
    private final RepoVideos repoVideos;
    private final RepoWatch repoWatch;
    private final RepoLista repoLista;


    public void save(Pelicula pelicula){
        repoPeliculas.save(pelicula);
    }
    public void save(Credits credicts){
        repoCreditos.save(credicts);
    }
    public void save(Videos videos){
        repoVideos.save(videos);
    }
    public void save(Watch watch){
        repoWatch.save(watch);
    }
    public void save(Map list){
        repoLista.save(list);
    }


    public List<Pelicula> findAll(){
        return repoPeliculas.findAll();
    }
    public Optional<Pelicula> findById(String id){
        return repoPeliculas.findById(id);
    }
    public void delete(String id){
        repoPeliculas.deleteById(id);
    }

}
