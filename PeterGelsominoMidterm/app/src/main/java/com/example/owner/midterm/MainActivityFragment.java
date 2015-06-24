package com.example.owner.midterm;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final EditText editUSDollars = (EditText) rootView.findViewById(R.id.usdollars);

        final EditText editFranc = (EditText) rootView.findViewById(R.id.france);

        Button button = (Button) rootView.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double dollars = Double.valueOf(editUSDollars.getText().toString());

                double france = dollars * 586.84;

                editFranc.setText(String.valueOf(france));
            }
        });
                    return rootView;
    }
}
