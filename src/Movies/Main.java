package Movies;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends Application {
    CreateMovieController createMovieController;
    MovieListController movieListController;
    GraphsController graphsController;

    @Override
    public void start(Stage movieListStage) throws Exception {

        // Create MovieModel and init it in all controllers
        MovieModel model = new MovieModel();

        createMovieController = new CreateMovieController(model);
        movieListController = new MovieListController(model);
        graphsController = new GraphsController(model);
        // Add all controllers to model
        model.addObserver(createMovieController);
        model.addObserver(movieListController);
        model.addObserver(graphsController);

        // Add all seed info to views
        model.notifyObservers();

        // Create additional stages for more windows
        Stage graphsStage = new Stage();
        Stage createMovieStage = new Stage();
//
        // Set window titles
        graphsStage.setTitle("Show Graphs");
        movieListStage.setTitle("Show all movies");
        createMovieStage.setTitle("Add new movie");
//
        // Set window locations
        graphsStage.setY(250);
        movieListStage.setY(250);
        createMovieStage.setY(250);
//
        graphsStage.setX(25);
        movieListStage.setX(675);
        createMovieStage.setX(1325);
//
        // Close all windows on closing 1 window
        movieListStage.setOnCloseRequest((arg0 -> Platform.exit()));
        graphsStage.setOnCloseRequest((arg0 -> Platform.exit()));
        createMovieStage.setOnCloseRequest((arg0 -> Platform.exit()));
//
        // Set stage scenes and show windows
        createMovieStage.setScene(createMovieController.getScene());
        movieListStage.setScene(movieListController.getScene());
        graphsStage.setScene(graphsController.getScene());
        createMovieStage.show();
        graphsStage.show();
        movieListStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
