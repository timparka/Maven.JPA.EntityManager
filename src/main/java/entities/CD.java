package entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "cd")
public class CD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int year;
    private double price;

    @ManyToMany(mappedBy = "cds")
    private Set<Artist> artists = new HashSet<>();

    public CD() {
    }

    public CD(String title, String description, int year, double price) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.price = price;
    }

    public CD(String title, String description, int year, double price, Set<Artist> artists) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.price = price;
        this.artists = artists;
    }

    public CD(Long id, String title, String description, int year, double price, Set<Artist> artists) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
        this.price = price;
        this.artists = artists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "CD{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", artists=" + artists +
                '}';
    }
}

