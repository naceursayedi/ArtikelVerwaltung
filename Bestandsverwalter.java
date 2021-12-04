import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
/**
 * Verwalte den Bestand eines Unternehmens.
 * Der Bestand ist beschrieben durch einen oder
 * mehrere Artikel.
 * 
 * @author Naceur Sayedi 
 * @version 18.11.2021
 */
public class Bestandsverwalter
{
    // Das Lager mit den Artikeln
    //private  ArrayList<Artikel> lager;
    private  HashMap<String,HashMap> lager;
    private  HashMap<Integer,Artikel> Category;
    /**
     * Initialisiere den Bestandsverwalter.
     */
    public Bestandsverwalter()
    {
        //lager = new ArrayList<Artikel>();
        lager = new HashMap<String,HashMap>();
    }

    /**
     * Führe einen neuen Artikel im Lager ein.
     * @param artikel Der Artikel, der neue eingeführt werden soll.
     */
    public void neuerArtikel(int nummer, String name, String category)
    {
       Artikel artikel;

        
        artikel = new Artikel(nummer, name,category);
        
        if(lager.containsKey(category)){
        lager.get(category).put(nummer,artikel);
        }
    }
    // Artikel Entfernen
    public void artikelentfernen(int nummer,String category)
    {
        Artikel artikel;
        artikel = findeArtikel(nummer,category);
        
        if(artikel == null)
            System.out.println("Artikel nicht gefunden ");
        else{
            artikel = null;
            System.out.println("Artikel entfernt");
        }
    }

    /**
     * Nimm eine Lieferung eines Artikels in das Lager auf.
     * Erhöhe den Lagerbestand um die angegebene Menge.
     * @param nummer Die Artikelnummer des Artikels.
     * @param menge Die angelieferte Menge.
     */
    public void aufnehmen(int nummer, int menge, String category)
    {
        Artikel artikel;
        artikel = findeArtikel(nummer,category);
        if(artikel == null)
            System.out.println("Artikel nicht gefunden ");
        else{
            artikel.erhoeheBestand(menge);
        }

    }

    /**
     * Versuche einen Artikel mit der angegebenen Nummer im
     * Bestand zu finden.
     * @param nummer Die Nummer des zu findenden Artikels.
     * @return den gefundenen Artikel oder null, falls kein
     *         passender Artikel gefunden wird.
     */
    public Artikel findeArtikel(int nummer,String category)
    {

        Artikel ar = (Artikel) lager.get(category).get(nummer);
            if(ar.gibNummer() == nummer){
                return ar;
            }

        
        return null;
    }

    /**
     * Finde einen Artikel mit der angegebenen Nummer und
     * liefere seine aktuelle Menge im Bestand.
     * Wenn die Nummer auf keinen Artikel passt, wird
     * Null zurückgeliefert.
     * @param nummer Die Nummer des Artikels.
     * @return die Menge des Artikels im Bestand.
     */
    public void mengeImBestand(int nummer,String category)
    {

        Artikel artikel;

        artikel = findeArtikel(nummer,category);
       
        if(artikel == null)
            System.out.println("Artikel nicht gefunden ");
        else {
            System.out.println("Menge im Bestand : "+artikel.gibBestand());
        }

    }
    /**
     * Gebe Details eines bestimmten Artikels auf der Konsole
     * aus. Wenn vorhanden, werden Name und Bestandsmenge
     * angezeigt.
     * @param nummer Die Nummer des zu suchenden Artikels.
     */
    public void zeigeDetails(int nummer,String category)
    {

        Artikel artikel;

        artikel = findeArtikel(nummer,category);
      
        if(artikel == null)
            System.out.println("Artikel nicht gefunden ");
        else {
            System.out.println(artikel.toString());
        }

    }
    
     public void addCategery(String catName){
        
        lager.put(catName,new HashMap<Integer,Artikel>());
        if(lager.containsKey(catName)){
        System.out.println("Category Created ");
        }
    
    }
    /**
     * Informationen über alle Artikel ausgeben.
     */
    public void alleArtikelAnzeigen()
    {
    
    Iterator<String> itL =lager.keySet().iterator();
    while(itL.hasNext()){
   
   
        Category=lager.get(itL.next());
        Artikel ar;
        Iterator<Artikel> itC =Category.values().iterator();
        while(itC.hasNext()){
        ar=itC.next();
        System.out.println(ar.toString());
    }
    }
    }
    /**
     * Verkaufe ein Exemplar eines bestimmten Artikels.
     * Zeige den Status des Artikels vor und nach dem 
     * Verkauf.
     * @param nummer Die Nummer des verkauften Artikels.
     */
    public void verkaufeArtikel(int nummer,String category)
    {

        Artikel artikel = findeArtikel(nummer,category);
      
        if(artikel == null)
            System.out.println("Artikel nicht gefunden ");
        else {
            artikel.verkaufeEinen();
            System.out.println(artikel);

        }

    }
    /**
     * findeArtikel 
     * 
     * @param  name    (Beschreibung des Parameters)
     * @return    Artikel    (Beschreibung des Rückgabewertes)
     */
    public void findeArtikel(String name,String category){

        Category = lager.get(category);
        
        Iterator hmIterator = Category.entrySet().iterator();
  
        while (hmIterator.hasNext()) {
            HashMap.Entry mapElement = (HashMap.Entry)hmIterator.next();
            Artikel artikel = ((Artikel)mapElement.getValue());
            if(artikel.gibName().equals(name)) {
                System.out.println(artikel);
                break;
            }
        }
        
        
        
        

    }
  

    // Name des Artikels bearbeiten 

    public void nameBearbeiten(String name,int nummer,String category){

        Artikel artikel =findeArtikel(nummer,category);
        if(artikel != null){
            artikel.nameAendern(name);
        }else
        {
            System.out.println("Artikel nicht gefunden . Bitte Schreiben Sie ein korrektes Nummer des Artikel");

        }

        
    
    } 

    // Nummer des Artikels bearbeiten 
    public  void NummerBearbeiten(int nummer, int nNummer,String category){
        Artikel artikel =findeArtikel(nummer,category);
        if(artikel != null){
            artikel.nummerAendern(nNummer);
        }else
        {
            System.out.println("Artikel nicht gefunden . Bitte Schreiben Sie ein korrektes Nummer des Artikel");

        }

    } 
    // Nummer des Artikels bearbeiten 
    public void bestandBearbeiten(int nummer , int bestandWert,String category){
        Artikel artikel =findeArtikel(nummer,category);
        if(artikel != null){
            artikel.bestandAendern(bestandWert);
        }else
        {
            System.out.println("Artikel nicht gefunden . Bitte Schreiben Sie ein korrektes Nummer des Artikel");

        }

    }

}
