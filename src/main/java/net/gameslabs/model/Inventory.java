package net.gameslabs.model;

public class Inventory {
    private Slot[] slot = new Slot[36];

    public Inventory()
    {
        for(int i = 0; i < 36; i++)
        {
            slot[i] = new Slot(Item.empty, 0);
        }
    }

    public Slot[] getSlot() {
        return slot;
    }

    public void giveItem(Item item, int quantity)
    {
        for(int i = 0; i < 36; i++)
        {
            if(slot[i].getItem() == Item.empty)
            {
                slot[i].setItem(item, quantity);
                return;
            }
        }
        System.out.println("Inventory is full");
    }
}
