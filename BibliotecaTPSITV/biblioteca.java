import java.util.List;;
public class biblioteca {
    private int id;
    private List<libro> libri_presenti;
    int count = 0;

    public biblioteca(int id){
        this.id = id;
    }

    public List<libro> getBooks()
    {
        return libri_presenti;
    }

    public void addLibro(libro l){
        libri_presenti.add(l);
    }
}
