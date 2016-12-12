package com.lenk.complex.home.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lenk.complex.home.R;
import com.lenk.complex.home.entity.FreeDine;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by liling on 2016/12/12.
 */

public class FreeDineViewProvider extends ItemViewProvider<FreeDine, FreeDineViewProvider.MyViewHolder> {

    @NonNull
    @Override
    protected MyViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_complex_type_temp, parent, false);
        return new FreeDineViewProvider.MyViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, @NonNull FreeDine freeDine) {

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
