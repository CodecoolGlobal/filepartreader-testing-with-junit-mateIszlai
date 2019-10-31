import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Test
    public void testOneLineAlphabetical() throws IOException {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("test.txt", 1,1);
        FileWordAnalyzer fa = new FileWordAnalyzer(fpr);
        List<String> result = new ArrayList<>();
        result.add("aaaa");
        result.add("bb");
        result.add("c");
        assertEquals(result, fa.getWordsOrderedAlphabetically());
    }

    @Test
    public void testFromLine1To3Alphabetical() throws IOException {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("test.txt", 1,3);
        FileWordAnalyzer fa = new FileWordAnalyzer(fpr);
        List<String> result = new ArrayList<>();
        result.add("a");
        result.add("aaaa");
        result.add("bb");
        result.add("bbbb");
        result.add("c");
        result.add("cc");
        result.add("cccc");
        result.add("dd");
        assertEquals(result, fa.getWordsOrderedAlphabetically());
    }

    @Test
    public void testContainingCLetter() throws IOException {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("test.txt", 1,3);
        FileWordAnalyzer fa = new FileWordAnalyzer(fpr);
        List<String> result = new ArrayList<>();
        result.add("c");
        result.add("cc");
        result.add("cccc");
        assertEquals(result, fa.getWordsContainingSubstring("c"));
    }

    @Test
    public void testContainingCCSubString() throws IOException {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("test.txt", 1,3);
        FileWordAnalyzer fa = new FileWordAnalyzer(fpr);
        List<String> result = new ArrayList<>();
        result.add("cc");
        result.add("cccc");
        assertEquals(result, fa.getWordsContainingSubstring("cc"));
    }

    @Test
    public void testIsPalindrom() throws IOException {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("test.txt", 5,8);
        FileWordAnalyzer fa = new FileWordAnalyzer(fpr);
        List<String> result = new ArrayList<>();
        result.add("eeee");
        result.add("ff");
        result.add("asdsa");
        result.add("asdfdsa");
        assertEquals(result, fa.getStringsWhichPalindromes());
    }
}