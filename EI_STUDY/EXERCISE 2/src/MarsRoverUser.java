
import java.util.Scanner;

public class MarsRoverUser {
    public static void main(String[] args) {
        Grid grid = new Grid(10, 10);
        grid.addObstacle(new Position(2, 2));
        grid.addObstacle(new Position(3, 5));

        Rover rover = new Rover(new Position(0, 0), Direction.NORTH, grid);
        RoverController controller = new RoverController(rover);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Mars Rover Simulation!");
        System.out.println("Enter commands for the rover (M: Move, L: Turn Left, R: Turn Right, S: Stop)");
        System.out.println("Enter commands one by one and press Enter after each command.");

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().toUpperCase();
            
            if (input.isEmpty()) {
                continue;
            }

            char command = input.charAt(0);
            
            if (command == 'S') {
                break;
            }

            if (command == 'M' || command == 'L' || command == 'R') {
                controller.executeCommands(new char[]{command});
                System.out.println(rover.getStatusReport());
            } else {
                System.out.println("Invalid command. Please use M, L, R, or S.");
            }
        }

        System.out.println("Simulation ended.");
        System.out.println("Final " + rover.getStatusReport());
        
        scanner.close();
    }
}