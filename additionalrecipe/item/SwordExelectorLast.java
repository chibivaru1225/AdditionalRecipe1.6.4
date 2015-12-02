package chibivaru.additionalrecipe.item;

import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.common.ICraftingHandler;
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
}
