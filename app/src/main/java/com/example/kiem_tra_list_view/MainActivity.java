package com.example.kiem_tra_list_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private PointAdapter adapter;
private List<Point> points;
private ListView listPoints;
private EditText edtX;
private EditText edtY;
private EditText edtName;
private Button btnAdd;
private Button btnRemove;
private int index;
private PointViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inItView();
        handleEvent();
        model= new ViewModelProvider(this).get(PointViewModel.class);
       model.getListLiveData().observe(this, points->adapter.setPointList(points));
       listPoints.setAdapter(adapter);


        listPoints.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index=position;
            }
        });
        btnRemove= (Button) findViewById(R.id.btn_remove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    points.remove(index);
                    adapter.notifyDataSetChanged();

            }
        });
    }

    private void handleEvent() {
        View.OnClickListener handle= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x= Integer.parseInt(edtX.getText().toString());
                int y= Integer.parseInt(edtY.getText().toString());
                String name= edtName.getText().toString().trim();
                Point point= new Point(x,y,name);
                points.add(point);

                listPoints.setAdapter(adapter);
                model.setLiveData(point);
               adapter.notifyDataSetChanged();

            }
        };
        btnAdd.setOnClickListener(handle);
    }

    private void inItView() {
        points= new ArrayList<>();
        listPoints=(ListView) findViewById(R.id.list_view);
        adapter= new PointAdapter(getApplicationContext(),points);
        edtX=(EditText) findViewById(R.id.edt_x);
        edtY=(EditText) findViewById(R.id.edt_y);
        edtName=(EditText) findViewById(R.id.edt_name);
        btnAdd=(Button) findViewById(R.id.btn_add);
    }
    public void delete(final int position){
        Toast.makeText(this,"ban da nhan vao day ",Toast.LENGTH_LONG).show();
    }
}