package lab4.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Scanner;

@Data
@Accessors(chain = true)
public class TicketOffice {


    private static final Scanner SCANNER = new Scanner(System.in);

    private Integer id;
    private Integer locationId;

    public TicketOffice(Integer id, Integer locationId) {
        this.id = id;
        this.locationId = locationId;
    }

    public static TicketOffice getTicketInputs() {
        System.out.println("\nEnter location_id: ");
        Integer locationId = SCANNER.nextInt();
        return new TicketOffice(locationId);
    }

    private TicketOffice(Integer locationId) {
        this(-1, locationId);
    }
}
