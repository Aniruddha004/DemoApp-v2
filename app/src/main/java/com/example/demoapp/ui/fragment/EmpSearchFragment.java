package com.example.demoapp.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.demoapp.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class EmpSearchFragment extends Fragment {

    public static EmpSearchFragment newInstance() {
        return new EmpSearchFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_emp_search, container, false);
    }
}