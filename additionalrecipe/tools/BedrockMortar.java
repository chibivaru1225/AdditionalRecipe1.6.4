package chibivaru.additionalrecipe.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BedrockMortar extends Item implements ICraftingHandler
{
    private boolean repair;
    public BedrockMortar(int par1)
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

    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
        return 0x666666;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = Item.bowlEmpty.getIconFromDamage(0);
    }
}
