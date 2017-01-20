package app.thslucia.mobilehealth.model;

/**
 * Created by Usuario on 14/01/2017.
 */
public class Patient {

    public static final String STATUS_ACTIVE = "active";
    public static final String STATUS_INACTIVE = "inactive";

    public Patient(String first_name, String second_name, String last_name, String second_last_name) {
        this.first_name = first_name;
        this.first_last_name = first_last_name;
        this.second_name = first_name;
        this.second_last_name = first_last_name;
    }

    public Patient(String first_name, String second_name, String first_last_name, String second_last_name,
                   String address_type, String address, String phone_type, String phone, String status) {
        this.first_name = first_name;
        this.first_last_name = first_last_name;
        this.second_name = second_name;
        this.second_last_name = second_last_name;
        this.phone = phone;
        this.address = address;
        this.phone_type = phone_type;
        this.address_type = address_type;
        this.status = status;
    }

    protected String id;
    protected String first_name;
    protected String second_name;
    protected String first_last_name;
    protected String second_last_name;
    protected String job;
    protected String document;
    protected String country;
    protected String email;
    protected String birthday;
    protected String status;
    protected String id_professional;
    protected String last_visit_date;

    //Address
    protected String address_type;
    protected String address;

    //Phone
    protected String phone_type;
    protected String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getSecondName() {
        return second_name;
    }

    public void setSecondName(String second_name) {
        this.second_name = second_name;
    }

    public String getFirstLastName() {
        return first_last_name;
    }

    public void setFirstLastName(String first_last_name) {
        this.first_last_name = first_last_name;
    }

    public String getSecondLastName() {
        return second_last_name;
    }

    public void setSecondLastName(String second_last_name) {
        this.second_last_name = second_last_name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdProfessional() {
        return id_professional;
    }

    public void setIdProfessional(String id_professional) {
        this.id_professional = id_professional;
    }

    public String getFirstNames() {
        return first_name + " " + second_name;
    }

    public String getLastNames() {
        return first_last_name + " " + second_last_name;
    }

    public String getLastVisitDate() {
        return "Hace 12 dias el 4 de enero del 2017";
    }

    public String getPhoneType() {
        return "Teléfono " + this.phone_type;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddressType() {
        return "Dirección " + this.address_type;
    }

    public String getAddress() {
        return this.address;
    }
}
