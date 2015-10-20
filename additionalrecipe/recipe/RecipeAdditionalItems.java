package chibivaru.additionalrecipe.recipe;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeAdditionalItems {
	public void init()
	{
		if(AdditionalRecipe.craftingAlchemic)
		{
			if(AdditionalRecipe.craftingExchangeIgnition)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						AdditionalRecipe.exchangeIgnitionItem,
						new Object[]{" X ","XYX"," X ",
							Character.valueOf('X'),Item.netherStar,
							Character.valueOf('Y'),Block.dragonEgg}));
			}
			if(AdditionalRecipe.craftingDustExchangeIgnition)
			{
				GameRegistry.addSmelting(AdditionalRecipe.exchangeIgnitionItemID,new ItemStack(AdditionalRecipe.dustExchangeIgnitionItem,1,0),0.0f);
			}
			if(AdditionalRecipe.craftingUltimateExchangeIgnition)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						AdditionalRecipe.ultimateExchangeIgnition,
						new Object[]{"XYX","YZY","XYX",
							Character.valueOf('X'),AdditionalRecipe.dustExchangeIgnitionItem,
							Character.valueOf('Y'),Block.dragonEgg,
							Character.valueOf('Z'),AdditionalRecipe.superGravitationFeatherItem}));
			}
			if(AdditionalRecipe.craftingCheaperExchangeIgnition)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						AdditionalRecipe.cheaperExchangeIgnition,
						new Object[]{"XXX","XYX","XXX",
							Character.valueOf('X'),AdditionalRecipe.blackRottenFleshItem,
							Character.valueOf('Y'),Block.blockDiamond}));
			}
		}
		if(AdditionalRecipe.craftingBlackRottenFlesh)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.blackRottenFleshItem,
					new Object[]{"XXX","X X","XXX",
						Character.valueOf('X'),Item.rottenFlesh}));
		}
		if(AdditionalRecipe.craftingMortar)
		{
			if(AdditionalRecipe.craftingBedrockMortar)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						AdditionalRecipe.bedrockMortarItem,
						new Object[]{"XYX"," X ",
							Character.valueOf('X'),Item.netherStar,
							Character.valueOf('Y'),Block.dragonEgg}));
			}
			if(AdditionalRecipe.craftingDiamondMortar)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						AdditionalRecipe.diamondMortarItem,
						new Object[]{"XYX"," X ",
							Character.valueOf('X'),Item.diamond,
							Character.valueOf('Y'),Item.ingotIron}));
			}
			if(AdditionalRecipe.craftingIronMortar)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						AdditionalRecipe.ironMortarItem,
						new Object[]{"XYX"," X ",
							Character.valueOf('X'),Item.ingotIron,
							Character.valueOf('Y'),Item.flint}));
			}
		}
		if(AdditionalRecipe.craftingGravitationFeather)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.gravitationFeatherItem,
					new Object[]{" X ","XYX"," X ",
						Character.valueOf('X'),Item.feather,
						Character.valueOf('Y'),Item.diamond}));
		}
		if(AdditionalRecipe.craftingNightVisionTorch)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.nightVisionTorchItem,
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Block.glowStone,
						Character.valueOf('Y'),Item.blazeRod}));
		}
		if(AdditionalRecipe.craftingSuperGravitationFeather)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.superGravitationFeatherItem,
					new Object[]{"ZXZ","XYX","ZXZ",
						Character.valueOf('X'),Block.blockDiamond,
						Character.valueOf('Y'),AdditionalRecipe.gravitationFeatherItem,
						Character.valueOf('Z'),AdditionalRecipe.nightVisionTorchItem}));
		}
		if(AdditionalRecipe.craftingCraftingFurnace)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.craftingFurnaceItem,
					new Object[]{"XYX","YZY","XYX",
						Character.valueOf('X'),Item.diamond,
						Character.valueOf('Y'),Item.coal,
						Character.valueOf('Z'),"ExchangeIgnition"}));
		}
		if(AdditionalRecipe.craftingBedrockArmor)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.armorBedrockItem[AdditionalRecipe.ARMOR_HELMET],
					new Object[]{"XXX","XYX","   ",
						Character.valueOf('X'),Block.bedrock,
						Character.valueOf('Y'),AdditionalRecipe.dustExchangeIgnitionItem}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.armorBedrockItem[AdditionalRecipe.ARMOR_PLATE],
					new Object[]{"XYX","XXX","XXX",
						Character.valueOf('X'),Block.bedrock,
						Character.valueOf('Y'),AdditionalRecipe.dustExchangeIgnitionItem}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.armorBedrockItem[AdditionalRecipe.ARMOR_LEGS],
					new Object[]{"XXX","XYX","X X",
						Character.valueOf('X'),Block.bedrock,
						Character.valueOf('Y'),AdditionalRecipe.dustExchangeIgnitionItem}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.armorBedrockItem[AdditionalRecipe.ARMOR_BOOTS],
					new Object[]{"   ","XYX","X X",
						Character.valueOf('X'),Block.bedrock,
						Character.valueOf('Y'),AdditionalRecipe.dustExchangeIgnitionItem}));
		}
	}
}
