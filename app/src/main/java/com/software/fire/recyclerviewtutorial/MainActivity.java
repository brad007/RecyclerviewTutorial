package com.software.fire.recyclerviewtutorial;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.genius.groupie.GroupAdapter;
import com.genius.groupie.Item;
import com.genius.groupie.OnItemClickListener;
import com.software.fire.recyclerviewtutorial.databinding.ActivityMainBinding;
import com.software.fire.recyclerviewtutorial.groups.ColumnGroup;
import com.software.fire.recyclerviewtutorial.items.CardItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    public static final String INSET_TYPE_KEY = "inset_type";
    public static final String INSET = "inset";

    private ActivityMainBinding mBinding;
    private GridLayoutManager mLayoutManager;
    private GroupAdapter mGroupAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mGroupAdapter = new GroupAdapter();
        mGroupAdapter.setOnItemClickListener(this);
        mGroupAdapter.setSpanCount(12);
        populateAdapter();

        mLayoutManager = new GridLayoutManager(this, mGroupAdapter.getSpanCount());
        mLayoutManager.setSpanSizeLookup(mGroupAdapter.getSpanSizeLookup());

        final RecyclerView recyclerView = mBinding.recyclerview;
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mGroupAdapter);
    }

    private void populateAdapter() {
        List<CardItem> cardItems = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            CardItem cardItem = new CardItem(Color.RED, String.valueOf(i));
            cardItems.add(cardItem);
        }

        ColumnGroup columnGroup = new ColumnGroup(cardItems);
        mGroupAdapter.add(columnGroup);
    }

    @Override
    public void onItemClick(Item item, View view) {
        if (item instanceof CardItem) {
            CardItem cardItem = (CardItem) item;
            if (!TextUtils.isEmpty(cardItem.getText())) {
                Toast.makeText(MainActivity.this, cardItem.getText(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
