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
import org.bukkit.block.Container;
import org.bukkit.inventory.ItemStack;

public final class DrillEvents implements Listener
{
    @EventHandler
    public void onDrillPlace(BlockPlaceEvent blockPlace)
    {
        Block pBlock = blockPlace.getBlockPlaced();
        if (pBlock.getType() == Material.DISPENSER /*&& pBlock.getMetadata()*/)
        {
            // Gets the BlockState and sets the
            // BlockState data to a Dispenser object

            BlockState pState = pBlock.getState();
            org.bukkit.material.Dispenser dBlock = (org.bukkit.material.Dispenser) pState.getData();


            // Sends message to the player
            // checking getFacing() BlockFace
            // BEFORE setting and updating
            // BlockFace facing

            //blockPlace.getPlayer().sendMessage(ChatColor.GOLD + "Block Facing: " + dBlock.getFacing());


            // Updates the block state with dBlock
            // BlockData of new FacingDirection
            dBlock.setFacingDirection(BlockFace.DOWN);
            pState.setData(dBlock);
            pState.update();



            /////////////////////////////////////////////
            //                  TEST                   //
            // Checking the dispenser for its contents //
            /////////////////////////////////////////////

            Container conTest = (Container) pState;

            ItemStack[] conInvConts = conTest.getInventory().getContents();
            blockPlace.getPlayer().sendMessage(ChatColor.BLUE + "Contents " + ChatColor.AQUA + conInvConts);

            ItemStack testItem1 = new ItemStack(Material.DIRT, 1);
            ItemStack testItem2 = new ItemStack(Material.STONE, 2);
            ItemStack testItem3 = new ItemStack(Material.IRON_BLOCK, 3);
            ItemStack[] testItems = {testItem1, testItem2, testItem3};

            conTest.getInventory().setContents(testItems);
            ItemStack[] conInvConts2 = conTest.getInventory().getContents();
            blockPlace.getPlayer().sendMessage(ChatColor.BLUE + "Contents " + ChatColor.AQUA + conInvConts2);

            /////////////////////////////////////////////



            // Sends message to the player
            // checking getFacing() BlockFace
            // AFTER setting and updating
            // BlockFace facing

            //blockPlace.getPlayer().sendMessage(ChatColor.GOLD + "Block Facing: " + dBlock.getFacing());
        }
    }
}