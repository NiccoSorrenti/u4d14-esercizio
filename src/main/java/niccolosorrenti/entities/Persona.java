package niccolosorrenti.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue
    @Column(name = "persona_id")
    private UUID personaId;

    private String nome;

    private String cognome;

    private String email;

    private LocalDate dataDiNascita;

    @Enumerated(EnumType.STRING)
    @Column(name = "sesso")
    private SessoPersona sessoPersona;

    @ManyToMany
    @JoinTable(name = "persone_gare",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "gara_id"))
    @Column(name = "lista_partecipazioni")
    private List<GaraDiAtletica> listaPartecipazioni;

    @ManyToOne
    @JoinColumn(name = "gara_di_atletica_id")
    private GaraDiAtletica garaDiAtletica;

    public Persona() {

    }

    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, SessoPersona sessoPersona, List<GaraDiAtletica> listaPartecipazioni) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sessoPersona = sessoPersona;
        this.listaPartecipazioni = listaPartecipazioni;
    }

    public String getEmail() {
        return email;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public UUID getPersonaId() {
        return personaId;
    }

    public List<GaraDiAtletica> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public GaraDiAtletica getGaraDiAtletica() {
        return garaDiAtletica;
    }

    public SessoPersona getSessoPersona() {
        return sessoPersona;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "personaId=" + personaId +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", sessoPersona=" + sessoPersona +
                ", listaPartecipazioni=" + listaPartecipazioni +
                '}';
    }
}
