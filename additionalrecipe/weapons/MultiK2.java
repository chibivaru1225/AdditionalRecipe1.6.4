package chibivaru.additionalrecipe.weapons;

import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class MultiK2 extends ItemSword
{
	private int weaponDamage;
	private EnumToolMaterial toolMaterial;
    private boolean effect;
    private int mode;
	public MultiK2(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
		this.setMaxStackSize(1);
		this.weaponDamage = (int) par2EnumToolMaterial.getDamageVsEntity();
		this.setMaxDamage(0);
		this.mode = 0;//0 = Great Sword,1 = Long Sword,2 = Lapier,3 = Wand
	}
	@SideOnly(Side.CLIENT)
	public void registerIcon(IconRegister register)
	{
		this.itemIcon = register.registerIcon(AdditionalRecipe.MODID + ":" + this.getUnlocalizedName());
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityPlayer)
	{
		if(this.mode > 3)
		{
			this.mode = 0;
		}
		this.mode++;
		switch(this.mode)
		{
			case 0:
			{
				this.weaponDamage = 35;
				this.setTextureName(AdditionalRecipe.MODID + ":K2GS");
				break;
			}
			case 1:
			{
				this.weaponDamage = 15;
				this.setTextureName(AdditionalRecipe.MODID + ":K2LS");
				break;
			}
			case 2:
			{
				this.weaponDamage = 5;
				this.setTextureName(AdditionalRecipe.MODID + ":K2LP");
				break;
			}
			case 3:
			{
				this.weaponDamage = 0;
				this.setTextureName(AdditionalRecipe.MODID + ":K2WA");
				break;
			}
		}
		return itemstack;
	}
}