package service;

import com.github.javafaker.Faker;
import model.Evento;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class EventoService {

    private static List<Evento> listaEventi = new ArrayList<>();
    private static Faker fake = new Faker(new Locale("it-IT"));

    public static void generaEventiFake(int numEventi) {
        for (int i = 0; i < numEventi; i++) {
            listaEventi.add(new Evento(
                    fake.educator().course(),
                    fake.name().fullName(),
                    fake.address().cityName(),
                    fake.date()
                            .future(180, TimeUnit.DAYS)
                            .toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate()
            ));
        }
    }

    public static List<Evento> getListaEventi() {
        return listaEventi;
    }

    public static Evento getEvento(int idEvento) {
        return listaEventi.stream()
                .filter(e -> e.getId() == idEvento)
                .findFirst()
                .orElse(null);
    }
}
