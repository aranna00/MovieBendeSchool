package Movies;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.Objects;
import java.util.function.UnaryOperator;

/**
 * Created by aran on 14-12-2017.
 * In project MovieBende.
 */
public class CreateMovieController extends Controller {
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

    private DataModel model;


    public void initModel(DataModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
    }

    @Override
    public void update() {
        Movie SelectedMovie = model.getCurrentMovie();
    }

    @FXML
    public void addMovie() {
        if (Objects.equals(name.getText(), "") || Objects.equals(yearOfRelease.getText(), "") || Objects.equals(country.getText(), "") || Objects.equals(budget.getText(), "")) {
            return;
        }
        Movie newMovie = new Movie(name.getText(), Integer.parseInt(yearOfRelease.getText()), country.getText(), Integer.parseInt(budget.getText()));
        model.addMovie(newMovie);
        name.setText("");
        yearOfRelease.setText("");
        country.setText("");
        budget.setText("");
    }

    public void initNumberFields() {
        initBudgetField();
        initReleaseField();
    }

    private void initReleaseField() {
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

    private void initBudgetField() {
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
}
