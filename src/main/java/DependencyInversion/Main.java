package DependencyInversion;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Anagrafica elenco = new Anagrafica();
        CarrieraUniversitaria c = new CarrieraUniversitaria();

        Studente s1 = new Studente("Francesca", "Rossi", "123456", c);
        elenco.iscrivi(s1, LocalDate.parse("2020-12-12"));
        s1.registraVoto(LocalDate.now(), "POO", 25, false);

        JSONizzatore js = JSONizzatore.instance;
        js.salva(elenco);
        System.out.print(js.toJson(elenco));
    }
}
