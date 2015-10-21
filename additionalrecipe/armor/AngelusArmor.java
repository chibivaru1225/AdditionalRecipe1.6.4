package chibivaru.additionalrecipe.armor;

import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class AngelusArmor extends ItemArmor
{
	private String texturePath = AdditionalRecipe.MODID + ":" + "textures/armor/";
	public AngelusArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4,String type)
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setTextureName(type,par4);
		super.setMaxStackSize(1);
		setMaxDamage(0);
	}

	//layer名を登録しています。
	//この場合はsample_layer_1.png、sample_layer_2.pngを登録しています。
	//上で指定したフォルダに入れてください。

	private void setTextureName(String type,int armorPart)
	{
		//head,body,boots
		if(armorType == 0 || armorType == 1 || armorType == 3)
		{
			this.texturePath += type + "_1.png";
		}
		//legs
		else
		{
			this.texturePath += type + "_2.png";
		}
	}
	@SideOnly(Side.CLIENT)
	public void registerIcon(IconRegister register)
	{
		this.itemIcon = register.registerIcon(AdditionalRecipe.MODID + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
	}
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		return this.texturePath;
	}
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
}
