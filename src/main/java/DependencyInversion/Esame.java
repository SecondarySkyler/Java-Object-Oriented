package DependencyInversion;

import java.time.LocalDate;

public class Esame implements Comparable{
    private final LocalDate data;
    private final String corso;
    private final int voto;
    private final boolean lode;

    public Esame(LocalDate data, String corso, int voto, boolean lode) {
        this.data = data;
        this.corso = corso;
        this.voto = voto;
        this.lode = lode;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Esame))
            return -1;
        Esame es = (Esame) o;
        if (data.isBefore(es.data))
            return -1;
        else if (data.isAfter(es.data))
            return 1;
        else return (corso.compareTo(es.corso));
    }
}
