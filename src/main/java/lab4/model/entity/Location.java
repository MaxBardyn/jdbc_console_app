package lab4.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Scanner;

@Data
@Accessors(chain = true)
public class Location {


    private static final Scanner SCANNER = new Scanner(System.in);

    private Integer id;
    private String name;
    private String address;

    public Location(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public static Location getEventInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter address: ");
        String address = SCANNER.next();
        return new Location(name, address);
    }

    public Location(String name, String address) {
        this(-1, name, address);
    }
}
