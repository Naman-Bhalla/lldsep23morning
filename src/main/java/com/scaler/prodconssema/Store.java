package com.scaler.prodconssema;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Store {
    private List<Object> storeItems = new ArrayList<>();
    private int maxItemsCount;

    public Store(int maxItemsCount) {
        this.maxItemsCount = maxItemsCount;
    }

    public List<Object> getStoreItems() {
        return storeItems;
    }

    public void setStoreItems(List<Object> storeItems) {
        this.storeItems = storeItems;
    }

    public void setItemsCount(int itemsCount) throws Exception {

        if (itemsCount > maxItemsCount || itemsCount < 0) {
            throw new Exception("Items count gone crazy " + itemsCount);
        }
    }
}
