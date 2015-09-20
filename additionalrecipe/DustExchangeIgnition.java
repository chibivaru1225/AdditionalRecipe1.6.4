package chibivaru.additionalrecipe;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DustExchangeIgnition extends Item{
	public DustExchangeIgnition(int par1) {
		super(par1);
		this.setMaxStackSize(64);	//スタックできる量
	}
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = Item.sugar.getIconFromDamage(0);
    }

	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float disX, float disY, float disZ)
	{
		//アイテムをブロックに対して右クリックした時に呼ばれる
		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
	{
		//アイテムを右クリック時に呼ばれる
		return item;
	}
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
        return 0xAAAAAA;
    }
}
