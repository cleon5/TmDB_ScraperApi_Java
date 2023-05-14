package com.example.MongoPrueba;

import com.example.MongoPrueba.Entity.Credits;
import com.example.MongoPrueba.Entity.Pelicula;
import com.example.MongoPrueba.Entity.Videos;
import com.example.MongoPrueba.Entity.Watch;
import com.example.MongoPrueba.Http.HttpGet;
import com.example.MongoPrueba.Service.ServicePeliculas;
import com.example.MongoPrueba.Service.Servicefire;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class Controller {
    private final ServicePeliculas servicePeliculas;
    @Autowired
    Servicefire firebase;
    HttpGet httpget =  new HttpGet();

    @PostMapping("/pelicula")
    public void save(@RequestBody Pelicula pelicula) {
        servicePeliculas.save(pelicula);
    }
    public void firebasePeliculas(Pelicula pelicula) throws ExecutionException, InterruptedException {
        firebase.save2("Peliculas", Integer.toString(pelicula.getId()), pelicula);
    }
    public void firebaseCredicts(Credits credits) throws ExecutionException, InterruptedException {
        firebase.save2("Creditos", Integer.toString(credits.getId()), credits);
    }
    public void firebaseVideos(Videos videos) throws ExecutionException, InterruptedException {
        firebase.save2("Videos", Integer.toString(videos.getId()), videos);
    }
    public void firebaseWatch(Watch watch) throws ExecutionException, InterruptedException {
        firebase.save2("Providers", Integer.toString(watch.getId()), watch);
    }
    public void firebaseLista(Map lista) throws ExecutionException, InterruptedException {
        firebase.save2("Listas", "listaPeli", lista);
    }
    public void saveDouble(Pelicula pelicula, Credits creditos, Videos videos, Watch watch) throws ExecutionException, InterruptedException {
        servicePeliculas.save(pelicula);
        servicePeliculas.save(creditos);
        servicePeliculas.save(videos);
        servicePeliculas.save(watch);


        this.firebasePeliculas(pelicula);
        this.firebaseCredicts(creditos);
        this.firebaseVideos(videos);
        firebaseWatch(watch);
    }



    @GetMapping("/peli")
    public void exe() throws IOException, ExecutionException, InterruptedException {
        int [] lis = {
            105,  19995,  438631, 24428, 791373, 752, 185, 38365, 1726, 9799,
                550, 1954, 272, 603, 13, 601, 10681, 38055, 9016, 10865,
                808, 35, 475557,  871, 11, 103,348, 106, 578, 218,
                49017, 18823, 4935, 129, 597, 162, 12155, 20526, 245891, 70160,
                671, 141, 61695, 927, 22, 10439, 1368, 312221, 1366, 561,
                75780, 111, 238, 1089, 620, 207703, 156022, 619, 205587, 8844,
                76341, 293660, 49538, 2080, 577922, 27205, 68726, 555604, 9479, 8871,
                854, 744, 9003, 7131, 264660, 4011, 680, 78, 38, 1091,
                539, 10494, 62, 9495, 16306, 502356, 424, 120, 324857, 508965,
                846867, 13183, 278, 149, 1359, 8392, 77, 2277, 339403, 644

        };
        Map<String, Pelicula> listPeliculas = new HashMap<String, Pelicula>();

        for(int id: lis){
            Pelicula peli = httpget.GetMovie(id);
            Credits creditos = httpget.GetCredics(id);
            Videos videos = httpget.GetVideos(id);
            Watch watch = httpget.GetWatch(id);

            listPeliculas.put(Integer.toString(peli.getId()), peli);
            System.out.println(peli);
            servicePeliculas.save(watch);

            saveDouble(peli, creditos, videos, watch);

        }
        firebaseLista(listPeliculas);
        servicePeliculas.save(listPeliculas);

        //saveDouble(peli, creditos, videos);
       // this.firebasePeliculas(list);
        //this.firebaseCredicts(creditos);
        //this.firebaseVideos(videos);*/
    }

    @GetMapping("/pelicula")
    public List<Pelicula> findAll() {

        return servicePeliculas.findAll();
    }
    @GetMapping("/pelicula/{id}")
    public Pelicula findById(@PathVariable String id){
        return servicePeliculas.findById(id).get();
    }
    @DeleteMapping("/pelicula/{id}")
    public void deleteById(@PathVariable String id){
        servicePeliculas.delete(id);
    }
    @PutMapping("/pelicula")
    public void update(@RequestBody Pelicula pelicula){
        servicePeliculas.save(pelicula);
    }
}
