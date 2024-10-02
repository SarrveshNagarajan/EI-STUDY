import java.util.HashMap;
import java.util.Map;

public class RoverController {
    private final Rover rover;
    private final Map<Character, Command> commands = new HashMap<>();

    public RoverController(Rover rover) {
        this.rover = rover;
        initializeCommands();
    }

    private void initializeCommands() {
        commands.put('M', new MoveCommand());
        commands.put('L', new TurnLeftCommand());
        commands.put('R', new TurnRightCommand());
    }

    public void executeCommands(char[] commandSequence) {
        for (char c : commandSequence) {
            Command command = commands.get(c);
            if (command != null) {
                command.execute(rover);
            }
        }
    }
}