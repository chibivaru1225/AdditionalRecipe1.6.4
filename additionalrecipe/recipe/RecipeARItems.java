package chibivaru.additionalrecipe.recipe;

import static chibivaru.additionalrecipe.common.ARConfiguration.*;
import static chibivaru.additionalrecipe.common.ARItemHandler.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeARItems
{
	public void init()
	{
		if(ARGetCrafting("AlchemicItem",true))
		{
			if(ARGetCrafting("ExchangeIgnition",true))
			{
				if(ARGetCrafting("Exelector",true))
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
			}
			if(ARGetCrafting("DustExchangeIgnition",true))
			{
				GameRegistry.addSmelting(ARGetItemIDRegister("exchangeiginiton"),new ItemStack(ARGetItemRegister("dustexchangeignition"),1,0),0.0f);
			}
			if(ARGetCrafting("UltimateExchangeIgnition",true))
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("ultimateexchangeiginiton"),
						new Object[]{"XYX","YZY","XYX",
							Character.valueOf('X'),ARGetItemRegister("dustexchangeignition"),
							Character.valueOf('Y'),Block.dragonEgg,
							Character.valueOf('Z'),ARGetItemRegister("supergravitationfeather")}));
			}
			if(ARGetCrafting("DustUltimateExchangeIgnition",true))
			{
				GameRegistry.addSmelting(ARGetItemIDRegister("ultimateexchangeiginiton"),new ItemStack(ARGetItemRegister("dustultimateexchangeignition"),1,0),0.0f);
			}
			if(ARGetCrafting("CheaperExchangeIgnition",true))
			{
				if(ARGetCrafting("Exelector",true))
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
			}
			if(ARGetCrafting("CirceForce",true))
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("circeforce"),
						new Object[]{"XYX","YZY","XYX",
							Character.valueOf('X'),Block.blockDiamond,
							Character.valueOf('Y'),Item.bucketWater,
							Character.valueOf('Z'),"ExchangeIgnition"}));
			}
		}
		if(ARGetCrafting("BlackRottenFlesh",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("blackrottenflesh"),
					new Object[]{"XXX","X X","XXX",
						Character.valueOf('X'),Item.rottenFlesh}));
		}
		if(ARGetCrafting("Mortar",true))
		{
			if(ARGetCrafting("BedrockMortar",true))
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("bedrockmortar"),
						new Object[]{"XYX"," X ",
							Character.valueOf('X'),Item.netherStar,
							Character.valueOf('Y'),Block.dragonEgg}));
			}
			if(ARGetCrafting("DiamondMortar",true))
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("diamondmortar"),
						new Object[]{"XYX"," X ",
							Character.valueOf('X'),Item.diamond,
							Character.valueOf('Y'),Item.ingotIron}));
			}
			if(ARGetCrafting("IronMortar",true))
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("ironmortar"),
						new Object[]{"XYX"," X ",
							Character.valueOf('X'),Item.ingotIron,
							Character.valueOf('Y'),Item.flint}));
			}
		}
		if(ARGetCrafting("GravitationFeather",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("gravitationfeather"),
					new Object[]{" X ","XYX"," X ",
						Character.valueOf('X'),Item.feather,
						Character.valueOf('Y'),Item.diamond}));
		}
		if(ARGetCrafting("NightVisionTorch",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("nightvisiontorch"),
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Block.glowStone,
						Character.valueOf('Y'),Item.blazeRod}));
		}
		if(ARGetCrafting("SuperGravitationFeather",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("supergravitationfeather"),
					new Object[]{"ZXZ","XYX","ZXZ",
						Character.valueOf('X'),Block.blockDiamond,
						Character.valueOf('Y'),ARGetItemRegister("gravitationfeather"),
						Character.valueOf('Z'),ARGetItemRegister("nightvisiontorch")}));
		}
		if(ARGetCrafting("CraftingFurnace",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("craftingfurnace"),
					new Object[]{"XYX","YZY","XYX",
						Character.valueOf('X'),Item.diamond,
						Character.valueOf('Y'),Item.coal,
						Character.valueOf('Z'),"ExchangeIgnition"}));
		}
		if(ARGetCrafting("BedrockArmor",true))
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
			GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("bedrockhelmet"),
						new Object[]{"XXX","XYX","   ",
							Character.valueOf('X'),Block.bedrock,
							Character.valueOf('Y'),ARGetItemRegister("forceball")}));
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("bedrockplate"),
						new Object[]{"XYX","XXX","XXX",
							Character.valueOf('X'),Block.bedrock,
							Character.valueOf('Y'),ARGetItemRegister("forceball")}));
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("bedrocklegs"),
						new Object[]{"XXX","XYX","X X",
							Character.valueOf('X'),Block.bedrock,
							Character.valueOf('Y'),ARGetItemRegister("forceball")}));
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("bedrockboots"),
						new Object[]{"   ","XYX","X X",
							Character.valueOf('X'),Block.bedrock,
							Character.valueOf('Y'),ARGetItemRegister("forceball")}));
		}
		if(ARGetCrafting("GluttonyArmor",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("gluttonyhood"),
					new Object[]{"ZYZ","ZXZ",
						Character.valueOf('X'),ARGetItemRegister("bedrockhelmet"),
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition"),
						Character.valueOf('Z'),Block.blockDiamond,}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("gluttonyvestment"),
					new Object[]{"ZYZ","ZXZ",
						Character.valueOf('X'),ARGetItemRegister("bedrockplate"),
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition"),
						Character.valueOf('Z'),Block.blockDiamond,}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("gluttonyskirt"),
					new Object[]{"ZYZ","ZXZ",
						Character.valueOf('X'),ARGetItemRegister("bedrocklegs"),
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition"),
						Character.valueOf('Z'),Block.blockDiamond,}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("gluttonyboots"),
					new Object[]{"ZYZ","ZXZ",
						Character.valueOf('X'),ARGetItemRegister("bedrockboots"),
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition"),
						Character.valueOf('Z'),Block.blockDiamond,}));
		}
		if(ARGetCrafting("AngelusArmor",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("angelushood"),
					new Object[]{"ZYZ","ZXZ","ZWZ",
						Character.valueOf('X'),ARGetItemRegister("gluttonyhood"),
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition"),
						Character.valueOf('Z'),Block.blockDiamond,
						Character.valueOf('W'),ARGetItemRegister("dustultimateexchangeignition")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("angelusvestment"),
					new Object[]{"ZYZ","ZXZ","ZWZ",
						Character.valueOf('X'),ARGetItemRegister("gluttonyvestment"),
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition"),
						Character.valueOf('Z'),Block.blockDiamond,
						Character.valueOf('W'),ARGetItemRegister("dustultimateexchangeignition")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("angelusskirt"),
					new Object[]{"ZYZ","ZXZ","ZWZ",
						Character.valueOf('X'),ARGetItemRegister("gluttonyskirt"),
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition"),
						Character.valueOf('Z'),Block.blockDiamond,
						Character.valueOf('W'),ARGetItemRegister("dustultimateexchangeignition")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					ARGetItemRegister("angelusboots"),
					new Object[]{"ZYZ","ZXZ","ZWZ",
						Character.valueOf('X'),ARGetItemRegister("gluttonyboots"),
						Character.valueOf('Y'),ARGetItemRegister("dustexchangeignition"),
						Character.valueOf('Z'),Block.blockDiamond,
						Character.valueOf('W'),ARGetItemRegister("dustultimateexchangeignition")}));
		}
		if(ARGetCrafting("Weapons",true))
		{
			if(ARGetCrafting("Exelector",true))
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
			}
			if(ARGetCrafting("NIOH",true))
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("nioh"),
						new Object[]{"X X","YZY","VZV",
							Character.valueOf('X'),Item.swordIron,
							Character.valueOf('Y'),Item.gunpowder,
							Character.valueOf('Z'),Block.blockIron,
							Character.valueOf('V'),Block.bedrock}));;
			}
			if(ARGetCrafting("Evil Spear DAYO",true))
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("dayo"),
						new Object[]{"XX ","XYZ"," ZV",
							Character.valueOf('X'),Item.swordDiamond,
							Character.valueOf('Y'),"ExchangeIgnition",
							Character.valueOf('Z'),Block.blockGold,
							Character.valueOf('V'),Block.bedrock}));
			}
			if(ARGetCrafting("Villany Sword YORU",true))
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						ARGetItemRegister("yoru"),
						new Object[]{" X ","YXY","ZVZ",
							Character.valueOf('X'),Block.blockIron,
							Character.valueOf('Y'),Block.bedrock,
							Character.valueOf('Z'),Block.blockDiamond,
							Character.valueOf('V'),"ExchangeIgnition"}));
			}
		}
		if(ARGetCrafting("K2 Items",true))
		{
			if(ARGetCrafting("Multi-Tool K2",true))
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
			}
		}
	}
}
