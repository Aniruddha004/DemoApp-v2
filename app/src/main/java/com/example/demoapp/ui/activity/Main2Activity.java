package com.example.demoapp.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.demoapp.AddVideoFragment;
import com.example.demoapp.ChildInfo;
import com.example.demoapp.CustomAdapter;
import com.example.demoapp.GroupInfo;
import com.example.demoapp.R;
import com.example.demoapp.ui.fragment.AddAlbumFragment;
import com.example.demoapp.ui.fragment.AddPhotoFragment;
import com.example.demoapp.ui.fragment.AddTimetableFragment;
import com.example.demoapp.ui.fragment.AddVehicleFragment;
import com.example.demoapp.ui.fragment.ClassFeeCollectionFragment;
import com.example.demoapp.ui.fragment.DeleteEmployeeDetailsFragment;
import com.example.demoapp.ui.fragment.DeleteStudentDetailsFragment;
import com.example.demoapp.ui.fragment.DeletedEmployeesDataFragment;
import com.example.demoapp.ui.fragment.DeletedStudentsDataFragment;
import com.example.demoapp.ui.fragment.DriverFragment;
import com.example.demoapp.ui.fragment.EmpRegistrationFragment;
import com.example.demoapp.ui.fragment.EmpSearchFragment;
import com.example.demoapp.ui.fragment.EmpUpdateFragment;
import com.example.demoapp.ui.fragment.FeeCollectionReportFragment;
import com.example.demoapp.ui.fragment.FeeHomeFragment;
import com.example.demoapp.ui.fragment.FineFragment;
import com.example.demoapp.ui.fragment.RouteWiseAttendanceFragment;
import com.example.demoapp.ui.fragment.RoutesFragment;
import com.example.demoapp.ui.fragment.RoutesReportFragment;
import com.example.demoapp.ui.fragment.SearchDefaulterFragment;
import com.example.demoapp.ui.fragment.StudentRegistrationFragment;
import com.example.demoapp.ui.fragment.ViewTimetableFragment;
import com.example.demoapp.ui.fragment.VisitorListFragment;
import com.google.android.material.navigation.NavigationView;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.HashMap;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private HashMap<String, GroupInfo> subjects = new HashMap<>();
    private ArrayList<GroupInfo> deptList = new ArrayList<>();

    private CustomAdapter listAdapter;
    private ExpandableListView simpleExpandableListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        Fragment fragment = EmpRegistrationFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        // add data for displaying in expandable list view
        loadData();

        //get reference of the ExpandableListView
        simpleExpandableListView = (ExpandableListView) findViewById(R.id.simpleExpandableListView);
        // create the adapter by passing your ArrayList data
        listAdapter = new CustomAdapter(Main2Activity.this, deptList);
        // attach the adapter to the expandable list view
        simpleExpandableListView.setAdapter(listAdapter);

        //expand all the Groups
        //expandAll();

        // setOnChildClickListener listener for child row click
        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //get the group info
                GroupInfo groupInfo = deptList.get(groupPosition);
                String groupName = groupInfo.getName();
                //get the child info
                ChildInfo childInfo = groupInfo.getProductList().get(childPosition);
                String childName = childInfo.getName();

                Fragment fragment = EmpRegistrationFragment.newInstance();

                if (groupName.equals(getString(R.string.employees))) {
                    if (childName.equals(getString(R.string.employee_registration))) {
                        fragment = EmpRegistrationFragment.newInstance();
                    } else if (childName.equals(getString(R.string.employee_updates))) {
                        fragment = EmpUpdateFragment.newInstance();
                    } else if (childName.equals(getString(R.string.search_employees))) {
                        fragment = EmpSearchFragment.newInstance();
                    } else {

                    }

                } else if (groupName.equals(getString(R.string.students))) {
                    if (childName.equals(getString(R.string.student_registration))) {
                        fragment = StudentRegistrationFragment.newInstance();
                    } else if (childName.equals(getString(R.string.student_updates))) {

                    } else if (childName.equals(getString(R.string.search_students))) {

                    } else if (childName.equals(getString(R.string.student_credentials))) {

                    } else {

                    }

                } else if (groupName.equals(getString(R.string.notice_home_syllabus))) {
                    if (childName.equals(getString(R.string.notice_to_class))) {

                    } else if (childName.equals(getString(R.string.notice_to_student))) {

                    } else if (childName.equals(getString(R.string.home_work))) {

                    } else {

                    }

                } else if (groupName.equals(getString(R.string.attendence))) {
                    if (childName.equals(getString(R.string.student_attendence))) {

                    } else if (childName.equals(getString(R.string.student_attendence_report))) {

                    } else if (childName.equals(getString(R.string.teacher_attendence))) {

                    } else {

                    }


                } else if (groupName.equals(getString(R.string.marks))) {
                    if (childName.equals(getString(R.string.marks_home))) {

                    } else if (childName.equals(getString(R.string.class_report))) {

                    } else {

                    }

                } else if (groupName.equals(getString(R.string.class_rooms))) {
                    if (childName.equals(getString(R.string.add_classroom))) {

                    }
                } else if (groupName.equals(getString(R.string.timetable))) {
                    if (childName.equals(getString(R.string.add_timetable_detail))) {
                        fragment = AddTimetableFragment.newInstance();
                    } else if(childName.equals(getString(R.string.view_timetable_details))){
                        fragment = ViewTimetableFragment.newInstance();
                    }
                } else if (groupName.equals(getString(R.string.fees))) {
                    if (childName.equals(getString(R.string.fee_home))) {
                        fragment = FeeHomeFragment.newInstance();
                    } else if (childName.equals(getString(R.string.fine))) {
                        fragment = FineFragment.newInstance();
                    } else if (childName.equals(getString(R.string.class_fee_collection))) {
                        fragment = ClassFeeCollectionFragment.newInstance();
                    } else if (childName.equals(getString(R.string.fee_collection_report))) {
                        fragment = FeeCollectionReportFragment.newInstance();
                    } else if(childName.equals(getString(R.string.search_defaulter)))
                        fragment = SearchDefaulterFragment.newInstance();

                } else if (groupName.equals(getString(R.string.delete))) {
                    if (childName.equals(getString(R.string.delete_student_details))) {
                        fragment = DeleteStudentDetailsFragment.newInstance();
                    } else if (childName.equals(getString(R.string.get_deleted_students_data))) {
                        fragment = DeletedStudentsDataFragment.newInstance();
                    } else if (childName.equals(getString(R.string.delete_employee_details))) {
                        fragment = DeleteEmployeeDetailsFragment.newInstance();
                    } else {
                        fragment = DeletedEmployeesDataFragment.newInstance();
                    }

                } else if (groupName.equals(getString(R.string.transport))) {
                    if (childName.equals(getString(R.string.add_vehicle))) {
                        fragment= new AddVehicleFragment();
                    } else if (childName.equals(getString(R.string.vehicle_list))) {

                    } else if (childName.equals(getString(R.string.driver))) {
                        fragment= new DriverFragment();
                    } else if (childName.equals(getString(R.string.route_wise_attendence))) {
                        fragment=new RouteWiseAttendanceFragment();
                    } else if (childName.equals(getString(R.string.routes))) {
                        fragment=new RoutesFragment();
                    } else {
                        fragment=new RoutesReportFragment();
                    }
                } else if (groupName.equals(getString(R.string.visitors))) {
                    if (childName.equals(getString(R.string.add_visitor))) {
                        fragment = new VisitorListFragment();
                    } else {

                    }

                } else {
                    if (childName.equals(getString(R.string.add_album))) {
                        fragment = AddAlbumFragment.newInstance();
                    } else if (childName.equals(getString(R.string.add_photo))) {
                        fragment = AddPhotoFragment.newInstance();
                    } else {
                        fragment = AddVideoFragment.newInstance();
                    }
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                return false;
            }
        });
        // setOnGroupClickListener listener for group heading click
        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //get the group header
                GroupInfo groupInfo = deptList.get(groupPosition);
                //display it or do something with it
