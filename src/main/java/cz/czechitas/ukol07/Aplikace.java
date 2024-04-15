package cz.czechitas.ukol07;

/**
 * Spouštěcí třída aplikace
 */
public class Aplikace{
    public static void main(String[] args) {

        new Aplikace().run();

    }


    public void run() {
        KnihaSluzba seznamKnih = new KnihaSluzba();

        System.out.println("Celkovy pocet knih: " + seznamKnih.vypisVsechnyKnihy().size());
        System.out.println("--------------------------------");

        System.out.println("Knihy od Karla Čapka: ");
        seznamKnih.vypisKnihyOdAutora("Karel Čapek").forEach(kniha -> System.out.println(kniha.getAutor() + ": " + kniha.getNazev()));
        System.out.println("--------------------------------");
        System.out.println(seznamKnih.vypisKnihyOdAutora("Božena Němcová"));

        System.out.println("Knihy z roku 1845: ");
        seznamKnih.vypisKnihyZroku(1845).forEach(kniha -> System.out.println(kniha.getAutor() + ": " + kniha.getNazev()));
    }
}
