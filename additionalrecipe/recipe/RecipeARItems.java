package chibivaru.additionalrecipe.recipe;

import static chibivaru.additionalrecipe.common.ARItemHandler.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeARItems {
	public void init()
	{
		if(AdditionalRecipe.craftingAlchemic)
		{
			if(AdditionalRecipe.craftingExchangeIgnition)
			{
				if(AdditionalRecipe.craftingExelector)
				{
					GameRegistry.addRecipe(
							new ShapedOreRecipe(
								ARGetItemRegister("exchangeiginiton"),
								new Object[]{" X ","XYX"," X ",
									Character.valueOf('X'),Item.netherStar,
									Character.valueOf('Y'),ARGetItemRegister("forceball")}));
				}
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("exchangeiginiton"),
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
				GameRegistry.addSmelting(ARGetItemIDRegister("exchangeiginiton"),new ItemStack(ARGetItemRegister("dustexchangeignition"),1,0),0.0f);
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
						ARGetItemRegister("ultimateexchangeiginiton"),
						new Object[]{"XYX","YZY","XYX",
							Character.valueOf('X'),ARGetItemRegister("dustexchangeignition"),
							Character.valueOf('Y'),Block.dragonEgg,
							Character.valueOf('Z'),ARGetItemRegister("supergravitationfeather")}));
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
				if(AdditionalRecipe.craftingExelector)
				{
					GameRegistry.addRecipe(
						new ShapedOreRecipe(
							ARGetItemRegister("cheaperexchangeiginiton"),
							new Object[]{"XXX","XYX","XXX",
								Character.valueOf('X'),ARGetItemRegister("blackrottenflesh"),
								Character.valueOf('Y'),ARGetItemRegister("forceball")}));
				}
				else
				{
					GameRegistry.addRecipe(
						new ShapedOreRecipe(
							ARGetItemRegister("cheaperexchangeiginiton"),
							new Object[]{"XXX","XYX","XXX",
								Character.valueOf('X'),ARGetItemRegister("blackrottenflesh"),
								Character.valueOf('Y'),Block.blockDiamond}));
				}
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
			if(AdditionalRecipe.craftingCirceForce)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("circeforce"),
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
					ARGetItemRegister("blackrottenflesh"),
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
						ARGetItemRegister("bedrockmortar"),
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
						ARGetItemRegister("diamondmortar"),
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
						ARGetItemRegister("ironmortar"),
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
					ARGetItemRegister("gravitationfeather"),
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
					ARGetItemRegister("nightvisiontorch"),
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
					ARGetItemRegister("supergravitationfeather"),
					new Object[]{"ZXZ","XYX","ZXZ",
						Character.valueOf('X'),Block.blockDiamond,
						Character.valueOf('Y'),ARGetItemRegister("gravitationfeather"),
						Character.valueOf('Z'),ARGetItemRegister("nightvisiontorch")}));
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
					ARGetItemRegister("craftingfurnace"),
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
					ARGetItemRegister("bedrockhelmet"),
					new Object[]{"XXX","XYX","   ",
						Character.valueOf('X'),Block.bedrock,
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("bedrockplate"),
					new Object[]{"XYX","XXX","XXX",
						Character.valueOf('X'),Block.bedrock,
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("bedrocklegs"),
					new Object[]{"XXX","XYX","X X",
						Character.valueOf('X'),Block.bedrock,
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("bedrockboots"),
					new Object[]{"   ","XYX","X X",
						Character.valueOf('X'),Block.bedrock,
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition")}));
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
					ARGetItemRegister("angelushood"),
					new Object[]{"ZYZ","ZXZ","ZWZ",
						Character.valueOf('X'),ARGetItemRegister("bedrockhelmet"),
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition"),
						Character.valueOf('Z'),Block.blockDiamond,
						Character.valueOf('W'),ARGetItemRegister("ultimateexchangeiginiton")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("angelusvestment"),
					new Object[]{"ZYZ","ZXZ","ZWZ",
						Character.valueOf('X'),ARGetItemRegister("bedrockplate"),
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition"),
						Character.valueOf('Z'),Block.blockDiamond,
						Character.valueOf('W'),ARGetItemRegister("ultimateexchangeiginiton")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("angelusskirt"),
					new Object[]{"ZYZ","ZXZ","ZWZ",
						Character.valueOf('X'),ARGetItemRegister("bedrocklegs"),
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition"),
						Character.valueOf('Z'),Block.blockDiamond,
						Character.valueOf('W'),ARGetItemRegister("ultimateexchangeiginiton")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("angelusboots"),
					new Object[]{"ZYZ","ZXZ","ZWZ",
						Character.valueOf('X'),ARGetItemRegister("bedrockboots"),
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition"),
						Character.valueOf('Z'),Block.blockDiamond,
						Character.valueOf('W'),ARGetItemRegister("ultimateexchangeiginiton")}));
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
		if(AdditionalRecipe.craftingWeapons)
		{
			if(AdditionalRecipe.craftingExelector)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("exelector"),
						new Object[]{" XX","ZVX","YZ ",
							Character.valueOf('X'),Item.netherQuartz,
							Character.valueOf('Y'),Item.stick,
							Character.valueOf('Z'),Item.diamond,
							Character.valueOf('V'),Item.redstone}));
				GameRegistry.addRecipe(
						new ShapedOreRecipe(
							ARGetItemRegister("exelector"),
							new Object[]{" XX","ZVX","YZ ",
								Character.valueOf('X'),"crystalCertusQuartz",
								Character.valueOf('Y'),Item.stick,
								Character.valueOf('Z'),Item.diamond,
								Character.valueOf('V'),Item.redstone}));
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						ARGetItemRegister("forceball"),
						new Object[]{new ItemStack(ARGetItemRegister("exelector"),1,0)}));
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "Exelector" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
					System.out.println(AdditionalRecipe.CONSOLE + "ForceBall" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
				}
			}
			else
			{
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "Exelector" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
					System.out.println(AdditionalRecipe.CONSOLE + "ForceBall" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
				}
			}
			if(AdditionalRecipe.craftingNIOH)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("nioh"),
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
						ARGetItemRegister("dayo"),
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
						ARGetItemRegister("yoru"),
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
		if(AdditionalRecipe.craftingItemsK2)
		{
			if(AdditionalRecipe.craftingMultiK2)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("toolk2"),
						new Object[]{"XYX","ZVZ","YWY",
							Character.valueOf('X'),Block.blockGold,
							Character.valueOf('Y'),Block.blockRedstone,
							Character.valueOf('Z'),Block.blockIron,
							Character.valueOf('V'),"ExchangeIgnition",
							Character.valueOf('W'),Block.obsidian}));
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "K2's Multi-Weapon" + RecipeHandler.RECIPE + RecipeHandler.ADDED);
				}
			}
			else
			{
				if(AdditionalRecipe.consoleOut)
				{
					System.out.println(AdditionalRecipe.CONSOLE + "K2's Multi-Weapon" + RecipeHandler.RECIPE + RecipeHandler.NOTADDED);
				}
			}
		}
	}
}
