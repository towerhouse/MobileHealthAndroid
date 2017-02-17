package app.thslucia.mobilehealth.viewAdapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import app.thslucia.mobilehealth.R;
import app.thslucia.mobilehealth.model.Patient;
import app.thslucia.mobilehealth.model.PatientTelephone;

/**
 * Created by Usuario on 16/02/2017.
 */
public class TelephoneViewAdapter extends RecyclerView.Adapter<TelephoneViewAdapter.TelephoneViewHolder> {
    List<PatientTelephone> telephoneList = Collections.emptyList();
    Context context;

    public TelephoneViewAdapter(List<PatientTelephone> patientList, Context context) {
        this.telephoneList = patientList;
        this.context = context;
    }

    @Override
    public TelephoneViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.telephone_row, parent, false);
        TelephoneViewAdapter.TelephoneViewHolder holder = new TelephoneViewAdapter.TelephoneViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final TelephoneViewHolder telephoneViewHolder, int i) {
        final PatientTelephone ci = telephoneList.get(i);
        telephoneViewHolder.card_telephone_owner.setText(ci.getOwner());
        telephoneViewHolder.card_telephone_number.setText(ci.getNumber());
        telephoneViewHolder.card_telephone_status.setText(ci.getStatus());

        //Show if this patient is active or not by the icon color
        setActiveIcon(telephoneViewHolder, i);

        //Open a new activity to show more phones
        /*telephoneViewHolder.card_telephone_more_phones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phonesIntent = new Intent(context, TelephonePhonesActivity.class).putExtra("telephone", ci);
                phonesIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(phonesIntent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return telephoneList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, PatientTelephone data) {
        telephoneList.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(PatientTelephone data) {
        int position = telephoneList.indexOf(data);
        telephoneList.remove(position);
        notifyItemRemoved(position);
    }

    public class TelephoneViewHolder extends RecyclerView.ViewHolder {
        protected TextView card_telephone_owner;
        protected TextView card_telephone_number;
        protected TextView card_telephone_status;

        public TelephoneViewHolder(View v) {
            super(v);
            card_telephone_owner = (TextView) v.findViewById(R.id.card_telephone_owner);
            card_telephone_number = (TextView) v.findViewById(R.id.card_telephone_number);
            card_telephone_status = (TextView) v.findViewById(R.id.card_telephone_status);
        }

    }

    protected void setActiveIcon(TelephoneViewHolder telephoneViewHolder, int i) {
        PatientTelephone current = telephoneList.get(i);
        if (current.getStatus().equals(PatientTelephone.STATUS_INACTIVE)) {
            telephoneViewHolder.card_telephone_status.setTextColor(ContextCompat.getColor(context, R.color.light_gray));
        } else if (current.getStatus().equals(PatientTelephone.STATUS_MAIN)) {
            telephoneViewHolder.card_telephone_status.setTextColor(ContextCompat.getColor(context, R.color.green));
        } else {
            telephoneViewHolder.card_telephone_status.setTextColor(ContextCompat.getColor(context, R.color.black));
        }
    }
}
