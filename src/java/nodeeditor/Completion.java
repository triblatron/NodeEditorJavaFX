package nodeeditor;

public class Completion {

    public void addWord(String word) {
        root.addWord(word);
        ++this.numWords;
    }

    public int numWords() {
        return this.numWords;
    }

    public String search(String substring) {
        return root.search(substring);
    }

    private final TrieNode root = new TrieNode();
    private int numWords;
}
