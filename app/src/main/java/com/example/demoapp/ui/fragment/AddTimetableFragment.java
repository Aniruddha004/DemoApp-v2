package com.example.demoapp.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.demoapp.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class AddTimetableFragment extends Fragment {

    public static AddTimetableFragment newInstance() {
        return new AddTimetableFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_add_timetable, container, false);

        String [] values =
                {"1-A","2-A","3-A","4-A","5-A","6-A","7-A","8-A","9-A","10-A",};
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        return v;

//        return inflater.inflate(R.layout.fragment_add_timetable, container, false);
    }
}