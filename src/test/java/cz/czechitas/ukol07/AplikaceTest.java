package cz.czechitas.ukol07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AplikaceTest {
    private final KnihaSluzba seznamKnih = new KnihaSluzba();
    private final Kniha kniha = new Kniha();


    @Test
    void vypisVsechnyKnihy() {
        assertNotNull(seznamKnih);
    }

    @Test
    void vypisKnihyOdAutora() {
        assertAll(
                () -> assertEquals(seznamKnih.vypisKnihyOdAutora("Božena Němcová").size(), 4),
                () -> assertEquals(seznamKnih.vypisKnihyOdAutora("Božena Čechová").size(), 0)
        );
    }

    @Test
    void vypisKnihyZRoku() {
        assertAll(
                () -> assertEquals(seznamKnih.vypisKnihyZroku(1929).size(), 1),
                () -> assertEquals(seznamKnih.vypisKnihyZroku(2007).size(), 0)
        );
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
        kniha.setAutor("Jaroslav Foglar");
        assertEquals("Jaroslav Foglar", kniha.getAutor());
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
        kniha.setNazev("Hoši od bobří řeky");
        assertEquals("Hoši od bobří řeky", kniha.getNazev());
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
        kniha.setRokVydani(1937);
        assertEquals(1937, kniha.getRokVydani());
    }

}