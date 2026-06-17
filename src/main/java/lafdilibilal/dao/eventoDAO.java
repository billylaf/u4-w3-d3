package lafdilibilal.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lafdilibilal.entities.evento;

public class eventoDAO {
    private final EntityManager entityManager;


    public eventoDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void save(evento newEvento) {


        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        this.entityManager.persist(newEvento);

        transaction.commit();

        System.out.println("l'evento" + newEvento + " e' stato salvato nel DB");

    }

    public evento findById(int id) {
        evento fromDB = this.entityManager.find(evento.class, id);
        if (fromDB == null) {
            throw new RuntimeException("Evento con ID " + id + " non trovato");
        }
        return fromDB;
    }

    
}