package ru.otus.springcourse05.domain;

import java.util.Objects;

public class Authors {

    private int idAuthor;
    private String firstname;
    private String lastname;
    private String country;

    public Authors() {
    }

    public Authors(int idAuthor, String firstname, String lastname, String country) {
        this.idAuthor = idAuthor;
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authors authors = (Authors) o;
        return idAuthor == authors.idAuthor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAuthor);
    }

    @Override
    public String toString() {
        return "Authors{" +
                "idAuthor=" + idAuthor +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

