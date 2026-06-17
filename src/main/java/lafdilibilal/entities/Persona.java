package lafdilibilal.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

import java.util.List;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private long id;

    private String nome;

    private String cognome;

    private String email;

    private LocalDate data_nascita;

    @Enumerated(EnumType.STRING)
    private sex sesso;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Partecipazione> partecipazioni;

    public Persona() {

    }

    public Persona(String nome, String cognome, String email, LocalDate data_nascita, sex sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_nascita = data_nascita;
        this.sesso = sesso;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public sex getSesso() {
        return sesso;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", data_nascita=" + data_nascita +
                ", sesso=" + sesso +
                '}';
    }
}
