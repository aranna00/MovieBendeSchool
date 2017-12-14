package Movies;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by aran on 14-12-2017.
 * In project MovieBende.
 */
public class GraphsController extends Controller {
    @FXML
    AnchorPane anchorPane;
    @FXML
    private BarChart barChart;

    public void initModel(DataModel model) {
        super.initModel(model);
    }

    @Override
    public void update() {
        this.barChart.getData().setAll();
        ObservableList<Movie> movieList = model.getMovieList();
        // lamda expression and stream
        Map<String, Long> ChartData = movieList.stream().collect(groupingBy(Movie::getCountry, counting()));


        XYChart.Series series = new XYChart.Series();
        for (Map.Entry<String, Long> entry : ChartData.entrySet()) {
            String country = entry.getKey();
            Long amount = entry.getValue();
            series.getData().add(new XYChart.Data(country, amount));
        }
        this.barChart.getData().add(series);
    }
}
