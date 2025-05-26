
//JOSE ARMANDO OLMOS RESENDIZ

package com.example.programa04;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class Estados extends Activity {
    private Spinner stateSpinner;
    private TextView capitalTextView;
    private Map<String, String> stateCapitalMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estados);

        stateSpinner = findViewById(R.id.stateSpinner);
        capitalTextView = findViewById(R.id.capitalTextView);

        
        stateCapitalMap = new HashMap<>();
        stateCapitalMap.put("California", "Sacramento");
        stateCapitalMap.put("Texas", "Austin");
        stateCapitalMap.put("Florida", "Tallahassee");
        stateCapitalMap.put("New York", "Albany");
        stateCapitalMap.put("Illinois", "Springfield");

        
        String[] states = stateCapitalMap.keySet().toArray(new String[0]);

        
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, states);

        
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        
        stateSpinner.setAdapter(adapter);

        
        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                
                String selectedState = parent.getItemAtPosition(position).toString();

                
                String capital = stateCapitalMap.get(selectedState);

                
                capitalTextView.setText("Capital: " + capital);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                
            }
        });
    }
}