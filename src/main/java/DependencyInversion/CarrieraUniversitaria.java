package DependencyInversion;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class CarrieraUniversitaria {
    private LocalDate dataIscrizione;
    private LocalDate dataLaurea;
    private boolean laureato;
    private int votoLaurea;
    private Set<Esame> esami = new TreeSet<>();

    void registraVoto(LocalDate data, String corso, int voto, boolean lode) {
        Esame es;
        es = new Esame(data, corso, voto, lode);
        esami.add(es);
    }

    public void registraLaurea(LocalDate dataLaurea, int voto) {
        setLaureato(true);
        setDataLaurea(dataLaurea);
        setVotoLaurea(votoLaurea);
    }

    private void setVotoLaurea(int votoLaurea) {
        this.votoLaurea = votoLaurea;
    }

    private void setDataLaurea(LocalDate dataLaurea) {
        this.dataLaurea = dataLaurea;
    }

    private void setLaureato(boolean b) {
        laureato = b;
    }

    public Stream<Esame> stream() {
        return esami.stream();
    }

    public void setDataIscrizione(LocalDate data) {
        dataIscrizione = data;
    }

    public Object getDataIscrizione() {
        return dataIscrizione;
    }

    public Object getDataLaurea() {
        return dataLaurea;
    }

    public Object getVotoLaurea() {
        return votoLaurea;
    }
}
