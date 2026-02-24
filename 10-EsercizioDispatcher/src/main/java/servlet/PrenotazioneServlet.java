package servlet;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Evento;
import model.Prenotazione;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.EventoService;
import util.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/prenota")
public class PrenotazioneServlet extends HttpServlet {

    private static Logger log = LoggerFactory.getLogger(PrenotazioneServlet.class);
    private static List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        prenotazioni = new ArrayList<Prenotazione>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("eventi", EventoService.getListaEventi());
        req.getRequestDispatcher("/jsp/prenotazione.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeUtente = req.getParameter("nomeUtente");
        String email = req.getParameter("email");
        int idEvento = Integer.parseInt(req.getParameter("event"));
        Evento ev = EventoService.getEvento(idEvento);
        if(ev == null) {
            log.warn("Evento non trovato");
            resp.sendRedirect("home");
            return;
        }
        Prenotazione p = new Prenotazione(nomeUtente, email, ev);
        prenotazioni.add(p);
        log.info("Prenotazione creata per: " + nomeUtente);

        try {
            FileManager.salvaPrenotazione(p);
        } catch (IOException e) {
            log.error("Errore di scrittura su file: " + e.getMessage());
        }
        req.getRequestDispatcher("/lista").forward(req, resp);
    }

    public static List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }
}
