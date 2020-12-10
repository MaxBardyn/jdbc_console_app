package lab4.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Scanner;

@Data
@Accessors(chain = true)
public class User {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Integer id;
    private String name;
    private String surname;
    private Integer age;

    public User(Integer id, String name, String surname, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public static User getUserInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter surname: ");
        String surname = SCANNER.next();
        System.out.println("Enter age: ");
        Integer age = SCANNER.nextInt();
        return new User(name, surname, age);
    }

    private User(String name, String surname, Integer age) {
        this(-1, name, surname, age);
    }
}
