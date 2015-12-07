package chibivaru.additionalrecipe.weapons;

import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class BladeNIOH extends ItemSword
{
	private int weaponDamage;
	private EnumToolMaterial toolMaterial;
	public BladeNIOH(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
		this.setMaxStackSize(1);
		this.weaponDamage = (int) par2EnumToolMaterial.getDamageVsEntity();
		if(AdditionalRecipe.bladeNIOHPreventDamage)
		{
			this.setMaxDamage(0);
		}
		else
		{
			this.setMaxDamage(AdditionalRecipe.bladeNIOHDamage);
		}
	}
	@SideOnly(Side.CLIENT)
	public void registerIcon(IconRegister register)
	{
		this.itemIcon = register.registerIcon(AdditionalRecipe.MODID + ":" + this.getUnlocalizedName());
	}
}
