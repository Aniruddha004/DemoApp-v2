package com.example.demoapp.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import com.example.demoapp.R;

public class ClassFeeCollectionFragment extends Fragment {

    public static ClassFeeCollectionFragment newInstance() {
        return new ClassFeeCollectionFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_timetable, container, false);

//        String [] values =
//                {"1-A","2-A","3-A","4-A","5-A","6-A","7-A","8-A","9-A","10-A",};
//        Spinner spinner = (Spinner) v.findViewById(R.id.spinnerClass);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
//        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//        spinner.setAdapter(adapter);

        String [] feeCat =
                {"1-A","2-A","3-A","4-A","5-A","6-A","7-A","8-A","9-A","10-A",};
        Spinner spin = (Spinner) v.findViewById(R.id.spinnerFeeCategory);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, feeCat);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spin.setAdapter(adapter1);

        return v;
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_class_fee_collection, container, false);
    }
}
