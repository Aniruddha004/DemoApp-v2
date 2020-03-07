package com.example.demoapp.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demoapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeeHomeFragment extends Fragment {

    public static FeeHomeFragment newInstance() {
        return new FeeHomeFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fee_home, container, false);
    }
}
