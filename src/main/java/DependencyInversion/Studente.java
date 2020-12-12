package DependencyInversion;

import java.time.LocalDate;

public class Studente {
    private String nome;
    private String cognome;
    private String matricola;
    private CarrieraUniversitaria carriera;

    public Studente(String n, String cgnm, String mat, CarrieraUniversitaria c) {
        this.nome = n;
        this.cognome = cgnm;
        this.matricola = mat;
        this.carriera = new CarrieraUniversitaria();
    }

    /**
     * iscrivi lo studente e setta la data
     * @param data
     */
    public void iscriviti(LocalDate data) {
        carriera.setDataIscrizione(data);
    }

    /**
     * registra un voto, lode solo se voto = 30
     * @param data
     * @param corso
     * @param voto
     * @param lode
     */
    public void registraVoto(LocalDate data, String corso, int voto, boolean lode) {
        if (lode && voto < 30)
            throw new RuntimeException("Non e' possibile registrare la lode senza un 30");
        carriera.registraVoto(data, corso, voto, lode);
    }

    /**
     *
     * @param dataLaurea
     * @param voto in 110
     */
    public void laureati(LocalDate dataLaurea, int voto) {
        carriera.registraLaurea(dataLaurea, voto);
    }

    public Object getNome() {
        return nome;
    }

    public Object getCognome() {
        return cognome;
    }

    public Object getMatricola() {
        return matricola;
    }

    public CarrieraUniversitaria getCarriera() {
        return this.carriera;
    }
}
