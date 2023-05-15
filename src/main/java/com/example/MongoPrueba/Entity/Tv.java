package com.example.MongoPrueba.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "tv")
public class Tv {
    @Id
    private String _id;

    private boolean adult;
    private String backdrop_path;
    private Object created_by;
    private Object episode_run_time;
    private String first_air_date;
    private Object genres;
    private String homepage;
    private int id;
    private boolean in_production;
    private Object languages;

    private String last_air_date;
    private Object last_episode_to_air;
    private String name;
    private Object next_episode_to_air;
    private Object networks;
    private int number_of_episodes;
    private int number_of_seasons;
    private Object origin_country;
    private String original_language;
    private String original_name;

    private String overview;
    private String popularity;
    private String poster_path;
    private Object production_companies;
    private Object production_countries;
    private Object seasons;
    private Object spoken_languages;
    private String status;
    private String tagline;
    private String type;

    private float vote_average;
    private float vote_count;

}
