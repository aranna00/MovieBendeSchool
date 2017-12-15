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
    private ObservableList<Movie> movieList = FXCollections.observableArrayList(
            new Movie("Star Wars: Episode I", 1999, "USA", 115000000),
            new Movie("Star Wars: Episode II", 2002, "USA", 120000000),
            new Movie("Star Wars: Episode III", 2005, "USA", 113000000),
            new Movie("Star Wars: Episode IV", 1977, "USA", 13000000),
            new Movie("Star Wars: Episode V", 1980, "USA", 18000000),
            new Movie("Star Wars: Episode VI", 1983, "USA", 32500000),
            new Movie("Iep!", 2010, "NL", 0),
            new Movie("Zwart Water", 2010, "NL", 0),
            new Movie("Shocking Blue", 2010, "NL", 0)
    );

    public ObservableList<Movie> getMovieList() {
        Comparator<Movie> comparator = Comparator.comparingInt(Movie::getYearOfRelease);
        FXCollections.sort(movieList, comparator);
        return movieList;
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
