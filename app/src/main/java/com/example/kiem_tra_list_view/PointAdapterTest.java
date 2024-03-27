package com.example.kiem_tra_list_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PointAdapterTest extends RecyclerView.Adapter<PointAdapterTest.ViewHolder> {
    private Context context;
    private List<Point>pointList;
    private OnClickListener listener;

    public PointAdapterTest(Context context, List<Point> pointList, OnClickListener listener) {
        this.context = context;
        this.pointList = pointList;
        this.listener = listener;
    }
    public void setPointList(List<Point> points){
        this.pointList=points;
        notifyDataSetChanged();
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adapterView= LayoutInflater.from(context).inflate(R.layout.item_list_view,parent
                ,false);
        return new ViewHolder(adapterView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Point point= pointList.get(position);
        holder.textX.setText("diem x:"+point.getX());
        holder.textY.setText("diem y:"+point.getY());
        holder.textName.setText("ten diem: "+point.getName());
        holder.onBind(listener,point);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private EditText textX;
        private EditText textY;
        private  EditText textName;
        private View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textX=itemView.findViewById(R.id.text_x);
            textY=itemView.findViewById(R.id.text_y);
            textName=itemView.findViewById(R.id.text_name);
            this.view=itemView;
        }
        void onBind(OnClickListener listener,Point point){
            view.setOnClickListener(v->listener.onClickListener(point));
        }
    }
    interface OnClickListener{
       void onClickListener(Point point);
    }
}
