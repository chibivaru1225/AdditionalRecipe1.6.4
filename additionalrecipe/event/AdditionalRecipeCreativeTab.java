package chibivaru.additionalrecipe.event;

import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class AdditionalRecipeCreativeTab extends CreativeTabs{

	public AdditionalRecipeCreativeTab(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return AdditionalRecipe.ultimateExchangeIgnition;
	}
 
	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "AdditionalRecipe";
	}
}
