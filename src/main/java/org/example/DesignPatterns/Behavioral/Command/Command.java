package org.example.DesignPatterns.Behavioral.Command;

import java.util.*;

/**
 * ============================================================
 *           COMMAND PATTERN — COMPLETE GUIDE
 * ============================================================
 *
 * INTENT: Encapsulate a request as an object, allowing you to
 * parameterize clients with different requests, queue/log requests,
 * and support undoable operations.
 *
 * COMPONENTS:
 * -----------
 *   Command    → interface with execute() and undo()
 *   Receiver   → knows how to perform the operations
 *   Invoker    → sends command, stores for undo/redo
 *   Client     → creates commands and sets receiver
 *
 * USE WHEN:
 * ---------
 *   - Undo/Redo functionality
 *   - Transactional behavior (rollback)
 *   - Job queues / task scheduling
 *   - Logging/Auditing
 *
 * ============================================================
 */
public class Command {

    // ── Command interface ─────────────────────────────────────
    interface ICommand {
        void execute();
        void undo();
        String description();
    }

    // ── 1. Text editor with undo/redo ─────────────────────────
    static class TextEditor {
        private StringBuilder text = new StringBuilder();

        void insert(int pos, String s) {
            text.insert(pos, s);
        }
        void delete(int from, int to) {
            text.delete(from, to);
        }
        String getText() { return text.toString(); }
        int length()     { return text.length(); }
    }

    static class InsertCommand implements ICommand {
        private final TextEditor editor;
        private final int position;
        private final String text;

        InsertCommand(TextEditor e, int pos, String text) {
            this.editor = e; this.position = pos; this.text = text;
        }
        @Override public void execute() { editor.insert(position, text); }
        @Override public void undo()    { editor.delete(position, position + text.length()); }
        @Override public String description() { return "Insert '" + text + "' at " + position; }
    }

    static class DeleteCommand implements ICommand {
        private final TextEditor editor;
        private final int from, to;
        private String deletedText;

        DeleteCommand(TextEditor e, int from, int to) {
            this.editor = e; this.from = from; this.to = to;
        }
        @Override public void execute() {
            deletedText = editor.getText().substring(from, to);
            editor.delete(from, to);
        }
        @Override public void undo()    { editor.insert(from, deletedText); }
        @Override public String description() { return "Delete [" + from + "," + to + "]"; }
    }

    // ── Command History (Invoker) ─────────────────────────────
    static class CommandHistory {
        private final Deque<ICommand> undoStack = new ArrayDeque<>();
        private final Deque<ICommand> redoStack = new ArrayDeque<>();

        void execute(ICommand cmd) {
            cmd.execute();
            undoStack.push(cmd);
            redoStack.clear(); // new action clears redo stack
            System.out.println("Executed: " + cmd.description());
        }

        boolean undo() {
            if (undoStack.isEmpty()) return false;
            ICommand cmd = undoStack.pop();
            cmd.undo();
            redoStack.push(cmd);
            System.out.println("Undone:   " + cmd.description());
            return true;
        }

        boolean redo() {
            if (redoStack.isEmpty()) return false;
            ICommand cmd = redoStack.pop();
            cmd.execute();
            undoStack.push(cmd);
            System.out.println("Redone:   " + cmd.description());
            return true;
        }
    }

    // ── 2. Bank transaction commands ──────────────────────────
    static class BankAccount {
        private double balance;
        String id;

        BankAccount(String id, double initial) {
            this.id = id; this.balance = initial;
        }

        void credit(double amount) { balance += amount; }
        void debit(double amount)  { balance -= amount; }
        double getBalance()        { return balance; }

        @Override public String toString() {
            return String.format("Account[%s: $%.2f]", id, balance);
        }
    }

    static class TransferCommand implements ICommand {
        private final BankAccount from, to;
        private final double amount;

        TransferCommand(BankAccount from, BankAccount to, double amount) {
            this.from = from; this.to = to; this.amount = amount;
        }

        @Override public void execute() {
            from.debit(amount);
            to.credit(amount);
        }

        @Override public void undo() {
            to.debit(amount);
            from.credit(amount);
        }

        @Override public String description() {
            return String.format("Transfer $%.2f from %s to %s", amount, from.id, to.id);
        }
    }

    // ── 3. Lambda command ─────────────────────────────────────
    static class SimpleCommand implements ICommand {
        private final Runnable action;
        private final Runnable undoAction;
        private final String desc;

        SimpleCommand(String desc, Runnable action, Runnable undoAction) {
            this.desc = desc; this.action = action; this.undoAction = undoAction;
        }

        @Override public void execute()           { action.run(); }
        @Override public void undo()              { undoAction.run(); }
        @Override public String description()     { return desc; }
    }

    public static void main(String[] args) {
        // 1. Text editor
        System.out.println("=== Text Editor with Undo/Redo ===");
        TextEditor editor = new TextEditor();
        CommandHistory history = new CommandHistory();

        history.execute(new InsertCommand(editor, 0, "Hello"));
        System.out.println("Text: '" + editor.getText() + "'");

        history.execute(new InsertCommand(editor, 5, " World"));
        System.out.println("Text: '" + editor.getText() + "'");

        history.execute(new DeleteCommand(editor, 5, 11));
        System.out.println("Text: '" + editor.getText() + "'");

        history.undo();
        System.out.println("After undo: '" + editor.getText() + "'");

        history.undo();
        System.out.println("After undo: '" + editor.getText() + "'");

        history.redo();
        System.out.println("After redo: '" + editor.getText() + "'");

        // 2. Bank transfer
        System.out.println("\n=== Bank Transfer Commands ===");
        BankAccount alice = new BankAccount("Alice", 1000);
        BankAccount bob   = new BankAccount("Bob",   500);
        System.out.println("Before: " + alice + " | " + bob);

        CommandHistory txHistory = new CommandHistory();
        txHistory.execute(new TransferCommand(alice, bob, 200));
        System.out.println("After transfer: " + alice + " | " + bob);

        txHistory.undo(); // rollback
        System.out.println("After rollback: " + alice + " | " + bob);

        // 3. Lambda commands
        System.out.println("\n=== Lambda Commands ===");
        int[] counter = {0};
        CommandHistory lambdaHistory = new CommandHistory();
        lambdaHistory.execute(new SimpleCommand("Increment by 5",
            () -> counter[0] += 5, () -> counter[0] -= 5));
        lambdaHistory.execute(new SimpleCommand("Multiply by 2",
            () -> counter[0] *= 2, () -> counter[0] /= 2));
        System.out.println("Counter: " + counter[0]); // 10
        lambdaHistory.undo();
        System.out.println("After undo: " + counter[0]); // 5

        System.out.println("\n=== Command Summary ===");
        System.out.println("Encapsulate request as object");
        System.out.println("execute() + undo() enable undo/redo");
        System.out.println("CommandHistory acts as Invoker");
        System.out.println("Use: editors, transactions, task queues, macros");
    }
}
