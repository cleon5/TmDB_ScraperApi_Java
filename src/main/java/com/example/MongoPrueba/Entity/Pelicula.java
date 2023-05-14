package com.example.MongoPrueba.Entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "peliculas")
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {

    @Id
    private String _id;
    private int id;
    private boolean adult;
    private String backdrop_path;
    private Object belongs_to_collection;
    private String budget;
    private Object genres;
    private String homepage;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private String popularity;
    private String poster_path;
    private Object production_companies;
    private Object production_countries;
    private String release_date;
    private String revenue;
    private int runtime;
    private Object spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private String video;
    private String vote_average;
    private String vote_count;
}
