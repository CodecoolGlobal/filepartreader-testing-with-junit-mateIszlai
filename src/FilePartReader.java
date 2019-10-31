import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;


    public FilePartReader() {
        this.filePath = null;
        this.fromLine = 0;
        this.toLine = 0;
    }

    public void setup(String filePath, int fromLine, int toLine) throws IllegalArgumentException {
        if (toLine < fromLine) {
            throw new IllegalArgumentException("fromLine < toLine");
        } else if (fromLine < 1) {
            throw new IllegalArgumentException("fromLine < 1");
        } else {
            this.filePath = filePath;
            this.toLine = toLine;
            this.fromLine = fromLine;
        }
    }

    public String read() throws IOException {
        File file = new File(this.filePath);
        Scanner sc = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()){
            sb.append(sc.nextLine()).append("\n");
        }
        return sb.toString();
    }

    public String readLines() throws IOException {
        String data = this.read();
        String[] dataArray = data.split("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = this.fromLine - 1; i < this.toLine; i++) {
            sb.append(dataArray[i]).append("\n");
        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        return sb.toString();
    }
}
