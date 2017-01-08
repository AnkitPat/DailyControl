package com.example.ankit.dailycontrol;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.renderscript.Script;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by ANKIT on 24/12/2016.
 */

public class NewListAdapterTest extends BaseAdapter {
    Context context;

    private ArrayList<Integer> images;
    private Button save,post,present,addRemarks;
    private ArrayList<String> kidArrayList;
    private ArrayList<ArrayList<HashMap<String,String>>> hashMapArrayList;
    ArrayList<String> remarkList;
    String YouEditTextValue ;

    public NewListAdapterTest(Context context,ArrayList<String>kidArrayList, ArrayList<ArrayList<HashMap<String,String>>> hashMapArrayList) {
    this.context=context;
    this.hashMapArrayList = hashMapArrayList;
        this.kidArrayList=kidArrayList;
    }

    @Override
    public int getCount() {
        return hashMapArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View convertView;
        if(view==null)
        {
            view = inflater.inflate(R.layout.dynamic_layout,null);
        }

        convertView=view;

        final TextView kidView=(TextView) view.findViewById(R.id.kidView);
        save=(Button)view.findViewById(R.id.save);
        post=(Button)view.findViewById(R.id.post);
        present=(Button)view.findViewById(R.id.present);
        addRemarks=(Button)view.findViewById(R.id.addRemarks);

       // ListView listView = (ListView)view.findViewById(R.id.listRemark);
        LinearLayout main_view =(LinearLayout) view.findViewById(R.id.mainView);

        final LinearLayout identityLinear = (LinearLayout)view.findViewById(R.id.identityLinear);

        for (int j=0;j<hashMapArrayList.get(i).size();j++) {

            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 150);
            layoutParams.setMargins(10,0,10,0);

            RelativeLayout layout = new RelativeLayout(context);

            kidView.setText(kidArrayList.get(i));

            layout.setLayoutParams(layoutParams);
            layout.setGravity(Gravity.CENTER);

            layoutParams = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(R.dimen.title_width), ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            layoutParams.addRule(Gravity.CENTER);




            TextView titleText = new TextView(context);
            titleText.setLayoutParams(layoutParams);

            String s = hashMapArrayList.get(i).get(j).keySet().toArray()[0].toString();
            titleText.setText(s);
            titleText.setBackgroundColor(Color.RED);
            titleText.setTextColor(Color.WHITE);
            titleText.setTextSize(20);
            titleText.setGravity(Gravity.CENTER_HORIZONTAL);
            layout.addView(titleText);


            if (hashMapArrayList.get(i).get(j).get(hashMapArrayList.get(i).get(j).keySet().toArray()[0].toString()).equals("spinner")) {
                layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

                layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                Spinner spinner = new Spinner(context);
                spinner.setLayoutParams(layoutParams);

                spinner.setAdapter(new SpinnerAdapter(context,getImages()));
                spinner.setGravity(Gravity.CENTER_HORIZONTAL);
                layout.addView(spinner);

               spinner.setTag(hashMapArrayList.get(i).get(j).keySet().toArray()[0]);
            } else {

                layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

                layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

                CheckBox checkBox = new CheckBox(context);
                checkBox.setLayoutParams(layoutParams);

                layout.addView(checkBox);
            }

            main_view.addView(layout);
        }



        kidView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(context,kidView.getText(),Toast.LENGTH_SHORT).show();
                kidView.setVisibility(View.GONE);

                identityLinear.setVisibility(View.VISIBLE);
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinner = (Spinner)convertView.findViewWithTag("sal");
                int sal = spinner.getSelectedItemPosition();
                 spinner = (Spinner)convertView.findViewWithTag("first");
                int first = spinner.getSelectedItemPosition();
                 spinner = (Spinner)convertView.findViewWithTag("second");

                Toast.makeText(context,sal+" "+first+" "+spinner.getSelectedItemPosition()+"ankit",Toast.LENGTH_SHORT).show();

            }
        });


//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context,R.layout.remark_list_item,R.id.remarkText,new String[]{"b","d","a","b","c"});
//
//        listView.setAdapter(arrayAdapter);

         remarkList= new ArrayList<>();


        addRemarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                final EditText edittext = new EditText(context);
                View view1 = LayoutInflater.from(context).inflate(R.layout.remark_layout,null);


                alert.setView(view1);

                YouEditTextValue = null;
                final ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("A");
                arrayList.add("B");
                arrayList.add("C");
                arrayList.add("D");
//                Button saveButton = (Button)view1.findViewById(R.id.save);
//                Button cancelButton = (Button)view1.findViewById(R.id.cancel);
                final Spinner spinner = (Spinner)view1.findViewById(R.id.preCommentSpinner);
                spinner.setAdapter(new SpinnerAdapterPreComment(context,arrayList));

                final EditText editText = (EditText)view1.findViewById(R.id.editText);


                alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //What ever you want to do with the value
                        YouEditTextValue = edittext.getText().toString();
                        remarkList.add(arrayList.get(spinner.getSelectedItemPosition())+" "+editText.getText()+" ");
                        LinearLayout remarkLInar = (LinearLayout)convertView.findViewById(R.id.remarkLinear);

                        for(int k=0;k<remarkList.size();k++)
                        {

                            LinearLayout tempLinear = new LinearLayout(context);
                            tempLinear.setOrientation(LinearLayout.HORIZONTAL);
                            TextView remarkText = new TextView(context);
                            remarkText.setText(remarkList.get(k)+"\n");
                            remarkText.setTextColor(Color.BLACK);

                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            layoutParams.setMargins(10,20,0,0);


                            remarkText.setLayoutParams(layoutParams);

                            tempLinear.addView(remarkText);

                            ImageView imageView  = new ImageView(context);
                            imageView.setImageResource(R.drawable.edit);

                            layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            layoutParams.setMargins(10,20,0,0);


                            tempLinear.addView(imageView);

                            imageView  = new ImageView(context);
                            imageView.setImageResource(R.drawable.cancel);

                            layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            layoutParams.setMargins(10,20,0,0);

                            tempLinear.addView(imageView);

                            imageView  = new ImageView(context);
                            imageView.setImageResource(R.drawable.post);

                            layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            layoutParams.setMargins(10,20,0,0);

                            tempLinear.addView(imageView);



                            remarkLInar.addView(tempLinear);


                        }
                        dialog.dismiss();
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // what ever you want to do with No option.
                        dialog.dismiss();
                    }
                });

                alert.show();


            }
        });


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

}
