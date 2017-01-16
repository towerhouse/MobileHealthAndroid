package app.thslucia.mobilehealth.model;

/**
 * Created by Usuario on 14/01/2017.
 */
public class Patient {

    public String name;
    public String last_name;
    public String email;

    public Patient(String name, String last_name, String email) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.name = email;
    }

    public String getTitle() {
        return name + " " + last_name;
    }
}
