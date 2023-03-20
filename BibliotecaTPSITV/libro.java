public class libro {
    private int id;
    private String isbn;
    private String edizione;
    private String autore;
    private int id_biblioteca;
    private int copie_presenti;


    public libro(int i, String code, String e, String a, int id_b, int c){
        this.id = i;
        this.isbn = code;
        this.edizione = e;
        this.autore = a;
        this.id_biblioteca = id_b;
        this.copie_presenti = c;
    }
}
