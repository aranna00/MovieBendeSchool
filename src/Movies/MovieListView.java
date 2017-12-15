package Movies;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;

/**
 * Created by aran on 15-12-2017.
 * In project MovieBende.
 */
public class MovieListView {
    // Load all info Labels
    @FXML
    private Label name;
    @FXML
    private Label country;
    @FXML
    private Label realeaseYear;
    @FXML
    private Label budget;
    @FXML
    private ListView<Movie> listView;
    private MovieListController movieListController;

    /**
     * @param movie The movie to show in labels
     */
    public void showMovie(Movie movie) {
        this.name.setText(movie.getName().get());
        this.country.setText(movie.getCountry());
        this.realeaseYear.setText(String.valueOf(movie.getYearOfRelease()));
        this.budget.setText(String.valueOf(movie.getBudget().get()));
    }

    /**
     * Remove selected movie from model
     */
    @FXML
    private void removeSelected() {
        MultipleSelectionModel<Movie> selectionMode = listView.getSelectionModel();
        Movie selectedItem = selectionMode.getSelectedItem();
        movieListController.removeMovie(selectedItem);
    }

    public void setMovieListController(MovieListController movieListController) {
        this.movieListController = movieListController;
    }

    public void setListView(ObservableList<Movie> movieList) {
        listView.setItems(movieList);
    }

    public void init() {
        this.listView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->
                showMovie(newSelection));
        //DESIGN PATTERN: Lambda Factory
        listView.setCellFactory(lv -> new ListCell<Movie>() {
            @Override
            public void updateItem(Movie movie, boolean empty) {
                super.updateItem(movie, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(movie.getName().get() + " (" + movie.getYearOfRelease() + ")");
                }
            }
        });
    }
}
