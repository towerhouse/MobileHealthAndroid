package app.thslucia.mobilehealth.model;

/**
 * Created by Usuario on 09/01/2017.
 */
public class Schedule {


    public String title;
    public String description;
    public int imageId;

    public Schedule(String title, String description, int imageId) {
        this.title = title;
        this.description = description;
        this.imageId = imageId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
