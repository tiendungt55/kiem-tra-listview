package com.example.kiem_tra_list_view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class PointViewModel extends ViewModel {
    private MutableLiveData<List<Point>> liveData;
    private List<Point>list;
    public LiveData<List<Point>> getListLiveData(){
        if(liveData==null){
            liveData=new MutableLiveData<>();
            list= new ArrayList<>();
        } else {
        liveData.setValue(list);
    }
        return liveData;
    }
    public void setLiveData(Point point){
        list.add(point);
        liveData.setValue(list);
    }
}
