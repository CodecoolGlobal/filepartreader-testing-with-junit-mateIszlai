import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    private FilePartReader fpr;

    public FileWordAnalyzer(FilePartReader fpr){
        this.fpr = fpr;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        return Arrays.stream(fpr.readLines().split("\\s"))
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        return Arrays.stream(fpr.readLines().split("\\s"))
                .filter(s -> s.contains(subString))
                .collect(Collectors.toList());
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        return Arrays.stream(fpr.readLines().split("\\s"))
                .filter(this::isPalindrome)
                .collect(Collectors.toList());

    }

    private boolean isPalindrome(String input) {
        StringBuilder reverse = new StringBuilder(input).reverse();
        return (reverse.toString()).equals(input);
    }
}
