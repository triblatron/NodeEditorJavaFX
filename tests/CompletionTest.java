import nodeeditor.Completion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CompletionTest {
    @ParameterizedTest
    @CsvSource({"Graph,Gr,Graph","Graph|Add Node|Math|Trig,Add,Graph|Add Node|Math|Trig"})
    public void testAddWord(String word, String substring, String matchString) {
        Completion sut = new Completion();
        sut.addWord(word);
        assertEquals(1, sut.numWords());
        ArrayList<String> matches = new ArrayList<>();
        sut.search(substring, matches);
        assertFalse(matches.isEmpty());
        assertEquals(matchString, matches.get(0));
    }

    @Test
    public void testSearchMultipleWords() {
        Completion sut = new Completion();
        sut.addWord("cat");
        sut.addWord("cab");
        ArrayList<String> matches = new ArrayList<>();
        sut.search("a", matches);
        assertFalse(matches.isEmpty());
        assertTrue(matches.contains("cat"));
        assertTrue(matches.contains("cab"));
    }
}
