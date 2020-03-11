package net.gameslabs.model;

public class Slot {
    private int ID;
    private Item item;
    private int quantity;

    public Slot(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void removeItem(int quantity)
    {
        if(this.quantity > quantity)
        {
            this.quantity -= quantity;
        }
        else if(this.quantity == quantity)
        {
            this.quantity = 0;
            this.item = Item.empty;
        }
        else
        {
            System.out.println("Not enough item in the inventory!");
        }
    }
}
