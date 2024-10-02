interface DataSource {
    void writeData(String data);
    String readData();
}

class FileDataSource implements DataSource {
    private String filename;
    private StringBuilder content = new StringBuilder();

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeData(String data) {
        content.append(data);
        System.out.println("Writing plain data to file: " + filename);
    }

    @Override
    public String readData() {
        System.out.println("Reading plain data from file: " + filename);
        return content.toString();
    }
}

abstract class DataSourceDecorator implements DataSource {
    protected DataSource wrappee;

    DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}

class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        System.out.println("Compressing data");
        String compressedData = compress(data);
        wrappee.writeData(compressedData);
    }

    @Override
    public String readData() {
        String compressedData = wrappee.readData();
        System.out.println("Decompressing data");
        return decompress(compressedData);
    }

    private String compress(String data) {
        // Simplified compression simulation
        return data.replace("a", "").replace("e", "").replace("i", "").replace("o", "").replace("u", "");
    }

    private String decompress(String data) {
        // In reality, we can't decompress like this. This is just for demonstration.
        return "Decompressed: " + data;
    }
}

class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        System.out.println("Encrypting data");
        String encryptedData = encrypt(data);
        wrappee.writeData(encryptedData);
    }

    @Override
    public String readData() {
        String encryptedData = wrappee.readData();
        System.out.println("Decrypting data");
        return decrypt(encryptedData);
    }

    private String encrypt(String data) {
        // Simplified encryption simulation
        return "encrypted(" + data + ")";
    }

    private String decrypt(String data) {
        // Simplified decryption simulation
        return data.replace("encrypted(", "").replace(")", "");
    }
}

public class FileCompressionDemo {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSource encoded = new CompressionDecorator(
                                new EncryptionDecorator(
                                    new FileDataSource("OutputDemo.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}