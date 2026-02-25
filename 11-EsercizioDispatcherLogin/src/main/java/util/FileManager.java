package util;

import model.Evento;
import model.Prenotazione;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String filePath = "data/prenotazioni.txt";
    private static Logger log = LoggerFactory.getLogger(FileManager.class);

    public static void salvaPrenotazione(Prenotazione p) throws IOException {
        // Mario Rossi | Java Advanced | 2026-03-01 | m.rossi@example.com | citta | docente
        File file = new File(filePath);

        String riga = p.getNomeUtente() + "|"
                    + p.getEvento().getTitoloEvento() + "|"
                    + p.getEvento().getData() + "|"
                    + p.getEmail() + "|"
                    + p.getEvento().getCitta() + "|"
                    + p.getEvento().getDocente();
        FileUtils.writeStringToFile(file, riga, StandardCharsets.UTF_8, true);
        log.debug("Salvata prenotazione: " + riga);
    }

    public static List<Prenotazione> leggiPrenotazioni() throws IOException {
        File file = new File(filePath);
        List<Prenotazione> listaPrenotazioni = new ArrayList<>();
        String prenotazioniTxt = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        String[] row = prenotazioniTxt.split(System.lineSeparator());
        for (int i = 0; i < row.length; i++) {
            // Mario Rossi | Java Advanced | 2026-03-01 | m.rossi@example.com | citta | docente
            String[] properties = row[i].split("|");
            Evento e = new Evento(properties[1], properties[5], properties[4], LocalDate.parse(properties[2]));
            Prenotazione p = new Prenotazione(properties[1], properties[3], e);
            listaPrenotazioni.add(p);
        }
        return listaPrenotazioni;
    }

}
