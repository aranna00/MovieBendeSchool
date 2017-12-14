package Movies;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aran on 14-12-2017.
 * In project MovieBende.
 */
public class DataModel {

    private final ObservableList<Movie> movieList = FXCollections.observableArrayList(movie -> new Observable[]{movie.getName(), movie.getBudget(), movie.getCountry(), movie.getYearOfRelease()});
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
        return movieList;
    }

    public void loadData() {
        // mock...
        movieList.setAll(
                new Movie("test", 1, "NL",1),
                new Movie("test2", 2,"NL",2),
                new Movie("test3", 3, "NL",3),
                new Movie("test4", 4, "NL",4),
                new Movie("test5", 5, "NL",5)
        );
        notifyAllObservers();
    }
    public void addMovie(Movie movie){
        movieList.add(movie);
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
