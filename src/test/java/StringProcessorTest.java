import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {
    StringProcessor stringProcessor = new StringProcessor();

    @Test
    void processTextTest() {
        assertEquals("[ewbfual, uifal, oem]",stringProcessor.processText("oem uifal ewbfual liuewfa"));
    }

    @Test
    void sortWordsAlphabetOrderTest() {
        List<String> list = new ArrayList<>();
        list.add("Yggdrasil");
        list.add("ioexception");
        assertEquals(stringProcessor.sortWordsAlphabetOrder(list).toString(),"[Yggdrasil, ioexception]");

    }

    @Test
    void shouldBeSwappedTest() {
        assertEquals(false,stringProcessor.shouldBeSwapped("import","oexception"));
    }
}