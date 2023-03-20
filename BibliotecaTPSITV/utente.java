import java.util.List;

public class utente {
    
    private int id;
    private String nome;
    private String cognome;
    private List<prestito> prestiti_effettuati;

    public utente(int i, String n, String c){

    }

    public void addPrestito(prestito p){
        prestiti_effettuati.add(p);
    }
    public void populateUsers(String path){

    }
}
