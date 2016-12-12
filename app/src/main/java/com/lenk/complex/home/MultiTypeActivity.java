package com.lenk.complex.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jaeger.library.StatusBarUtil;
import com.lenk.complex.home.base.Constant;
import com.lenk.complex.home.component.SpaceGridItemDecoration;
import com.lenk.complex.home.entity.Category;
import com.lenk.complex.home.entity.FreeDine;
import com.lenk.complex.home.entity.HouseKeeperService;
import com.lenk.complex.home.entity.MItem;
import com.lenk.complex.home.entity.Notice;
import com.lenk.complex.home.provider.FreeDineViewProvider;
import com.lenk.complex.home.provider.HeadViewPagerViewProvider;
import com.lenk.complex.home.provider.HousekeeperServiceViewProvider;
import com.lenk.complex.home.provider.MItemViewProvider;
import com.lenk.complex.home.provider.NoticeViewProvider;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MultiTypeActivity extends AppCompatActivity {

    private MultiTypeAdapter adapter;
    Items items = new Items();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_type);
        View headLayout = findViewById(R.id.headLayout);
        StatusBarUtil.setTranslucentForImageView(this, 0, headLayout);

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
                    case Constant.TYPE_RE_HEAD_VIEW_PAGER:
                    case Constant.TYPE_RE_NOTICE:
                    case Constant.TYPE_RE_HOUSEKEEPER_service:
                    case Constant.TYPE_RE_FREE_DINE:
                    case Constant.TYPE_RE_BOUTIQUE_SERVICE:
                    case Constant.TYPE_RE_ACTIVITY:
                    case Constant.TYPE_RE_QUALITY_GOODS:
                    case Constant.TYPE_RE_PRIVATE_HOUSEKEEPER:
                    case Constant.TYPE_RE_LATEST_PRODUCT:
                        return 2;
                    default:
                        return 1;
                }
            }
        });
        recyclerView.addItemDecoration(new SpaceGridItemDecoration(8, 8));
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MultiTypeAdapter(items);

        adapter.register(MItem.class, new MItemViewProvider());
        adapter.register(Category.class, new HeadViewPagerViewProvider(this));
        adapter.register(Notice.class, new NoticeViewProvider());
        adapter.register(HouseKeeperService.class, new HousekeeperServiceViewProvider());
        adapter.register(FreeDine.class, new FreeDineViewProvider());

        Category category = new Category("tt");
        items.add(category);
        Notice notice = new Notice();
        items.add(notice);
        HouseKeeperService houseKeeperService = new HouseKeeperService();
        items.add(houseKeeperService);
        FreeDine freeDine = new FreeDine();
        items.add(freeDine);

        recyclerView.setAdapter(adapter);

        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    MItem item = new MItem("test" + i);
                    items.add(item);
                }
                adapter.notifyDataSetChanged();
            }
        }, 4000);

        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                Category category = (Category) items.get(0);
                List<String> picUrls = new ArrayList<String>();
                picUrls.add("test");
                category.setPagerPicUrl(picUrls);
                adapter.notifyItemChanged(0);
            }
        }, 7000);
    }
}
