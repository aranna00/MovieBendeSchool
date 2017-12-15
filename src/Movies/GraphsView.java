package Movies;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by aran on 15-12-2017.
 * In project MovieBende.
 */
public class GraphsView {
    // Select barChart from view
    @FXML
    private BarChart barChart;

    public void updateBarChart(ObservableList<Movie> movieList) {
        barChart.getData().clear();

        //DESIGN PATTERN: stream
        Map<String, Long> ChartData = movieList.stream().collect(groupingBy(Movie::getCountry, counting()));

        XYChart.Series series = new XYChart.Series();
        for (Map.Entry<String, Long> entry : ChartData.entrySet()) {
            String country = entry.getKey();
            Long amount = entry.getValue();
            series.getData().add(new XYChart.Data(country, amount));
        }
        barChart.getData().add(series);
    }
}
