package com.lenk.complex.home.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by liling on 2016/12/9.
 */

public class HeadViewPagerAdapter extends PagerAdapter {

    Context context;
    ArrayList<View> viewContainter = new ArrayList<View>();

    public HeadViewPagerAdapter(Context context, ArrayList<View> viewContainter) {
        this.context = context;
        this.viewContainter = viewContainter;
    }

    @Override
    public int getCount() {
        return viewContainter.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(viewContainter.get(position));
        return viewContainter.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
        ((ViewPager) container).removeView(viewContainter.get(position));
    }
}
