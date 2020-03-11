package net.gameslabs.model;

public class MiningBlock {
    private String name;
    private int exp;
    private int level;

    public static MiningBlock coalOre = new MiningBlock("Coal ore", 25, 5);
    public static MiningBlock silverOre = new MiningBlock("Silver ore", 50, 10);
    public static MiningBlock goldOre = new MiningBlock("Gold ore", 100, 15);

    public MiningBlock(String name, int exp, int level) {
        this.name = name;
        this.exp = exp;
        this.level = level;
    }

    public int getLevel()
    {
        return level;
    }

    public int getExp()
    {
        return exp;
    }
}
