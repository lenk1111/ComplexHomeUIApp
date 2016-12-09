package com.lenk.complex.home.component;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by liling on 2016/12/9.
 */

public class SpaceGridItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    private int lastExcludePosition;

    /**
     * @param space               item间隔
     * @param lastExcludePosition 从0项至lastExcludePosition项被排除,不显示分隔条
     */
    public SpaceGridItemDecoration(int space, int lastExcludePosition) {
        this.space = space;
        this.lastExcludePosition = lastExcludePosition;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getChildLayoutPosition(view) > lastExcludePosition) {
            outRect.left = space;
            outRect.bottom = space;

            if (parent.getChildLayoutPosition(view) % 2 != 0) {
                outRect.left = 0;
            }
        }
    }
}
