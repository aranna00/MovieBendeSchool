package Movies;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
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
    @FXML
    private PieChart pieChart;

    public void updateBarChart(ObservableList<Movie> movieList) {
        barChart.getData().clear();

        //DESIGN PATTERN: stream
        Map<String, Long> ChartData = movieList.stream().collect(groupingBy(Movie::getCountry, counting()));
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        XYChart.Series series = new XYChart.Series();
        for (Map.Entry<String, Long> entry : ChartData.entrySet()) {
            String country = entry.getKey();
            Long amount = entry.getValue();
            pieChartData.add(new PieChart.Data(country, amount));
            series.getData().add(new XYChart.Data(country, amount));
        }
        pieChart.setData(pieChartData);
        barChart.getData().add(series);
    }
}
