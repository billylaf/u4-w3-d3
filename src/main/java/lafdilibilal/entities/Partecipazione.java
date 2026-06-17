package lafdilibilal.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partecipazione_id")
    private long id;

    @ManyToOne
    private Persona persona;

    @ManyToOne
    private evento evento;

    @Enumerated(EnumType.STRING)
    private statoPartecipazione stato;

    public Partecipazione() {
    }

    public Partecipazione(Persona persona, evento evento, statoPartecipazione stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public long getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public evento getEvento() {
        return evento;
    }

    public statoPartecipazione getStato() {
        return stato;
    }


    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona.getId() +
                ", evento=" + evento.getId() +
                ", stato=" + stato +
                '}';
    }
}
