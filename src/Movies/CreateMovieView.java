package Movies;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Objects;
import java.util.function.UnaryOperator;

/**
 * Created by aran on 15-12-2017.
 * In project MovieBende.
 */
public class CreateMovieView {
    // Select all InputFields from view
    @FXML
    private TextField name;
    @FXML
    private TextField country;
    @FXML
    private TextField budget;
    @FXML
    private TextField yearOfRelease;
    @FXML
    private Button addButton;
    private CreateMovieController controller;

    /**
     * Add a new movie from textInputs
     */
    @FXML
    public void addMovie() {
        // Don't do anything if any inputs are empty
        if (Objects.equals(name.getText(), "") || Objects.equals(yearOfRelease.getText(), "") || Objects.equals(country.getText(), "") || Objects.equals(budget.getText(), "")) {
            return;
        }
        Movie newMovie = new Movie(name.getText(), Integer.parseInt(yearOfRelease.getText()), country.getText(), Integer.parseInt(budget.getText()));

        controller.addMovie(newMovie);

        // Clear input fields
        name.setText("");
        yearOfRelease.setText("");
        country.setText("");
        budget.setText("");
    }

    /**
     * DESIGN PATTERN: Dependency Injection
     *
     * @param event keyevent
     */
    @FXML
    public void enterPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            addMovie();
        }
    }

    @FXML
    public void selectFile() {
        controller.ImportCsv();
    }

    /**
     * Init all numberfields with a TextFormatter
     */
    public void initNumberFields() {
        initBudgetField();
        initReleaseField();
    }

    /**
     * Add TextFormatter to yearOfRelease input
     */
    private void initReleaseField() {
        //DESIGN PATTERN: Lambda
        UnaryOperator<TextFormatter.Change> filter = (TextFormatter.Change change) -> {
            String text = change.getText();

            if (text.matches("[0-9]*") && (this.yearOfRelease.getText() + text).length() <= 4) {
                return change;
            }

            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        this.yearOfRelease.setTextFormatter(textFormatter);
    }

    /**
     * Add TextFormatter to yearOfRelease input
     */
    private void initBudgetField() {
        //DESIGN PATTERN: Lambda
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();

            if (text.matches("[0-9]*") && (this.budget.getText() + text).length() <= 9) {
                return change;
            }

            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        budget.setTextFormatter(textFormatter);
    }

    public void setController(CreateMovieController controller) {
        this.controller = controller;
    }
}
