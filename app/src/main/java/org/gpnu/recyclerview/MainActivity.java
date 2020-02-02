package org.gpnu.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.gpnu.recyclerview.adapter.ImageAdapter;
import org.gpnu.recyclerview.model.Bean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Bean> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);

        mList = new ArrayList<>();
        ImageAdapter adapter = new ImageAdapter(this,mList);

        //设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));//用类设置分割线

        //设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //设置adapter
        mRecyclerView.setAdapter(adapter);
    }
}
