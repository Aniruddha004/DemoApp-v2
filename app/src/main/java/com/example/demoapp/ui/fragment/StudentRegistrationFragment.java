package com.example.demoapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.demoapp.R;

public class StudentRegistrationFragment extends Fragment {

    public static StudentRegistrationFragment newInstance() {
        return new StudentRegistrationFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_registration, container, false);
    }
}