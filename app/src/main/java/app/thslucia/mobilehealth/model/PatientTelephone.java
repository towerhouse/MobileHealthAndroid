package app.thslucia.mobilehealth.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Usuario on 14/02/2017.
 */
public class PatientTelephone implements Parcelable {

    public static final String STATUS_ACTIVE = "active";
    public static final String STATUS_INACTIVE = "inactive";
    public static final String STATUS_MAIN = "principal";

    protected String id;
    protected String id_patient;
    protected String number;
    protected String owner;
    protected String status;
    protected String id_professional;

    public PatientTelephone(String owner, String number, String status) {
        this.owner = owner;
        this.number = number;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPatient() {
        return id_patient;
    }

    public void setIdPatient(String id_patient) {
        this.id_patient = id_patient;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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


    /* Parcel methods */

    public PatientTelephone(Parcel in ) {
        readFromParcel( in );
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public PatientTelephone createFromParcel(Parcel in ) {
            return new PatientTelephone( in );
        }

        public PatientTelephone[] newArray(int size) {
            return new PatientTelephone[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //Add them in the same order you declare them
        dest.writeString(id);
        dest.writeString(id_patient);
        dest.writeString(number);
        dest.writeString(owner);
        dest.writeString(status);
        dest.writeString(id_professional);
    }

    private void readFromParcel(Parcel in ) {
        id = in.readString();
        id_patient = in.readString();
        number = in.readString();
        owner = in.readString();
        status = in.readString();
        id_professional = in.readString();
    }
}
