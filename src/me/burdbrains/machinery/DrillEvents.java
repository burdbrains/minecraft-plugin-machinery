package me.burdbrains.machinery;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.material.Directional;

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

            Directional dBlock = (Directional) pBlock.getState().getData();
            blockPlace.getPlayer().sendMessage(ChatColor.GOLD + "Block Facing: " + dBlock.getFacing());
            dBlock.setFacingDirection(BlockFace.DOWN);
            blockPlace.getBlockPlaced().getState().update(true);
            blockPlace.getPlayer().sendMessage(ChatColor.GOLD + "Block Facing: " + dBlock.getFacing());


            //////////////////////////////////////
            // !!! NEITHER UPDATES THE BLOCK !!! //
            //////////////////////////////////////


            /// Second sendMessage sends whatever
            /// first message sent in this version

            /*blockPlace.getPlayer().sendMessage(ChatColor.GOLD + "Block Facing: " + ((Directional)pBlock.getState().getData()).getFacing());
            ((Directional)pBlock.getState().getData()).setFacingDirection(BlockFace.DOWN);
            pBlock.getState().update(true);
            blockPlace.getPlayer().sendMessage(ChatColor.GOLD + "Block Facing: " + ((Directional)pBlock.getState().getData()).getFacing());*/
        }
    }
}