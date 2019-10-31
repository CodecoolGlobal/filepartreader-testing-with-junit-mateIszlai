import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    @Test
    public void testFromLineIsBelow1ThrowException() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {
            filePartReader.setup("text.txt", 0, 2);
        });
    }

    @Test
    public void testToLineIsBelowFromLineThrowException() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {
            filePartReader.setup("text.txt", 2, 1);
            });
    }

    @Test
    public void testIfWrongFilePathThrowException(){
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("wrongPath",1,5);
        assertThrows(IOException.class, () -> {
            filePartReader.read();
        });
    }

    @Test
    public void testRead() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("test.txt",1,5);
        assertEquals("1aaaa\n2bbbb\n3cccc\n4dddd\n5eeee\n",filePartReader.read());
    }

    @Test
    public void testReadLineFromLine1ToLine1() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("test.txt",1,1);
        assertEquals("1aaaa",filePartReader.readLines());
    }

    @Test
    public void testReadLineFrom1To4() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("test.txt",1,4);
        assertEquals("1aaaa\n2bbbb\n3cccc\n4dddd",filePartReader.readLines());
    }
}