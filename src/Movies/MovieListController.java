package Movies;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

/**
 * Created by aran on 14-12-2017.
 * In project MovieBende.
 */
public class MovieListController extends Controller {
    @FXML
    SplitPane splitPane;
    @FXML
    Label name;
    @FXML
    private Label country;
    @FXML
    private Label realeaseYear;
    @FXML
    private Label budget;
    @FXML
    private ListView<Movie> listView;

    private DataModel model;

    public void initModel(DataModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }

        this.model = model;
        this.listView = (ListView) ((AnchorPane) splitPane.getItems().get(0)).getChildren().get(0);
        this.listView.setItems(model.getMovieList());

        this.listView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->
                model.setCurrentMovie(newSelection));

        model.currentMovieProperty().addListener((obs, oldMovie, newMovie) -> {
            if (newMovie == null) {
                this.listView.getSelectionModel().clearSelection();
            } else {
                this.listView.getSelectionModel().select(newMovie);
                showMovie(newMovie);
            }
        });

        listView.setCellFactory(lv -> new ListCell<Movie>() {
            @Override
            public void updateItem(Movie movie, boolean empty) {
                super.updateItem(movie, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(movie.getName().get() + " (" + movie.getYearOfRelease().get() + ")");
                }
            }
        });
    }

    public void showMovie(Movie movie) {
        this.name.setText(movie.getName().get());
        this.country.setText(movie.getCountry().get());
        this.realeaseYear.setText(String.valueOf(movie.getYearOfRelease()));
        this.budget.setText(String.valueOf(movie.getBudget()));
    }

    @Override
    public void update() {
        this.listView.setItems(model.getMovieList());
    }
}
