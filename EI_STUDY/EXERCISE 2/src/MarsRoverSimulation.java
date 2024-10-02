public class MarsRoverSimulation {
    public static void main(String[] args) {
        Grid grid = new Grid(10, 10);
        grid.addObstacle(new Position(2, 2));
        grid.addObstacle(new Position(3, 5));

        Rover rover = new Rover(new Position(0, 0), Direction.NORTH, grid);
        RoverController controller = new RoverController(rover);

        char[] commands = {'M', 'L', 'R', 'M', 'L', 'M'};
        controller.executeCommands(commands);

        System.out.println(rover.getStatusReport());
    }
}