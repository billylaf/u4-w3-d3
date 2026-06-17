package lafdilibilal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lafdilibilal.dao.eventoDAO;
import lafdilibilal.dao.locationDAO;
import lafdilibilal.dao.partecipazioneDA0;
import lafdilibilal.dao.personaDAO;
import lafdilibilal.entities.Location;
import lafdilibilal.entities.evento;
import lafdilibilal.entities.tipoEvento;

import java.time.LocalDate;

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

        /*Location milanoIpo = new Location("ipodromo", "milano");

        locationDAO.save(milanoIpo);*/

        try {
            Location FromDB = locationDAO.findById(2);
            evento cocoEvent;
            cocoEvent = new evento("concerto sfera", LocalDate.of(2026, 7, 12), "evento speciale di sefra ebbasta", tipoEvento.PUBBLICO, 200000, FromDB);
            eventoDAO.save(cocoEvent);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Hello World!");
    }
}
