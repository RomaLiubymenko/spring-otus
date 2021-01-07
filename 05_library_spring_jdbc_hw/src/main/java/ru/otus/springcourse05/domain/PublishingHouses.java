package ru.otus.springcourse05.domain;

import java.util.Objects;

public class PublishingHouses {

    private int idPublishingHouse;
    private String publishingName;
    private String country;

    public PublishingHouses() {
    }

    public PublishingHouses(int idPublishingHouse, String publishingName, String country) {
        this.idPublishingHouse = idPublishingHouse;
        this.publishingName = publishingName;
        this.country = country;
    }

    public int getIdPublishingHouse() {
        return idPublishingHouse;
    }

    public void setIdPublishingHouse(int idPublishingHouse) {
        this.idPublishingHouse = idPublishingHouse;
    }

    public String getPublishingName() {
        return publishingName;
    }

    public void setPublishingName(String publishingName) {
        this.publishingName = publishingName;
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
        PublishingHouses that = (PublishingHouses) o;
        return idPublishingHouse == that.idPublishingHouse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPublishingHouse);
    }

    @Override
    public String toString() {
        return "PublishingHouses{" +
                "idPublishingHouse=" + idPublishingHouse +
                ", publishingName='" + publishingName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
