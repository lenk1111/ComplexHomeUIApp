package com.lenk.complex.home.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lenk.complex.home.R;
import com.lenk.complex.home.adapter.HeadViewPagerAdapter;
import com.lenk.complex.home.entity.Category;

import java.util.ArrayList;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by liling on 2016/12/12.
 */

public class HeadViewPagerViewProvider extends ItemViewProvider<Category, HeadViewPagerViewProvider.ViewHolder> {

    Context context;
    ArrayList<View> viewContainter = new ArrayList<View>();
    HeadViewPagerAdapter headViewPagerAdapter = new HeadViewPagerAdapter(context, viewContainter);

    public HeadViewPagerViewProvider(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_complex_type_viewpager, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(
            @NonNull ViewHolder holder, @NonNull Category category) {
        if (category.getPagerPicUrl().size() > 0) {
            viewContainter.clear();
            for (int i = 0; i < category.getPagerPicUrl().size(); i++) {
                View view = LayoutInflater.from(context).inflate(R.layout.layout_head_viewpager, null);
                viewContainter.add(view);
                headViewPagerAdapter.notifyDataSetChanged();
            }
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ViewPager headViewPager;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            headViewPager = (ViewPager) itemView.findViewById(R.id.headViewPager);
            View view1 = LayoutInflater.from(context).inflate(R.layout.layout_head_viewpager, null);
            View view2 = LayoutInflater.from(context).inflate(R.layout.layout_head_viewpager, null);
            View view3 = LayoutInflater.from(context).inflate(R.layout.layout_head_viewpager, null);
            viewContainter.add(view1);
            viewContainter.add(view2);
            viewContainter.add(view3);
            headViewPagerAdapter.notifyDataSetChanged();
            headViewPager.setAdapter(headViewPagerAdapter);
        }
    }
}
