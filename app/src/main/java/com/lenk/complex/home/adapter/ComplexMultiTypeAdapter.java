package com.lenk.complex.home.adapter;

import android.support.annotation.NonNull;

import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;
import me.drakeet.multitype.TypePool;

/**
 * Created by liling on 2016/12/12.
 */

public class ComplexMultiTypeAdapter extends MultiTypeAdapter {


    public ComplexMultiTypeAdapter(@NonNull List<?> items) {
        super(items);
    }

    public ComplexMultiTypeAdapter(@NonNull List<?> items, TypePool pool) {
        super(items, pool);
    }


}
