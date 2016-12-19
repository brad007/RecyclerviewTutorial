package com.software.fire.recyclerviewtutorial.items;

import android.support.annotation.ColorInt;

import com.genius.groupie.Item;
import com.software.fire.recyclerviewtutorial.R;
import com.software.fire.recyclerviewtutorial.databinding.ItemCardBinding;

import java.util.HashMap;
import java.util.Map;

import static com.software.fire.recyclerviewtutorial.MainActivity.INSET;
import static com.software.fire.recyclerviewtutorial.MainActivity.INSET_TYPE_KEY;

/**
 * Created by Brad on 12/19/2016.
 */

//Doing this cleans the code, as each item type is handles seperately from the others
    //This leaves us with much cleaner code and reduces boilerplate code
public class CardItem extends Item<ItemCardBinding> {

    @ColorInt private int colorRes;
    private CharSequence text;

    public CardItem(@ColorInt int colorRes){
        this(colorRes, "");
    }

    public CardItem(@ColorInt int colorRes, CharSequence text){
        this.colorRes = colorRes;
        this.text = text;
    }

    @Override
    public int getLayout() {
        return R.layout.item_card;
    }

    @Override
    public void bind(ItemCardBinding viewBinding, int position) {
        viewBinding.text.setText(text);
    }

    public CharSequence getText() {
        return text;
    }

    public void setText(CharSequence text) {
        this.text = text;
    }

    @Override
    public Map<String, Object> getExtras() {
        Map<String, Object> map = new HashMap<>();
        map.put(INSET_TYPE_KEY, INSET);
        return map;
    }
}
