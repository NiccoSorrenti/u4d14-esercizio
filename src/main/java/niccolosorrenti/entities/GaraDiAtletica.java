package niccolosorrenti.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity

public class GaraDiAtletica extends Evento {

    @OneToMany(mappedBy = "garaDiAtletica")
//    @Column(name = "set_atleti")
    private List<Persona> setAtleti = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "vincitore_id")
//    @Column(name = "vincitore")
    private Persona vincitore;

    protected GaraDiAtletica() {

    }

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, List<Persona> setAtleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento);
        this.setAtleti = setAtleti;
        this.vincitore = vincitore;
    }

    public List<Persona> getSetAtleti() {
        return setAtleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "setAtleti=" + setAtleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
