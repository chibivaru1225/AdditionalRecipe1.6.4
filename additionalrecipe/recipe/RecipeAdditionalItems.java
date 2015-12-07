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
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "ExchangeIgnition" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
				}
			}
			else
			{
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "ExchangeIgnition" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
				}
			}
			if(AdditionalRecipe.craftingDustExchangeIgnition)
			{
				GameRegistry.addSmelting(AdditionalRecipe.exchangeIgnitionItemID,new ItemStack(AdditionalRecipe.dustExchangeIgnitionItem,1,0),0.0f);
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "DustExchangeIgnition" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
				}
			}
			else
			{
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "DustExchangeIgnition" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
				}
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
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "UltimateExchangeIgnition" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
				}
			}
			else
			{
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "UltimateExchangeIgnition" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
				}
			}
			if(AdditionalRecipe.craftingCheaperExchangeIgnition)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						AdditionalRecipe.cheaperExchangeIgnition,
						new Object[]{"XXX","XYX","XXX",
							Character.valueOf('X'),AdditionalRecipe.blackRottenFleshItem,
							Character.valueOf('Y'),Block.blockDiamond}));
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "CheaperExchangeIgnition" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
				}
			}
			else
			{
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "CheaperExchangeIgnition" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
				}
			}
		}
		else
		{
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "AlchemicItems" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
			}
		}
		if(AdditionalRecipe.craftingBlackRottenFlesh)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.blackRottenFleshItem,
					new Object[]{"XXX","X X","XXX",
						Character.valueOf('X'),Item.rottenFlesh}));
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "BlackRottenFlesh" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
			}
		}
		else
		{
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "BlackRottenFlesh" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
			}
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
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "BedrockMortar" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
				}
			}
			else
			{
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "BedrockMortar" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
				}
			}
			if(AdditionalRecipe.craftingDiamondMortar)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						AdditionalRecipe.diamondMortarItem,
						new Object[]{"XYX"," X ",
							Character.valueOf('X'),Item.diamond,
							Character.valueOf('Y'),Item.ingotIron}));
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "DiamondMortar" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
				}
			}
			else
			{
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "DiamondMortar" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
				}
			}
			if(AdditionalRecipe.craftingIronMortar)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						AdditionalRecipe.ironMortarItem,
						new Object[]{"XYX"," X ",
							Character.valueOf('X'),Item.ingotIron,
							Character.valueOf('Y'),Item.flint}));
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "IronMortar" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
				}
			}
			else
			{
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "IronMortar" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
				}
			}
		}
		else
		{
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "Mortars" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
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
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "GravitationFeather" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
			}
		}
		else
		{
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "GravitationFeather" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
			}
		}
		if(AdditionalRecipe.craftingNightVisionTorch)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.nightVisionTorchItem,
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Block.glowStone,
						Character.valueOf('Y'),Item.blazeRod}));
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "NightVisionTorch" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
			}
		}
		else
		{
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "NightVisionTorch" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
			}
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
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "SuperGravitationFeather" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
			}
		}
		else
		{
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "SuperGravitationFeather" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
			}
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
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "CraftingFurnace" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
			}
		}
		else
		{
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "CraftingFurnace" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
			}
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
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "BedrockArmor" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
			}
		}
		else
		{
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "BedrockArmor" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
			}
		}
		if(AdditionalRecipe.craftingAngelusArmor)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.armorAngelusItem[AdditionalRecipe.ARMOR_HELMET],
					new Object[]{"ZYZ","ZXZ","ZWZ",
						Character.valueOf('X'),AdditionalRecipe.armorBedrockItem[AdditionalRecipe.ARMOR_HELMET],
						Character.valueOf('Y'),AdditionalRecipe.dustExchangeIgnitionItem,
						Character.valueOf('Z'),Block.blockDiamond,
						Character.valueOf('W'),AdditionalRecipe.ultimateExchangeIgnitionItem}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.armorAngelusItem[AdditionalRecipe.ARMOR_PLATE],
					new Object[]{"ZYZ","ZXZ","ZWZ",
						Character.valueOf('X'),AdditionalRecipe.armorBedrockItem[AdditionalRecipe.ARMOR_PLATE],
						Character.valueOf('Y'),AdditionalRecipe.dustExchangeIgnitionItem,
						Character.valueOf('Z'),Block.blockDiamond,
						Character.valueOf('W'),AdditionalRecipe.ultimateExchangeIgnitionItem}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.armorAngelusItem[AdditionalRecipe.ARMOR_LEGS],
					new Object[]{"ZYZ","ZXZ","ZWZ",
						Character.valueOf('X'),AdditionalRecipe.armorBedrockItem[AdditionalRecipe.ARMOR_LEGS],
						Character.valueOf('Y'),AdditionalRecipe.dustExchangeIgnitionItem,
						Character.valueOf('Z'),Block.blockDiamond,
						Character.valueOf('W'),AdditionalRecipe.ultimateExchangeIgnitionItem}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.armorAngelusItem[AdditionalRecipe.ARMOR_BOOTS],
					new Object[]{"ZYZ","ZXZ","ZWZ",
						Character.valueOf('X'),AdditionalRecipe.armorBedrockItem[AdditionalRecipe.ARMOR_BOOTS],
						Character.valueOf('Y'),AdditionalRecipe.dustExchangeIgnitionItem,
						Character.valueOf('Z'),Block.blockDiamond,
						Character.valueOf('W'),AdditionalRecipe.ultimateExchangeIgnitionItem}));
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "AngelusArmor" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
			}
		}
		else
		{
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "AngelusArmor" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
			}
		}
		if(AdditionalRecipe.craftingCirceForce)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.circeForceItem,
					new Object[]{"XYX","YZY","XYX",
						Character.valueOf('X'),Block.blockDiamond,
						Character.valueOf('Y'),Item.bucketWater,
						Character.valueOf('Z'),"ExchangeIgnition"}));
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "CirceForce" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
			}
		}
		else
		{
			if(AdditionalRecipe.consoleOut)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "CirceForce" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
			}
		}
		if(AdditionalRecipe.craftingWeapons)
		{
			if(AdditionalRecipe.craftingNIOH)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						AdditionalRecipe.bladeNIOHItem,
						new Object[]{"X X","YZY","VZV",
							Character.valueOf('X'),Item.swordIron,
							Character.valueOf('Y'),Item.gunpowder,
							Character.valueOf('Z'),Block.blockIron,
							Character.valueOf('V'),Block.bedrock}));;
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "NIOH" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
				}
			}
			else
			{
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "NIOH" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
				}
			}
			if(AdditionalRecipe.craftingDAYO)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						AdditionalRecipe.spearDAYOItem,
						new Object[]{"XX ","XYZ"," ZV",
							Character.valueOf('X'),Item.swordDiamond,
							Character.valueOf('Y'),"ExchangeIgnition",
							Character.valueOf('Z'),Block.blockGold,
							Character.valueOf('V'),Block.bedrock}));
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "Evil Spear 'DAYO'" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
				}
			}
			else
			{
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "Evil Spear 'DAYO'" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
				}
			}
			if(AdditionalRecipe.craftingYORU)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						AdditionalRecipe.swordYORUItem,
						new Object[]{" X ","YXY","ZVZ",
							Character.valueOf('X'),Block.blockIron,
							Character.valueOf('Y'),Block.bedrock,
							Character.valueOf('Z'),Block.blockDiamond,
							Character.valueOf('V'),"ExchangeIgnition"}));
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "Villany Sword 'YORU'" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
				}
			}
			else
			{
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "Villany Sword 'YORU'" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
				}
			}
		}
	}
}
