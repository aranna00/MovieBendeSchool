package Movies;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage movieListStage) throws Exception{
        FXMLLoader createMovie = new FXMLLoader(getClass().getResource("createMovie.fxml"));
        Scene createMoviescene = new Scene(createMovie.load());
        CreateMovieController createMovieController = createMovie.getController();
        createMovieController.initNumberFields();

        FXMLLoader movieList = new FXMLLoader(getClass().getResource("movieList.fxml"));
        Scene movieListScene = new Scene(movieList.load());
        MovieListController movieListController = movieList.getController();

        FXMLLoader graphs = new FXMLLoader(getClass().getResource("graphs.fxml"));
        Scene graphsScene = new Scene(graphs.load());
        GraphsController graphsController = graphs.getController();

        DataModel model = new DataModel();
        model.loadData();
        createMovieController.initModel(model);
        movieListController.initModel(model);
        graphsController.initModel(model);

        model.attach(createMovieController);
        model.attach(movieListController);
        model.attach(graphsController);

        Stage graphsStage = new Stage();
        Stage createMovieStage = new Stage();

        graphsStage.setTitle("Show Graphs");
        movieListStage.setTitle("Show all movies");
        createMovieStage.setTitle("Add new movie");

        graphsStage.setY(250);
        movieListStage.setY(250);
        createMovieStage.setY(250);

        graphsStage.setX(75);
        movieListStage.setX(775);
        createMovieStage.setX(1475);

        movieListStage.setOnCloseRequest((arg0 -> {
            Platform.exit();
        }));
        graphsStage.setOnCloseRequest((arg0 -> {
            Platform.exit();
        }));
        createMovieStage.setOnCloseRequest((arg0 -> {
            Platform.exit();
        }));

        createMovieStage.setScene(createMoviescene);
        movieListStage.setScene(movieListScene);
        graphsStage.setScene(graphsScene);
        createMovieStage.show();
        graphsStage.show();
        movieListStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
