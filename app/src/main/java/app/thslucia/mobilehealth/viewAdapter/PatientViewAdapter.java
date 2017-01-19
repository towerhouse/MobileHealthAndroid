package app.thslucia.mobilehealth.viewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import com.balysv.materialripple.MaterialRippleLayout;
import com.pkmmte.view.CircularImageView;

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
    public void onBindViewHolder(PatientViewHolder patientViewHolder, int i) {
        Patient ci = patientList.get(i);
        patientViewHolder.card_patient_first_names.setText(ci.getFirstNames());
        patientViewHolder.card_patient_last_names.setText(ci.getLastNames());
        patientViewHolder.card_patient_phone_type.setText(ci.getPhoneType());
        patientViewHolder.card_patient_phone.setText(ci.getPhone());
        patientViewHolder.card_patient_address_type.setText(ci.getAddressType());
        patientViewHolder.card_patient_address.setText(ci.getAddress());
        patientViewHolder.card_patient_last_visit.setText(ci.getLastVisitDate());
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

        public PatientViewHolder(View v) {
            super(v);
            setActiveIcon(v);
            setCircularIconFrame(v);
            card_patient_first_names = (TextView) v.findViewById(R.id.card_patient_first_names);
            card_patient_last_names = (TextView) v.findViewById(R.id.card_patient_last_names);
            card_patient_last_visit = (TextView) v.findViewById(R.id.card_patient_last_visit);
            card_patient_address_type = (TextView) v.findViewById(R.id.card_patient_address_type);
            card_patient_address = (TextView) v.findViewById(R.id.card_patient_address);
            card_patient_phone_type = (TextView) v.findViewById(R.id.card_patient_phone_type);
            card_patient_phone = (TextView) v.findViewById(R.id.card_patient_phone);
        }

        protected void setActiveIcon(View v) {
            CircularImageView circularImageView = (CircularImageView) v.findViewById(R.id.card_patient_status);
        }

        protected void setCircularIconFrame(View v) {
            CircularImageView circularImageView = (CircularImageView) v.findViewById(R.id.card_patient_frame);
            circularImageView.setBorderColor(R.color.gray_border);
            circularImageView.setBorderWidth(10);
            circularImageView.setSelectorColor(R.color.light_blue);
            circularImageView.setSelectorStrokeWidth(10);
            circularImageView.addShadow();
        }
    }
}
