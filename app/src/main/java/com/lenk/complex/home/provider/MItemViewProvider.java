package com.lenk.complex.home.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lenk.complex.home.R;
import com.lenk.complex.home.entity.MItem;

import me.drakeet.multitype.ItemViewProvider;


/**
 * Created by liling on 2016/12/12.
 */

public class MItemViewProvider extends ItemViewProvider<MItem, MItemViewProvider.MyViewHolder> {
    @NonNull
    @Override
    protected MyViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_multi_type, parent, false);
        return new MyViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, @NonNull MItem mItem) {

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
