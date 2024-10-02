import java.util.HashMap;
import java.util.Map;

public class Grid {
    private final int width;
    private final int height;
    private final Map<Position, GridComponent> grid = new HashMap<>();

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        initializeGrid();
    }

    private void initializeGrid() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid.put(new Position(x, y), new EmptySpace());
            }
        }
    }

    public void addObstacle(Position position) {
        grid.put(position, new Obstacle());
    }

    public boolean isObstacle(Position position) {
        GridComponent component = grid.get(position);
        return component != null && component.isObstacle();
    }

    public boolean isWithinBounds(Position position) {
        return position.getX() >= 0 && position.getX() < width &&
               position.getY() >= 0 && position.getY() < height;
    }
}