package niccolosorrenti.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity

public class GaraDiAtletica extends Evento {

    @Column(name = "set_atleti")
    private Persona setAtleti;

    @Column(name = "vincitore")
    private Persona vincitore;

    protected GaraDiAtletica() {

    }

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, Persona setAtleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento);
        this.setAtleti = setAtleti;
        this.vincitore = vincitore;
    }

    public Persona getSetAtleti() {
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
