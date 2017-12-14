package Movies;

/**
 * Created by Aran on 14/12/2017.
 * In project MovieBendeSchool.
 */
public abstract class Controller {
    protected DataModel model;

    public abstract void update();

    public void initModel(DataModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }

        this.model = model;
    }
}
