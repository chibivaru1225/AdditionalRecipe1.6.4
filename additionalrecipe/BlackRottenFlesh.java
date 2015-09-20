package chibivaru.additionalrecipe;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlackRottenFlesh extends Item
{
	public BlackRottenFlesh(int i)
	{
		super(i);
		this.setMaxStackSize(64);	//スタックできる量
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = Item.rottenFlesh.getIconFromDamage(0);
	}
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if(par3EntityPlayer.getFoodStats().getFoodLevel() != 0)
    	{
    		PotionEffect Effect = new PotionEffect(Potion.regeneration.id,1200,49);
    		boolean isRegeneration = par3EntityPlayer.isPotionActive(Effect.getPotionID());
    		if(!isRegeneration)
    		{
    			par3EntityPlayer.swingItem();
    			par1ItemStack.stackSize--;
    			par3EntityPlayer.addPotionEffect(Effect);
    			par3EntityPlayer.getFoodStats().setFoodLevel(0);
    		}
    	}
    	return par1ItemStack;
    }
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
	public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
	{
		return 0x777777;
	}
}