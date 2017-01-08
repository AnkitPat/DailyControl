package com.example.ankit.dailycontrol;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private  ArrayList<String> kidArrayList;

    private Spinner spMealOp1,spMealOp2,spMealOp3,spMealOp4,spMealOp5;
    private Spinner sleepOp1;
    private Spinner toilet,toilet1,toilet2;
    private CheckBox diapers,wetWipes;
    private TextView kid;

    private ArrayList<Integer> images;
    int mYear,mMonth,mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        System.out.println("the selected " + mDay);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NoticeBoardPopup.class);
                startActivity(intent);
            }
        });
       

        // Meal
        spMealOp1=(Spinner) findViewById(R.id.mealOp1);
        spMealOp2=(Spinner) findViewById(R.id.mealOp2);
        spMealOp3=(Spinner) findViewById(R.id.mealOp3);
        spMealOp4=(Spinner) findViewById(R.id.mealOp4);
        spMealOp5=(Spinner) findViewById(R.id.mealOp5);


        spMealOp1.setAdapter(new SpinnerAdapter(MainActivity.this,getImages()));
        spMealOp2.setAdapter(new SpinnerAdapter(MainActivity.this,getImages()));
        spMealOp3.setAdapter(new SpinnerAdapter(MainActivity.this,getImages()));
        spMealOp4.setAdapter(new SpinnerAdapter(MainActivity.this,getImages()));
        spMealOp5.setAdapter(new SpinnerAdapter(MainActivity.this,getImages()));

        //Toilet
        toilet=(Spinner) findViewById(R.id.normalToilet);
        toilet.setAdapter(new SpinnerAdapter(MainActivity.this,getImages()));

        toilet1=(Spinner)findViewById(R.id.diarrheaToilet);
        toilet1.setAdapter(new SpinnerAdapter(MainActivity.this,getImages()));

        toilet2=(Spinner)findViewById(R.id.hardToilet);
        toilet2.setAdapter(new SpinnerAdapter(MainActivity.this,getImages()));

        //Sleep


        sleepOp1=(Spinner)findViewById(R.id.napTime);
        sleepOp1.setAdapter(new SpinnerAdapter(MainActivity.this,getImages()));

        //Needs
        diapers=(CheckBox)findViewById(R.id.diaper_need);
        wetWipes=(CheckBox) findViewById(R.id.wetWipes);



        kid=(TextView)findViewById(R.id.kid);

        listView = (ListView)findViewById(R.id.newListView);
        kidArrayList = new ArrayList<>();

        kidArrayList.add("Azhar");
        kidArrayList.add("Ankit");
        kidArrayList.add("Suraj");
        kidArrayList.add("Piyush");


        ArrayList<Integer> universalValueArrayList = new ArrayList<>();
        universalValueArrayList.add(spMealOp1.getSelectedItemPosition());
        universalValueArrayList.add(spMealOp2.getSelectedItemPosition());
        universalValueArrayList.add(spMealOp3.getSelectedItemPosition());
        universalValueArrayList.add(spMealOp4.getSelectedItemPosition());
        universalValueArrayList.add(spMealOp5.getSelectedItemPosition());

        universalValueArrayList.add(toilet.getSelectedItemPosition());
        universalValueArrayList.add(toilet1.getSelectedItemPosition());
        universalValueArrayList.add(toilet2.getSelectedItemPosition());

        universalValueArrayList.add(sleepOp1.getSelectedItemPosition());

        universalValueArrayList.add(1);
        universalValueArrayList.add(1);


        ArrayList<ArrayList<HashMap<String,String>>> mainArrayLIst = new ArrayList<>();

        ArrayList<HashMap<String,String>> hashMapArrayList = new ArrayList<>();
        hashMapArrayList = new ArrayList<>();
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("sal","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("first","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("second","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("sna","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("din","spinner");
        hashMapArrayList.add(hashMap);

        hashMap.put("sal","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("first","checkbox");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("second","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("sna","checkbox");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("dinr","spinner");
        hashMapArrayList.add(hashMap);

        mainArrayLIst.add(hashMapArrayList);


        hashMapArrayList = new ArrayList<>();
        hashMap = new HashMap<>();
        hashMap.put("sal","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("first","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("second","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("sna","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("din","spinner");
        hashMapArrayList.add(hashMap);

        hashMap.put("sal","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("first","checkbox");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("second","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("sna","checkbox");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("dinr","spinner");
        hashMapArrayList.add(hashMap);

        hashMapArrayList = new ArrayList<>();
        hashMap.put("sal","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("first","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("second","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("sna","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("din","spinner");
        hashMapArrayList.add(hashMap);

        hashMap.put("sal","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("first","checkbox");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("second","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("sna","checkbox");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("dinr","spinner");
        hashMapArrayList.add(hashMap);

        mainArrayLIst.add(hashMapArrayList);

        hashMapArrayList  =  new ArrayList<>();

        hashMap.put("sal","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("first","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("second","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("sna","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("din","spinner");
        hashMapArrayList.add(hashMap);

        hashMap.put("sal","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("first","checkbox");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("second","spinner");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("sna","checkbox");
        hashMapArrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("dinr","spinner");
        hashMapArrayList.add(hashMap);

        mainArrayLIst.add(hashMapArrayList);

        mainArrayLIst.add(hashMapArrayList);





        NewListAdapterTest newListAdapter = new NewListAdapterTest(this,kidArrayList,mainArrayLIst);

        listView.setAdapter(newListAdapter);

//        spMealOp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                ArrayList<Integer> universalValueArrayList = new ArrayList<>();
//                universalValueArrayList.add(spMealOp1.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp2.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp3.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp4.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp5.getSelectedItemPosition());
//
//                universalValueArrayList.add(toilet.getSelectedItemPosition());
//                universalValueArrayList.add(toilet1.getSelectedItemPosition());
//                universalValueArrayList.add(toilet2.getSelectedItemPosition());
//
//                universalValueArrayList.add(sleepOp1.getSelectedItemPosition());
//
//                universalValueArrayList.add(1);
//                universalValueArrayList.add(1);
//
//                NewListAdapter newListAdapter = new NewListAdapter(MainActivity.this,kidArrayList,universalValueArrayList);
//
//                listView.setAdapter(newListAdapter);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        spMealOp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                ArrayList<Integer> universalValueArrayList = new ArrayList<>();
//                universalValueArrayList.add(spMealOp1.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp2.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp3.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp4.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp5.getSelectedItemPosition());
//
//                universalValueArrayList.add(toilet.getSelectedItemPosition());
//                universalValueArrayList.add(toilet1.getSelectedItemPosition());
//                universalValueArrayList.add(toilet2.getSelectedItemPosition());
//
//                universalValueArrayList.add(sleepOp1.getSelectedItemPosition());
//
//                universalValueArrayList.add(1);
//                universalValueArrayList.add(1);
//
//                NewListAdapter newListAdapter = new NewListAdapter(MainActivity.this,kidArrayList,universalValueArrayList);
//
//                listView.setAdapter(newListAdapter);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        spMealOp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                ArrayList<Integer> universalValueArrayList = new ArrayList<>();
//                universalValueArrayList.add(spMealOp1.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp2.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp3.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp4.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp5.getSelectedItemPosition());
//
//                universalValueArrayList.add(toilet.getSelectedItemPosition());
//                universalValueArrayList.add(toilet1.getSelectedItemPosition());
//                universalValueArrayList.add(toilet2.getSelectedItemPosition());
//
//                universalValueArrayList.add(sleepOp1.getSelectedItemPosition());
//
//                universalValueArrayList.add(1);
//                universalValueArrayList.add(1);
//
//                NewListAdapter newListAdapter = new NewListAdapter(MainActivity.this,kidArrayList,universalValueArrayList);
//
//                listView.setAdapter(newListAdapter);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        spMealOp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                ArrayList<Integer> universalValueArrayList = new ArrayList<>();
//                universalValueArrayList.add(spMealOp1.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp2.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp3.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp4.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp5.getSelectedItemPosition());
//
//                universalValueArrayList.add(toilet.getSelectedItemPosition());
//                universalValueArrayList.add(toilet1.getSelectedItemPosition());
//                universalValueArrayList.add(toilet2.getSelectedItemPosition());
//
//                universalValueArrayList.add(sleepOp1.getSelectedItemPosition());
//
//                universalValueArrayList.add(1);
//                universalValueArrayList.add(1);
//
//                NewListAdapter newListAdapter = new NewListAdapter(MainActivity.this,kidArrayList,universalValueArrayList);
//
//                listView.setAdapter(newListAdapter);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        spMealOp5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                ArrayList<Integer> universalValueArrayList = new ArrayList<>();
//                universalValueArrayList.add(spMealOp1.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp2.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp3.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp4.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp5.getSelectedItemPosition());
//
//                universalValueArrayList.add(toilet.getSelectedItemPosition());
//                universalValueArrayList.add(toilet1.getSelectedItemPosition());
//                universalValueArrayList.add(toilet2.getSelectedItemPosition());
//
//                universalValueArrayList.add(sleepOp1.getSelectedItemPosition());
//
//                universalValueArrayList.add(1);
//                universalValueArrayList.add(1);
//
//                NewListAdapter newListAdapter = new NewListAdapter(MainActivity.this,kidArrayList,universalValueArrayList);
//
//                listView.setAdapter(newListAdapter);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//
//        toilet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                ArrayList<Integer> universalValueArrayList = new ArrayList<>();
//                universalValueArrayList.add(spMealOp1.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp2.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp3.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp4.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp5.getSelectedItemPosition());
//
//                universalValueArrayList.add(toilet.getSelectedItemPosition());
//                universalValueArrayList.add(toilet1.getSelectedItemPosition());
//                universalValueArrayList.add(toilet2.getSelectedItemPosition());
//
//                universalValueArrayList.add(sleepOp1.getSelectedItemPosition());
//
//                universalValueArrayList.add(1);
//                universalValueArrayList.add(1);
//
//                NewListAdapter newListAdapter = new NewListAdapter(MainActivity.this,kidArrayList,universalValueArrayList);
//
//                listView.setAdapter(newListAdapter);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        toilet1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                ArrayList<Integer> universalValueArrayList = new ArrayList<>();
//                universalValueArrayList.add(spMealOp1.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp2.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp3.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp4.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp5.getSelectedItemPosition());
//
//                universalValueArrayList.add(toilet.getSelectedItemPosition());
//                universalValueArrayList.add(toilet1.getSelectedItemPosition());
//                universalValueArrayList.add(toilet2.getSelectedItemPosition());
//
//                universalValueArrayList.add(sleepOp1.getSelectedItemPosition());
//
//                universalValueArrayList.add(1);
//                universalValueArrayList.add(1);
//
//                NewListAdapter newListAdapter = new NewListAdapter(MainActivity.this,kidArrayList,universalValueArrayList);
//
//                listView.setAdapter(newListAdapter);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        toilet2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                ArrayList<Integer> universalValueArrayList = new ArrayList<>();
//                universalValueArrayList.add(spMealOp1.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp2.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp3.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp4.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp5.getSelectedItemPosition());
//
//                universalValueArrayList.add(toilet.getSelectedItemPosition());
//                universalValueArrayList.add(toilet1.getSelectedItemPosition());
//                universalValueArrayList.add(toilet2.getSelectedItemPosition());
//
//                universalValueArrayList.add(sleepOp1.getSelectedItemPosition());
//
//                universalValueArrayList.add(1);
//                universalValueArrayList.add(1);
//
//                NewListAdapter newListAdapter = new NewListAdapter(MainActivity.this,kidArrayList,universalValueArrayList);
//
//                listView.setAdapter(newListAdapter);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        sleepOp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                ArrayList<Integer> universalValueArrayList = new ArrayList<>();
//                universalValueArrayList.add(spMealOp1.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp2.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp3.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp4.getSelectedItemPosition());
//                universalValueArrayList.add(spMealOp5.getSelectedItemPosition());
//
//                universalValueArrayList.add(toilet.getSelectedItemPosition());
//                universalValueArrayList.add(toilet1.getSelectedItemPosition());
//                universalValueArrayList.add(toilet2.getSelectedItemPosition());
//
//                universalValueArrayList.add(sleepOp1.getSelectedItemPosition());
//
//                universalValueArrayList.add(1);
//                universalValueArrayList.add(1);
//
//                NewListAdapter newListAdapter = new NewListAdapter(MainActivity.this,kidArrayList,universalValueArrayList);
//
//                listView.setAdapter(newListAdapter);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
        kid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Daily Control");
                LayoutInflater inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View v=inflater.inflate(R.layout.dialog,null);

                Spinner s = (Spinner) v.findViewById(R.id.spinner); // find the spinner
                ArrayAdapter<CharSequence> mSpinnerAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.testArray, R.layout.spinner_item); //  create the adapter from a StringArray
                s.setAdapter(mSpinnerAdapter); // set the adapter

                String[] mtestArray = getResources().getStringArray(R.array.testArray);


                ImageButton calendar=(ImageButton) v.findViewById(R.id.calendar);
                calendar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                                new mDateSetListener(), mYear, mMonth, mDay);
                        dialog.show();



                        dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                mYear = i;
                                mMonth = i1;
                                mDay = i2;

                                System.out.print(mDay+" "+mMonth+" "+mYear);
                            }
                        });


                    }
                });

                kid.setText(mtestArray[s.getSelectedItemPosition()]);


                builder.setView(v);
                Dialog dialog=builder.create();
                dialog.show();
            }
        });




    }

    private ArrayList<Integer> getImages(){
        images=new ArrayList<>();

        images.add(R.mipmap.up);
        images.add(R.mipmap.down);
        images.add(R.mipmap.ok);
        images.add(R.mipmap.no);
        return images;

    }

    class mDateSetListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            // getCalender();
            int mYear = year;
            int mMonth = monthOfYear;
            int mDay = dayOfMonth;


        }
    }

}