//                Toast.makeText(getBaseContext(), " Header is :: " + groupInfo.getName(),
//                        Toast.LENGTH_LONG).show();

                return false;
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    //method to expand all groups
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            simpleExpandableListView.expandGroup(i);
        }
    }

    //method to collapse all groups
    private void collapseAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            simpleExpandableListView.collapseGroup(i);
        }
    }

    //load some initial data into out list
    private void loadData() {
        addProduct(getString(R.string.employees), "Employee Registration");
        addProduct(getString(R.string.employees), "Employee Updates");
        addProduct(getString(R.string.employees), "Search Employees");
        addProduct(getString(R.string.employees), "Employee Credentials");

        addProduct(getString(R.string.students), "Student Registration");
        addProduct(getString(R.string.students), "Student Updates");
        addProduct(getString(R.string.students), "Search Students");
        addProduct(getString(R.string.students), "Student Credentials");
        addProduct(getString(R.string.students), "Bulk Upload");

        addProduct(getString(R.string.notice_home_syllabus), "Notice to Class");
        addProduct(getString(R.string.notice_home_syllabus), "Notice to Student");
        addProduct(getString(R.string.notice_home_syllabus), "Home Work");
        addProduct(getString(R.string.notice_home_syllabus), "Add Syllabus");

        addProduct(getString(R.string.attendence), "Student Attendence");
        addProduct(getString(R.string.attendence), "Student Attendence Report");
        addProduct(getString(R.string.attendence), "Teacher Attendence");
        addProduct(getString(R.string.attendence), "Teacher Attendence Report");

        addProduct(getString(R.string.marks), "Marks Home");
        addProduct(getString(R.string.marks), "Class Report");
        addProduct(getString(R.string.marks), "Report Card");

        addProduct(getString(R.string.class_rooms), "Add ClassRoom");

        addProduct(getString(R.string.timetable), "Add TimeTable Detail");
        addProduct(getString(R.string.timetable), "View TimeTable Details");

        addProduct(getString(R.string.fees), "Fee Home");
        addProduct(getString(R.string.fees), "Fine");
        addProduct(getString(R.string.fees), "Class Fee Collection");
        addProduct(getString(R.string.fees), "Search Defaulter");
        addProduct(getString(R.string.fees), "Fee Collection Report");

        addProduct(getString(R.string.delete), "Delete Student Details");
        addProduct(getString(R.string.delete), "Get Deleted Students Data");
        addProduct(getString(R.string.delete), "Delete Employee Details");
        addProduct(getString(R.string.delete), "Get Deleted Employees Data");

        addProduct(getString(R.string.transport), "Add Vehicle");
        addProduct(getString(R.string.transport), "Vehicle List");
        addProduct(getString(R.string.transport), "Driver");
        addProduct(getString(R.string.transport), "Route Wise Attendence");
        addProduct(getString(R.string.transport), "Routes");
        addProduct(getString(R.string.transport), "Routes Report");

        addProduct(getString(R.string.visitors), "Add Visitor");
        addProduct(getString(R.string.visitors), "Visitor List");

        addProduct(getString(R.string.gallery), "Add Album");
        addProduct(getString(R.string.gallery), "Add Photo");
        addProduct(getString(R.string.gallery), "Add Video");
    }


    //here we maintain our products in various departments
    private void addProduct(String department, String product) {

        int groupPosition = 0;

        //check the hash map if the group already exists
        GroupInfo headerInfo = subjects.get(department);
        //add the group if doesn't exists
        if (headerInfo == null) {
            headerInfo = new GroupInfo();
            headerInfo.setName(department);
            subjects.put(department, headerInfo);
            deptList.add(headerInfo);
        }

        //get the children for the group
        ArrayList<ChildInfo> productList = headerInfo.getProductList();
        //size of the children list
        int listSize = productList.size();
        //add to the counter
        listSize++;

        //create a new child and add that to the group
        ChildInfo detailInfo = new ChildInfo();
        detailInfo.setSequence(String.valueOf(listSize));
        detailInfo.setName(product);
        productList.add(detailInfo);
        headerInfo.setProductList(productList);

        //find the group position inside the list
        groupPosition = deptList.indexOf(headerInfo);
    }

}
