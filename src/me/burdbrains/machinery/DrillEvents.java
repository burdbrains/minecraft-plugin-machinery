package me.burdbrains.machinery;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Dispenser;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.BlockState;
import org.bukkit.material.Directional;
import org.bukkit.material.MaterialData;

public final class DrillEvents implements Listener
{
    @EventHandler
    public void onDrillPlace(BlockPlaceEvent blockPlace)
    {
        Block pBlock = blockPlace.getBlockPlaced();
        if (pBlock.getType() == Material.DISPENSER /*&& pBlock.getMetadata()*/)
        {
            /// Second sendMessage sends "DOWN"
            /// with this version of code

            BlockState pState = pBlock.getState();
            org.bukkit.material.Dispenser dBlock = (org.bukkit.material.Dispenser) pState.getData();
            //Directional dBlock = (Directional) pState.getData();
            blockPlace.getPlayer().sendMessage(ChatColor.GOLD + "Block Facing: " + dBlock.getFacing());
            dBlock.setFacingDirection(BlockFace.DOWN);
            pState.setData(dBlock);
            pState.update();
            blockPlace.getPlayer().sendMessage(ChatColor.GOLD + "Block Facing: " + dBlock.getFacing());
        }
    }
}