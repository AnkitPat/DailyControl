package  com.example.ankit.dailycontrol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import java.util.ArrayList;

/**
 * Created by ANKIT on 19/12/2016.
 */

public class SpinnerAdapter extends BaseAdapter {
    private ArrayList<Integer> imageList;
    private ImageView imageView;
    private Context context;

    public  SpinnerAdapter(Context context,ArrayList<Integer> imageList){
        this.imageList=imageList;
        this.context=context;
    }
    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public Object getItem(int i) {
        return imageList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.spinner,null);
        imageView=(ImageView) v.findViewById(R.id.spinnerItem);
        imageView.setImageResource(imageList.get(i));
        return v;
    }


}
