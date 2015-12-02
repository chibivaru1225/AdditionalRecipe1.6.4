package chibivaru.additionalrecipe.item;

import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class SwordExelectorLast extends ItemSword
{
	private int weaponDamage;
	private EnumToolMaterial toolMaterial;
	public SwordExelectorLast(int itemID, EnumToolMaterial par2EnumToolMaterial)
	{
		super(itemID, par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
		this.setMaxStackSize(1);
		this.setContainerItem(AdditionalRecipe.swordExelectorFirst);
		this.weaponDamage = (int) (4 + par2EnumToolMaterial.getDamageVsEntity());
		this.setMaxDamage(0);
	}
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
	{
		return false;
	}
	@SideOnly(Side.CLIENT)
	public void registerIcon(IconRegister register)
	{
		this.itemIcon = register.registerIcon(AdditionalRecipe.MODID + ":" + this.getUnlocalizedName());
	}
}
