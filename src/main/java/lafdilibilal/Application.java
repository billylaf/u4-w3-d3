package lafdilibilal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lafdilibilal.dao.eventoDAO;
import lafdilibilal.dao.locationDAO;
import lafdilibilal.dao.partecipazioneDA0;
import lafdilibilal.dao.personaDAO;
import lafdilibilal.entities.Genere;


public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4-w3-d3");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();

        eventoDAO eventoDAO = new eventoDAO(em);

        partecipazioneDA0 partecipazioneDAO = new partecipazioneDA0(em);

        personaDAO personaDAO = new personaDAO(em);

        locationDAO locationDAO = new locationDAO(em);

       /* Persona aldo = new Persona("aldo", "rossi", "email@gmail.com", LocalDate.of(2006, 3, 24), sex.MASCHIO);

        personaDAO.save(aldo);

        Persona giovanni = new Persona("giovani", "ferrari", "email2345@gmail.com", LocalDate.of(1999, 6, 30), sex.MASCHIO);

        personaDAO.save(giovanni);

        Persona giacomo = new Persona("giacomo", "moretti", "email@gmail.com", LocalDate.of(1995, 7, 2), sex.MASCHIO);

        personaDAO.save(giacomo);

        Location milanoIpo = new Location("ipodromo", "milano");

        locationDAO.save(milanoIpo);

        Location coco = new Location("cocorico", "riccione");

        locationDAO.save(coco);

        Location sansiro = new Location("san siro", "milano");

        locationDAO.save(sansiro);

        Location pistaRoma = new Location("pista da corsa di roma", "roma");

        locationDAO.save(pistaRoma);*/

       /* try {
            Location FromDB = locationDAO.findById(4);
            Persona FromDB2 = personaDAO.findById(2);
            evento garaAtletica = new GaraDiAtletica("400m velocita", LocalDate.of(2026, 7, 23), "mondiali di corsa 2026", tipoEvento.PUBBLICO, 10, FromDB, 5, FromDB2);
            eventoDAO.save(garaAtletica);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }


        try {
            Location FromDB = locationDAO.findById(3);

            evento max = new Concerto("concerto max pezzali", LocalDate.of(2026, 12, 26), "super cocerto di max pezzali a san siro", tipoEvento.PUBBLICO, 254000, FromDB, Genere.CLASSSICO, false);
            eventoDAO.save(max);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
/**/
        eventoDAO.getConcertiInStreaming(true).forEach(System.out::println);
        eventoDAO.getConcertiPerGenere(Genere.CLASSSICO).forEach(System.out::println);
        System.out.println("Hello World!");
    }
}
