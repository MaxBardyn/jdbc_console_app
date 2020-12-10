package lab4.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Scanner;

@Data
@Accessors(chain = true)
public class Ticket {


    private static final Scanner SCANNER = new Scanner(System.in);

    private Integer id;
    private Integer price;
    private String sector;
    private String placeNumber;
    private Integer eventId;
    private Integer ticketOfficeId;

    public Ticket(Integer id, Integer price, String sector, String placeNumber, Integer eventId, Integer ticketOfficeId) {
        this.id = id;
        this.price = price;
        this.sector = sector;
        this.placeNumber = placeNumber;
        this.eventId = eventId;
        this.ticketOfficeId = ticketOfficeId;
    }

    public static Ticket getEventInputs() {
        System.out.println("\nEnter price: ");
        Integer price = SCANNER.nextInt();
        System.out.println("\nEnter sector: ");
        String sector = SCANNER.next();
        System.out.println("\nEnter place_number: ");
        String placeNumber = SCANNER.next();
        System.out.println("\nEnter event_id: ");
        Integer eventId = SCANNER.nextInt();
        System.out.println("\nEnter place_number: ");
        Integer ticketOfficeId = SCANNER.nextInt();
        return new Ticket(price, sector, placeNumber, eventId, ticketOfficeId);
    }

    private Ticket(Integer price, String sector, String placeNumber, Integer eventId, Integer ticketOfficeId) {
        this(-1, price, sector, placeNumber, eventId, ticketOfficeId);
    }
}
