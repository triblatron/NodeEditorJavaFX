import nodeeditor.Completion;

public class CompletionTest {
    public void addMultipleWords(Completion sut) {
        sut.addWord("cat");
        sut.addWord("cab");
        sut.addWord("cabin");
        sut.addWord("catamaran");
        sut.addWord("Node|Add|Math|Trig");
        sut.addWord("Node|Add|Math|RelOp");
    }

    public void addNoMatches(Completion sut) {
        sut.addWord("Node|Add|Math|Trig");
        sut.addWord("Node|Add|Math|RelOp");
        sut.addWord("Node|Add|Math|Constant");
    }
}
