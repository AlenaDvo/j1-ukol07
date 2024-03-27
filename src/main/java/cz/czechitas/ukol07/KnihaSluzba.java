package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Informace o seznamu knih.
 */

public class KnihaSluzba {
    private List<Kniha> seznamKnih;

    public KnihaSluzba() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = KnihaSluzba.class.getResourceAsStream("knihy.json")) {
            seznamKnih = objectMapper.readValue(inputStream, new TypeReference<List<Kniha>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Nepodarilo se nacist soubor knih.", e);
        }
    }

    @Override
    public String toString() {
        return "Seznam knih: " + System.getProperty("line.separator") + seznamKnih;
    }

    public List<Kniha> vypisVsechnyKnihy() {
        return seznamKnih;
    }

    public List<Kniha> vypisKnihyOdAutora(String autor) {
        return seznamKnih.stream()
                .filter((kniha) -> kniha.getAutor().equals(autor))
                .toList();
    }

    public List<Kniha> vypisKnihyZroku(int rokVydani) {
        return seznamKnih.stream()
                .filter((kniha) -> kniha.getRokVydani() == rokVydani)
                .toList();
    }
}