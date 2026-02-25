package model;

public class Prenotazione {

    private String nomeUtente;
    private String email;
    private Evento evento;

    public Prenotazione(String nomeUtente, String email, Evento evento) {
        this.nomeUtente = nomeUtente;
        this.email = email;
        this.evento = evento;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }
    public String getEmail() {
        return email;
    }
    public Evento getEvento() {
        return evento;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "nomeUtente='" + nomeUtente + '\'' +
                ", email='" + email + '\'' +
                ", evento=" + evento +
                '}';
    }
}
