package net.gameslabs.model;

import net.gameslabs.api.Component;
import net.gameslabs.api.ComponentRegistry;
import net.gameslabs.api.Player;
import net.gameslabs.components.ChartComponent;
import net.gameslabs.events.BlockBreakEvent;
import net.gameslabs.events.GetPlayerLevel;
import net.gameslabs.events.GiveXpEvent;
import net.gameslabs.events.InventoryCheckEvent;
import net.gameslabs.implem.PlayerImplem;

import java.util.Arrays;

public class Assignment {

    protected final ComponentRegistry registry;
    private final Player mainPlayer;

    public Assignment(Component ... myComponentsToAdd) {
        registry = new ComponentRegistry();
        Arrays.asList(myComponentsToAdd).forEach(registry::registerComponent);
        registry.registerComponent(new ChartComponent());
        registry.load();
        mainPlayer = PlayerImplem.newPlayer("MyPlayer");
    }

    public final void run() {
        // Old code
        registry.sendEvent(new GiveXpEvent(mainPlayer, Skill.CONSTRUCTION, 25));
        registry.sendEvent(new GiveXpEvent(mainPlayer, Skill.EXPLORATION, 25));
        registry.sendEvent(new GiveXpEvent(mainPlayer, Skill.MINING, 25));
        GetPlayerLevel getPlayerLevel = new GetPlayerLevel(mainPlayer, Skill.CONSTRUCTION);
        log("Player level", mainPlayer, getPlayerLevel.getLevel());
        runChecks();

        // Check inventory
        mainPlayer.getInventory().giveItem(Item.coins, 1000);
        System.out.print("Inventory before event: ");
        for(int i = 0; i < 36; i++)
        {
            System.out.print("[" + i + "]" + ": " + mainPlayer.getInventory().getSlot()[i].getItem().getName() + "(" + mainPlayer.getInventory().getSlot()[i].getQuantity() + ") / ");
        }
        System.out.println();
        registry.sendEvent(new InventoryCheckEvent(mainPlayer, Item.coins, 100));

        System.out.print("Inventory after event: ");
        for(int i = 0; i < 36; i++)
        {
            System.out.print("[" + i + "]" + ": " + mainPlayer.getInventory().getSlot()[i].getItem().getName() + "(" + mainPlayer.getInventory().getSlot()[i].getQuantity() + ") / ");
        }
        System.out.println();

        // Simulating a block break event for mining
        System.out.println("Mining Level: " + getLevel(Skill.MINING));
        registry.sendEvent(new BlockBreakEvent(MiningBlock.coalOre, mainPlayer, getLevel(Skill.MINING)));

        registry.sendEvent(new GiveXpEvent(mainPlayer, Skill.MINING, 200));
        System.out.println("Mining Level: " + getLevel(Skill.MINING));
        registry.sendEvent(new BlockBreakEvent(MiningBlock.coalOre, mainPlayer, getLevel(Skill.MINING)));
        registry.sendEvent(new BlockBreakEvent(MiningBlock.coalOre, mainPlayer, getLevel(Skill.MINING)));
        registry.sendEvent(new BlockBreakEvent(MiningBlock.coalOre, mainPlayer, getLevel(Skill.MINING)));
        registry.sendEvent(new BlockBreakEvent(MiningBlock.coalOre, mainPlayer, getLevel(Skill.MINING)));
        registry.sendEvent(new BlockBreakEvent(MiningBlock.coalOre, mainPlayer, getLevel(Skill.MINING)));
        System.out.println("Mining Level: " + getLevel(Skill.MINING));

        System.out.print("Inventory final: ");
        for(int i = 0; i < 36; i++)
        {
            System.out.print("[" + i + "]" + ": " + mainPlayer.getInventory().getSlot()[i].getItem().getName() + "(" + mainPlayer.getInventory().getSlot()[i].getQuantity() + ") / ");
        }
        System.out.println();


        // Unload
        registry.unload();
    }

    private void runChecks() {
        if (getLevel(Skill.EXPLORATION) != 1) throw new AssignmentFailed("Exploration XP should be set to level 1");
        if (getLevel(Skill.CONSTRUCTION) != 2) throw new AssignmentFailed("Construction XP should be set to level 2");
    }

    private int getLevel(Skill skill) {
        GetPlayerLevel getPlayerLevel = new GetPlayerLevel(mainPlayer, skill);
        registry.sendEvent(getPlayerLevel);
        return getPlayerLevel.getLevel();
    }

    public void log(Object ... arguments) {
        System.out.println(Arrays.asList(arguments).toString());
    }

}
