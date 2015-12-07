package chibivaru.additionalrecipe.weapons;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SwordExelectorFirst extends ItemSword
{
	private int weaponDamage;
	private EnumToolMaterial toolMaterial;
	private boolean can;
	private int exp;
	public SwordExelectorFirst(int itemID, EnumToolMaterial par2EnumToolMaterial)
	{
		super(itemID, par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
		this.setMaxStackSize(1);
		this.weaponDamage = (int) par2EnumToolMaterial.getDamageVsEntity();
		this.setMaxDamage(0);
		this.setExp(0);
		this.setCanUse(false);
	}
	@SideOnly(Side.CLIENT)
	public void registerIcon(IconRegister register)
	{
		this.itemIcon = register.registerIcon(AdditionalRecipe.MODID + ":" + this.getUnlocalizedName());
	}
	public void setExp(int par1)
	{
		this.exp = par1;
	}
	public void setCanUse(boolean par1)
	{
		this.can = par1;
	}
	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		if(this.exp > AdditionalRecipe.exelectorFirstExp)
		{
			this.can = true;
		}
		this.exp++;
		return true;
	}
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if(this.can)
		{
			par3List.add("Exelector can improve to next level!");
		}
		else
		{
			par3List.add("Exp = " + this.exp + " / " + AdditionalRecipe.exelectorFirstExp);
		}
	}
}