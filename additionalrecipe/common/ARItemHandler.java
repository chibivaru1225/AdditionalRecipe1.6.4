package chibivaru.additionalrecipe.common;

import static chibivaru.additionalrecipe.AdditionalRecipe.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ARItemHandler
{
	public static void ARItemRegister()
	{

	}
	public static void ARNewItemRegister(Item par1Item,String par2UnlocalizedName,CreativeTabs par3CreativeTab,String par4Name)
	{
		par1Item.setUnlocalizedName(par2UnlocalizedName);
		par1Item.setCreativeTab(par3CreativeTab);
		ARItem.put(par2UnlocalizedName, par1Item);
		GameRegistry.registerItem(par1Item, par4Name);
		LanguageRegistry.addName(par1Item, par4Name);
		if(par1Item instanceof ICraftingHandler)
		{
			GameRegistry.registerCraftingHandler((ICraftingHandler)par1Item);
		}
	}
	public static void ARNewItemRegister(Item par1Item,String par2UnlocalizedName,CreativeTabs par3CreativeTab,String par4Name,String par5SuperName)
	{
		par1Item.setUnlocalizedName(par2UnlocalizedName);
		par1Item.setCreativeTab(par3CreativeTab);
		ARItem.put(par2UnlocalizedName, par1Item);
		GameRegistry.registerItem(par1Item, par4Name);
		LanguageRegistry.addName(par1Item, par5SuperName);
		if(par1Item instanceof ICraftingHandler)
		{
			GameRegistry.registerCraftingHandler((ICraftingHandler)par1Item);
		}
	}
	public static void ARNewItemRegister(Item par1Item,String par2UnlocalizedName,CreativeTabs par3CreativeTab,String par4Name,String par5Lang,String par6OtherName)
	{
		par1Item.setUnlocalizedName(par2UnlocalizedName);
		par1Item.setCreativeTab(par3CreativeTab);
		ARItem.put(par2UnlocalizedName, par1Item);
		GameRegistry.registerItem(par1Item, par4Name);
		LanguageRegistry.addName(par1Item, par4Name);
		LanguageRegistry.instance().addNameForObject(par1Item, par5Lang, par6OtherName);
		if(par1Item instanceof ICraftingHandler)
		{
			GameRegistry.registerCraftingHandler((ICraftingHandler)par1Item);
		}
	}
	public static void ARNewItemIDRegister(int par1ItemID,String par2ItemName)
	{
		ARItemID.put(par2ItemName, par1ItemID);
	}
	public static Item ARGetItemRegister(String par1Name)
	{
		Item item;
		if(ARItem.containsKey(par1Name))
		{
			return ARItem.get(par1Name);
		}
		else
		{
			return null;
		}
	}
	public static int ARGetItemIDRegister(String par1Name)
	{
		Item item;
		if(ARItemID.containsKey(par1Name))
		{
			return ARItemID.get(par1Name);
		}
		else
		{
			return 0;
		}
	}
}
