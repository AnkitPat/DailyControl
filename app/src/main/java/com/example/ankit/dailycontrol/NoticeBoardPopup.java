package com.example.ankit.dailycontrol;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Azhar on 07-01-2017.
 */

public class NoticeBoardPopup extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticeboardpopup);
        Spinner numberDropDown = (Spinner) findViewById(R.id.dropDown);
        TextView startdate = (TextView) findViewById(R.id.startdate);
        TextView finishdate = (TextView) findViewById(R.id.finishdate);
        TextView classroom = (TextView) findViewById(R.id.classroom);
        TextView notice = (TextView) findViewById(R.id.notice);
        TextView action = (TextView) findViewById(R.id.action);

        ArrayList<String> numberArrayLIst = new ArrayList<>();
        numberArrayLIst.add("10");
        numberArrayLIst.add("25");
        numberArrayLIst.add("50");
        numberArrayLIst.add("100");

        numberDropDown.setAdapter(new SpinnerAdapterPreComment(this,numberArrayLIst));



        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        startdate.setLayoutParams(new LinearLayout.LayoutParams((int) (width*0.15), LinearLayout.LayoutParams.WRAP_CONTENT));
        finishdate.setLayoutParams(new LinearLayout.LayoutParams((int) (width*0.15), LinearLayout.LayoutParams.WRAP_CONTENT));
        classroom.setLayoutParams(new LinearLayout.LayoutParams((int) (width*0.15), LinearLayout.LayoutParams.WRAP_CONTENT));
        notice.setLayoutParams(new LinearLayout.LayoutParams((int) (width*0.40), LinearLayout.LayoutParams.WRAP_CONTENT));
        action.setLayoutParams(new LinearLayout.LayoutParams((int) (width*0.15), LinearLayout.LayoutParams.WRAP_CONTENT));


    }
}
