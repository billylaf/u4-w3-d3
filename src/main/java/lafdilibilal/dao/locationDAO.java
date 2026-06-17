package lafdilibilal.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lafdilibilal.entities.Location;

public class locationDAO {
    private final EntityManager entityManager;


    public locationDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void save(Location newLocation) {


        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        this.entityManager.persist(newLocation);

        transaction.commit();

        System.out.println("Location" + newLocation + " e' stato salvato nel DB");

    }

    public Location findById(long id) {
        Location fromDB = this.entityManager.find(Location.class, id);
        if (fromDB == null) {
            throw new RuntimeException("Location con ID " + id + " non trovato");

        }
        return fromDB;
    }

}
