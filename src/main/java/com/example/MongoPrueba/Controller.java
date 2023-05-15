package com.example.MongoPrueba;

import com.example.MongoPrueba.Entity.*;
import com.example.MongoPrueba.Http.HttpGet;
import com.example.MongoPrueba.Service.ServicePeliculas;
import com.example.MongoPrueba.Service.Servicefire;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public void firebaseSeries(Tv serie) throws ExecutionException, InterruptedException {
        firebase.save2("Series", Integer.toString(serie.getId()), serie);
    }
    public void firebaseCaricaturas(Tv serie) throws ExecutionException, InterruptedException {
        firebase.save2("Caricaturas", Integer.toString(serie.getId()), serie);
    }
    public void firebaseAnime(Tv serie) throws ExecutionException, InterruptedException {
        firebase.save2("Animes", Integer.toString(serie.getId()), serie);
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

    public void firebaseCredictsSeries(Credits credits) throws ExecutionException, InterruptedException {
        firebase.save2("CreditosSeries", Integer.toString(credits.getId()), credits);
    }
    public void firebaseVideoSeries(Videos videos) throws ExecutionException, InterruptedException {
        firebase.save2("VideosSeries", Integer.toString(videos.getId()), videos);
    }
    public void firebaseWatchSeries(Watch watch) throws ExecutionException, InterruptedException {
        firebase.save2("ProvidersSeries", Integer.toString(watch.getId()), watch);
    }


    public void firebaseLista(Map lista, String doc) throws ExecutionException, InterruptedException {
        firebase.save2("Listas", doc, lista);
    }

    public void saveDouble(Pelicula pelicula, Credits creditos, Videos videos, Watch watch) throws ExecutionException, InterruptedException {
        servicePeliculas.save(pelicula);
        servicePeliculas.save(creditos);
        servicePeliculas.save(videos);
        servicePeliculas.save(watch);

        this.firebasePeliculas(pelicula);
        this.firebaseCredicts(creditos);
        this.firebaseVideos(videos);
        this.firebaseWatch(watch);
    }

    public void saveDoubleSeries(Tv serie, Credits creditos, Videos videos, Watch watch) throws ExecutionException, InterruptedException {
        servicePeliculas.save(serie);
        servicePeliculas.save(creditos);
        servicePeliculas.save(videos);
        servicePeliculas.save(watch);

        this.firebaseSeries(serie);
        this.firebaseCredictsSeries(creditos);
        this.firebaseVideoSeries(videos);
        firebaseWatchSeries(watch);
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
            Credits creditos = httpget.GetCredics(id, "movie/");
            Videos videos = httpget.GetVideos(id,"movie/");
            Watch watch = httpget.GetWatch(id, "movie/");

            listPeliculas.put(Integer.toString(peli.getId()), peli);
            System.out.println(peli);
            servicePeliculas.save(watch);

            saveDouble(peli, creditos, videos, watch);

        }
        firebaseLista(listPeliculas, "listaPeli");
        servicePeliculas.save(listPeliculas);

        //saveDouble(peli, creditos, videos);
       // this.firebasePeliculas(list);
        //this.firebaseCredicts(creditos);
        //this.firebaseVideos(videos);*/
    }
    @GetMapping("/series")
    public void Series() throws IOException, ExecutionException, InterruptedException {
        int [] series = {
                1668, 2004, 4087, 79788, 76479, 42009, 86831, 46952, 96677, 206709,
                119051, 66732, 82856, 100088,63174, 90802, 71712, 30991, 69478, 71446,
                119051,1622,60574,1399, 1402, 46786, 4604, 19885, 1396, 60059,
                2316, 39272, 1418, 63247, 93405, 70523, 63639, 62560, 75006, 69740,
                2038, 113036, 40008, 87739, 60573, 68421, 58474, 63314, 46648, 1416,
                81356, 655, 48891, 83659, 2288, 87108, 1398, 60059, 6357, 85552,
                67070,60622, 76331, 501, 4607, 48866, 44217, 1425, 71912, 1920,
                46639, 61664, 56296, 39351, 84958, 57243,1424, 5371, 1892, 70785,
                2691, 1100, 1705, 5920, 1639, 63351, 1973, 1778,2352, 86340,
                4658, 47640, 46331, 1104, 95396, 2382, 46533, 1406, 65494, 71915,
                93784, 90669
        };
        int [] caricaturas = {
                91425, 61617,  456, 60625,  61222, 33217, 1434, 2660, 15260,38693,
                4229, 1719, 95557, 4336, 92685,31132,32118, 3793,  18123, 40075,
                2129, 346, 1720, 37606, 61175, 7842, 2228, 615, 73021, 74387,
                94605, 2309, 604, 96713, 2190, 74440, 387, 91363, 606, 63401,
                2723, 1546, 89456, 1988, 4574, 888, 61593, 4194, 4686, 3854,
                33623, 1618,  61923, 10331, 97727, 709, 2122, 4232, 1877, 2355,
                65334, 240, 2405, 10283, 7821, 985, 1996, 2362, 32605, 8392,
                135918, 6782, 97645, 2131, 897, 4630, 3022, 537, 82, 2416,
                607, 288, 4429, 4303, 2098, 653, 657, 10926, 2345, 2005,
                46080,  1615, 3319, 720, 7869, 51817, 46994, 68267, 44305, 1769,
        };
        int [] animes = {
                64706, 64710, 98986, 57911, 38464, 94664, 95269, 12406, 34109, 99778,
                1063, 26453, 42705, 43865, 83100, 46261, 60572, 42444, 16830, 30669,
                60808, 1095, 1097, 60728, 3570, 30983, 57706, 28136, 30984, 31654,
                45950, 62104, 61374, 67075, 80564, 75208, 86031, 61459, 79141, 902,
                83097, 76121, 82739, 65844, 93149, 72636, 84669, 88046, 83095, 46004,
                105009,  120089, 112163, 25707, 19253, 12504, 668, 2192, 72305, 90937,
                33880, 246, 96316, 62110, 45790, 45782, 80623, 35610,  71024, 114868,
                1087, 42589, 61223, 12598, 95479, 73223, 37863, 12609, 31724, 64196,
                35935, 88803, 30991, 37854, 65930, 46260, 46298, 1429, 85937, 63926,
                890, 42509, 42671, 13916, 114410, 30981, 105248, 75214, 31911, 112160,
        };

        Map<String, Tv> listSeries = new HashMap<String, Tv>();
        Map<String, Tv> listCaricaturas= new HashMap<String, Tv>();
        Map<String, Tv> listAnime = new HashMap<String, Tv>();

        for(int id: series){
            Tv serie = httpget.GetTv(id);
            Credits creditos = httpget.GetCredics(id, "tv/");
            Videos videos = httpget.GetVideos(id,"tv/");
            Watch watch = httpget.GetWatch(id, "tv/");

            listSeries.put(Integer.toString(serie.getId()), serie);
            System.out.println(serie);
            saveDoubleSeries(serie, creditos, videos, watch);
        }
        for(int id: caricaturas){
            Tv caricatura = httpget.GetTv(id);
            Credits creditos = httpget.GetCredics(id, "tv/");
            Videos videos = httpget.GetVideos(id,"tv/");
            Watch watch = httpget.GetWatch(id, "tv/");

            listCaricaturas.put(Integer.toString(caricatura.getId()), caricatura);
            System.out.println(caricatura);
            saveDoubleSeries(caricatura, creditos, videos, watch);
        }
        for(int id: animes){
            Tv anime = httpget.GetTv(id);
            Credits creditos = httpget.GetCredics(id, "tv/");
            Videos videos = httpget.GetVideos(id,"tv/");
            Watch watch = httpget.GetWatch(id, "tv/");

            listAnime.put(Integer.toString(anime.getId()), anime);
            System.out.println(anime);
            saveDoubleSeries(anime, creditos, videos, watch);
        }
        firebaseLista(listSeries, "listaSeries");
        servicePeliculas.save(listSeries);

        firebaseLista(listCaricaturas, "listaCaricaturas");
        servicePeliculas.save(listCaricaturas);

        firebaseLista(listAnime, "listaAnimes");
        servicePeliculas.save(listAnime);

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
