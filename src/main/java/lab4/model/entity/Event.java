package lab4.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Scanner;

@Data
@Accessors(chain = true)
public class Event {


    private static final Scanner SCANNER = new Scanner(System.in);

    private Integer id;
    private String name;
    private Integer locationId;
    private Integer artistId;

    public Event(Integer id, String name, Integer locationId, Integer artistId) {
        this.id = id;
        this.name = name;
        this.locationId = locationId;
        this.artistId = artistId;
    }

    public static Event getEventInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter location_id: ");
        Integer locationId = SCANNER.nextInt();
        System.out.println("\nEnter artist_id: ");
        Integer artistId = SCANNER.nextInt();
        return new Event(name, locationId, artistId);
    }

    private Event(String name, Integer locationId, Integer artistId) {
        this(-1, name, locationId, artistId);
    }
}
