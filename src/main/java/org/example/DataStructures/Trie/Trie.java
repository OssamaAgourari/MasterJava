package org.example.DataStructures.Trie;

import java.util.*;

/**
 * ============================================================
 *                  TRIE — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS A TRIE?
 * ----------------
 * A tree-like data structure for storing strings where each
 * node represents one CHARACTER of a key. Also called:
 * Prefix Tree / Digital Tree.
 *
 *   Insert: "apple", "app", "apply", "apt"
 *
 *        root
 *         |
 *         a
 *         |
 *         p
 *        / \
 *       p*  t*
 *       |
 *       l
 *       |
 *       e* y*
 *   (* = isEnd flag)
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Operation  | Time  | Notes
 *   -----------|-------|----------------------------------
 *   insert     | O(L)  | L = length of word
 *   search     | O(L)  | exact word search
 *   startsWith | O(L)  | prefix search
 *   delete     | O(L)  |
 *   All words  | O(n)  | n = total characters in trie
 *
 * SPACE: O(ALPHABET_SIZE × L × N)  where N = number of words
 *   Typically 26 × avg_length × num_words
 *
 * WHEN TO USE:
 * -------------
 *   ✔ Autocomplete / typeahead search
 *   ✔ Spell checking
 *   ✔ IP routing (longest prefix matching)
 *   ✔ Word games (Boggle, crossword)
 *   ✔ Dictionary lookups
 *   ✔ Searching for all words with a given prefix
 *
 * TRIE vs HASHMAP:
 * -----------------
 *   HashMap search is O(L) too, but:
 *   - Trie allows PREFIX search efficiently
 *   - Trie uses less memory for large shared-prefix datasets
 *   - Trie allows lexicographically ordered iteration
 *
 * ============================================================
 */
public class Trie {

    // ─── TrieNode ─────────────────────────────────────────────
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;

