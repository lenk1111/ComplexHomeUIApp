package com.lenk.complex.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lenk.complex.home.adapter.ComplexTypesRecycleAdapter;
import com.lenk.complex.home.component.SpaceGridItemDecoration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycler();
    }

    public void initRecycler() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        return 2;
                    default:
                        return 1;
                }
            }
        });
        recyclerView.addItemDecoration(new SpaceGridItemDecoration(8, 8));
        recyclerView.setLayoutManager(layoutManager);
        ComplexTypesRecycleAdapter adapter = new ComplexTypesRecycleAdapter(this);
        recyclerView.setAdapter(adapter);
    }
}
