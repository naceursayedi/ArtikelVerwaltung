
/**
 * Demonstriert die Klassen Bestandsverwalter und Artikel.
 * Die Demonstration wird funktionstüchtig, indem die
 * Klasse Bestandsverwalter vervollständigt wird.
 * 
 * @author David J. Barnes und Michael Kölling
 * @version 2008.03.30
 */
public class BestandDemo
{
    // Der Bestandsverwalter
    private Bestandsverwalter verwalter;
    private Menu m;
    /**
     * Erzeuge einen Bestandsverwalter und füttere ihn mit
     * ein paar Beispielartikeln.
     */
    public BestandDemo()
    {
        m = new Menu();
        verwalter = new Bestandsverwalter();
        //verwalter.neuerArtikel(new Artikel(132, "Uhrenradio"));
        //verwalter.neuerArtikel(new Artikel(37, "Mobiltelefon"));
        //verwalter.neuerArtikel(new Artikel(23, "Mikrowellenherd"));
        //verwalter.neuerArtikel(new Artikel(233, "Mikro"));
    }

    /**
     * Eine Demonstration aller Methoden im Bestandsverwalter.
     * Wenn Sie die Klasse Bestandsverwalter mit allen Methoden fertig 
     * gestellt haben, dann sollte diese Demo korrekt ablaufen.
     * Nutzen Sie diese Klasse für weitere Tests.
     */
    /*
     * 
     public void demo()
    {

        System.out.println("************** Finde Artikel **************");
        Artikel ar ;
        ar = verwalter.findeArtikel(132);
        System.out.println(ar);
        // Zeige Infos zu allen Artikeln.
        System.out.println();
        System.out.println("************** alleArtikelAnzeigen **************");
        verwalter.alleArtikelAnzeigen();
        // Eine Lieferung von 5 Artikeln aufnehmen.
        System.out.println();
        System.out.println("*************** Aufnehmen 132 anzahl 5***************");
        verwalter.aufnehmen(132, 5);
        verwalter.alleArtikelAnzeigen();
        // Menge des Artikels mit der Nummer 132 ausgeben.
        System.out.println();
        System.out.println("*************** AusgabeMengeImBestand ***************");
        ausgabeMengeImBestand(132);
        for(int i = 0; i<4; i++) {
            // Ein Exemplar des Artikels Nr. 132 verkaufen.
            verwalter.verkaufeArtikel(132);
        }
        System.out.println();
        System.out.println("*************** AusgabeMengeImBestand ***************");
        ausgabeMengeImBestand(132);
        verwalter.aufnehmen(38, 40);
        // Die Details über den Artikel Nr. 37 ausgeben.
        verwalter.zeigeDetails(37);
        System.out.println();
        System.out.println("************** Aufnehmen 37 Anzahl 40 ***************");
        verwalter.aufnehmen(37, 40);
        verwalter.zeigeDetails(37);
        System.out.println();
        System.out.println("************** Finde Artikel **************");
        ar=verwalter.findeArtikel("Mobiltelefon");
        System.out.println(ar);
        verwalter.befuellen(6);
        System.out.println();
        System.out.println("*************** Befuellen **************");
        verwalter.alleArtikelAnzeigen();
    }
    */
    public void test()
    {
        
             m.hauptmenue();
                   
                   

    
    
    
        }
       /* public void ausgabeMengeImBestand(int nummer) {
        int menge = verwalter.mengeImBestand(nummer);

        System.out.println("Menge im Bestand von Artikel Nr." + nummer + ": " + menge);
    }
    */
}
