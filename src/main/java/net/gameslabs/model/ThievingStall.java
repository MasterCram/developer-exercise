package net.gameslabs.model;

public class ThievingStall {
    private String name;
    private int exp;
    private int levelRequired;

    public static final ThievingStall FOOD_STALL = new ThievingStall(ThievingStallType.FOOD_STALL.toString(), 100, 1);
    public static final ThievingStall MAGIC_STALL = new ThievingStall(ThievingStallType.MAGIC_STALL.toString(), 200, 10);

    public ThievingStall(String name, int exp, int levelRequired)
    {
        this.name = name;
        this.exp = exp;
        this.levelRequired = levelRequired;
    }

    public String getName() {
        return name;
    }

    public int getExp() {
        return exp;
    }

    public int getLevelRequired() {
        return levelRequired;
    }
}
