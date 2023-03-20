
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class main {
    File user_xml = new File("sas");
    File book_xml = new File("sas");
    File library_xml = new File("sas");
    List<utente> users = parseUser(user_xml);
    List<biblioteca> biblioteche = parseLibrary(library_xml);

    
    
    
    
    
    public static List<biblioteca> parseLibrary(File xmlFile) throws Exception {
        List<biblioteca> biblioteche = new ArrayList<>();
    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
    
        doc.getDocumentElement().normalize();
        NodeList bibliotecaNodes = doc.getElementsByTagName("biblioteca");
    
        for (int i = 0; i < bibliotecaNodes.getLength(); i++) {
          Element bibliotecaElement = (Element) bibliotecaNodes.item(i);
          int id = Integer.parseInt(bibliotecaElement.getAttribute("id"));    
          NodeList prestitiNodes = bibliotecaElement.getElementsByTagName("libri_presenti");
          List<libro> libri = new ArrayList<>();
          for (int j = 0; j < prestitiNodes.getLength(); j++) {
            Element prestitoElement = (Element) prestitiNodes.item(j);
            int idlibro = Integer.parseInt(prestitoElement.getAttribute("id"));
            String isbn = (prestitoElement.getAttribute("isbn")).toString();
            String edizione = (prestitoElement.getAttribute("edizione")).toString();
            String autore = (prestitoElement.getAttribute("id_biblioteca")).toString();
            int idbiblio = Integer.parseInt(prestitoElement.getAttribute("id"));
            int copie = Integer.parseInt(prestitoElement.getAttribute("copie_presenti"));
            // parsing altri attributi del prestito
            libro libro = new libro(idlibro, isbn, edizione, autore, idbiblio, copie);
            libri.add(libro);
          }
    
          biblioteca biblioteca = new biblioteca(id);
          for (libro l : libri) {
            biblioteca.addLibro(l);
          }
          biblioteche.add(biblioteca);
        }
    
        return biblioteche;
      }
    
    public static List<utente> parseUser(File xmlFile) throws Exception {
        List<utente> utenti = new ArrayList<>();
    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
    
        doc.getDocumentElement().normalize();
        NodeList utenteNodes = doc.getElementsByTagName("utente");
    
        for (int i = 0; i < utenteNodes.getLength(); i++) {
          Element utenteElement = (Element) utenteNodes.item(i);
          int id = Integer.parseInt(utenteElement.getAttribute("id"));
          String nome = utenteElement.getElementsByTagName("nome").item(0).getTextContent();
          String cognome = utenteElement.getElementsByTagName("cognome").item(0).getTextContent();
    
          NodeList prestitiNodes = utenteElement.getElementsByTagName("prestito");
          List<prestito> prestiti = new ArrayList<>();
          for (int j = 0; j < prestitiNodes.getLength(); j++) {
            Element prestitoElement = (Element) prestitiNodes.item(j);
            int idutente = Integer.parseInt(prestitoElement.getAttribute("id_utente"));
            int idlibro = Integer.parseInt(prestitoElement.getAttribute("id_libro"));
            String datainizio = (prestitoElement.getAttribute("data_inizio")).toString();
            String datafine = (prestitoElement.getAttribute("data_fine")).toString();
            // parsing altri attributi del prestito
            prestito prestito = new prestito(idutente, idlibro, datainizio, datafine);
            prestiti.add(prestito);
          }
    
          utente utente = new utente(id, nome, cognome);
          for (prestito p : prestiti) {
            utente.addPrestito(p);
          }
          utenti.add(utente);
        }
    
        return utenti;
      }
}



  
