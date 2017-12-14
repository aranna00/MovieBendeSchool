package Movies;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage movieListStage) throws Exception{
        FXMLLoader createFilm = new FXMLLoader(getClass().getResource("createMovie.fxml"));
        Scene createFilmscene = new Scene(createFilm.load());
        CreateMovieController createMovieController = createFilm.getController();

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

        Stage graphsStage = new Stage();
        Stage createFilmStage = new Stage();
        movieListStage.setOnCloseRequest((arg0 -> {
            Platform.exit();
        }));
        graphsStage.setOnCloseRequest((arg0 -> {
            Platform.exit();
        }));
        createFilmStage.setOnCloseRequest((arg0 -> {
            Platform.exit();
        }));

        createFilmStage.setScene(createFilmscene);
        movieListStage.setScene(movieListScene);
        graphsStage.setScene(graphsScene);
        movieListStage.show();
        createFilmStage.show();
        graphsStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
