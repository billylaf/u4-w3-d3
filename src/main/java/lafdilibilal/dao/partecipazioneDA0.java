package lafdilibilal.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lafdilibilal.entities.Partecipazione;

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
        System.out.println("Partecipazione " + newPartecipazione + " e' stato salvato nel DB");
    }

    // CORRETTO: ora restituisce Partecipazione invece di evento
    public Partecipazione findById(long id) {
        Partecipazione fromDB = this.entityManager.find(Partecipazione.class, id);
        if (fromDB == null) {
            throw new RuntimeException("Partecipazione con ID " + id + " non trovato");
        }
        return fromDB;
    }
}