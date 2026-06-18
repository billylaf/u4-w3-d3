package lafdilibilal.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lafdilibilal.entities.Concerto;
import lafdilibilal.entities.Genere;
import lafdilibilal.entities.evento;

import java.util.List;

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

    public List<Concerto> getConcertiInStreaming(boolean streaming) {
        TypedQuery<Concerto> query = entityManager.createQuery(
                "SELECT c FROM Concerto c WHERE c.streaming = :streaming", Concerto.class);
        query.setParameter("streaming", streaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(Genere genere) {
        TypedQuery<Concerto> query = entityManager.createQuery(
                "SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
        // SELECT * FROM concerti WHERE genere = 'POP'
    }


}