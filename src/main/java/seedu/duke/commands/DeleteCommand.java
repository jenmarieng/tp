package seedu.duke.commands;

import seedu.duke.book.BookManager;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

public class DeleteCommand extends Command {

    private final String bookIndex;

    public DeleteCommand(String index) {
        bookIndex = index;
    }

    @Override
    public void execute(BookManager bookManager, Ui ui, Storage storage) {
        assert bookManager != null : "BookManager should not be null";
        assert ui != null : "Ui should not be null";
        assert storage != null : "Storage should not be null";
        assert bookIndex != null : "Book Index cannot be null";

        String response = bookManager.deleteBook(bookIndex);
        ui.printWithSeparator(response);
        storage.writeToFile(bookManager.getBooks());
    }
}
