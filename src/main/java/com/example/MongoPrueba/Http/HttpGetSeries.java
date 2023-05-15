package com.example.MongoPrueba.Http;
import com.example.MongoPrueba.Entity.*;
import com.example.MongoPrueba.Service.Servicefire;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class HttpGetSeries {
    Servicefire firebase = new Servicefire();
    Gson gson = new Gson();
    String linea;
    StringBuilder resultado = new StringBuilder();
    String base = "https://api.themoviedb.org/3/movie/";
    String baseSerie = "https://api.themoviedb.org/3/tv/";
    String key = "?api_key=a2b6ad9056e64a591e4c8a348de51860";

    public Tv GetTv(int movieID) throws IOException {
        URL urlMovie = new URL(base + movieID + key);

        HttpURLConnection conexion = (HttpURLConnection) urlMovie.openConnection();
        conexion.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        resultado = new StringBuilder();
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        rd.close();

        Tv serie = gson.fromJson(resultado.toString(), Tv.class);

        return serie;
    }

    public Videos GetVideosSeries(int movieID) throws IOException {
        URL urlVideos = new URL(base + movieID + "/videos" + key);
        HttpURLConnection conexion2 = (HttpURLConnection) urlVideos.openConnection();
        conexion2.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion2.getInputStream()));
        resultado = new StringBuilder();

        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        rd.close();
        Videos video = gson.fromJson(resultado.toString(), Videos.class);
        return video;
    }

    public Credits GetCredicsSeries(int movieID) throws IOException {
        URL urlCreditos = new URL(base + movieID + "/credits" + key);
        HttpURLConnection conexion2 = (HttpURLConnection) urlCreditos.openConnection();
        conexion2.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion2.getInputStream()));
        resultado = new StringBuilder();
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        rd.close();
        Credits creditos = gson.fromJson(resultado.toString(), Credits.class);
        return creditos;
    }
    public Watch GetWatchSeries(int movieID) throws IOException {
        URL urlProviders = new URL(base + movieID + "/watch/providers" + key);
        HttpURLConnection conexion2 = (HttpURLConnection) urlProviders.openConnection();
        conexion2.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion2.getInputStream()));
        resultado = new StringBuilder();
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        rd.close();
        Watch watch = gson.fromJson(resultado.toString(), Watch.class);
        Map<String, Object> o = (Map<String, Object>) watch.getResults();
        System.out.println(o.get("MX"));
        System.out.println(o.get("US"));

        List<Object> o2 = new ArrayList<Object>();;
        o2.add(o.get("US"));
        o2.add(o.get("MX"));

        watch.setResults(o2);
        System.out.println(watch.getResults());


        return watch;
    }
    public Credits GetListaSeries(int movieID) throws IOException {
        URL urlCreditos = new URL(base + movieID + "/credits" + key);
        HttpURLConnection conexion2 = (HttpURLConnection) urlCreditos.openConnection();
        conexion2.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion2.getInputStream()));
        resultado = new StringBuilder();
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        rd.close();
        Credits creditos = gson.fromJson(resultado.toString(), Credits.class);
        return creditos;
    }
}
