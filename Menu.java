import java.util.Scanner;
import java.io.IOException;
/**
 * Beschreiben Sie hier die Klasse menu.
 * 
 * @author Naceur Sayedi 
 * @version 18.11.2021
 */
public class Menu
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Scanner input ;
    private Bestandsverwalter verwalt;

    /**
     * Konstruktor für Objekte der Klasse menu
     */
    public Menu()
    {
        // Instanzvariable initialisieren
        input = new Scanner(System.in);
        verwalt = new Bestandsverwalter();
    }

    /**
     * verifizierung vom Auswahl 
     * 
     * @param  y    (Beschreibung des Parameters)
     * @return        (Beschreibung des Rückgabewertes)
     */
    public  int auswahl(int bis)
    {
        int auswahl;
        while(true){
            auswahl = input.nextInt();
            if(auswahl <1 || auswahl > bis ){
                System.out.println("Falsches Auswahl");
            }else{
                break;
            }

        }
        return auswahl;
    }
    //Antwort ob ja oder Nein tippen 
    /**
     * Antwort ob ja oder Nein tippen 
     * 
     * @param  y    (Beschreibung des Parameters)
     * @return    antwort    (Beschreibung des Rückgabewertes)
     */
    public String antwortWeiter(String y)
    {
        System.out.println("*************************************************");
        System.out.println(y + "?  (j/n)");
        return input.next();
    }

    //Nummer tippen
    /**
     * Nummer tippen
     * 
     * @param      (Beschreibung des Parameters)
     * @return    nummer eines Artikels    (Beschreibung des Rückgabewertes)
     */
    public int nummerTippen()
    {
        System.out.println("Bitte Schreiben Sie die Nummer des Artikels");
        return input.nextInt();
    }
    
    //Kategorie tippen
    /**
     * kategorie tippen
     * 
     * @param      (Beschreibung des Parameters)
     * @return   kategorie eines Artikels    (Beschreibung des Rückgabewertes)
     */
    public String kategorieTippen()
    {
        System.out.println("Bitte Schreiben Sie die Name des Kategories");
        return input.next();
    }

    /**
     * Hauptmenue
     * 
     * @param     (Beschreibung des Parameters)
     * @return   Auswahl     (Beschreibung des Rückgabewertes)
     */
    public void hauptmenue()
    {
        // tragen Sie hier den Code ein
        int a;

        System.out.println("**************** Lagerverwaltung ****************");
        System.out.println("1 - Artikel ");
        System.out.println("2 - Verwaltung ");
        System.out.println("3 - Kategoriemenue ");
        System.out.println("4 - Exit");
        System.out.println("*************************************************");

        System.out.println("\n");
        System.out.println("Auswahl : ");
        a = auswahl(4);
        switch(a){
            case 1: clrscr();    
                artikelmenue();
                break;

            case 2 :clrscr();    
                verwaltungmenue();
                break;
            case 3 :clrscr();    
            Kategoriemenue();
            break;

            case 4 :clrscr();    
                exit();
                break;
        }

    }

    /**
     * Artikelmenue
     * 
     * @param         (Beschreibung des Parameters)
     * @return auswahl       (Beschreibung des Rückgabewertes)
     */
    public void artikelmenue()
    {
        // tragen Sie hier den Code ein
        int a;

        System.out.println("**************** Artikel ****************");
        System.out.println("1 - Neuer Artikel hinfuegen ");
        System.out.println("2 - Artikel entfernen ");
        System.out.println("3 - Artikel bearbeiten ");
        System.out.println("4 - zurueck zum Hauptmenue ");
        System.out.println("*************************************************");
        System.out.println("\n");
        System.out.println("Auswahl : ");

        a = auswahl(4);
        switch(a){
            case 1:   clrscr();    
                neuerArtikel();
                break;

            case 2:
                clrscr();    
                artikelentfernen();
                break;
            case 3:clrscr();    
                artikelbearbeitenmenue();
                break;
            case 4:
                clrscr();    
                hauptmenue();
                break;
        }

    }
    ////////////// Neuer Artikel hinfügen
    public void neuerArtikel()
    {

        System.out.println("**************** Neuer Artikel hinfuegen ****************");
        System.out.println(" Name des Artikels :");
        String name=input.next();
        String category=kategorieTippen();

        int nummer = nummerTippen();

        verwalt.neuerArtikel(nummer,name,category);

        if(antwortWeiter("Moechten Sie nochmal ein Artikel hinfuegin ").equals("j")){
            clrscr();
            neuerArtikel();
        }
        else{
            clrscr();
            artikelmenue();
        }

    }
    // Artikel Entfernen
    public void artikelentfernen()
    {

        System.out.println("**************** Artikel entfernen ****************");

        int nummer = nummerTippen();
        String category=kategorieTippen();
        verwalt.artikelentfernen(nummer,category);

        if(antwortWeiter("Moechten Sie nochmal ein Artikel entfernen ").equals("j")){
            clrscr();
            artikelentfernen();
        }
        else{
            clrscr();
            artikelmenue();
        }

    }
    // Artikel aufnehmen
    public void aufnehmen()
    {

        System.out.println("**************** Artikel aufnehmen ****************");

        int nummer = nummerTippen();
        String category=kategorieTippen();
        System.out.println(" Menge des Artikels :");
        int menge = input.nextInt();
        verwalt.aufnehmen(nummer,menge,category);

        if(antwortWeiter("Moechten Sie nochmal ein Artikel aufnehmen ").equals("j")){
            clrscr();
            aufnehmen();
        }
        else{
            clrscr();
            verwaltungmenue();
        }

    }
    //mengeImBestand
    public void mengeImBestand()
    {

        System.out.println("**************** Menge im Bestand ****************");

        int nummer = nummerTippen();
        String category=kategorieTippen();
        verwalt.mengeImBestand(nummer,category);

        if(antwortWeiter("Moechten Sie nochmal die Menge im Bestand eines Artikel anzeigen ").equals("j")){
            clrscr();
            mengeImBestand();
        }
        else{
            clrscr();
            verwaltungmenue();
        }

    }
    //ZeigeDetails
    public void zeigeDetails()
    {

        System.out.println("**************** Zeige Details ****************");

        int nummer = nummerTippen();
        String category=kategorieTippen();
        verwalt.zeigeDetails(nummer,category);

        if(antwortWeiter("Moechten Sie nochmal Details eines Artikel anzeigen ").equals("j")){
            clrscr();
            zeigeDetails();
        }
        else{
            clrscr();
            verwaltungmenue();
        }

    }
    public void addCategery(){
        System.out.println("**************** Category hinfuegin ****************");
        String category=kategorieTippen();
        verwalt.addCategery(category);
        if(antwortWeiter("Moechten Sie nochmal ein Category hinfuegin ").equals("j")){
            clrscr();
            addCategery();
        }
        else{
            clrscr();
            Kategoriemenue();
        }
    }
    /**
     * Artikel bearbeiten Menue
     * 
     * @param         (Beschreibung des Parameters)
     * @return auswahl       (Beschreibung des Rückgabewertes)
     */
    public  void artikelbearbeitenmenue()
    {
        // tragen Sie hier den Code ein
        int a;

        System.out.println("**************** Artikel Bearbeitung ****************");
        System.out.println("1 - Name des Artikel bearbeiten ");
        System.out.println("2 - Nummer des Artikel bearbeiten ");
        System.out.println("3 - Bestand des Artikel bearbeiten ");
        System.out.println("4 - zurueck zum Artikelmenue ");
        System.out.println("*************************************************");
        System.out.println("\n");
        System.out.println("Auswahl : ");

        a = auswahl(4);
        switch(a){
            case 1 :   clrscr();    
                nameBearbeiten();
                break;
            case 2:
                clrscr();    
                NummerBearbeiten();
                break;
            case 3 :
                clrscr();    
                bestandBearbeiten();
                break;
            case 4 :
                clrscr();    
                artikelmenue();
                break;
        }
    }
    public  void Kategoriemenue()
    {
        // tragen Sie hier den Code ein
        int a;

        System.out.println("**************** Kategorie Bearbeitung ****************");
        System.out.println("1 - Kategorie hinfuegin ");
        System.out.println("2 - Name des Kategorie bearbeiten ");
        System.out.println("3 - Kategorie entfernen ");
        System.out.println("4 - zurueck zum Hauptmenue ");
        System.out.println("*************************************************");
        System.out.println("\n");
        System.out.println("Auswahl : ");

        a = auswahl(4);
        switch(a){
            case 1 :   clrscr();    
                addCategery();
                break;
            case 2:
                clrscr();    
                NameKategorieBearbeiten();
                break;
            case 3 :
                clrscr();    
                kategorieEntfernen();
                break;
            case 4 :
                clrscr();    
                hauptmenue();
                break;
        }
    }
  //Name des Kategories Bearbeiten
    public void NameKategorieBearbeiten()
    {
        System.out.println("**************** Name des Kategories Bearbeiten ****************");
        

        if(antwortWeiter("Moechten Sie nochmal Name des Kategories bearbeiten").equals("j")){
            clrscr();
            NameKategorieBearbeiten();
        }
        else{
            clrscr();
            Kategoriemenue();
        }
    }
    // Kategories entfernen
    public void kategorieEntfernen()
    {
        System.out.println("**************** Kategorie entfernen ****************");
        

        if(antwortWeiter("Moechten Sie nochmal Kategorie entfernen").equals("j")){
            clrscr();
            kategorieEntfernen();
        }
        else{
            clrscr();
            Kategoriemenue();
        }
    }
    /**
     * Verwaltungmenue
     * 
     * @param         (Beschreibung des Parameters)
     * @return auswahl       (Beschreibung des Rückgabewertes)
     */
    public void  verwaltungmenue()
    {
        // tragen Sie hier den Code ein
        System.out.println("**************** Verwaltung ****************");
        System.out.println("1 - Artikel suchen ");
        System.out.println("2 - Artikelbestand aufnehmen ");
        System.out.println("3 - Aktuelle Menge im Bestand  ");
        System.out.println("4 - Beschreibung eines Artikel  ");
        System.out.println("5 - Alle Artikel anzeigen  ");
        System.out.println("6 - Ein Artikel verkaufen  ");
        System.out.println("7 - zurueck zum Hauptmenue ");
        System.out.println("*************************************************");
        System.out.println("\n");
        System.out.println("Auswahl : ");

        int a ; 

        a = auswahl(7);
        switch(a){
            case 1 : clrscr();    
                artikelSuchen();
                break;
            case 2 : clrscr();    
                aufnehmen();
                break;
            case 3 : clrscr();    
                mengeImBestand();
                break;
            case 4 : clrscr();    
                zeigeDetails();
                break;
            case 5 : clrscr();    
                alleArtikelAnzeigen();
                break;
            case 6 : clrscr();    
                verkaufeArtikel();
                break;
            case 7 : clrscr();    
                hauptmenue();
                break;
        }

    }

    //alle artikel anzeigen
    public void alleArtikelAnzeigen()
    {
        System.out.println("**************** alle Artikel anzeigen ****************");
        verwalt.alleArtikelAnzeigen();

        if(antwortWeiter("Moechten Sie nochmal alle Artikel anzeigen ").equals("j")){
            clrscr();
            alleArtikelAnzeigen();
        }
        else{
            clrscr();
            verwaltungmenue();
        }
    }

    //verkaufeArtikel
    public void verkaufeArtikel()
    {

        System.out.println("**************** verkaufe Artikel ****************");

        int nummer = nummerTippen();
        String category=kategorieTippen();
        verwalt.verkaufeArtikel(nummer,category);

        if(antwortWeiter("Moechten Sie nochmal ein Artikel verkaufen ").equals("j")){
            clrscr();
            verkaufeArtikel();
        }
        else{
            clrscr();
            verwaltungmenue();
        }
    }

    //findeArtikel
    public void findeArtikel(){

        System.out.println("**************** finde Artikel nach Name ****************");
        System.out.println(" Name des Artikels :");
        String name=input.next();
        String category=kategorieTippen();
        verwalt.findeArtikel(name,category);

        if(antwortWeiter("Moechten Sie nochmal nach einem Artikel suchen  ").equals("j")){
            clrscr();
            findeArtikel();
        }
        else{
            clrscr();
            artikelSuchen();
        }

    }

    /**
     * Verwaltungmenue Artkel suchen 
     * 
     * @param         (Beschreibung des Parameters)
     * @return auswahl       (Beschreibung des Rückgabewertes)
     */
    public void  artikelSuchen()
    {
        // tragen Sie hier den Code ein
        System.out.println("**************** Artikel suchen ****************");
        System.out.println("1 - Artikel nach der Name suchen ");
        System.out.println("2 - zurueck zum verwaltungmenue ");
        System.out.println("*************************************************");
        System.out.println("\n");
        System.out.println("Auswahl : ");

        int a ; 

        a = auswahl(2);
        switch(a){
            case 1 : clrscr();    
                findeArtikel();
                break;
            case 2 : clrscr();    
                verwaltungmenue();
                break;
        }
    }

    public void  exit()
    {
        // tragen Sie hier den Code ein
        System.out.println("**************** Exit ****************");
        System.out.println("auf wiedersehen ");
        System.out.println("*************************************************");
    }

    public void nameBearbeiten(){
        System.out.println("**************** Name ein Artikel bearbeiten ****************");

        int nummer = nummerTippen();
        String category=kategorieTippen();
        if(verwalt.findeArtikel(nummer,category) != null){
            System.out.println("Bitte Schreiben Sie ein neue Name des Artikel");
            String name= input.next();
            verwalt.nameBearbeiten(name,nummer,category);
        }

        if(antwortWeiter("Moechten Sie nochmal eine Name eines Artikel bearbeiten ").equals("j")){
            clrscr();
            nameBearbeiten();
        }
        else{
            clrscr();
            artikelbearbeitenmenue();
        }

    } 
    // Nummer des Artikels bearbeiten 
    public  void NummerBearbeiten(){
        System.out.println("**************** Nummer ein Artikel bearbeiten ****************");

        int nummer = nummerTippen();
        String category=kategorieTippen();
        if(verwalt.findeArtikel(nummer,category) != null){
            System.out.println(verwalt.findeArtikel(nummer,category));
            System.out.println("Bitte Schreiben Sie ein neues Nummer des Artikel");
            int nNummer = input.nextInt();
            verwalt.NummerBearbeiten(nummer,nNummer,category);
        }
        if(antwortWeiter("Moechten Sie nochmal eine Nummer eines Artikel bearbeiten ").equals("j")){
            clrscr();
            NummerBearbeiten();
        }
        else{ 
            clrscr();
            artikelbearbeitenmenue();
        }

    } 

    public void bestandBearbeiten(){
        System.out.println("**************** Nummer ein Artikel bearbeiten ****************");

        int nummer = nummerTippen();
        String category=kategorieTippen();
        if(verwalt.findeArtikel(nummer,category) != null){
            System.out.println(verwalt.findeArtikel(nummer,category));
            System.out.println("Bitte Schreiben Sie ein neues Bestandswert des Artikel");
            int bestandWert= input.nextInt();
            verwalt.bestandBearbeiten(nummer,bestandWert,category);
        }

        if(antwortWeiter("Moechten Sie nochmal eine Bestand eines Artikel bearbeiten ").equals("j")){
            clrscr();
            bestandBearbeiten();
        }
        else{  
            clrscr();
            artikelbearbeitenmenue();
        }

    } 

    public  void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    } 
}
