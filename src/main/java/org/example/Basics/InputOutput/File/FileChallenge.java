package org.example.Basics.InputOutput.File;

import java.io.*;
import java.nio.file.*;
import java.util.List;

/**
 * ============================================================
 *              FILE I/O CHALLENGES — LeetCode Style
 * ============================================================
 * Difficulty scale:
 *   [EASY]    — straightforward, one concept
 *   [MEDIUM]  — requires combining multiple ideas
 *   [HARD]    — tricky logic or optimization needed
 *
 * How to use:
 *   1. Read the problem and examples carefully.
 *   2. Write your solution inside the method body.
 *   3. Run main() — all tests print PASS or FAIL automatically.
 *
 * Note: The test runner creates real temp files so you can use
 *       actual file I/O in your solutions.
 * ============================================================
 */
public class FileChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]
    // =========================================================
    // Count Lines
    //
    // Return the number of lines in the file at the given path.
    //
    // Example (file contains "a\nb\nc"):
    //   Input: path to file  → 3
    // =========================================================
    static int countLines(Path path) throws IOException {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]
    // =========================================================
    // Read File to String
    //
    // Read the entire file and return its contents as a single String.
    //
    // Example (file contains "Hello\nWorld"):
    //   Input: path  → "Hello\nWorld"
    // =========================================================
    static String readFileToString(Path path) throws IOException {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 3  [EASY]
    // =========================================================
    // Write String to File
    //
    // Write the given content to the file at path.
    // Overwrite any existing content.
    // =========================================================
    static void writeStringToFile(Path path, String content) throws IOException {
        // TODO: write your solution here
    }

    // =========================================================
    // CHALLENGE 4  [EASY]
    // =========================================================
    // File Exists
    //
    // Return true if a regular file exists at the given path.
    // Return false if the path doesn't exist or is a directory.
    // =========================================================
    static boolean fileExists(Path path) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 5  [EASY]
    // =========================================================
    // Count Words in File
    //
    // Return the total number of whitespace-separated words in the file.
    //
    // Example (file contains "hello world\nfoo bar baz"):
    //   Input: path  → 5
    // =========================================================
    static int countWordsInFile(Path path) throws IOException {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]
    // =========================================================
    // Append Line
    //
    // Append the given line (followed by a newline) to the file.
    // The file is guaranteed to already exist.
    // =========================================================
    static void appendLine(Path path, String line) throws IOException {
        // TODO: write your solution here
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]
    // =========================================================
    // Sum Numbers in File
    //
    // The file contains one integer per line. Return their sum.
    //
    // Example (file contains "10\n20\n30"):
    //   Input: path  → 60
    // =========================================================
    static long sumNumbersInFile(Path path) throws IOException {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]
    // =========================================================
    // Find Max in File
    //
    // The file contains one integer per line. Return the largest.
    // Assume at least one integer is present.
    //
    // Example (file contains "5\n1\n9\n3"):
    //   Input: path  → 9
    // =========================================================
    static int findMaxInFile(Path path) throws IOException {
        // TODO: write your solution here

        return Integer.MIN_VALUE;
    }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]
    // =========================================================
    // Copy File Content
    //
    // Read from src and write all its content to dst.
    // dst will be created (or overwritten) by this method.
    // Do NOT use Files.copy() — use read + write.
    // =========================================================
    static void copyFileContent(Path src, Path dst) throws IOException {
        // TODO: write your solution here
    }

    // =========================================================
    // CHALLENGE 10  [HARD]
    // =========================================================
    // Word Frequency
    //
    // Return the number of times the given word appears in the file
    // (case-insensitive, whole-word match using whitespace splitting).
    //
    // Example (file contains "the cat sat on the mat"):
    //   Input: path, "the"  → 2
    //   Input: path, "cat"  → 1
    //   Input: path, "dog"  → 0
    // =========================================================
    static int wordFrequency(Path path, String word) throws IOException {
        // TODO: write your solution here

        return 0;
    }


    // ============================================================
    //  TEST RUNNER — do not modify
    // ============================================================
    public static void main(String[] args) throws IOException {
        int pass = 0, fail = 0;
        Path tmp = Files.createTempDirectory("file_challenge");

        // ---- Challenge 1: count lines ----
        Path c1 = tmp.resolve("c1.txt");
        Files.writeString(c1, "a\nb\nc\n");
        pass += check("Challenge 1a", countLines(c1), 3) ? 1 : 0;
        fail += check("Challenge 1a", countLines(c1), 3) ? 0 : 1;

        // ---- Challenge 2: read file to string ----
        Path c2 = tmp.resolve("c2.txt");
        Files.writeString(c2, "Hello\nWorld");
        pass += check("Challenge 2a", readFileToString(c2), "Hello\nWorld") ? 1 : 0;
        fail += check("Challenge 2a", readFileToString(c2), "Hello\nWorld") ? 0 : 1;

        // ---- Challenge 3: write string to file ----
        Path c3 = tmp.resolve("c3.txt");
        writeStringToFile(c3, "test content");
        pass += check("Challenge 3a", Files.readString(c3), "test content") ? 1 : 0;
        fail += check("Challenge 3a", Files.readString(c3), "test content") ? 0 : 1;

        // ---- Challenge 4: file exists ----
        Path c4a = tmp.resolve("c4.txt");
        Files.createFile(c4a);
        Path c4b = tmp.resolve("nope.txt");
        pass += check("Challenge 4a", fileExists(c4a), true)  ? 1 : 0;
        fail += check("Challenge 4a", fileExists(c4a), true)  ? 0 : 1;
        pass += check("Challenge 4b", fileExists(c4b), false) ? 1 : 0;
        fail += check("Challenge 4b", fileExists(c4b), false) ? 0 : 1;
        pass += check("Challenge 4c", fileExists(tmp),  false) ? 1 : 0;
        fail += check("Challenge 4c", fileExists(tmp),  false) ? 0 : 1;

        // ---- Challenge 5: count words ----
        Path c5 = tmp.resolve("c5.txt");
        Files.writeString(c5, "hello world\nfoo bar baz\n");
        pass += check("Challenge 5a", countWordsInFile(c5), 5) ? 1 : 0;
        fail += check("Challenge 5a", countWordsInFile(c5), 5) ? 0 : 1;

        // ---- Challenge 6: append line ----
        Path c6 = tmp.resolve("c6.txt");
        Files.writeString(c6, "first\n");
        appendLine(c6, "second");
        List<String> c6lines = Files.readAllLines(c6);
        pass += check("Challenge 6a", c6lines.size(), 2)        ? 1 : 0;
        fail += check("Challenge 6a", c6lines.size(), 2)        ? 0 : 1;
        pass += check("Challenge 6b", c6lines.get(1), "second") ? 1 : 0;
        fail += check("Challenge 6b", c6lines.get(1), "second") ? 0 : 1;

        // ---- Challenge 7: sum numbers ----
        Path c7 = tmp.resolve("c7.txt");
        Files.writeString(c7, "10\n20\n30\n");
        pass += check("Challenge 7a", sumNumbersInFile(c7), 60L) ? 1 : 0;
        fail += check("Challenge 7a", sumNumbersInFile(c7), 60L) ? 0 : 1;

        // ---- Challenge 8: find max ----
        Path c8 = tmp.resolve("c8.txt");
        Files.writeString(c8, "5\n1\n9\n3\n");
        pass += check("Challenge 8a", findMaxInFile(c8), 9) ? 1 : 0;
        fail += check("Challenge 8a", findMaxInFile(c8), 9) ? 0 : 1;

        // ---- Challenge 9: copy content ----
        Path c9src = tmp.resolve("c9src.txt");
        Path c9dst = tmp.resolve("c9dst.txt");
        Files.writeString(c9src, "copy me");
        copyFileContent(c9src, c9dst);
        pass += check("Challenge 9a", Files.readString(c9dst), "copy me") ? 1 : 0;
        fail += check("Challenge 9a", Files.readString(c9dst), "copy me") ? 0 : 1;

        // ---- Challenge 10: word frequency ----
        Path c10 = tmp.resolve("c10.txt");
        Files.writeString(c10, "the cat sat on the mat");
        pass += check("Challenge 10a", wordFrequency(c10, "the"), 2) ? 1 : 0;
        fail += check("Challenge 10a", wordFrequency(c10, "the"), 2) ? 0 : 1;
        pass += check("Challenge 10b", wordFrequency(c10, "cat"), 1) ? 1 : 0;
        fail += check("Challenge 10b", wordFrequency(c10, "cat"), 1) ? 0 : 1;
        pass += check("Challenge 10c", wordFrequency(c10, "dog"), 0) ? 1 : 0;
        fail += check("Challenge 10c", wordFrequency(c10, "dog"), 0) ? 0 : 1;
        pass += check("Challenge 10d", wordFrequency(c10, "THE"), 2) ? 1 : 0;
        fail += check("Challenge 10d", wordFrequency(c10, "THE"), 2) ? 0 : 1;

        System.out.println("\n==============================");
        System.out.println("  RESULTS: " + pass + " passed, " + fail + " failed");
        System.out.println("==============================");
    }

    // ---- helper ----
    private static boolean check(String name, Object got, Object expected) {
        boolean ok = String.valueOf(got).equals(String.valueOf(expected));
        System.out.printf("%-15s %s  (expected: %s | got: %s)%n",
                name, ok ? "✔ PASS" : "✘ FAIL", expected, got);
        return ok;
    }
}
