package app.thslucia.mobilehealth;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import app.thslucia.mobilehealth.model.Card;
import app.thslucia.mobilehealth.model.Patient;
import app.thslucia.mobilehealth.model.PatientTelephone;
import app.thslucia.mobilehealth.viewAdapter.PatientViewAdapter;
import app.thslucia.mobilehealth.viewAdapter.TelephoneViewAdapter;

public class PatientPhonesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_phone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Patient patient = getIntent().getExtras().getParcelable("patient");
        getPatientTelephones(patient);

    }

    protected void getPatientTelephones(Patient patient)
    {
        List<PatientTelephone> data = fillWithTelephoneData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.container_phones_body);
        TelephoneViewAdapter adapter = new TelephoneViewAdapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    //// TODO BORRAR TODO ESTO
    public List<PatientTelephone> fillWithTelephoneData() {
        List<PatientTelephone> data = new ArrayList<>();
        data.add(new PatientTelephone("Familia", "099 555 555", "Activo"));
        data.add(new PatientTelephone("Abuelos", "2900 00 00", "Activo"));
        data.add(new PatientTelephone("Sobrino materno", "3900 00 00", "Inactivo"));

        return data;
    }

}
