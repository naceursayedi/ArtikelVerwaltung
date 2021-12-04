/**
 * Modelliert Informationen zu einem Artikel, der von
 * einer Firma verkauft wird.
 * 

 * @author Naceur Sayedi 
 * @neuer Version 18.11.2021 von Naceur Sayedi
 */
public class Artikel
{
    // Die Nummer dieses Artikels
    private int nummer;
    // Der Name dieses Artikels
    private String name;
    // Der Kategorie dieses Artikels
    private String category;
    // Der aktuelle Bestand dieses Artikels im Lager
    private int bestand;

    /**
     * Konstruktor für Objekte der Klasse Artikel.
     * Der Anfangsbestand ist Null.
     * @param nummer Die Artikelnummer des Artikels.
     * @param name Der Name des Artikels.
     */
    public Artikel(int nummer, String name,String category)
    {
        this.nummer = nummer;
        this.name = name;
        this.category=category;
        bestand = 0;
    }

    /**
     * @return die Artikelnummer.
     */
    public int gibNummer()
    {
        return nummer;
    }
    /**
     * @return die Kategorie.
     */
    public String gibkategorie()
    {
        return category;
    }

    /**
     * @return den Artikelnamen.
     */
    public String gibName()
    {
        return name;
    }

    /**
     * @return den Bestand im Lager.
     */
    public int gibBestand()
    {
        return bestand;
    }

    /**
     * @return die Nummer, den Namen und den Lagerbestand als String.
     */
    public String toString()
    {
        return nummer + ": " +
        name + 
        " Kategorie: " + category +
        " Lagerbestand: " + bestand;
    }

    /**
     * Erhöhe den Lagerbestand dieses Artikels um den 
     * angegebenen Wert.
     * @param anzahl Die Anzahl der zusätzlichen Artikel.
     *               Dieser Wert muss größer als Null sein.
     */
    public void erhoeheBestand(int anzahl)
    {
        if(anzahl > 0) {
            bestand += anzahl;
        }
        else {
            System.out.println("Versuchte Aufstockung von " +
                name +
                " um einen negativen Wert: " +
                anzahl);
        }
    }

    /**
     * Verkaufe einen dieser Artikel.
     * Ein Fehler wird gemeldet, wenn der Artikel nicht auf
     * Lager ist.
     */
    public void verkaufeEinen()
    {
        if(bestand > 0) {
            bestand--;
        }
        else {
            System.out.println(
                "Versuchter Verkauf eines nicht vorrätigen Artikels: " + name);
        }
    }

    // name Aendern
    public void nameAendern(String nameA){
        name=nameA;
    }
    // nummer Aendern
    public void nummerAendern(int nummerA){
        nummer=nummerA;
    }
    // bestand Aendern
    public void bestandAendern(int bestandWert){
        bestand=bestandWert;

    }

}
