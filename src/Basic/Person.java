package Basic;

/**
 * Задача 2 - да се напише програма в която ясно се вижда, че всички мъже над 18 гадини,
 * задължително отиват в казарма и всички жени над 18 години отиват по желание
 * <p></p>
 * Задача 3 - как ще отркиеш игла в купа сена  - с магнит, може да запалиш сеното,
 * може да го сложиш във вода и иглата ще потъне.
 */

public class Person {
    public String name;
    public int age;

    // 0 for don't want, 1 for want
    public int wantsBarracks;

    // 0 for male, 1 for female
    public int gender;

    //create constructor for class Person
    public Person(String name, int age, int gender, int wantsBarracks) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.wantsBarracks = wantsBarracks;
    }
}

class Main {
    public static void main(String[] args) {

        Person person = new Person("Ivan", 19, 0, 1);

        //gender woman = 1, wantsBarracks = 1
        if ((person.age > 18 && person.gender == 1 && person.wantsBarracks == 1) ||
                (person.age > 18 && person.gender == 0)) {
            System.out.println("Отива в казарма");
        } else {
            System.out.println("Не отива в казарма");
        }

    }
}


