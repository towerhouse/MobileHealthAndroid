package app.thslucia.mobilehealth.viewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

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
        patientViewHolder.name.setText(ci.getName());
        patientViewHolder.last_name.setText(ci.getLastName());
        patientViewHolder.email.setText(ci.getEmail());
        patientViewHolder.title.setText(ci.getTitle());
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
        protected TextView name;
        protected TextView last_name;
        protected TextView email;
        protected TextView title;

        public PatientViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.card_patient_name);
            last_name = (TextView) v.findViewById(R.id.card_patient_last_name);
            email = (TextView) v.findViewById(R.id.card_patient_email);
            title = (TextView) v.findViewById(R.id.card_patient_title);
        }
    }
}
