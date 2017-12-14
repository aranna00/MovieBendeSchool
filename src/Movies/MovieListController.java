package Movies;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by aran on 14-12-2017.
 * In project MovieBende.
 */
public class MovieListController {
    @FXML
    SplitPane movieList;
    @FXML
    Label name;
    @FXML
    private Label country;
    @FXML
    private Label realeaseYear;
    @FXML
    private Label budget;

    private DataModel model;

    MovieListController(Stage movieListStage) throws Exception {
        this.movieList = (SplitPane) FXMLLoader.load(getClass().getResource("movieList.fxml"));
        movieListStage.setTitle("All movies");
        movieListStage.setScene(new Scene(movieList));
        movieListStage.setX(50);
        movieListStage.setY(250);
        movieListStage.show();

        ListView listView = (ListView) ((AnchorPane) movieList.getItems().get(0)).getChildren().get(0);
    }

    public void initModel(DataModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }

        this.model = model;
//        ListView<Movie> listView = (ListView) ((AnchorPane) movieList.getItems().get(0)).getChildren().get(0);
//        movieList.setItems(model.getMovieList());
//
//        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->
//                model.setCurrentMovie(newSelection));
//
//        model.currentMovieProperty().addListener((obs, oldMovie, newMovie) -> {
//            if (newMovie == null) {
//                listView.getSelectionModel().clearSelection();
//            } else {
//                listView.getSelectionModel().select(newMovie);
//            }
//        });
    }

    public void addMovieToList(Movie movie) {
        ListView listView = (ListView) ((AnchorPane) movieList.getItems().get(0)).getChildren().get(0);
        listView.getItems().add(movie.getName());
    }

    public void showMovie(Movie movie) {
        this.name = (Label) ((AnchorPane) this.movieList.getItems().get(1)).getChildren().get(4);
        this.country = (Label) ((AnchorPane) this.movieList.getItems().get(1)).getChildren().get(5);
        this.realeaseYear = (Label) ((AnchorPane) this.movieList.getItems().get(1)).getChildren().get(6);
        this.budget = (Label) ((AnchorPane) this.movieList.getItems().get(1)).getChildren().get(7);
        name.setText(movie.getName());
        country.setText(movie.getCountry());
        realeaseYear.setText(String.valueOf(movie.getYearOfRelease()));
        budget.setText(String.valueOf(movie.getBudget()));
    }
}
