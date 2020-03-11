package net.gameslabs.events;

import net.gameslabs.api.Player;
import net.gameslabs.api.PlayerEvent;
import net.gameslabs.model.MiningBlock;

public class BlockBreakEvent extends PlayerEvent {

    private MiningBlock block;
    private int miningLevel;

    public BlockBreakEvent(MiningBlock block, Player player, int miningLevel)
    {
        super(player);
        this.block = block;
        this.miningLevel = miningLevel;
    }

    public MiningBlock getBlock()
    {
        return block;
    }

    public int getMiningLevel()
    {
        return miningLevel;
    }
}
