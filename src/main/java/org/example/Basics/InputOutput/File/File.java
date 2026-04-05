package org.example.Basics.InputOutput.File;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

/**
 * ============================================================
 *              JAVA FILE I/O - COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS FILE I/O?
 * ------------------
 * File I/O lets your program read data from files and write data
 * to files on disk. Java provides two main APIs:
 *   - Classic I/O (java.io):   streams, readers, writers
 *   - NIO (java.nio.file):     Path, Files — simpler and more powerful
 *
 * THE File CLASS (java.io.File):
 * --------------------------------
 *   File f = new File("path/to/file.txt");
 *
 *   f.exists()          → true if file/dir exists
 *   f.isFile()          → true if it's a regular file
 *   f.isDirectory()     → true if it's a directory
 *   f.getName()         → just the filename: "file.txt"
 *   f.getPath()         → the path given to constructor
 *   f.getAbsolutePath() → full absolute path
 *   f.length()          → size in bytes
 *   f.delete()          → delete the file, returns boolean
 *   f.createNewFile()   → creates empty file, returns boolean
 *   f.mkdir()           → creates one directory
 *   f.mkdirs()          → creates all needed parent directories
 *   f.listFiles()       → array of File objects in the directory
 *
 * CLASSIC I/O CLASSES:
 * ---------------------
 *   Reading text:
 *     FileReader         → reads characters from a file
 *     BufferedReader     → adds buffering + readLine() method
 *
 *   Writing text:
 *     FileWriter         → writes characters to a file
 *     BufferedWriter     → adds buffering + newLine() method
 *     PrintWriter        → adds print/println/printf methods
 *
 *   Reading bytes:
 *     FileInputStream    → reads raw bytes from a file
 *     BufferedInputStream→ adds buffering
 *
 *   Writing bytes:
 *     FileOutputStream   → writes raw bytes to a file
 *     BufferedOutputStream→ adds buffering
 *
 * TRY-WITH-RESOURCES (always use this!):
 * ----------------------------------------
 *   try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
 *       String line;
 *       while ((line = br.readLine()) != null) {
 *           System.out.println(line);
 *       }
 *   }  // br is automatically closed here
 *
 *   Without try-with-resources you MUST call close() in a finally block.
 *   If you forget, you get resource leaks.
 *
 * NIO (java.nio.file) — RECOMMENDED:
 * -------------------------------------
 *   Path p = Path.of("file.txt");              // create a Path
 *   Path p = Paths.get("dir", "file.txt");     // join path parts
 *
 *   Files.exists(p)                  → true if path exists
 *   Files.isRegularFile(p)           → true if it's a file
 *   Files.readString(p)              → read entire file as String (Java 11+)
 *   Files.readAllLines(p)            → read all lines as List<String>
 *   Files.readAllBytes(p)            → read all bytes as byte[]
 *   Files.writeString(p, content)    → write string to file (Java 11+)
 *   Files.write(p, lines)            → write List<String> to file
 *   Files.copy(src, dst)             → copy a file
 *   Files.move(src, dst)             → move/rename a file
 *   Files.delete(p)                  → delete (throws if not exists)
 *   Files.deleteIfExists(p)          → delete only if it exists
 *   Files.createFile(p)              → create empty file
 *   Files.createDirectories(p)       → create dirs (including parents)
 *   Files.size(p)                    → file size in bytes
 *   Files.lines(p)                   → Stream<String> of lines (Java 8+)
 *
 * OPEN OPTIONS for writing:
 * --------------------------
 *   StandardOpenOption.CREATE         → create file if it doesn't exist
 *   StandardOpenOption.TRUNCATE_EXISTING → overwrite existing content
 *   StandardOpenOption.APPEND         → append to existing content
 *   StandardOpenOption.CREATE_NEW     → fail if file already exists
 *
 * SCANNER WITH FILES:
 * --------------------
 *   Scanner sc = new Scanner(new File("data.txt"));
 *   while (sc.hasNextLine()) { ... }
 *   sc.close();
 *
 * IMPORTANT: ALWAYS handle IOException with try-catch or declare throws.
 *
 * ============================================================
 */
