package com.example.MongoPrueba.Service;

import com.example.MongoPrueba.Entity.Pelicula;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
@Service
public class Servicefire {
    public String save(Pelicula peli) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture  = dbFirestore.collection("Peliculas").document(peli.getTitle()).set(peli);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String save2(String collection,String doc, Object dato) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture  = dbFirestore.collection(collection).document(doc).set(dato);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
}
