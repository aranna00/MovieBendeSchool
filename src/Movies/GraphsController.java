package Movies;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Observable;

/**
 * Created by aran on 14-12-2017.
 * In project MovieBende.
 */
public class GraphsController extends Controller {
    private GraphsView graphsView;

    public GraphsController(MovieModel model) throws IOException {
        this.model = model;
//        // Load graphs view with controller
        FXMLLoader graphs = new FXMLLoader(getClass().getResource("graphs.fxml"));
        this.scene = new Scene(graphs.load());
        this.graphsView = graphs.getController();
    }

    /**
     *
     * DESIGN PATTERN: command
     * Update view with new data from MovieModel
     */
    @Override
    public void update(Observable o, Object arg) {
        graphsView.updateBarChart((ObservableList<Movie>) arg);
    }
}
