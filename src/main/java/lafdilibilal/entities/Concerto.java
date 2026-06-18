package lafdilibilal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "concerti")
public class Concerto extends evento {

    @Enumerated(EnumType.STRING)
    private Genere genere;

    private boolean streaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, tipoEvento tipoEvento, int numeroMassimoPartecipanti,
                    Location location, Genere genere, boolean streaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.streaming = streaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public boolean isStreaming() {
        return streaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", streaming=" + streaming +
                '}';
    }
}