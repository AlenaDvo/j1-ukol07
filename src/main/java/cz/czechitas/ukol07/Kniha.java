package cz.czechitas.ukol07;

/**
 * Informace o knihach.
 */
public class Kniha {
    private String autor;
    private String nazev;
    private int rokVydani;

    public Kniha(String autor, String nazev, int rokVydani) {
        this.autor = autor;
        this.nazev = nazev;
        this.rokVydani = rokVydani;
    }

    public Kniha() {
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null) {
            throw new IllegalArgumentException("Parametr autor je null.");
        } else if (autor.isEmpty()) {
            throw new IllegalArgumentException("Parametr autor je prazdny.");
        } else {
            this.autor = autor;
        }
    }


    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        if (nazev == null) {
            throw new IllegalArgumentException("Parametr nazev je null.");
        } else if (nazev.isEmpty()) {
            throw new IllegalArgumentException("Parametr nazev je prazdny.");
        } else {
            this.nazev = nazev;
        }
    }

    public int getRokVydani() {
        return rokVydani;
    }

    public void setRokVydani(int rokVydani) {
        if (rokVydani >= 1440 & rokVydani < 2024) {
            this.rokVydani = rokVydani;
        } else {
            throw new IllegalArgumentException("Parametr rokVydani nesmi byt mensi nez 1440 a vetsi nez 2024.");
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%d)", autor, nazev, rokVydani);
    }
}
