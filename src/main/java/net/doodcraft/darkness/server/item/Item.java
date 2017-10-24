package net.doodcraft.darkness.server.item;

import java.util.concurrent.ConcurrentHashMap;

public class Item {

    private static ConcurrentHashMap<ItemType, Double> values = new ConcurrentHashMap<>();

    private ItemType type;
    private int quantity;
    private double value;

    public Item(ItemType type, int quantity) {
        this.type = type;
        this.quantity = quantity;
        this.value = getValue(type);
    }

    public ItemType getType() {
        return this.type;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static double getValue(ItemType type) {
        return values.get(type);
    }

    public static void setValue(ItemType type, double value) {
        values.put(type, value);
    }
}