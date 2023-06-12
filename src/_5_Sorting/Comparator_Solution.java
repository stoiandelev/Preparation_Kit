package _5_Sorting;

//Comparators are used to compare two objects.
// In this challenge, you'll create a comparator and use it to sort an array.

//It should sort first descending by score, then ascending by name.
// The code stub reads the input, creates a list of Player objects,
// uses your method to sort the data, and prints it out properly.

//Players(score) in descending order
// Name is ascending order
//The players are first sorted descending by score, then ascending by name.

//5
//amy 100
//david 100
//heraldo 50
//aakansha 75
//aleksa 150

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Comparator_Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfPlayers = scan.nextInt();

        Player[] player = new Player[numberOfPlayers];
        Checker checker = new Checker();

        for (int i = 0; i < numberOfPlayers; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);

        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].getName(), player[i].getScore());
        }
    }
}


class Checker implements Comparator<Player> {

//Players(score) in descending order
// Name is ascending order
//The players are first sorted descending by score, then ascending by name.

    @Override
    public int compare(Player o1, Player o2) {
//        return Comparator.comparing(Player::getScore).reversed()
//                .thenComparing(Player::getName)
//                .compare(o1, o2);

//return a.score == b.score ? compareName(a, b): compareScore(a, b);
//    }
//
//    private int compareScore(Player a, Player b){
//        return Integer.compare(b.score,a.score);
//    }
//    private int compareName(Player a, Player b){
//        return a.name.compareTo(b.name);
//    }

        if ((o2.getScore() - o1.getScore()) == 0) {
            return o1.getName().compareTo(o2.getName());
        }
        return o2.getScore() - o1.getScore();
    }
}


class Player {
    private String name;
    private Integer score;

    public Player(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public Player setScore(Integer score) {
        this.score = score;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(score, player.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
