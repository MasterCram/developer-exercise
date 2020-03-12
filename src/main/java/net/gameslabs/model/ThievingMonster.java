package net.gameslabs.model;

public class ThievingMonster {
    private String name;
    private int exp;
    private int levelRequired;

    public static final ThievingMonster MAN = new ThievingMonster(ThievingMonsterType.MAN.toString(), 100, 1);
    public static final ThievingMonster GOBLIN = new ThievingMonster(ThievingMonsterType.GOBLIN.toString(), 200, 10);

    public ThievingMonster(String name, int exp, int levelRequired)
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
