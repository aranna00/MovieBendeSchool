package Movies;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by aran on 14-12-2017.
 * In project MovieBende.
 */
class CreateFilmController {
    @FXML
    private TextField name;
    @FXML
    private TextField country;
    @FXML
    private TextField budget;
    @FXML
    private TextField yearOfRelease;

    private DataModel model;

    public void initModel(DataModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
//        model.currentMovieProperty().addListener((obs, oldMovie, newMovie) -> {
//            if (oldMovie != null) {
//                name.textProperty().unbindBidirectional(oldMovie.nameProperty());
//                country.textProperty().unbindBidirectional(oldMovie.countryProperty());
//                budget.textProperty().unbindBidirectional(oldMovie.budgetProperty());
//                yearOfRelease.textProperty().unbindBidirectional(oldMovie.yearOfReleaseProperty());
//            }
//            if (newMovie == null) {
//                name.setText("");
//                country.setText("");
//                budget.setText("");
//                yearOfRelease.setText("");
//            } else {
//                name.textProperty().bindBidirectional(newMovie.nameProperty());
//                country.textProperty().bindBidirectional(newMovie.countryProperty());
//                budget.textProperty().bindBidirectional(newMovie.budgetProperty());
//                yearOfRelease.textProperty().bindBidirectional(newMovie.yearOfReleaseProperty());
//            }
//        });
    }
}
