package nodeeditor;

import java.util.ArrayList;
import java.util.HashMap;

public class TrieNode {
    public static class Link {
        public Character key;
        TrieNode child;

        Link(Character key, TrieNode child) {
            this.key = key;
            this.child = child;
        }
    }
    private final HashMap<Character, Link> children = new HashMap<>();

    public void addWord(String word) {
        if (word == null || word.isEmpty()) {
            children.put('*',new TrieNode.Link('*', null));
            return;
        }
        String first = word.substring(0,1);
        String rest = null;
        if (word.length()>1) {
            rest = word.substring(1);
        }
        if (this.children.get(first.charAt(0))==null) {
            this.children.put(first.charAt(0),new Link(first.charAt(0), new TrieNode()));
        }
        this.children.get(first.charAt(0)).child.addWord(rest);
    }

    public void search(String word, ArrayList<String> matches) {
        search(word, matches, "");
    }

    private void search(String word, ArrayList<String> matches, String partialMatch) {
        if (word == null || word.isEmpty()) {
            // Depth-first search to build up possible rest of matches
            Object[] a = children.values().toArray();
            for (Object o : a) {
                Link link = (Link) o;
                if (link.key != '*') {
                    link.child.search(word, matches, partialMatch + link.key);
                }
                else {
                    matches.add(partialMatch);
                }
            }
            return;
        }
        char first = word.charAt(0);
        String rest = null;

        if (word.length()>1) {
            rest = word.substring(1);
        }

        Link child = children.get(first);

        if (child != null) {
            child.child.search(rest, matches, partialMatch + child.key);
        }
        else {
            Object[] a = children.values().toArray();
            for (int i=0; i<a.length; ++i) {
                Link link = (Link) a[i];

                link.child.search(word, matches, partialMatch + link.key);
            }
        }
    }
}