public class File {
    public static void main(String[] args) throws IOException {

        // ---- Use a temp file for all exercises so nothing is left on disk ----
        Path tempDir = Files.createTempDirectory("java_io_guide");

        // --------------------------------------------------------
        // EXERCISE 1: Create a file with java.io.File
        // --------------------------------------------------------
        java.io.File legacyFile = new java.io.File(tempDir.toString(), "legacy.txt");
        boolean created = legacyFile.createNewFile();
        System.out.println("Created: "   + created);
        System.out.println("Exists:  "   + legacyFile.exists());
        System.out.println("isFile:  "   + legacyFile.isFile());
        System.out.println("Name:    "   + legacyFile.getName());
        System.out.println("Length:  "   + legacyFile.length() + " bytes");

        // --------------------------------------------------------
        // EXERCISE 2: Write text with FileWriter
        // --------------------------------------------------------
        java.io.File fw_file = new java.io.File(tempDir.toString(), "fw.txt");
        try (FileWriter fw = new FileWriter(fw_file)) {
            fw.write("Line 1\n");
            fw.write("Line 2\n");
        }
        System.out.println("FileWriter wrote: " + fw_file.length() + " bytes");

        // --------------------------------------------------------
        // EXERCISE 3: Read text with FileReader + BufferedReader
        // --------------------------------------------------------
        try (BufferedReader br = new BufferedReader(new FileReader(fw_file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Read: " + line);
            }
        }

        // --------------------------------------------------------
        // EXERCISE 4: Write with BufferedWriter + PrintWriter
        // --------------------------------------------------------
        Path pwPath = tempDir.resolve("printwriter.txt");
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(pwPath.toFile())))) {
            pw.println("Hello from PrintWriter");
            pw.printf("Number: %d%n", 42);
            pw.printf("Float:  %.2f%n", 3.14);
        }

        // --------------------------------------------------------
        // EXERCISE 5: Append to a file (FileWriter with append=true)
        // --------------------------------------------------------
        try (FileWriter appender = new FileWriter(fw_file, true)) {
            appender.write("Line 3 (appended)\n");
        }
        System.out.println("After append: " + fw_file.length() + " bytes");

        // --------------------------------------------------------
        // EXERCISE 6: NIO — Files.writeString and Files.readString
        // --------------------------------------------------------
        Path nioFile = tempDir.resolve("nio.txt");
        Files.writeString(nioFile, "Hello NIO!\nSecond line\n");
        String content = Files.readString(nioFile);
        System.out.println("NIO content:\n" + content);

        // --------------------------------------------------------
        // EXERCISE 7: NIO — Files.readAllLines
        // --------------------------------------------------------
        List<String> lines = Files.readAllLines(nioFile);
        System.out.println("Line count: " + lines.size());
        for (String l : lines) {
            System.out.println("  > " + l);
        }

        // --------------------------------------------------------
        // EXERCISE 8: NIO — Files.write with append option
        // --------------------------------------------------------
        Files.writeString(nioFile, "Third line\n", StandardOpenOption.APPEND);
        System.out.println("After NIO append: " + Files.readAllLines(nioFile).size() + " lines");

        // --------------------------------------------------------
        // EXERCISE 9: Scanner reading from a file
        // --------------------------------------------------------
        Path scanFile = tempDir.resolve("numbers.txt");
        Files.writeString(scanFile, "10\n20\n30\n40\n50\n");
        int sum = 0;
        try (Scanner sc = new Scanner(scanFile)) {
            while (sc.hasNextInt()) {
                sum += sc.nextInt();
            }
        }
        System.out.println("Sum from file: " + sum); // 150

        // --------------------------------------------------------
        // EXERCISE 10: NIO — File existence and metadata
        // --------------------------------------------------------
        System.out.println("Exists:    " + Files.exists(nioFile));
        System.out.println("Is file:   " + Files.isRegularFile(nioFile));
        System.out.println("Is dir:    " + Files.isDirectory(nioFile));
        System.out.println("Size:      " + Files.size(nioFile) + " bytes");

        // --------------------------------------------------------
        // EXERCISE 11: Copy a file with NIO
        // --------------------------------------------------------
        Path copyDest = tempDir.resolve("copy.txt");
        Files.copy(nioFile, copyDest);
        System.out.println("Copy exists: " + Files.exists(copyDest));
        System.out.println("Copy size:   " + Files.size(copyDest));

        // --------------------------------------------------------
        // EXERCISE 12: Move/rename a file with NIO
        // --------------------------------------------------------
        Path renamed = tempDir.resolve("renamed.txt");
        Files.move(copyDest, renamed);
        System.out.println("Old exists: " + Files.exists(copyDest));
        System.out.println("New exists: " + Files.exists(renamed));

        // --------------------------------------------------------
        // EXERCISE 13: Create directories
        // --------------------------------------------------------
        Path subDir = tempDir.resolve("a/b/c");
        Files.createDirectories(subDir);
        System.out.println("Dir created: " + Files.isDirectory(subDir));

        // --------------------------------------------------------
        // EXERCISE 14: List files in a directory
        // --------------------------------------------------------
        System.out.println("Files in temp dir:");
        try (var stream = Files.list(tempDir)) {
            stream.forEach(p -> System.out.println("  " + p.getFileName()));
        }

        // --------------------------------------------------------
        // EXERCISE 15: Delete files
        // --------------------------------------------------------
        Files.deleteIfExists(renamed);
        System.out.println("Deleted renamed: " + !Files.exists(renamed));
        legacyFile.delete();
        System.out.println("Deleted legacy: " + !legacyFile.exists());

        // --------------------------------------------------------
        // SUMMARY
        // --------------------------------------------------------
        System.out.println("\n=== File I/O Quick Reference ===");
        System.out.println("Write: Files.writeString(path, text)");
        System.out.println("Read:  Files.readString(path)");
        System.out.println("Lines: Files.readAllLines(path)");
        System.out.println("Append: Files.writeString(path, text, StandardOpenOption.APPEND)");
        System.out.println("Always use try-with-resources to avoid leaks!");
    }
}
