package ru.otus.springcourse07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PublishingHouses")
public class PublishingHouse {

    @Id
    @Column(name = "idPublishingHouse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublishingHouse;

    @Column( name = "publishingName", nullable = false, length = 100)
    private String publishingName;

    @Column(nullable = false, length = 100)
    private String country;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "publishingHouse")
    @ToString.Exclude
    private List<Book> bookList;

    @Override
    public String toString(){
        return String.valueOf(this.getIdPublishingHouse());
    }
}
