import entities.Artist;
import entities.CD;
import services.ArtistService;
import services.CDService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        CDService cdService = new CDService();
        ArtistService artistService = new ArtistService();

        // Create artists
        Artist artist1 = new Artist("John", "Doe", "Guitar");
        Artist artist2 = new Artist("Jane", "Smith", "Piano");
        artistService.create(artist1);
        artistService.create(artist2);

        // Create a CD
        CD cd = new CD("Album Title", "Album Description", 2023, 15.99);
        cd.getArtists().add(artist1);
        cd.getArtists().add(artist2);
        cdService.create(cd);

        // Find and display all CDs
        List<CD> cds = cdService.findAll();
        for (CD cdItem : cds) {
            System.out.println(cdItem);
        }

        // Find and display all artists
        List<Artist> artists = artistService.findAll();
        for (Artist artist : artists) {
            System.out.println(artist);
        }
    }
}
