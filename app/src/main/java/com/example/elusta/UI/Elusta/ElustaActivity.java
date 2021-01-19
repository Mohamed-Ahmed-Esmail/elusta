package com.example.elusta.UI.Elusta;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elusta.Adapter.GridSpacingItemDecoration;
import com.example.elusta.Adapter.RecyclerViewAdapter;
import com.example.elusta.Model.ServicesPojoModel;
import com.example.elusta.R;
import com.example.elusta.UI.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class ElustaActivity extends BaseActivity implements ElustaMvpView {
    RecyclerView recyclerView;
    ElustaPresenter elustaPresenter;
    private List<ServicesPojoModel.AllserviceEntity> list = new ArrayList<>();
    RecyclerViewAdapter recyclerViewAdapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elusta);

        recyclerView = findViewById(R.id.recyclerView);

        elustaPresenter = new ElustaPresenter();
        elustaPresenter.onAttach(this);

        elustaPresenter.Services("en");

    }

    public void initList() {


        recyclerViewAdapter = new RecyclerViewAdapter(ElustaActivity.this, list);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(ElustaActivity.this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, (Integer) dpToPx(25), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);

        list.add(new ServicesPojoModel.AllserviceEntity(70, R.drawable.profile + "", "desc", "name"));
        recyclerViewAdapter.notifyDataSetChanged();
    }


    @Override
    public void showData(ServicesPojoModel.DataEntity servicesPojoModel) {
        list = new ArrayList<ServicesPojoModel.AllserviceEntity>();

        list.addAll(servicesPojoModel.getAllservice());

        initList();
    }


    private Object dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


}

