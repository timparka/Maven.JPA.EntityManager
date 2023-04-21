package entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String instrument;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "artist_cd",
            joinColumns = { @JoinColumn(name = "artist_id") },
            inverseJoinColumns = { @JoinColumn(name = "cd_id") }
    )
    private Set<CD> cds = new HashSet<>();

    public Artist() {
    }

    public Artist(String first_name, String last_name, String instrument, Set<CD> cds) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.instrument = instrument;
        this.cds = cds;
    }

    public Artist(Long id, String first_name, String last_name, String instrument, Set<CD> cds) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.instrument = instrument;
        this.cds = cds;
    }

    public Artist(String first_name, String last_name, String instrument) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.instrument = instrument;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Set<CD> getCds() {
        return cds;
    }

    public void setCds(Set<CD> cds) {
        this.cds = cds;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", instrument='" + instrument + '\'' +
                ", cds=" + cds +
                '}';
    }
}
