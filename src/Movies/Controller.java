package Movies;

import javafx.scene.Scene;

import java.util.Observer;

/**
 * Created by Aran on 14/12/2017.
 * In project MovieBendeSchool.
 */
public abstract class Controller implements Observer {
    protected MovieModel model;
    protected Scene scene;

    //DESIGN PATTERN: Observer
    public Scene getScene() {
        return scene;
    }
}
