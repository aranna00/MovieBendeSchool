package Movies;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.util.Observable;

/**
 * Created by aran on 14-12-2017.
 * In project MovieBende.
 */
public class CreateMovieController extends Controller {

    private CreateMovieView createMovieView;

    public CreateMovieController(MovieModel model) throws Exception {
        this.model = model;
        // Load createMovie view with controller
        FXMLLoader createMovie = new FXMLLoader(getClass().getResource("createMovie.fxml"));
        this.scene = new Scene(createMovie.load());
        createMovieView = createMovie.getController();
        createMovieView.initNumberFields();
        createMovieView.setController(this);
    }

    // DESIGN PATTERN: command
    public void addMovie(Movie movie) {
        model.addMovie(movie);
    }

    @Override
    public void update(Observable o, Object arg) {
        // Not needed
    }
}
