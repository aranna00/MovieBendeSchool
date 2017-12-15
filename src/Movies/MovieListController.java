package Movies;

import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    @FXML
    private Button DeleteButton;

    public void initModel(DataModel model) {
        super.initModel(model);

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
                    setText(movie.getName().get() + " (" + movie.getYearOfRelease() + ")");
                }
            }
        });
    }

    public void showMovie(Movie movie) {
        this.name.setText(movie.getName().get());
        this.country.setText(movie.getCountry());
        this.realeaseYear.setText(String.valueOf(movie.getYearOfRelease()));
        this.budget.setText(String.valueOf(movie.getBudget().get()));
    }

    @Override
    public void update() {
        this.listView.setItems(model.getMovieList());
    }

    @FXML
    private void delete() {
        model.removeMovie(model.getCurrentMovie());
    }
}
