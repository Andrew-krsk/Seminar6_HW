package view;

import controllers.NoteController;
import model.Note;

import java.util.List;
import java.util.Scanner;

public class ViewNote {
    private final NoteController noteController;

    public ViewNote(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run() {
        Commands com;

        while (true) {
            String command = prompt("Enter command: ");
            try {
                com = Commands.valueOf(command.toUpperCase());

                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE:
                        createNote();
                        break;
                    case READ:
                        readNote();
                        break;
                    case LIST:
                        listNotes();
                        break;
                    case UPDATE:
                        updateNote();
                        break;
                    case DELETE:
                        deleteNote();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void updateNote() throws Exception {
        String readId = prompt("Enter editable note ID: ");
        noteController.updateNote(readId, inputNote());
    }

    private void listNotes() {
        List<Note> listNotes = noteController.readAllNotes();
        for (Note note : listNotes) {
            System.out.println(note + "\n");
        }
    }

    private void readNote() throws Exception {
        String id = prompt("Note ID: ");

        Note note = noteController.readNote(id);
        System.out.println(note);

    }

    private void deleteNote() throws Exception {
        String readId = prompt("Enter deletable note ID: ");
        noteController.deleteNote(readId);


    }

    private Note inputNote() {
        String header = prompt("Header: ");
        String text = prompt("Text: ");
        return new Note(header, text);
    }

    private void createNote() throws Exception {
        noteController.saveNote(inputNote());
    }


    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
