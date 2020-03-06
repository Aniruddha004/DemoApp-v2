package com.example.demoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<GroupInfo> deptList;

    public CustomAdapter(Context context, ArrayList<GroupInfo> deptList) {
        this.context = context;
        this.deptList = deptList;
    }

    @Override
    public int getGroupCount() {
        return deptList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<ChildInfo> productList = deptList.get(groupPosition).getProductList();
        return productList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return deptList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<ChildInfo> productList = deptList.get(groupPosition).getProductList();
        return productList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        GroupInfo headerInfo = (GroupInfo) getGroup(groupPosition);
        if (view == null) {
            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.group_items, null);
        }

        TextView heading = view.findViewById(R.id.heading);
        heading.setText(headerInfo.getName().trim());

        ImageView icon = view.findViewById(R.id.imageView);
        String groupName = headerInfo.getName().trim();

        if (groupName.equals(context.getString(R.string.employees))) {
            icon.setImageResource(R.drawable.employee);
        } else if (groupName.equals(context.getString(R.string.students))) {
            icon.setImageResource(R.drawable.student);
        } else if (groupName.equals(context.getString(R.string.notice_home_syllabus))) {
            icon.setImageResource(R.drawable.homework);
        } else if (groupName.equals(context.getString(R.string.attendence))) {
            icon.setImageResource(R.drawable.attendence);
        } else if (groupName.equals(context.getString(R.string.marks))) {
            icon.setImageResource(R.drawable.marks);
        } else if (groupName.equals(context.getString(R.string.class_rooms))) {
            icon.setImageResource(R.drawable.classroom);
        } else if (groupName.equals(context.getString(R.string.timetable))) {
            icon.setImageResource(R.drawable.timetable);
        } else if (groupName.equals(context.getString(R.string.fees))) {
            icon.setImageResource(R.drawable.fees);
        } else if (groupName.equals(context.getString(R.string.delete))) {
            icon.setImageResource(R.drawable.delete);
        } else if (groupName.equals(context.getString(R.string.transport))) {
            icon.setImageResource(R.drawable.vehicle);
        } else if (groupName.equals(context.getString(R.string.visitors))) {
            icon.setImageResource(R.drawable.visitor);
        } else {
            icon.setImageResource(R.drawable.gallery);
        }

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        ChildInfo detailInfo = (ChildInfo) getChild(groupPosition, childPosition);
        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.child_items, null);
        }

        TextView childItem = view.findViewById(R.id.childItem);
        childItem.setText(detailInfo.getName().trim());

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
