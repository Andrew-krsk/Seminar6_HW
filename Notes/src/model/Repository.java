package model;

import java.util.List;

public interface Repository {
    List<Note> getAllNotes();

    String CreateNote(Note note);

    void saveNotes(List<Note> notes);
}
