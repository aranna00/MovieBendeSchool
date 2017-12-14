package Movies;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by aran on 14-12-2017.
 * In project MovieBende.
 */
public class DataModel {

    private final ObservableList<Movie> movieList = FXCollections.observableArrayList();

    private final ObjectProperty<Movie> currentFilm = new SimpleObjectProperty<>(null);

    public ObjectProperty<Movie> currentFilmProperty() {
        return currentFilm ;
    }

//    public final Movie getCurrentFilm() {
//        return currentMovie().get();
//    }
//
//    public final void setCurrentMovie(Movie movie) {
//        currentMovie().set(movie);
//    }

    public ObservableList<Movie> getMovieList() {
        return movieList;
    }
}
