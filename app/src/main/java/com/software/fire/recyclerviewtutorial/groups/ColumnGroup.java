package com.software.fire.recyclerviewtutorial.groups;

import com.genius.groupie.Group;
import com.genius.groupie.GroupDataObserver;
import com.genius.groupie.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brad on 12/19/2016.
 */

public class ColumnGroup implements Group{

    private List<Item>items = new ArrayList<>();

    public ColumnGroup(List<? extends Item> items) {
        for (int i = 0; i < items.size(); i++) {
            //Rearrange items so that the adapter appears to arrange them in vertical columns
            int index;
            if(i%2 == 0){
                index = i/2;
            }else{
                index = (i-1)/2 + (int)(items.size()/2f);
                //If columns are uneven, we'll put an extra one at the end of the first column,
                //meaning the second column's indices will all be increased by 1
                if(items.size() % 2 == 1) index++;
            }
            Item trackItem = items.get(index);
            this.items.add(trackItem);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getPosition(Item item) {
        return items.indexOf(item);
    }

    @Override
    public void setGroupDataObserver(GroupDataObserver groupDataObserver) {
        //do nothing
    }
}
