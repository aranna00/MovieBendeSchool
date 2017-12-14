package Movies;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private CreateFilmController createFilmController;
    private Graph graphsController;
    private MovieListController movieListController;

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        FXMLLoader createFilm = FXMLLoader.load(getClass().getResource("createFilm.fxml"));
        root.setCenter(createFilm.load());
        createFilmController = createFilm.getController();

//        this.createFilmController = new CreateFilmController(new Stage());
//        this.graphsController = new Graphs(new Stage());
//        this.movieListController = new MovieListController(new Stage());
//        Movie testMovie = new Movie("test",1995,"NL",200);
//        movieListController.addMovieToList(testMovie);
//        movieListController.showMovie(testMovie);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
