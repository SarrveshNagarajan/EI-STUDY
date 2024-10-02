

public class Rover {
    private Position position;
    private Direction direction;
    private final Grid grid;
    private int obstaclesDetected;

    public Rover(Position position, Direction direction, Grid grid) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
        this.obstaclesDetected = 0;
    }

    public boolean move() {
        Position newPosition = calculateNewPosition();
        if (grid.isWithinBounds(newPosition)) {
            if (!grid.isObstacle(newPosition)) {
                position = newPosition;
                return true;
            } else {
                obstaclesDetected++;
                System.out.printf("Obstacle detected at (%d,%d)%n", newPosition.getX(), newPosition.getY());
                return false;
            }
        }
        return false;
    }

    private Position calculateNewPosition() {
        int newX = position.getX();
        int newY = position.getY();
        switch (direction) {
            case NORTH: newY++; break;
            case EAST:  newX++; break;
            case SOUTH: newY--; break;
            case WEST:  newX--; break;
        }
        return new Position(newX, newY);
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public String getStatusReport() {
        return String.format("Rover is at (%d, %d) facing %s. Total Obstacles detected: %d",
                position.getX(), position.getY(), direction.toString(), obstaclesDetected);
    }

    public int getObstaclesDetected() {
        return obstaclesDetected;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}