package niccolosorrenti.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "eventi")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_id")
    private long id;

    @Column(name = "titolo", nullable = false, length = 30)
    private String titolo;

    @Column(name = "data_evento")
    private LocalDate dataEvento;

    @Column(name = "descrizione", nullable = false, length = 255)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento", nullable = false)
    private TipoEvento tipoEvento;

    @OneToOne
    @JoinColumn(name = "partita_di_calcio_id")
    private PartitaDiCalcio partitaDiCalcio;

    //    Questo è obbligatorio, va scritto con zero parametri e zero logica
    public Evento() {

    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                '}';
    }
}
