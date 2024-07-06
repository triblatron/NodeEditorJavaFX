package nodeeditor;

import java.util.ArrayList;

public class CompletionSubstring implements Completion {

    @Override
    public void addWord(String word) {
        words.add(word);
    }

    @Override
    public int numWords() {
        return words.size();
    }

    @Override
    public void search(String substring, ArrayList<String> matches) {
        for (String word : words) {
            if (word.contains(substring)) {
                matches.add(word);
            }
        }
    }

    private final ArrayList<String> words = new ArrayList<>();
}
