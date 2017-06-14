package Models;

/**
 * Created by Sanonzon on 2017-06-13.
 */
public class WhiskyModel {
    private String name;
    private int age;
    private String malt;
    private String description;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getMalt() {
        return malt;
    }
    public String getDescription() { return description; }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setMalt(String malt) {
        this.malt = malt;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
