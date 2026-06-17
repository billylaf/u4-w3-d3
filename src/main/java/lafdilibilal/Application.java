package lafdilibilal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lafdilibilal.dao.eventoDAO;
import lafdilibilal.dao.locationDAO;
import lafdilibilal.dao.partecipazioneDA0;
import lafdilibilal.dao.personaDAO;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4-w3-d3");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();

        eventoDAO eventoDAO = new eventoDAO(em);

        partecipazioneDA0 partecipazioneDAO = new partecipazioneDA0(em);

        personaDAO personaDAO = new personaDAO(em);

        locationDAO locationDAO = new locationDAO(em);

     /*   Persona aldo = new Persona("aldo", "rossi", "email@gmail.com", LocalDate.of(2006, 3, 24), sex.MASCHIO);

        personaDAO.save(aldo);*/

       /* Location cocorico = new Location("cocorico", "riccione");

        locationDAO.save(cocorico);*/
        System.out.println("Hello World!");
    }
}
