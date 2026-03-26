package niccolosorrenti.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    @Column(name = "genere_concerto")
    private GenereConcerto genereConcerto;

    @Column(name = "in_streaming")
    private boolean inStreaming;

    @OneToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    protected Concerto() {

    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, GenereConcerto genereConcerto, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento);
        this.genereConcerto = genereConcerto;
        this.inStreaming = inStreaming;
    }

    public GenereConcerto getGenereConcerto() {
        return genereConcerto;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public Evento getEvento() {
        return evento;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genereConcerto=" + genereConcerto +
                ", inStreaming=" + inStreaming +
                ", evento=" + evento +
                '}';
    }
}
