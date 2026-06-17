package lafdilibilal.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lafdilibilal.entities.Persona;

public class personaDAO {
    private final EntityManager entityManager;

    public personaDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void save(Persona newPersona) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newPersona);
        transaction.commit();
        System.out.println("persona " + newPersona + " e' stato salvato nel DB");
    }

    // CORRETTO: ora restituisce Persona invece di evento
    public Persona findById(long id) {
        Persona fromDB = this.entityManager.find(Persona.class, id);
        if (fromDB == null) {
            throw new RuntimeException("Persona con ID " + id + " non trovato");
        }
        return fromDB;
    }
}