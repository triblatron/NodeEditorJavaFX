import nodeeditor.Completion;
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

    @ParameterizedTest
    @CsvSource({"a,4,cat", "a,4,cab", "a,4,cabin", "b,2,cab", "b,2,cabin", "cat,2,cat", "cat,2,catamaran"})
    public void testSearchMultipleWords(String substring, int numMatches, String match) {
        Completion sut = new Completion();
        sut.addWord("cat");
        sut.addWord("cab");
        sut.addWord("cabin");
        sut.addWord("catamaran");
        ArrayList<String> matches = new ArrayList<>();
        sut.search(substring, matches);
        assertEquals(numMatches, matches.size());
        assertTrue(matches.contains(match));
    }
}
