package me.burdbrains.machinery;

import org.bukkit.block.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dispenser;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.bukkit.inventory.Inventory;

import java.util.Collection;
import java.util.List;

public class Drill
{
    private Block drill;


    // Function that runs the
    // drill, to do the digging.

    public void initiateDrill()
    {
        // TODO
        // Break the block below the "drill"
        // wait 3 seconds before breaking the next item
        // use for loop and checkStack to get the ItemStack
        // and add to inventory it if the current item isn't in the
        // inventory or

        Container cDrill = (Container) drill.getState();
        Block dDownRel = drill.getRelative(BlockFace.DOWN);
        while (dDownRel.getType() != Material.BEDROCK)
        {
            // use Block.getDrops() to add items like
            // redstone dust and diamonds to the dispenser
            // inventory

            ItemStack[] dContents = cDrill.getInventory().getContents();

            for(ItemStack curStack: dContents)
            {
                if (curStack.getAmount() != curStack.getMaxStackSize())
                {
                    //
                }
            }

            dDownRel.setType(Material.AIR);
            dDownRel.getState().update();
        }
    }


    // Function to check the amount of an
    // ItemStack and add aAmount to the ItemStack
    // (for use on drill when adding items to container)

    public ItemStack checkStack(ItemStack iStack, int aAmount)
    {
        int curAmount = iStack.getAmount();
        iStack.setAmount(curAmount + aAmount);
        return iStack;
    }


    // Function to check the drops of an itemstack
    // for use in checkStack so ores like lapis, redstone
    // diamond, etc. give their correct drops

    public ItemStack checkDrops(ItemStack iStack)
    {
        return iStack;
    }
}
