import nodeeditor.CompletionTrie;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CompletionTrieTest extends CompletionTest {
    @ParameterizedTest
    @CsvSource({"Graph,Gr,Graph","Graph|Add Node|Math|Trig,Add,Graph|Add Node|Math|Trig"})
    public void testAddWord(String word, String substring, String matchString) {
        CompletionTrie sut = new CompletionTrie();
        sut.addWord(word);
        assertEquals(1, sut.numWords());
        ArrayList<String> matches = new ArrayList<>();
        sut.search(substring, matches);
        assertFalse(matches.isEmpty());
        assertEquals(matchString, matches.get(0));
    }

    @ParameterizedTest
    @CsvSource({
            // Match at middle of multiple words
            "a,6,cat",
            "a,6,cab",
            "a,6,cabin",
            "b,2,cab",
            "b,2,cabin",
            "cat,2,cat",
            "cat,2,catamaran",
            "at,4,cat",
            "at,4,catamaran",
            "ta,1,catamaran",
            // Match in middle
            "Add,2,Node|Add|Math|Trig",
            "Add,2,Node|Add|Math|RelOp",
            // Match at end
            "RelOp,1,Node|Add|Math|RelOp",
    })
    public void testSearchMultipleWords(String substring, int numMatches, String match) {
        CompletionTrie sut = new CompletionTrie();

        addMultipleWords(sut);
        ArrayList<String> matches = new ArrayList<>();
        sut.search(substring, matches);
        assertEquals(numMatches, matches.size());
        assertTrue(matches.contains(match));
    }

    @ParameterizedTest
    @CsvSource({
            "Vector"
    })
    public void testNoMatches(String substring) {
        CompletionTrie sut = new CompletionTrie();
        addNoMatches(sut);
        ArrayList<String> matches = new ArrayList<>();
        sut.search(substring, matches);
        assertEquals(0, matches.size());
    }
}
