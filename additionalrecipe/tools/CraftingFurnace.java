package chibivaru.additionalrecipe.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CraftingFurnace extends Item implements ICraftingHandler
{
    private boolean repair;
    public CraftingFurnace(int par1)
    {
        super(par1);
        this.setMaxStackSize(1);
    }

    public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
    {
        return false;
    }

    public boolean hasContainerItem()
    {
        return !repair;
    }

    public ItemStack getContainerItemStack(ItemStack itemStack)
    {
        if (itemStack != null && itemStack.itemID == this.itemID)
        {
            itemStack.setItemDamage(itemStack.getItemDamage());
        }
        return itemStack;
    }

    @Override
    public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
    {
        repair = this.itemID == item.itemID;
    }

    @Override
    public void onSmelting(EntityPlayer player, ItemStack item){};

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = Item.coal.getIconFromDamage(0);
    }
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
}