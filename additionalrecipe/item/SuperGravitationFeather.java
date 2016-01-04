package chibivaru.additionalrecipe.item;

import static chibivaru.additionalrecipe.common.ARItemHandler.*;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SuperGravitationFeather extends Item
{
    private boolean repair;
    private boolean effect;

    public SuperGravitationFeather(int par1)
    {
        super(par1);
        this.setMaxStackSize(1);
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
		NBTTagCompound nbttagcompound = item.getTagCompound();
		boolean mode = false;
		if(nbttagcompound == null)
		{
			nbttagcompound = new NBTTagCompound();
			item.setTagCompound(nbttagcompound);
			mode = false;
		}
		else
		{
			mode = nbttagcompound.getBoolean("adr.sgf");
		}
		nbttagcompound.setBoolean("adr.sgf",!mode);
		player.swingItem();
		player.worldObj.playSoundAtEntity(player, "random.orb", 0.2F, 0.6F);
		//アイテムを右クリック時に呼ばれる
		return item;
	}
    //既存のハサミと見分けるため、テクスチャを赤で乗算
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
        return 0xFF00FF;
    }

    //1.5.2のテクスチャ指定
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = Item.feather.getIconFromDamage(0);
    }
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
		NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();
		boolean mode = false;
		if(nbttagcompound == null)
		{
			nbttagcompound = new NBTTagCompound();
			par1ItemStack.setTagCompound(nbttagcompound);
			mode = false;
		}
		else
		{
			mode = nbttagcompound.getBoolean("adr.sgf");
		}
        return mode;
    }
    @Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();
		boolean mode = false;
		if(nbttagcompound == null)
		{
			nbttagcompound = new NBTTagCompound();
			par1ItemStack.setTagCompound(nbttagcompound);
			mode = false;
		}
		else
		{
			mode = nbttagcompound.getBoolean("adr.sgf");
		}
		if(mode)
		{
			par3List.add((new StringBuilder()).append(EnumChatFormatting.BLUE).append("Mode ").append(EnumChatFormatting.BLUE).append("ON").toString());
		}
		else
		{
			par3List.add((new StringBuilder()).append(EnumChatFormatting.BLUE).append("Mode ").append(EnumChatFormatting.BLUE).append("OFF").toString());
		}
	}
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean held)
	{
		if(entity instanceof EntityPlayer)
		{
			NBTTagCompound nbttagcompound = stack.getTagCompound();
			boolean mode = false;
			if(nbttagcompound == null)
			{
				nbttagcompound = new NBTTagCompound();
				stack.setTagCompound(nbttagcompound);
				mode = false;
			}
			else
			{
				mode = nbttagcompound.getBoolean("adr.sgf");
			}
			EntityPlayer player = (EntityPlayer)entity;
			if(mode)
			{
				if(player.inventory.hasItem(ARGetItemIDRegister("supergravitationfeather")))
				{
					player.addPotionEffect(new PotionEffect(Potion.nightVision.id,20*30));
				}
			}
		}
	}
}