package cz.czechitas.ukol07;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AplikaceTest {
    private final KnihaSluzba seznamKnih = new KnihaSluzba();
    private final Kniha kniha = new Kniha();


    @Test
    void setSeznamKnihNeniPrazdny() {
        assert (!seznamKnih.vypisVsechnyKnihy().isEmpty());
    }


    @Test
    void vypisKnihyOdAutora() {
        assertEquals(seznamKnih.vypisKnihyOdAutora("Božena Němcová").size(), 4);
        assertEquals(seznamKnih.vypisKnihyOdAutora("Božena Němcová"), List.of(
                new Kniha("Božena Němcová", "V zámku a podzámčí", 1856),
                new Kniha("Božena Němcová", "Divá Bára", 1856),
                new Kniha("Božena Němcová", "Babička", 1855),
                new Kniha("Božena Němcová", "Národní báchorky a pověsti", 1845)));

        assertEquals(seznamKnih.vypisKnihyOdAutora("Božena Čechová").size(), 0);
        assertEquals(seznamKnih.vypisKnihyOdAutora("Božena Čechová"), List.of());
    }

    @Test
    void vypisKnihyZRoku() {
        assertEquals(seznamKnih.vypisKnihyZroku(1929).size(), 1);
        assertEquals(seznamKnih.vypisKnihyZroku(1929), List.of(new Kniha("Josef Čapek", "Povídání o pejskovi a kočičce", 1929)));

        assertEquals(seznamKnih.vypisKnihyZroku(2007), List.of());
    }

    @Test
    void setAutorNull() {
        try {
            kniha.setAutor(null);
            fail("setAutorNull - Ocekavalo se vyhozeni IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            System.out.println("setAutorNull - Vyhozena ocekavana vyjimka IllegalArgumentException");
        }
    }

    @Test
    void setAutorEmpty() {
        try {
            kniha.setAutor("");
            fail("setAutorEmpty - Ocekavalo se vyhozeni IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            System.out.println("setAutorEmpty - Vyhozena ocekavana vyjimka IllegalArgumentException");
        }
    }

    @Test
    void setAutorOK() {
        String testovanyAutor = "Jaroslav Foglar";
        kniha.setAutor(testovanyAutor);
        assertEquals(testovanyAutor, kniha.getAutor());
    }

    @Test
    void setNazevNull() {
        try {
            kniha.setNazev(null);
            fail("setNazevNull - Ocekavalo se vyhozeni IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            System.out.println("setNazevNull - Vyhozena ocekavana vyjimka IllegalArgumentException");
        }
    }

    @Test
    void setNazevEmpty() {
        try {
            kniha.setNazev("");
            fail("setNazevEmpty - Ocekavalo se vyhozeni IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            System.out.println("setNazevEmpty - Vyhozena ocekavana vyjimka IllegalArgumentException");
        }
    }

    @Test
    void setNazevOK() {
        String testovanyNazev = "Hoši od bobří řeky";
        kniha.setNazev(testovanyNazev);
        assertEquals(testovanyNazev, kniha.getNazev());
    }

    @Test
    void setRokVydaniPod1440() {
        try {
            kniha.setRokVydani(1200);
            fail("setRokVydaniPod1440 - Ocekavalo se vyhozeni IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            System.out.println("setRokVydaniPod1440 - Vyhozena ocekavana vyjimka IllegalArgumentException");
        }
    }

    @Test
    void setRokVydaniNad2024() {
        try {
            kniha.setRokVydani(2050);
            fail("setRokVydaniNad2024 - Ocekavalo se vyhozeni IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            System.out.println("setRokVydaniNad2024 - Vyhozena ocekavana vyjimka IllegalArgumentException");
        }
    }

    @Test
    void setRokVydaniOK() {
        int testovanyRok = 1937;
        kniha.setRokVydani(testovanyRok);
        assertEquals(testovanyRok, kniha.getRokVydani());
    }
}