package com.example.thdgk.graduateProject;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thdgk.registeration.R;

import java.util.List;

/**
 * Created by thdgk on 2017-06-24.
 */

public class RankListAdapter extends BaseAdapter {

    private Context context;
    private List<Course> courseList;
    private Fragment parent;

    public RankListAdapter(Context context, List<Course> courseList, Fragment parent) {
        this.context = context;
        this.courseList = courseList;
        this.parent = parent;
        //new BackgroundTask().execute();

    }

    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Object getItem(int i) {
        return courseList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        View v = View.inflate(context, R.layout.rank, null);

        TextView rankTextView = (TextView)v.findViewById(R.id.ranTextView);
        TextView courseGrade = (TextView)v.findViewById(R.id.courseGrade);
        TextView courseTitle = (TextView)v.findViewById(R.id.courseTitle);
        TextView courseCredit = (TextView)v.findViewById(R.id.courseCredit);
        TextView coursePersonnel = (TextView)v.findViewById(R.id.coursePersonnel);
        TextView courseProfessor = (TextView)v.findViewById(R.id.courseProfessor);
        TextView courseTime = (TextView)v.findViewById(R.id.courseTime);

        rankTextView.setText((i + 1) + "위");
        if(i != 0){
            rankTextView.setBackgroundColor(parent.getResources().getColor(R.color.colorPrimary));
        }


        courseGrade.setText(courseList.get(i).getCourseGrade());

        courseTitle.setText(courseList.get(i).getCourseTitle());
        courseCredit.setText(courseList.get(i).getCourseCredit() + "학점");

        if(courseList.get(i).getCoursePersonnel() == 0){
            coursePersonnel.setText("인원 제한 없음");
        }
        else{

            coursePersonnel.setText("제한 인원: " + courseList.get(i).getCoursePersonnel() + "명");

        }

        courseProfessor.setText(courseList.get(i).getCourseProfessor() + "교수님");
        courseTime.setText(courseList.get(i).getCourseTime());

       v.setTag(courseList.get(i).getCourseID());

        final String code = String.valueOf(courseList.get(i).getCourseID());

        return v;

    }

}
