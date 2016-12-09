package com.lenk.complex.home.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lenk.complex.home.R;
import com.lenk.complex.home.entity.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liling on 2016/12/9.
 */

public class ComplexTypesRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    List<Item> dataList = new ArrayList<>();
    ArrayList<View> viewContainter = new ArrayList<View>();

    public static final int TYPE_HEAD_VIEW_PAGER = 0;
    public static final int TYPE_NOTICE = 1;//公告
    public static final int TYPE_HOUSEKEEPER_service = 2;//管家服务
    public static final int TYPE_FREE_DINE = 3;//霸王餐
    public static final int TYPE_BOUTIQUE_SERVICE = 4;//精品服务
    public static final int TYPE_ACTIVITY = 5;//活动 美食推荐
    public static final int TYPE_QUALITY_GOODS = 6;//优质货源
    public static final int TYPE_PRIVATE_HOUSEKEEPER = 7;//私人管家
    public static final int TYPE_LATEST_PRODUCT = 8;//最新好货
    public static final int TYPE_DEFAULT = 9;

    public ComplexTypesRecycleAdapter(Context context) {
        this.context = context;
    }

    public void updateData(List<Item> dataList) {
        this.dataList.clear();
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEAD_VIEW_PAGER:
                HeadViewPagerViewHolder viewPagerHolder = new HeadViewPagerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_complex_type_viewpager, parent, false));
                return viewPagerHolder;
            case TYPE_NOTICE:
                MyViewHolder noticeHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_complex_type_notice, parent, false));
                return noticeHolder;
            case TYPE_HOUSEKEEPER_service:
                MyViewHolder houseKeeperServiceHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_complex_type_temp, parent, false));
                return houseKeeperServiceHolder;
            case TYPE_FREE_DINE:
                MyViewHolder freeDineHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_complex_type_temp, parent, false));
                return freeDineHolder;
            case TYPE_BOUTIQUE_SERVICE:
                MyViewHolder boutiqueHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_complex_type_temp, parent, false));
                return boutiqueHolder;
            case TYPE_ACTIVITY:
                MyViewHolder activityHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_complex_type_temp, parent, false));
                return activityHolder;
            case TYPE_QUALITY_GOODS:
                MyViewHolder qualityHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_complex_type_temp, parent, false));
                return qualityHolder;
            case TYPE_PRIVATE_HOUSEKEEPER:
                MyViewHolder privateHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_complex_type_temp, parent, false));
                return privateHolder;
            case TYPE_LATEST_PRODUCT:
                MyViewHolder latestProductHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_complex_type_temp, parent, false));
                return latestProductHolder;
            case TYPE_DEFAULT:
                CommodityViewHolder holder = new CommodityViewHolder(LayoutInflater.from(context).inflate(R.layout.item_complex, parent, false));
                return holder;
            default:
                return null;
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEAD_VIEW_PAGER;
        } else if (position == 1) {
            return TYPE_NOTICE;
        } else if (position == 2) {
            return TYPE_HOUSEKEEPER_service;
        } else if (position == 3) {
            return TYPE_FREE_DINE;
        } else if (position == 4) {
            return TYPE_BOUTIQUE_SERVICE;
        } else if (position == 5) {
            return TYPE_ACTIVITY;
        } else if (position == 6) {
            return TYPE_QUALITY_GOODS;
        } else if (position == 7) {
            return TYPE_PRIVATE_HOUSEKEEPER;
        } else if (position == 8) {
            return TYPE_LATEST_PRODUCT;
        } else {
            return TYPE_DEFAULT;
        }
    }

    @Override
    public int getItemCount() {
        return 40;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    class HeadViewPagerViewHolder extends RecyclerView.ViewHolder {

        ViewPager headViewPager;

        public HeadViewPagerViewHolder(View itemView) {
            super(itemView);

            headViewPager = (ViewPager) itemView.findViewById(R.id.headViewPager);
            View view1 = LayoutInflater.from(context).inflate(R.layout.layout_head_viewpager, null);
            View view2 = LayoutInflater.from(context).inflate(R.layout.layout_head_viewpager, null);
            View view3 = LayoutInflater.from(context).inflate(R.layout.layout_head_viewpager, null);
            viewContainter.add(view1);
            viewContainter.add(view2);
            viewContainter.add(view3);
            HeadViewPagerAdapter headViewPagerAdapter = new HeadViewPagerAdapter(context, viewContainter);
            headViewPager.setAdapter(headViewPagerAdapter);
        }
    }

    class CommodityViewHolder extends RecyclerView.ViewHolder {
        ImageView commodityIv;

        public CommodityViewHolder(View itemView) {
            super(itemView);
            commodityIv = (ImageView) itemView.findViewById(R.id.commodityIv);
            Glide.with(context).load("https://gw.alicdn.com/bao/uploaded/TB17rUJOXXXXXaAaXXXSutbFXXX.jpg_190x190q90.jpg").into(commodityIv);
        }

    }
}
