package lab4.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Scanner;

@Data
@Accessors(chain = true)
public class Artist {


    private static final Scanner scanner = new Scanner(System.in);

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String alias;

    public Artist(Integer id, String name, String surname, Integer age, String alias) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.alias = alias;
    }

    public static Artist getArtistInputs() {
        System.out.println("\nEnter name: ");
        String name = scanner.next();
        System.out.println("Enter surname: ");
        String surname = scanner.next();
        System.out.println("Enter age: ");
        Integer age = scanner.nextInt();
        System.out.println("Enter alias: ");
        String alias = scanner.next();
        return new Artist(name, surname, age, alias);
    }

    private Artist(String name, String surname, Integer age, String alias) {
        this(-1, name, surname, age, alias);
    }
}
