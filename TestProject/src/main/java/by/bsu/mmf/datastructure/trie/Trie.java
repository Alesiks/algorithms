package by.bsu.mmf.datastructure.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void addValue(String value) {
        if (value == null || value.isEmpty()) {
            return;
        }

        TrieNode currNode = root;
        currNode.incrementNumOfCompleteWords();
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);

            if (!currNode.hasChildNode(ch)) {
                currNode.addChildNode(ch);
            }
            currNode = currNode.getChildNode(ch);
            currNode.incrementNumOfCompleteWords();
        }
        currNode.setCompleteWord(true);
    }


    public List<String> findValuesByPrefix(String prefix) {
        List<String> result = new ArrayList<>();

        TrieNode currNode = root;
        boolean isPrefixExist = true;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!currNode.hasChildNode(ch)) {
                isPrefixExist = false;
                break;
            }
            currNode = currNode.getChildNode(ch);
        }

        if (isPrefixExist) {
            if (currNode.isCompleteWord) {
                result.add(prefix);
            }
            getAllWords(currNode, result, prefix);
        }

        return result;
    }

    private void getAllWords(TrieNode currNode, List<String> result, String currWord) {
        if (currNode != null) {
            Map<Character, TrieNode> childrenNodes = currNode.getChildrenNodes();
            for (Map.Entry<Character, TrieNode> entry : childrenNodes.entrySet()) {
                String tempWord = currWord + entry.getKey();
                if (entry.getValue().isCompleteWord) {
                    result.add(tempWord);
                }
                getAllWords(entry.getValue(), result, tempWord);
            }
        }
    }

    public int getNumOfWordsByPrefix(String prefix) {
        TrieNode currNode = root;
        boolean isPrefixExist = true;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!currNode.hasChildNode(ch)) {
                isPrefixExist = false;
                break;
            }
            currNode = currNode.getChildNode(ch);
        }

        int count = isPrefixExist ? currNode.getNumOfCompleteWords() : 0;

        return count;
    }
}


class TrieNode {

    private int numOfCompleteWords = 0;
    private Map<Character, TrieNode> childrenNodes = new HashMap<>();
    boolean isCompleteWord;

    public Map<Character, TrieNode> getChildrenNodes() {
        return childrenNodes;
    }

    public boolean hasChildNode(char ch) {
        return childrenNodes.containsKey(ch);
    }

    public TrieNode getChildNode(char ch) {
        return childrenNodes.get(ch);
    }

    public void addChildNode(char ch) {
        childrenNodes.put(ch, new TrieNode());
    }

    public void setCompleteWord(boolean completeWord) {
        isCompleteWord = completeWord;
    }

    public boolean isCompleteWord() {
        return isCompleteWord;
    }

    public void incrementNumOfCompleteWords() {
        numOfCompleteWords++;
    }

    public int getNumOfCompleteWords() {
        return numOfCompleteWords;
    }
}