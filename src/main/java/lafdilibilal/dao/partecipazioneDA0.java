package lafdilibilal.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lafdilibilal.entities.Partecipazione;
import lafdilibilal.entities.evento;

public class partecipazioneDA0 {
    private final EntityManager entityManager;


    public partecipazioneDA0(EntityManager em) {
        this.entityManager = em;
    }

    public void save(Partecipazione newPartecipazione) {


        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        this.entityManager.persist(newPartecipazione);

        transaction.commit();

        System.out.println("Partecipazione" + newPartecipazione + " e' stato salvato nel DB");

    }

    public evento findById(int id) {
        evento fromDB = this.entityManager.find(evento.class, id);
        if (fromDB == null) {
            throw new RuntimeException("Partecipazione con ID " + id + " non trovato");
        }
        return fromDB;
    }


}