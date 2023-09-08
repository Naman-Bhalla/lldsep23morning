package com.scaler.producerconsumer;

public class Store {
    private int itemsCount = 0;
    private int maxItemsCount;

    public Store(int maxItemsCount) {
        this.maxItemsCount = maxItemsCount;
    }

    public int getMaxItemsCount() {
        return maxItemsCount;
    }

    public void setMaxItemsCount(int maxItemsCount) {
        this.maxItemsCount = maxItemsCount;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) throws Exception {
        this.itemsCount = itemsCount;
        System.out.println(itemsCount);
        if (itemsCount > maxItemsCount || itemsCount < 0) {
            throw new Exception("Items count gone crazy " + itemsCount);
        }
    }
}
