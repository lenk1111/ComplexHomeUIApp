package com.lenk.complex.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.lenk.complex.home.entity.easyrv.CommunityShopInfo;
import com.lenk.complex.home.entity.easyrv.HomeTradeInfo;
import com.lenk.complex.home.entity.easyrv.SingleSearchResult;

import java.util.ArrayList;
import java.util.List;

public class MultiTypeOfEasyRVActivity extends AppCompatActivity {

    public final int TYPE_RV_SHOP_ABOUT = 0;
    public final int TYPE_RV_SHOP = 1;
    public final int TYPE_RV_PRODUCT_ABOUT = 2;
    public final int TYPE_RV_PRODUCT = 3;
    int indexOfProductAboutView;

    EasyRecyclerView easyRecyclerView;
    SearchResultsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        easyRecyclerView = (EasyRecyclerView) findViewById(R.id.resultsRecyclerView);

        easyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SearchResultsAdapter(this);
        easyRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MultiTypeOfEasyRVActivity.this, "点击", Toast.LENGTH_SHORT).show();
            }
        });
        mAdapter.setMore(R.layout.layout_more, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                List<SingleSearchResult> dataList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    SingleSearchResult result = new SingleSearchResult();
                    result.setHomeTradeInfo(new HomeTradeInfo());
                    dataList.add(result);
                }
                mAdapter.addAll(dataList);
            }
        });
        mAdapter.setNoMore(R.layout.layout_no_more);
        easyRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                easyRecyclerView.setRefreshing(false);
            }
        });
        initData();
       /* boolean isHomeTradeInfo;
        for (int i = 0; i < dataList.size(); i++) {
            if (null == dataList.get(i).getHomeTradeInfo()) {
                isHomeTradeInfo = false;
            }
            if(i>0){
                indexOfProductAboutView = i;
            }
        }*/

    }

    public void initData() {


        List<SingleSearchResult> dataList = new ArrayList<>();

        SingleSearchResult headResult = new SingleSearchResult();
        SingleSearchResult aboutResult = new SingleSearchResult();

        SingleSearchResult firstResult = new SingleSearchResult();
        SingleSearchResult twoResult = new SingleSearchResult();
        SingleSearchResult threeResult = new SingleSearchResult();

        firstResult.setCommunityShopInfo(new CommunityShopInfo());
        twoResult.setHomeTradeInfo(new HomeTradeInfo());
        threeResult.setHomeTradeInfo(new HomeTradeInfo());

        dataList.add(firstResult);
        dataList.add(twoResult);
        dataList.add(threeResult);

        dataList.add(0, headResult);
        dataList.add(2, aboutResult);
        indexOfProductAboutView = 2;

        for (int i = 0; i < 30; i++) {
            SingleSearchResult result = new SingleSearchResult();
            result.setHomeTradeInfo(new HomeTradeInfo());
            dataList.add(result);
        }

        mAdapter.addAll(dataList);
    }

    class SearchResultsAdapter extends RecyclerArrayAdapter<SingleSearchResult> {

        public SearchResultsAdapter(Context context) {
            super(context);
        }

        @Override
        public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
            switch (viewType) {
                case TYPE_RV_PRODUCT:
                    return new ResultsProductViewHolder(parent);
                case TYPE_RV_PRODUCT_ABOUT:
                    return new ResultsAboutViewHolder(parent, viewType);
                case TYPE_RV_SHOP:
                    return new ResultsShopViewHolder(parent);
                case TYPE_RV_SHOP_ABOUT:
                    return new ResultsAboutViewHolder(parent, viewType);
                default:
                    return null;
            }
        }

        @Override
        public int getViewType(int position) {
            if (position == 0) {
                return TYPE_RV_SHOP_ABOUT;
            } else if (position == indexOfProductAboutView) {
                return TYPE_RV_PRODUCT_ABOUT;
            } else if (null != getItem(position).getCommunityShopInfo()) {
                return TYPE_RV_SHOP;
            } else if (null != getItem(position).getHomeTradeInfo()) {
                return TYPE_RV_PRODUCT;
            }
            return super.getViewType(position);
        }


        class ResultsAboutViewHolder extends BaseViewHolder<SingleSearchResult> {
            TextView aboutTv;
            int type;

            public ResultsAboutViewHolder(ViewGroup parent, int type) {
                super(parent, R.layout.item_search_results_about);
                aboutTv = $(R.id.textView);
                this.type = type;
            }

            @Override
            public void setData(SingleSearchResult data) {
                super.setData(data);
                if (type == TYPE_RV_PRODUCT_ABOUT) {
                    aboutTv.setText("关于-产品");
                } else {
                    aboutTv.setText("关于-店铺");
                }
            }
        }

        class ResultsShopViewHolder extends BaseViewHolder<SingleSearchResult> {

            public ResultsShopViewHolder(ViewGroup parent) {
                super(parent, R.layout.item_search_results_shop);
            }
        }

        class ResultsProductViewHolder extends BaseViewHolder<SingleSearchResult> {

            public ResultsProductViewHolder(ViewGroup parent) {
                super(parent, R.layout.item_search_results_product);
            }
        }
    }
}
