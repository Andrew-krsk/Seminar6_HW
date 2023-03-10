import controllers.NoteController;
import model.*;
import view.Validation;
import view.ViewNote;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("notes.txt");
        Repository repository = new RepositoryFile(fileOperation, new NoteMapper());
        NoteController controller = new NoteController(repository,new Validation());
        ViewNote view = new ViewNote(controller);
        view.run();
    }
}