        boolean hasChild(char c) { return children[c-'a'] != null; }
        TrieNode getChild(char c) { return children[c-'a']; }
        TrieNode addChild(char c) { children[c-'a'] = new TrieNode(); return children[c-'a']; }
    }

    // ─── Trie ─────────────────────────────────────────────────
    static class TrieTree {
        TrieNode root = new TrieNode();

        // ── INSERT — O(L) ─────────────────────────────────────
        void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.hasChild(c)) cur.addChild(c);
                cur = cur.getChild(c);
            }
            cur.isEnd = true;
        }

        // ── SEARCH exact word — O(L) ──────────────────────────
        boolean search(String word) {
            TrieNode node = findNode(word);
            return node != null && node.isEnd;
        }

        // ── STARTS WITH prefix — O(L) ─────────────────────────
        boolean startsWith(String prefix) {
            return findNode(prefix) != null;
        }

        // ── DELETE — O(L) ─────────────────────────────────────
        void delete(String word) {
            deleteHelper(root, word, 0);
        }
        private boolean deleteHelper(TrieNode node, String word, int i) {
            if (i == word.length()) {
                if (!node.isEnd) return false; // word doesn't exist
                node.isEnd = false;
                return isEmpty(node); // delete node if no children
            }
            char c = word.charAt(i);
            if (!node.hasChild(c)) return false;
            boolean shouldDelete = deleteHelper(node.getChild(c), word, i+1);
            if (shouldDelete) { node.children[c-'a'] = null; return !node.isEnd && isEmpty(node); }
            return false;
        }
        private boolean isEmpty(TrieNode n) {
            for (TrieNode c : n.children) if (c != null) return false;
            return true;
        }

        // ── ALL WORDS with prefix — O(n) ──────────────────────
        List<String> wordsWithPrefix(String prefix) {
            List<String> result = new ArrayList<>();
            TrieNode node = findNode(prefix);
            if (node != null) collectWords(node, new StringBuilder(prefix), result);
            return result;
        }
        private void collectWords(TrieNode node, StringBuilder path, List<String> result) {
            if (node.isEnd) result.add(path.toString());
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    path.append((char)('a'+i));
                    collectWords(node.children[i], path, result);
                    path.deleteCharAt(path.length()-1);
                }
            }
        }

        // ── COUNT WORDS ───────────────────────────────────────
        int countWords() {
            int[] count = {0};
            countHelper(root, count);
            return count[0];
        }
        private void countHelper(TrieNode n, int[] c) {
            if (n == null) return;
            if (n.isEnd) c[0]++;
            for (TrieNode child : n.children) countHelper(child, c);
        }

        // ── LONGEST COMMON PREFIX ─────────────────────────────
        String longestCommonPrefix() {
            StringBuilder prefix = new StringBuilder();
            TrieNode cur = root;
            while (true) {
                // count non-null children
                int childCount = 0; int childIdx = -1;
                for (int i = 0; i < 26; i++) { if (cur.children[i] != null) { childCount++; childIdx = i; } }
                if (childCount != 1 || cur.isEnd) break;
                prefix.append((char)('a'+childIdx));
                cur = cur.children[childIdx];
            }
            return prefix.toString();
        }

        private TrieNode findNode(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (!cur.hasChild(c)) return null;
                cur = cur.getChild(c);
            }
            return cur;
        }
    }

    public static void main(String[] args) {

        // EXERCISE 1: Insert and search
        TrieTree trie = new TrieTree();
        trie.insert("apple"); trie.insert("app"); trie.insert("apply"); trie.insert("apt");
        System.out.println("search(apple):  " + trie.search("apple"));  // true
        System.out.println("search(app):    " + trie.search("app"));    // true
        System.out.println("search(ap):     " + trie.search("ap"));     // false (not a full word)
        System.out.println("search(apricot):" + trie.search("apricot")); // false

        // EXERCISE 2: Prefix search
        System.out.println("startsWith(ap): " + trie.startsWith("ap")); // true
        System.out.println("startsWith(az): " + trie.startsWith("az")); // false

        // EXERCISE 3: Words with prefix
        System.out.println("words with 'app': " + trie.wordsWithPrefix("app"));
        // [app, apple, apply]
        System.out.println("words with 'ap':  " + trie.wordsWithPrefix("ap"));
        // [app, apple, apply, apt]

        // EXERCISE 4: Count words
        System.out.println("Word count: " + trie.countWords()); // 4

        // EXERCISE 5: Delete
        trie.delete("app");
        System.out.println("After delete(app):");
        System.out.println("search(app):   " + trie.search("app"));   // false
        System.out.println("search(apple): " + trie.search("apple")); // true (still exists)

        // EXERCISE 6: Longest common prefix
        TrieTree lcp = new TrieTree();
        lcp.insert("flower"); lcp.insert("flow"); lcp.insert("flight");
        System.out.println("Longest common prefix: " + lcp.longestCommonPrefix()); // fl

        // EXERCISE 7: Autocomplete (all words with prefix)
        TrieTree auto = new TrieTree();
        String[] dict = {"dog","door","dove","down","duck","dune"};
        for (String w : dict) auto.insert(w);
        System.out.println("Autocomplete 'do': " + auto.wordsWithPrefix("do"));
        // [dog, door, dove, down]
        System.out.println("Autocomplete 'du': " + auto.wordsWithPrefix("du"));
        // [duck, dune]

        // EXERCISE 8: Word search game (does word exist with prefix?)
        TrieTree dict2 = new TrieTree();
        for (String w : new String[]{"cat","car","card","care","scar","score"}) dict2.insert(w);
        System.out.println("'scar' exists: " + dict2.search("scar"));     // true
        System.out.println("'sc' prefix:   " + dict2.startsWith("sc"));   // true
        System.out.println("'scarf' exists:" + dict2.search("scarf"));    // false

        // EXERCISE 9: Count prefix occurrences (modified insert)
        // Useful for problems asking how many words have a given prefix
        TrieTree countPre = new TrieTree();
        for (String w : new String[]{"apple","app","application","apt","bat"}) countPre.insert(w);
        System.out.println("Words with prefix 'ap': " + countPre.wordsWithPrefix("ap").size()); // 3

        // SUMMARY
        System.out.println("\n=== Trie Complexity ===");
        System.out.println("insert      O(L)  L = word length");
        System.out.println("search      O(L)");
        System.out.println("startsWith  O(L)");
        System.out.println("delete      O(L)");
        System.out.println("allWords    O(n)  n = total chars in trie");
        System.out.println("Space       O(ALPHABET × L × N)");
    }
}
