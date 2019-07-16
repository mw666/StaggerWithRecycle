package com.example.shengdian.staggerwithrecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.example.shengdian.staggerwithrecycle.adapter.StaggerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.rc)
    RecyclerView rc;
    private List<Integer> lists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        int height = dm.heightPixels;       // 屏幕高度（像素）
        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = dm.densityDpi;     // 屏幕密度dpi（120 / 160 / 240）

        StaggerAdapter testAdapter = new StaggerAdapter(this, width, lists);
        rc.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rc.setAdapter(testAdapter);
    }

    private void initData() {
        lists = new ArrayList<>();
        lists.add(R.drawable.t2);
        lists.add(R.drawable.t3);
        lists.add(R.drawable.t4);
        lists.add(R.drawable.t5);
        lists.add(R.drawable.t7);
        lists.add(R.drawable.t9);
        lists.add(R.drawable.t10);
        lists.add(R.drawable.t2);
        lists.add(R.drawable.t3);
        lists.add(R.drawable.t4);
        lists.add(R.drawable.t5);
        lists.add(R.drawable.t7);
        lists.add(R.drawable.t9);
        lists.add(R.drawable.t10);
        lists.add(R.drawable.t2);
        lists.add(R.drawable.t3);
        lists.add(R.drawable.t4);
        lists.add(R.drawable.t5);
        lists.add(R.drawable.t7);
        lists.add(R.drawable.t9);
        lists.add(R.drawable.t10);
        lists.add(R.drawable.t2);
        lists.add(R.drawable.t10);
        lists.add(R.drawable.t5);
        lists.add(R.drawable.t7);
        lists.add(R.drawable.t9);
        lists.add(R.drawable.t10);
        lists.add(R.drawable.t2);
        lists.add(R.drawable.t3);
        lists.add(R.drawable.t4);
        lists.add(R.drawable.t5);
        lists.add(R.drawable.t7);
        lists.add(R.drawable.t9);
        lists.add(R.drawable.t10);
        lists.add(R.drawable.t2);
        lists.add(R.drawable.t3);
        lists.add(R.drawable.t4);
        lists.add(R.drawable.t5);
        lists.add(R.drawable.t7);
        lists.add(R.drawable.t9);
        lists.add(R.drawable.t10);
        lists.add(R.drawable.t9);
        lists.add(R.drawable.t9);
        lists.add(R.drawable.t7);
    }
}
