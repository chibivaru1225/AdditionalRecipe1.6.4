package chibivaru.additionalrecipe.common;

import static chibivaru.additionalrecipe.common.ARItemHandler.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ARCreativeTab extends CreativeTabs
{

	public ARCreativeTab(String label)
	{
		super(label);
		// TODO Auto-generated constructor stub
	}
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return ARGetItemRegister("ultimateexchangeiginiton");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "AdditionalRecipe";
	}
}
