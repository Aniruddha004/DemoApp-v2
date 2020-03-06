package com.example.demoapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.demoapp.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private String[] categories = {"Select", "Teacher", "Driver", "Peon", "Receptionist", "Coordinator", "Manger", "Helper", "Principal", "Oyher"};
    EditText etDOB, etJoiningDate;
    private int mDayBirth, mMonthBirth, mYearBirth;
    private int mDayJoin, mMonthJoin, mYearJoin;

    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form1_screen);
//        getSupportActionBar().hide();

        Spinner spinnerCategory = findViewById(R.id.spEmpCategory);
        spinnerCategory.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categories));

        etDOB = findViewById(R.id.etDOB);
        etJoiningDate = findViewById(R.id.etJoiningDate);

        etJoiningDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mDayJoin = dayOfMonth;
                        mMonthJoin = month;
                        mYearJoin = year;
                        updateLabel(mYearJoin, mMonthJoin, mDayJoin);
                    }
                }, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        etDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        mDayBirth = dayOfMonth;
                        mMonthBirth = monthOfYear;
                        mYearBirth = year;
                        updateLabel(mYearBirth, mMonthBirth, mDayBirth);
                    }
                }, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void updateLabel(int year, int month, int day) {
        etDOB.setText(new StringBuilder()
                // Month is 0 based so add 1
                .append(day).append("/").append(month + 1).append("/").append(year).append(" "));
    }
}
