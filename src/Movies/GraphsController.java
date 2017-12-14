package Movies;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by aran on 14-12-2017.
 * In project MovieBende.
 */
class GraphsController {
    GraphsController(Stage graphsStage) throws IOException {
        Parent graphs = FXMLLoader.load(getClass().getResource("graphs.fxml"));
        graphsStage.setTitle("Graphs");
        graphsStage.setScene(new Scene(graphs));
        graphsStage.setX(1200);
        graphsStage.setY(250);
        graphsStage.show();
    }
}
