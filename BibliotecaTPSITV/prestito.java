public class prestito {
    private int id_utente;
    private int id_libro;
    private String datainizio;
    private String datafine;

    public prestito(int i_u, int i_l, String di, String df){
        this.id_libro = i_l;
        this.id_utente = i_u;
        this.datainizio = di;
        this.datafine = df;
    }
}
