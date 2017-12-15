package Movies;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Observable;

/**
 * Created by aran on 14-12-2017.
 * In project MovieBende.
 */
public class MovieListController extends Controller {
    private MovieListView movieListView;


    MovieListController(MovieModel model) throws IOException {
        this.model = model;

//        // Load movieList view with controller
        FXMLLoader movieList = new FXMLLoader(getClass().getResource("movieList.fxml"));
        this.scene = new Scene(movieList.load());
        movieListView = movieList.getController();
        movieListView.init();
        movieListView.setMovieListController(this);
    }

    /**
     * Update view with new data from MovieModel
     */
    @Override
    public void update(Observable o, Object arg) {
        movieListView.setListView((ObservableList<Movie>) arg);
    }

    public void removeMovie(Movie movie) {
        model.removeMovie(movie);
    }
}
