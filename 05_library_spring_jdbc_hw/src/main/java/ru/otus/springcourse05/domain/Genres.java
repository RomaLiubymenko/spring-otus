package ru.otus.springcourse05.domain;

import java.util.Objects;

public class Genres {

    private int idGenre;
    private String nameGenre;

    public Genres() {
    }

    public Genres(int idGenre, String nameGenre) {
        this.idGenre = idGenre;
        this.nameGenre = nameGenre;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getNameGenre() {
        return nameGenre;
    }

    public void setNameGenre(String nameGenre) {
        this.nameGenre = nameGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genres genres = (Genres) o;
        return idGenre == genres.idGenre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenre);
    }

    @Override
    public String toString() {
        return "Genres{" +
                "idGenre=" + idGenre +
                ", nameGenre='" + nameGenre + '\'' +
                '}';
    }
}
