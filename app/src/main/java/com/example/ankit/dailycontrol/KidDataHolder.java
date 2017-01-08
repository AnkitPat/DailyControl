package com.example.ankit.dailycontrol;

import java.util.ArrayList;

/**
 * Created by ANKIT on 03/01/2017.
 */

public class KidDataHolder {

    String category;
    String subCategory;
    int activate_default;

    ArrayList<String> valueArrayList,iconArrayList;

    public KidDataHolder(String category, String subCategory, int activate_default, ArrayList<String> valueArrayList, ArrayList<String> iconArrayList) {
        this.category = category;
        this.subCategory = subCategory;
        this.activate_default = activate_default;
        this.valueArrayList = valueArrayList;
        this.iconArrayList = iconArrayList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public int getActivate_default() {
        return activate_default;
    }

    public void setActivate_default(int activate_default) {
        this.activate_default = activate_default;
    }

    public ArrayList<String> getValueArrayList() {
        return valueArrayList;
    }

    public void setValueArrayList(ArrayList<String> valueArrayList) {
        this.valueArrayList = valueArrayList;
    }

    public ArrayList<String> getIconArrayList() {
        return iconArrayList;
    }

    public void setIconArrayList(ArrayList<String> iconArrayList) {
        this.iconArrayList = iconArrayList;
    }
}
