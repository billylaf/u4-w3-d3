package lafdilibilal.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lafdilibilal.entities.Persona;
import lafdilibilal.entities.evento;

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

        System.out.println("persona" + newPersona + " e' stato salvato nel DB");

    }

    public evento findById(int id) {
        evento fromDB = this.entityManager.find(evento.class, id);
        if (fromDB == null) {
            throw new RuntimeException("persona con ID " + id + " non trovato");
        }
        return fromDB;
    }


}
