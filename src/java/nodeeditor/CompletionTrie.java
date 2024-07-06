package nodeeditor;

import java.util.ArrayList;

public class CompletionTrie implements Completion {

    public void addWord(String word) {
        root.addWord(word);
        ++this.numWords;
    }

    public int numWords() {
        return this.numWords;
    }

    public void search(String substring, ArrayList<String> matches) {
        root.search(substring,matches);
    }

    private final TrieNode root = new TrieNode();
    private int numWords;
}
