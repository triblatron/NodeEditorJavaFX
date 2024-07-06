package nodeeditor;

import java.util.ArrayList;

public interface Completion {
    void addWord(String word);

    int numWords();

    void search(String substring, ArrayList<String> matches);
}
