package Models;

import javafx.beans.property.*;

/**
 * Created by Sanonzon on 2017-06-14.
 */
public class WhiskyTableModel {
    private StringProperty name = new SimpleStringProperty();
    private StringProperty malt = new SimpleStringProperty();
    private StringProperty age = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();

    public WhiskyTableModel(String name, String malt, int age, String description){
        this.name.set(name);
        this.malt.set(malt);
        this.age.set(Integer.toString(age));
        this.description.set(description);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getMalt() {
        return malt.get();
    }

    public StringProperty maltProperty() {
        return malt;
    }

    public void setMalt(String malt) {
        this.malt.set(malt);
    }

    public String getAge() {
        return age.get();
    }

    public StringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
