package Movies;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Comparator;
import java.util.Observable;

/**
 * Created by aran on 14-12-2017.
 * In project MovieBende.
 * <p>
 * Observer
 */
public class MovieModel extends Observable {
    // List of movies with default data
    private ObservableList<Movie> movieList = FXCollections.observableArrayList();

    public ObservableList<Movie> getMovieList() {
        Comparator<Movie> comparator = Comparator.comparingInt(Movie::getYearOfRelease);
        FXCollections.sort(movieList, comparator);
        return movieList;
    }

    /**
     * DESIGN PATTERN: Adapter
     *
     * @param importer
     */
    public void importMovies(MovieImporterInterface importer) {
        getMovieList().addAll(importer.importMovies());
        notifyObservers();
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
        this.notifyObservers();
    }

    public void removeMovie(Movie movie) {
        movieList.remove(movie);
        this.notifyObservers();
    }

    @Override
    public void notifyObservers() {
        setChanged();
        this.notifyObservers(getMovieList());
    }
}
