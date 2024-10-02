# Design Patterns Exercise

In compliance with the given problem statement on Design patterns, I have created two use cases to demonstrated two sub patterns of each design pattern.

### 1. Behavioural Design Pattern

#### Observer Pattern

This implementation demonstrates the Observer pattern using a news agency scenario:

- `NewsSubscriber` is the observer interface with a `receiveNews` method.
- `NewsAgency` is the subject (observable) class that maintains a list of subscribers and notifies them of news updates.
- `NewsChannel` is a concrete implementation of `NewsSubscriber`.
- `NewsAgencyDemo` shows how to use these classes.

#### Strategy Pattern 

This implementation demonstrates the Strategy pattern in a game character context:

- `AttackStrategy` is the strategy interface with an `attack` method.
- `SwordAttack`, `BowAttack`, and `MagicAttack` are concrete implementations of the `AttackStrategy`.
- `GameCharacter` is the context class that uses the attack strategy.
- `GameStrategyDemo` shows how to use these classes.


### 2. Creational Design Pattern

#### Singleton Pattern

This implementation demonstrates the Singleton pattern using a Logger class:

- `Logger` is the Singleton class with a private constructor and a static `getInstance()` method.
- The Logger writes to a file using `PrintWriter`.
- `UserService` and `ProductService` are example classes that use the `Logger`.
- `LoggerDemo` shows how to use these classes.

#### Factoryton Pattern

This implementation demonstrates the Factory Method pattern using document creation as an example:

- `Document` is the interface that defines the common operations for all documents.
- `PDFDocument` and `WordDocument` are concrete implementations of the `Document` interface.
- `DocumentCreator` is the abstract creator class that declares the factory method `createDocument()`.
- `PDFCreator` and `WordCreator` are concrete creator classes that implement the factory method to create specific document types.
- The `editDocument()` method in `DocumentCreator` uses the factory method to create and work with documents without knowing their specific types.
- `DocumentCreatorDemo` shows how to use these classes, creating different types of documents using their respective creators.


### 3. Structural Design Pattern

#### Adapter Pattern

This implementation demonstrates the Adapter pattern in the context of shape drawing:

- `Shape` is the target interface that defines the `draw()` method.
- `Circle` is a class that already implements the `Shape` interface.
- `LegacyRectangle` is a pre-existing class that doesn't implement the `Shape` interface.
- `RectangleAdapter` is the adapter class that makes `LegacyRectangle` compatible with the `Shape` interface.
- The adapter holds an instance of `LegacyRectangle` and implements the `Shape` interface, translating the `draw()` method to `drawRectangle()`.
- `ShapeDrawingDemo` shows how to use both the `Circle` and the adapted `LegacyRectangle` uniformly through the `Shape` interface.

#### Decorator Pattern

This implementation demonstrates the Decorator pattern using file data operations:

- `DataSource` is the component interface that defines reading and writing operations.
- `FileDataSource` is the concrete component that implements basic file operations.
- `DataSourceDecorator` is the base decorator class that implements `DataSource` and holds a reference to a wrapped `DataSource` object.
- `CompressionDecorator` and `EncryptionDecorator` are concrete decorators that add compression and encryption behaviors respectively.
- Each decorator adds its own behavior before or after delegating to the wrapped object.
- `FileCompressionDemo` shows how to use these classes, creating a chain of decorators to add multiple behaviors (compression and encryption) to a basic file data source.