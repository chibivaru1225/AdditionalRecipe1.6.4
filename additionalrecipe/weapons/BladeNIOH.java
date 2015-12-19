package chibivaru.additionalrecipe.weapons;

import static chibivaru.additionalrecipe.common.ARConfiguration.*;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;
import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BladeNIOH extends ItemSword
{
	private int weaponDamage;
	private EnumToolMaterial toolMaterial;
	public BladeNIOH(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
		this.setMaxStackSize(1);
		this.weaponDamage = (int) par2EnumToolMaterial.getDamageVsEntity();
		this.setTextureName("additionalrecipe:" + this.getUnlocalizedName());
		if(ARGetAnother("NIOHPreventDamage",true))
		{
			this.setMaxDamage(0);
		}
		else
		{
			this.setMaxDamage(ARGetCfgOther("NIOH",4));
		}
	}
	@SideOnly(Side.CLIENT)
	public void registerIcon(IconRegister register)
	{
		this.itemIcon = register.registerIcon(AdditionalRecipe.MODID + ":" + this.getUnlocalizedName());
	}
}
