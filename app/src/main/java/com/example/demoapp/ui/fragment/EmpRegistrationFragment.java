package com.example.demoapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.demoapp.R;

public class EmpRegistrationFragment extends Fragment {

    private String[] categories = {"Select", "Teacher", "Driver", "Peon", "Receptionist", "Coordinator", "Manger", "Helper", "Principal", "Oyher"};

    public static EmpRegistrationFragment newInstance() {
        return new EmpRegistrationFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_emp_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Spinner spinnerCategory = view.findViewById(R.id.spEmpCategory);
        spinnerCategory.setAdapter(new ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, categories));
    }
}