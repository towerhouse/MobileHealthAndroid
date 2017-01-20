package app.thslucia.mobilehealth.viewAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import com.balysv.materialripple.MaterialRippleLayout;
import com.pkmmte.view.CircularImageView;

import app.thslucia.mobilehealth.PatientsPhoneActivity;
import app.thslucia.mobilehealth.R;
import app.thslucia.mobilehealth.model.Patient;

/**
 * Created by Lucia on 15/01/2017.
 */
public class PatientViewAdapter extends RecyclerView.Adapter<PatientViewAdapter.PatientViewHolder> {

    List<Patient> patientList = Collections.emptyList();
    Context context;

    public PatientViewAdapter(List<Patient> patientList, Context context) {
        this.patientList = patientList;
        this.context = context;
    }

    @Override
    public PatientViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.patient_row, parent, false);
        PatientViewAdapter.PatientViewHolder holder = new PatientViewAdapter.PatientViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final PatientViewHolder patientViewHolder, int i) {
        Patient ci = patientList.get(i);
        patientViewHolder.card_patient_first_names.setText(ci.getFirstNames());
        patientViewHolder.card_patient_last_names.setText(ci.getLastNames());
        patientViewHolder.card_patient_phone_type.setText(ci.getPhoneType());
        patientViewHolder.card_patient_phone.setText(ci.getPhone());
        patientViewHolder.card_patient_address_type.setText(ci.getAddressType());
        patientViewHolder.card_patient_address.setText(ci.getAddress());
        patientViewHolder.card_patient_last_visit.setText(ci.getLastVisitDate());

        //Open a new activity to show more phones
        patientViewHolder.card_patient_more_phones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phonesIntent = new Intent(context, PatientsPhoneActivity.class);
                phonesIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(phonesIntent);
            }
        });

        //Show if this patient is active or not by the icon color
        setActiveIcon(patientViewHolder, i);
    }


    protected void setActiveIcon(PatientViewHolder patientViewHolder, int i) {
        Patient current = patientList.get(i);
        if (current.getStatus().equals(Patient.STATUS_INACTIVE)) {
            patientViewHolder.card_patient_frame.setColorFilter(ContextCompat.getColor(context, R.color.light_gray));
        }
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Patient data) {
        patientList.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Patient data) {
        int position = patientList.indexOf(data);
        patientList.remove(position);
        notifyItemRemoved(position);
    }

    public class PatientViewHolder extends RecyclerView.ViewHolder {
        protected TextView card_patient_first_names;
        protected TextView card_patient_last_names;
        protected TextView card_patient_last_visit;
        protected TextView card_patient_address_type;
        protected TextView card_patient_address;
        protected TextView card_patient_phone_type;
        protected TextView card_patient_phone;
        protected ImageView card_patient_frame;
        protected ImageView card_patient_more_addresses;
        protected ImageView card_patient_more_phones;

        public PatientViewHolder(View v) {
            super(v);
            card_patient_first_names = (TextView) v.findViewById(R.id.card_patient_first_names);
            card_patient_last_names = (TextView) v.findViewById(R.id.card_patient_last_names);
            card_patient_last_visit = (TextView) v.findViewById(R.id.card_patient_last_visit);
            card_patient_address_type = (TextView) v.findViewById(R.id.card_patient_address_type);
            card_patient_address = (TextView) v.findViewById(R.id.card_patient_address);
            card_patient_phone_type = (TextView) v.findViewById(R.id.card_patient_phone_type);
            card_patient_phone = (TextView) v.findViewById(R.id.card_patient_phone);
            card_patient_frame = (ImageView) v.findViewById(R.id.card_patient_frame);
            card_patient_more_addresses = (ImageView) v.findViewById(R.id.card_patient_more_addresses);
            card_patient_more_phones = (ImageView) v.findViewById(R.id.card_patient_more_phones);
        }

    }
}
