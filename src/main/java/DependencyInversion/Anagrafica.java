package DependencyInversion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Anagrafica {
    List<Studente> elenco = new ArrayList<>();

    /**
     * iscrivi lo studente a aggiungilo all'anagrafica
     * @param s studente
     * @param dataIscrizione
     */
    public void iscrivi(Studente s, LocalDate dataIscrizione) {
        elenco.add(s);
        s.iscriviti(dataIscrizione);
    }

    public Stream<Studente> stream() {
        return elenco.stream();
    }

}
