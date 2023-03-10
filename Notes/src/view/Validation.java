package view;

import model.Note;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    Pattern headerPattern = Pattern.compile("^\\S");

    public void validateNote(Note inputNote) throws Exception {
        Matcher headerMatcher = headerPattern.matcher(inputNote.getHeader());
        Matcher textMatcher = headerPattern.matcher(inputNote.getText());
        if (!headerMatcher.find()) {
            throw new Exception("This header is not allowed!");
        }
        if (!textMatcher.find()) {
            throw new Exception("This text is not allowed!");
        }
    }
}
