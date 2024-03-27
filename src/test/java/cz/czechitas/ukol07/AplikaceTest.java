package cz.czechitas.ukol07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AplikaceTest {
    private final KnihaSluzba seznamKnih = new KnihaSluzba();

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
}