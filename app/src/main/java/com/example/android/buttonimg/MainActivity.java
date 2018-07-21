package com.example.android.buttonimg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private String mSpinnerLabel = "";

    Spinner mlabelspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlabelspinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Food, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        if (mlabelspinner != null) {
            mlabelspinner.setAdapter(adapter);
            mlabelspinner.setOnItemSelectedListener(this);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int
            i, long l) {
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(),mSpinnerLabel+" is selected", Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG, "onNothingSelected: ");
    }
}



