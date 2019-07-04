import java.util.ArrayList;
import java.util.List;


public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > winner.getDistance()) {
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        Horse horse1 = new Horse("Willy", 3, 0);
        Horse horse2 = new Horse("Lucha", 3, 0);
        Horse horse3 = new Horse("Nusha", 3, 0);

        List<Horse> list = new ArrayList<>();
        list.add(horse1);
        list.add(horse2);
        list.add(horse3);

        game = new Hippodrome(list);
        game.run();
        game.printWinner();
    }
}
