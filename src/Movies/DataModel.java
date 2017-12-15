package Movies;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by aran on 14-12-2017.
 * In project MovieBende.
 */
public class DataModel {

    //private final ObservableList<Movie> movieList = FXCollections.observableArrayList(movie -> new Observable[]{movie.getName(), movie.getBudget(), movie.getCountry(), movie.getYearOfRelease()});
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
    private final ObjectProperty<Movie> currentMovie = new SimpleObjectProperty<>(null);
    private List<Controller> observers = new ArrayList<Controller>();

    public ObjectProperty<Movie> currentMovieProperty() {
        return currentMovie;
    }

    public final Movie getCurrentMovie() {
        return currentMovie.get();
    }

    public final void setCurrentMovie(Movie movie) {
        currentMovie.set(movie);
        notifyAllObservers();
    }

    public ObservableList<Movie> getMovieList() {
        Comparator<Movie> comparator = Comparator.comparingInt(Movie::getYearOfRelease);
        FXCollections.sort(movieList, comparator);
        return movieList;
    }
    public void addMovie(Movie movie){
        movieList.add(movie);
        notifyAllObservers();
    }

    public void removeMovie(Movie movie) {
        movieList.remove(movie);
        notifyAllObservers();
    }

    public void attach(Controller observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Controller observer : observers) {
            observer.update();
        }
    }
}
