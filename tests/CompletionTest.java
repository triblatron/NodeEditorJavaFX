import nodeeditor.Completion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompletionTest {
    @ParameterizedTest
    @CsvSource({"Graph,Gr,Graph","Graph|Add Node|Math|Trig,Add,Graph|Add Node|Math|Trig"})
    public void testAddWord(String word, String substring, String matchString) {
        Completion sut = new Completion();
        sut.addWord(word);
        assertEquals(1, sut.numWords());
        assertEquals(matchString, sut.search(substring));
    }
}
