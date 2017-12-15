package Movies;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by aran on 15-12-2017.
 * In project MovieBende.
 */
public class CSVImporter implements MovieImporterInterface {
    private ArrayList<Movie> importedMovies = new ArrayList<Movie>();

    @Override
    public ArrayList<Movie> importMovies() {

        FileChooser fileChooser = new FileChooser();
        Stage fileChooserStage = new Stage();
        fileChooserStage.setTitle("Choose CSV");
        fileChooser.setTitle("Choose CSV");
        File file = fileChooser.showOpenDialog(fileChooserStage);
        BufferedReader br = null;
        String line = ";";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] movieLine = line.split(cvsSplitBy);
                importedMovies.add(new Movie(movieLine[0], Integer.parseInt(movieLine[1]), movieLine[2], Integer.parseInt(movieLine[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return importedMovies;
    }

    @Override
    public Movie getMovie() {
        return null;
    }
}
