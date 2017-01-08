package com.example.ankit.dailycontrol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by ANKIT on 24/12/2016.
 */

public class NewListAdapter  extends BaseAdapter {
    Context context;
    private ArrayList<String> kid;

    private Spinner spMealOp1,spMealOp2,spMealOp3,spMealOp4,spMealOp5;
    private Spinner sleepOp1;
    private Spinner toilet,toilet1,toilet2;
    private CheckBox diapers,wetWipes;
    private TextView kidText;
    private Button save,post,present,addRemarks;

    private ArrayList<Integer> images;
    private ArrayList<Integer> universalArrayList;

    public NewListAdapter(Context context,ArrayList<String> kid,ArrayList<Integer> universalArrayList) {
    this.context=context;
        this.kid = kid;
        this.universalArrayList = universalArrayList;
    }

    @Override
    public int getCount() {
        return kid.size();
    }

    @Override
    public Object getItem(int i) {
        return kid.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view==null)
        {
            view = inflater.inflate(R.layout.new_item_list,null);;
        }

        kidText = (TextView)view.findViewById(R.id.kidIndividual);
        save=(Button)view.findViewById(R.id.save);
        post=(Button)view.findViewById(R.id.post);
        present=(Button)view.findViewById(R.id.present);
        addRemarks=(Button)view.findViewById(R.id.addRemarks);
        kidText.setText(kid.get(i));


        // Meal
        spMealOp1=(Spinner)view. findViewById(R.id.mealOp1);
        spMealOp2=(Spinner) view.findViewById(R.id.mealOp2);
        spMealOp3=(Spinner)view. findViewById(R.id.mealOp3);
        spMealOp4=(Spinner) view.findViewById(R.id.mealOp4);
        spMealOp5=(Spinner) view.findViewById(R.id.mealOp5);


        spMealOp1.setAdapter(new SpinnerAdapter(context,getImages()));
        spMealOp2.setAdapter(new SpinnerAdapter(context,getImages()));
        spMealOp3.setAdapter(new SpinnerAdapter(context,getImages()));
        spMealOp4.setAdapter(new SpinnerAdapter(context,getImages()));
        spMealOp5.setAdapter(new SpinnerAdapter(context,getImages()));

        //Toilet
        toilet=(Spinner) view.findViewById(R.id.normalToilet);
        toilet.setAdapter(new SpinnerAdapter(context,getImages()));

        toilet1=(Spinner)view.findViewById(R.id.diarrheaToilet);
        toilet1.setAdapter(new SpinnerAdapter(context,getImages()));

        toilet2=(Spinner)view.findViewById(R.id.hardToilet);
        toilet2.setAdapter(new SpinnerAdapter(context,getImages()));

        //Sleep


        sleepOp1=(Spinner)view.findViewById(R.id.napTime);
        sleepOp1.setAdapter(new SpinnerAdapter(context,getImages()));

        //Needs
        diapers=(CheckBox)view.findViewById(R.id.diaper_need);
        wetWipes=(CheckBox) view.findViewById(R.id.wetWipes);

        spMealOp1.setSelection(universalArrayList.get(0));
        spMealOp2.setSelection(universalArrayList.get(1));
        spMealOp3.setSelection(universalArrayList.get(2));
        spMealOp4.setSelection(universalArrayList.get(3));
        spMealOp5.setSelection(universalArrayList.get(4));



        return view;

    }
    private ArrayList<Integer> getImages(){
        images=new ArrayList<>();
        images.add(R.mipmap.up);
        images.add(R.mipmap.down);
        images.add(R.mipmap.ok);
        images.add(R.mipmap.no);
        return images;

    }
    public void showSelected(int p){

    }
}
