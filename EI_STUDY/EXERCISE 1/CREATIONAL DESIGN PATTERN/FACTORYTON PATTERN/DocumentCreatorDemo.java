interface Document {
    void open();
    void save();
}

class PDFDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document");
    }
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document");
    }
}

abstract class DocumentCreator {
    public abstract Document createDocument();

    public void editDocument() {
        Document doc = createDocument();
        doc.open();
        // Edit the document
        doc.save();
    }
}

class PDFCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new PDFDocument();
    }
}

class WordCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

public class DocumentCreatorDemo {
    public static void main(String[] args) {
        DocumentCreator pdfCreator = new PDFCreator();
        pdfCreator.editDocument();

        DocumentCreator wordCreator = new WordCreator();
        wordCreator.editDocument();
    }
}