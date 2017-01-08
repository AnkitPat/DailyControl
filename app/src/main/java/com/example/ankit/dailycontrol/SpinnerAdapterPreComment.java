package com.example.ankit.dailycontrol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ANKIT on 19/12/2016.
 */

public class SpinnerAdapterPreComment extends BaseAdapter {
    private ArrayList<String> commentList;

    private Context context;

    public SpinnerAdapterPreComment(Context context, ArrayList<String> commentList){
        this.commentList=commentList;
        this.context=context;
    }
    @Override
    public int getCount() {
        return commentList.size();
    }

    @Override
    public Object getItem(int i) {
        return commentList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.spinner_precomment_item,null);

        TextView textView   = (TextView)v.findViewById(R.id.textPreComment);

        textView.setText(commentList.get(i));
        return v;
    }


}
