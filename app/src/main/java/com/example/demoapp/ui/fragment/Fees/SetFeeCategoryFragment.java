package com.example.demoapp.ui.fragment.Fees;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demoapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetFeeCategoryFragment extends Fragment {

    public static SetFeeCategoryFragment newInstance() {
        return new SetFeeCategoryFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_fee_category, container, false);
    }
}
