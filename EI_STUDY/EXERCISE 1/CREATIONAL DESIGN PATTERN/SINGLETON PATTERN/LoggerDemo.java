import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Logger {
    private static Logger instance;
    private PrintWriter writer;
    private static final String LOG_FILE = "application.log";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Logger() {
        try {
            FileWriter fw = new FileWriter(LOG_FILE, true);
            writer = new PrintWriter(fw, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        String logEntry = LocalDateTime.now().format(formatter) + " - " + message;
        writer.println(logEntry);
        System.out.println("Logged: " + logEntry);  // Print to console as well
    }

    public void close() {
        writer.close();
    }
}

class UserService {
    private Logger logger = Logger.getInstance();

    public void createUser(String username) {
        // Simulating user creation
        logger.log("User created: " + username);
    }
}

class ProductService {
    private Logger logger = Logger.getInstance();

    public void addProduct(String productName) {
        // Simulating product addition
        logger.log("Product added: " + productName);
    }
}

public class LoggerDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        
        logger.log("Application started");

        UserService userService = new UserService();
        ProductService productService = new ProductService();

        userService.createUser("Alice");
        productService.addProduct("Laptop");
        userService.createUser("Bob");
        productService.addProduct("Smartphone");

        logger.log("Application finished");

        logger.close();
    }
}