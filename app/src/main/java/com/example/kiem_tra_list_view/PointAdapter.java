package com.example.kiem_tra_list_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.lifecycle.Observer;

import java.util.List;

public class PointAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<Point>pointList;
    @Override
    public int getCount() {
        return pointList.size();
    }

    public PointAdapter(Context context, List<Point> pointList) {
        this.context = context;
        this.pointList = pointList;
        inflater= LayoutInflater.from(context);
    }
    public void setPointList(List<Point>points){
        this.pointList=points;
        notifyDataSetChanged();

    }

    @Override
    public Object getItem(int position) {
        return pointList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if(view==null){
            view= inflater.inflate(R.layout.item_list_view,null);
            viewHolder =new ViewHolder();
            viewHolder.textX=(TextView) view.findViewById(R.id.text_x);
            viewHolder.textY=(TextView) view.findViewById(R.id.text_y);
            viewHolder.textName=(TextView) view.findViewById(R.id.text_name);
            viewHolder.recycle=(ImageButton)view.findViewById(R.id.image_remove);


            view.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder) view.getTag();
        }
        Point point= pointList.get(position);
        viewHolder.textX.setText( " Toa do x:"+point.getX());
        viewHolder.textY.setText(" Toa do x:"+point.getY());
        viewHolder.textName.setText( "Ten diem"+point.getName());
        viewHolder.recycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).delete(position);
            }
        });
        return view;
    }
    private static class ViewHolder{
        TextView textX;
        TextView textY;
        TextView textName;
        ImageButton recycle;

    }
}
