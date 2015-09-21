package chibivaru.additionalrecipe.recipe;

import com.xcompwiz.mystcraft.api.MystObjects;

import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipeAnotherMod {
	private static Class MFR;
	private static Class BC;

	public void init()
	{
		if(Loader.isModLoaded("Mystcraft"))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					new ItemStack(MystObjects.link_modifer),
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Block.blockDiamond,
						Character.valueOf('Y'),Block.blockGold}));
		}
		if(Loader.isModLoaded("AppliedEnergistics"))
		{
			if(OreDictionary.getOres("dustWheat").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						OreDictionary.getOres("dustWheat").get(0),
						new Object[]{Item.wheat}));
			}
		}
		try
		{
			MFR = Class.forName("powercrystals.minefactoryreloaded.MineFactoryReloadedCore");
			Object pinkSlimeBall = MFR.getField("pinkSlimeballItem").get(null);
			ItemStack pink = new ItemStack((Item)pinkSlimeBall);
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					pink,
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Item.rottenFlesh,
						Character.valueOf('Y'),Item.slimeBall}));
		}
		catch(Exception e)
		{
			System.out.println("[AdditionalRecipe]:Can't Find MineFactory Reloaded");
		}
		try
		{
			BC = Class.forName("buildcraft.BuildCraftCore");
			Object springBlock = BC.getField("springBlock").get(null);
			Block spring = (Block)springBlock;
			if(AdditionalRecipe.digBCSpring)
			{
				spring.setHardness(60F);
			}
		}
		catch(Exception e)
		{
			System.out.println("[AdditionalRecipe]:Can't Find BuildCraft");
		}
	}
}
