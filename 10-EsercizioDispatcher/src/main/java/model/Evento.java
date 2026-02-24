package model;

import java.time.LocalDate;

public class Evento {

    private static int count = 1;
    private int id;
    private String titoloEvento;
    private String docente;
    private String citta;
    private LocalDate data;

    public Evento(String titoloEvento, String docente, String citta, LocalDate data) {
        this.id = count++;
        this.titoloEvento = titoloEvento;
        this.docente = docente;
        this.citta = citta;
        this.data = data;
    }

    public Evento(int id, String titoloEvento, String docente, String citta, LocalDate data) {
        this.id = id;
        this.titoloEvento = titoloEvento;
        this.docente = docente;
        this.citta = citta;
        this.data = data;
    }

    public int getId() {
        return id;
    }
    public String getTitoloEvento() {
        return titoloEvento;
    }
    public String getDocente() {
        return docente;
    }
    public String getCitta() {
        return citta;
    }
    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titoloEvento='" + titoloEvento + '\'' +
                ", docente='" + docente + '\'' +
                ", citta='" + citta + '\'' +
                ", data=" + data +
                '}';
    }
}
