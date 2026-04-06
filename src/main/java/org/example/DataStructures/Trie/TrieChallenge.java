package org.example.DataStructures.Trie;

import java.util.*;

/**
 * ============================================================
 *            TRIE CHALLENGES — LeetCode Style
 * ============================================================
 */
public class TrieChallenge {

    static class TrieNode {
        TrieNode[] ch = new TrieNode[26]; boolean end;
        boolean has(char c){return ch[c-'a']!=null;}
        TrieNode get(char c){return ch[c-'a'];}
        void add(char c){ch[c-'a']=new TrieNode();}
    }

    // =========================================================
    // CHALLENGE 1  [EASY]  — Implement Trie (Prefix Tree)
    // insert(word), search(word) → exact, startsWith(prefix) → bool
    // =========================================================
    static class Trie {
        // TODO: declare root

        void insert(String word) { /* TODO */ }
        boolean search(String word) { /* TODO */ return false; }
        boolean startsWith(String prefix) { /* TODO */ return false; }
    }

    // =========================================================
    // CHALLENGE 2  [MEDIUM]  — Longest Word in Dictionary
    // Return the longest word that can be built one char at a time.
    // If tie, return lexicographically smallest.
    // Example: ["w","wo","wor","worl","world"] → "world"
    // =========================================================
    static String longestWord(String[] words) { return ""; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [MEDIUM]  — Replace Words
    // Given dictionary of roots, replace words in sentence with their shortest root.
    // Example: roots=["cat","bat","rat"], sentence="the cattle was rattled by the battery"
    //        → "the cat was rat by the bat"
    // =========================================================
    static String replaceWords(List<String> dictionary, String sentence) { return ""; /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Map Sum Pairs
    // insert(key, val): insert key with value (overwrite if exists)
    // sum(prefix): return sum of values of all keys starting with prefix
    // Example: insert("apple",3), insert("app",2)
    //          sum("ap") → 5
    //          sum("apple") → 3
    // =========================================================
    static class MapSum {
        // TODO

        void insert(String key, int val) { /* TODO */ }
        int sum(String prefix) { /* TODO */ return 0; }
    }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Design Add and Search Words
    // addWord(word): store word
    // search(word): supports '.' as wildcard matching any char
    // Example: addWord("bad"), addWord("dad"), addWord("mad")
    //          search("pad") → false  search(".ad") → true
    // =========================================================
    static class WordDictionary {
        // TODO

        void addWord(String word) { /* TODO */ }
        boolean search(String word) { /* TODO */ return false; }
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Search Suggestions System
    // Given products list and searchWord, return list of lists:
    // after typing each character, suggest up to 3 products
    // that start with current prefix (lexicographically sorted).
    // Example: products=["mobile","mouse","moneypot","monitor","mousepad"]
    //          searchWord="mouse"
    //        → [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],
    //            ["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
    // =========================================================
    static List<List<String>> suggestedProducts(String[] products, String searchWord) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [HARD]  — Word Search II
    // Given board of characters and list of words, find all words
    // that exist in the board (can move in 4 directions, no reuse).
    // Use Trie + DFS for efficiency.
    // Example: board=[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
    //          words=["oath","pea","eat","rain"] → ["eat","oath"]
    // =========================================================
    static List<String> findWords(char[][] board, String[] words) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [HARD]  — Maximum XOR of Two Numbers
    // Return maximum result of nums[i] XOR nums[j].
    // Use binary Trie (insert 32-bit representation, find max XOR).
    // Example: [3,10,5,25,2,8] → 28  (5 XOR 25)
    // =========================================================
    static int findMaximumXOR(int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Palindrome Pairs
    // Given list of unique words, find all pairs (i,j) where
    // words[i] + words[j] is a palindrome.
    // Example: ["abcd","dcba","lls","s","sssll"] → [[0,1],[1,0],[3,2],[2,4]]
    // =========================================================
    static List<List<Integer>> palindromePairs(String[] words) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Concatenated Words
    // Given list of words, return all words that can be formed
    // by concatenating at least two shorter words from the list.
    // Example: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
    //        → ["catsdogcats","dogcatsdog","ratcatdogcat"]
    // =========================================================
    static List<String> findAllConcatenatedWordsInADict(String[] words) { return new ArrayList<>(); /* TODO */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // C1
        Trie t = new Trie();
        t.insert("apple"); t.insert("app");
        pass += check("C1a", t.search("apple"),   true)  ? 1:0; fail += check("C1a", t.search("apple"),   true)  ? 0:1;
        pass += check("C1b", t.search("app"),     true)  ? 1:0; fail += check("C1b", t.search("app"),     true)  ? 0:1;
        pass += check("C1c", t.search("ap"),      false) ? 1:0; fail += check("C1c", t.search("ap"),      false) ? 0:1;
        pass += check("C1d", t.startsWith("app"), true)  ? 1:0; fail += check("C1d", t.startsWith("app"), true)  ? 0:1;
        pass += check("C1e", t.startsWith("az"),  false) ? 1:0; fail += check("C1e", t.startsWith("az"),  false) ? 0:1;

        // C2
        pass += check("C2a", longestWord(new String[]{"w","wo","wor","worl","world"}), "world") ? 1:0;
        fail += check("C2a", longestWord(new String[]{"w","wo","wor","worl","world"}), "world") ? 0:1;

        // C3
        pass += check("C3a",
                replaceWords(Arrays.asList("cat","bat","rat"), "the cattle was rattled by the battery"),
                "the cat was rat by the bat") ? 1:0;
        fail += check("C3a",
                replaceWords(Arrays.asList("cat","bat","rat"), "the cattle was rattled by the battery"),
                "the cat was rat by the bat") ? 0:1;

        // C4
        MapSum ms = new MapSum();
        ms.insert("apple",3); ms.insert("app",2);
        pass += check("C4a", ms.sum("ap"),    5) ? 1:0; fail += check("C4a", ms.sum("ap"),    5) ? 0:1;
        pass += check("C4b", ms.sum("apple"), 3) ? 1:0; fail += check("C4b", ms.sum("apple"), 3) ? 0:1;

        // C5
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad"); wd.addWord("dad"); wd.addWord("mad");
        pass += check("C5a", wd.search("pad"),  false) ? 1:0; fail += check("C5a", wd.search("pad"),  false) ? 0:1;
        pass += check("C5b", wd.search(".ad"),  true)  ? 1:0; fail += check("C5b", wd.search(".ad"),  true)  ? 0:1;
        pass += check("C5c", wd.search("b.."),  true)  ? 1:0; fail += check("C5c", wd.search("b.."),  true)  ? 0:1;

        // C6
        List<List<String>> sp = suggestedProducts(
                new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
        pass += check("C6a", sp.size(), 5) ? 1:0; fail += check("C6a", sp.size(), 5) ? 0:1;

        // C8
        pass += check("C8a", findMaximumXOR(new int[]{3,10,5,25,2,8}), 28) ? 1:0;
        fail += check("C8a", findMaximumXOR(new int[]{3,10,5,25,2,8}), 28) ? 0:1;

        System.out.println("\n==============================");
        System.out.println("  RESULTS: " + pass + " passed, " + fail + " failed");
        System.out.println("==============================");
    }

    private static boolean check(String n, Object got, Object exp) {
        boolean ok = String.valueOf(got).equals(String.valueOf(exp));
        System.out.printf("%-6s %s  (exp:%s | got:%s)%n", n, ok?"✔":"✘", exp, got);
        return ok;
    }
}
