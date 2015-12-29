package chibivaru.additionalrecipe.common;

import static chibivaru.additionalrecipe.AdditionalRecipe.*;
import static chibivaru.additionalrecipe.common.ARItemHandler.*;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ARConfiguration
{
	public static Configuration cfg;
	public static void init(FMLPreInitializationEvent event)
	{
		cfg = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			cfg.load();
			ARNewItemIDRegister(ARSetID("ItemID","BedrockMortarItemID",12503),"bedrockmortar");
			ARNewItemIDRegister(ARSetID("ItemID","DiamondMortarItemID",12502),"diamondmortar");
			ARNewItemIDRegister(ARSetID("ItemID","IronMortarItemID"   ,12501),"ironmortar");
			ARNewItemIDRegister(ARSetID("ItemID","UltimateExchangeIgnitionItemID",12506),"ultimateexchangeiginiton");
			ARNewItemIDRegister(ARSetID("ItemID","ExchangeIgnitionItemID",12500),"exchangeiginiton");
			ARNewItemIDRegister(ARSetID("ItemID","CheaperExchangeIgnitionItemID",12507),"cheaperexchangeiginiton");
			ARNewItemIDRegister(ARSetID("ItemID","CraftingFurnaceItemID",12505),"craftingfurnace");
			ARNewItemIDRegister(ARSetID("ItemID","BlackRottenFleshItemID",12508),"blackrottenflesh");
			ARNewItemIDRegister(ARSetID("ItemID","GravitationFeatherItemID",12504),"gravitationfeather");
			ARNewItemIDRegister(ARSetID("ItemID","SuperGravitationFeatherItemID",12510),"supergravitationfeather");
			ARNewItemIDRegister(ARSetID("ItemID","NightVisionTorchItemID",12509),"nightvisiontorch");
			ARNewItemIDRegister(ARSetID("ItemID","ForceBallItemID",12511),"forceball");
			ARNewItemIDRegister(ARSetID("ItemID","CirceForceItemID",12512),"circeforce");

			ARNewItemIDRegister(ARSetID("WeaponItemID","SwordMoonlightID",12551),"moonlight");
			ARNewItemIDRegister(ARSetID("WeaponItemID","SwordDarkslayerID",12552),"darkslayer");
			ARNewItemIDRegister(ARSetID("WeaponItemID","SwordExelectorID",12553),"exelector");
			ARNewItemIDRegister(ARSetID("WeaponItemID","BladeNIOHID",12557),"nioh");
			ARNewItemIDRegister(ARSetID("WeaponItemID","SpearDAYOID",12558),"dayo");
			ARNewItemIDRegister(ARSetID("WeaponItemID","SwordYORUID",12559),"yoru");
			ARNewItemIDRegister(ARSetID("WeaponItemID","MultiToolK2ID",12560),"toolk2");

			ARNewItemIDRegister(ARSetID("ArmorItemID","BedrockHelmetItemID",12700),"bedrockhelmet");
			ARNewItemIDRegister(ARSetID("ArmorItemID","BedrockPlateItemID",12701),"bedrockplate");
			ARNewItemIDRegister(ARSetID("ArmorItemID","BedrockLegsItemID",12702),"bedrocklegs");
			ARNewItemIDRegister(ARSetID("ArmorItemID","BedrockBootsItemID",12703),"bedrockboots");
			ARNewItemIDRegister(ARSetID("ArmorItemID","AngelusHoodItemID",12704),"angelushood");
			ARNewItemIDRegister(ARSetID("ArmorItemID","AngelusVestmentItemID",12705),"angelusvestment");
			ARNewItemIDRegister(ARSetID("ArmorItemID","AngelusSkirtItemID",12706),"angelusskirt");
			ARNewItemIDRegister(ARSetID("ArmorItemID","AngelusBootsItemID",12707),"angelusboots");
			ARNewItemIDRegister(ARSetID("ArmorItemID","K2HelmetItemID",12708),"k2helmet");
			ARNewItemIDRegister(ARSetID("ArmorItemID","K2PlateItemID",12709),"k2plate");
			ARNewItemIDRegister(ARSetID("ArmorItemID","K2LegsItemID",12710),"k2legs");
			ARNewItemIDRegister(ARSetID("ArmorItemID","K2BootsItemID",12711),"k2boots");
			ARNewItemIDRegister(ARSetID("ArmorItemID","GluttonyHoodItemID",12712),"gluttonyhood");
			ARNewItemIDRegister(ARSetID("ArmorItemID","GluttonyVestmentItemID",12713),"gluttonyvestment");
			ARNewItemIDRegister(ARSetID("ArmorItemID","GluttonySkirtItemID",12714),"gluttonyskirt");
			ARNewItemIDRegister(ARSetID("ArmorItemID","GluttonyBootsItemID",12715),"gluttonyboots");

			ARNewItemIDRegister(ARSetID("DustItemID","DustNetherStarItemID",12600),"dustnetherstar");
			ARNewItemIDRegister(ARSetID("DustItemID","DustBedrockItemID",12601),"dustbedrock");
			ARNewItemIDRegister(ARSetID("DustItemID","DustExchangeIgnitionID",12602),"dustexchangeignition");
			ARNewItemIDRegister(ARSetID("DustItemID","DustUltimateExchangeIgnitionID",12603),"dustultimateexchangeignition");

			ARSmelting.put("RecycleTool",ARSet("Smelting","RecycleTool",true));
			ARSmelting.put("WoodTool",ARSet("Smelting","WoodTool",true));
			ARSmelting.put("StoneTool",ARSet("Smelting","StoneTool",true));
			ARSmelting.put("IronTool",ARSet("Smelting","IronTool",true));
			ARSmelting.put("GoldTool",ARSet("Smelting","GoldTool",true));
			ARSmelting.put("DiamondTool",ARSet("Smelting","DiamondTool",true));
			ARSmelting.put("Bow",ARSet("Smelting","Bow",true));
			ARSmelting.put("SteelTool",ARSet("Smelting","SteelTool",true));
			ARSmelting.put("InvarTool",ARSet("Smelting","InvarTool",true));

			ARSmelting.put("RecycleArmor",ARSet("Smelting","RecycleArmor",true));
			ARSmelting.put("ChainArmor",ARSet("Smelting","ChainArmor",true));
			ARSmelting.put("LeatherArmor",ARSet("Smelting","LeatherArmor",true));
			ARSmelting.put("IronArmor",ARSet("Smelting","IronArmor",true));
			ARSmelting.put("GoldArmor",ARSet("Smelting","GoldArmor",true));
			ARSmelting.put("DiamondArmor",ARSet("Smelting","DiamondArmor",true));
			ARSmelting.put("SteelArmor",ARSet("Smelting","SteelArmor",true));
			ARSmelting.put("InvarArmor",ARSet("Smelting","InvarArmor",true));

			ARSmelting.put("NetherBrick", ARSet("Smelting","NetherBrick",true,"Require StoneBrick"));
			ARSmelting.put("Netherrack", ARSet("Smelting","Netherrack",false,"Require Dirt"));
			ARSmelting.put("Leather", ARSet("Smelting","Leather",true,"Require RottenFlesh"));
			ARSmelting.put("GlowStoneDust", ARSet("Smelting","GlowStoneDust",false,"Require RedstoneDust"));
			ARSmelting.put("MinecartEmpty", ARSet("Smelting","MinecartEmpty",true));
			ARSmelting.put("IronDoor", ARSet("Smelting","IronDoor",true));
			ARSmelting.put("WoodDoor", ARSet("Smelting","WoodDoor",true));

			ARCrafting.put("EndPortal",ARSet("Crafting","EndPortal",false));
			ARCrafting.put("Ore",ARSet("Crafting","Ore",false));
			ARCrafting.put("Crystal",ARSet("Crafting","Crystal",true));
			ARCrafting.put("PinkSlimeBall",ARSet("Crafting","PinkSlimeBall",true));
			ARCrafting.put("Flour",ARSet("Crafting","Flour",true));
			ARCrafting.put("LinkModifer",ARSet("Crafting","LinkModifer",true));
			ARCrafting.put("Mushroom",ARSet("Crafting","Mushroom",true));
			ARCrafting.put("Piston",ARSet("Crafting","Piston",true));
			ARCrafting.put("Jewel",ARSet("Crafting","Jewel",true));
			ARCrafting.put("Skull",ARSet("Crafting","Skull",true));
			ARCrafting.put("Bedrock",ARSet("Crafting","Bedrock",false));
			ARCrafting.put("DragonEgg",ARSet("Crafting","DragonEgg",true));
			ARCrafting.put("NetherStar",ARSet("Crafting","NetherStar",true));
			ARCrafting.put("EnderPearl",ARSet("Crafting","EnderPearl",true));
			ARCrafting.put("PowerStone",ARSet("Crafting","PowerStone",true));
			ARCrafting.put("Grass",ARSet("Crafting","Grass",true));
			ARCrafting.put("Obsidian",ARSet("Crafting","Obsidian",false));
			ARCrafting.put("BlazeRod",ARSet("Crafting","BlazeRod",true));
			ARCrafting.put("BookOld",ARSet("Crafting","BookOld",true));
			ARCrafting.put("Cray",ARSet("Crafting","Cray",false));
			ARCrafting.put("Cactus",ARSet("Crafting","Cactus",false));
			ARCrafting.put("SlimeBall",ARSet("Crafting","SlimeBall",true));
			ARCrafting.put("ExpBottle",ARSet("Crafting","ExpBottle",true));
			ARCrafting.put("GlowStoneDust",ARSet("Crafting","GlowStoneDust",true));
			ARCrafting.put("Button",ARSet("Crafting","Button",true));

			ARCrafting.put("AlchemicItem",ARSet("AdditionalRecipe","AlchemicItem",true));
			ARCrafting.put("ExchangeIgnition",ARSet("AdditionalRecipe","ExchangeIgnition",true));
			ARCrafting.put("UltimateExchangeIgnition",ARSet("AdditionalRecipe","UltimateExchangeIgnition",true));
			ARCrafting.put("CheaperExchangeIgnition",ARSet("AdditionalRecipe","CheaperExchangeIgnition",true));
			ARCrafting.put("BlackRottenFlesh",ARSet("AdditionalRecipe","BlackRottenFlesh",true));
			ARCrafting.put("CraftingFurnace",ARSet("AdditionalRecipe","CraftingFurnace",false));
			ARCrafting.put("NightVisionTorch",ARSet("AdditionalRecipe","NightVisionTorch",true));
			ARCrafting.put("GravitationFeather",ARSet("AdditionalRecipe","GravitationFeather",true));
			ARCrafting.put("SuperGravitationFeather",ARSet("AdditionalRecipe","SuperGravitationFeather",false));
			ARCrafting.put("Mortar",ARSet("AdditionalRecipe","Mortar",true));
			ARCrafting.put("IronMortar",ARSet("AdditionalRecipe","IronMortar",true));
			ARCrafting.put("DiamondMortar",ARSet("AdditionalRecipe","DiamondMortar",true));
			ARCrafting.put("BedrockMortar",ARSet("AdditionalRecipe","BedrockMortar",true));
			ARCrafting.put("CirceForce",ARSet("AdditionalRecipe","CirceForce",true));
			ARCrafting.put("DustNetherStar",ARSet("AdditionalRecipe","DustNetherStar",false));
			ARCrafting.put("DustBedrock",ARSet("AdditionalRecipe","DustBedrock",false));
			ARCrafting.put("DustExchangeIgnition",ARSet("AdditionalRecipe","DustExchangeIgnition",true));
			ARCrafting.put("DustUltimateExchangeIgnition",ARSet("AdditionalRecipe","DustUltimateExchangeIgnition",true));
			ARCrafting.put("BedrockArmor",ARSet("AdditionalRecipe","BedrockArmor",true));
			ARCrafting.put("AngelusArmor",ARSet("AdditionalRecipe","AngelusArmor",true));
			ARCrafting.put("GluttonyArmor",ARSet("AdditionalRecipe","GluttonyArmor",true));
			ARCrafting.put("Weapons",ARSet("AdditionalRecipe","Weapons",true));
			ARCrafting.put("Exelector",ARSet("AdditionalRecipe","Exelector",true));
			ARCrafting.put("NIOH",ARSet("AdditionalRecipe","NIOH",true));
			ARCrafting.put("Evil Spear DAYO",ARSet("AdditionalRecipe","Evil Spear DAYO",false));
			ARCrafting.put("Villany Sword YORU",ARSet("AdditionalRecipe","Villany Sword YORU",false));
			ARCrafting.put("K2 Items",ARSet("AdditionalRecipe","K2 Items",true));
			ARCrafting.put("Multi-Tool K2",ARSet("AdditionalRecipe","Multi-Tool K2",true));
			ARCrafting.put("Mind-Armor K2",ARSet("AdditionalRecipe","Mind-Armor K2",true));

			ARCfgOther.put("DiamondMortar",ARSet("ItemDamage","DiamondMortar",1561));
			ARCfgOther.put("IromMortar",ARSet("ItemDamage","IromMortar",250));
			ARCfgOther.put("CheaperExchangeIgnition",ARSet("ItemDamage","CheaperExchangeIgnition",128));
			ARCfgOther.put("NIOH",ARSet("ItemDamage","NIOH",4));

			ARCfgOther.put("BedrockMortarDust",ARSet("MortarCrafting","BedrockMortarDust",8));
			ARCfgOther.put("DiamondMortar",ARSet("MortarCrafting","DiamondMortar",4));
			ARCfgOther.put("IronMortarDust",ARSet("MortarCrafting","IronMortarDust",2));

			ARCfgOther.put("ExelectorFirstExp",ARSet("Another","ExelectorFirstExp",100));
			ARCfgOther.put("ExelectorSecondExp",ARSet("Another","ExelectorSecondExp",250));
			ARCfgOther.put("ExelectorLastExp",ARSet("Another","ExelectorLastExp",500));
			ARCfgOther.put("ForceBallExperience",ARSet("Another","ForceBallExperience",25));
			ARCfgOther.put("Difficulty",ARSet("Another","Difficulty",0,"0=easy 1=normal 2=hard 3=lunatic 4=ultimate The others are easy."));

			ARAnother.put("ExpBottle",ARSet("OreDicitionary","ExpBottle",false));
			ARAnother.put("BuildCraft_Spring",ARSet("Dig","BuildCraft_Spring",true));
			ARAnother.put("EndPortal",ARSet("Dig","EndPortal",false));

			ARAnother.put("ConsoleOut",ARSet("Another","ConsoleOut",true));
			ARAnother.put("UltimateExchangeIgnitionEffect",ARSet("Another","UltimateExchangeIgnitionEffect",false));
			ARAnother.put("NIOHPreventDamage",ARSet("Another","NIOHPreventDamage",true));
			ARAnother.put("ARItemsBonusChest",ARSet("Another","ARItemsBonusChest",false));
			ARAnother.put("ForceBallSwingForExperience",ARSet("Another","ForceBallSwingForExperience",true));

			ARCrafting.put("CraftingOreDust",ARSet("MortarCrafting","CraftingOreDust",true));
			ARCrafting.put("CraftingIngotDust",ARSet("MortarCrafting","CraftingIngotDust",true));

			ARCrafting.put("DustIngot",ARSet("Crafting","DustIngot",false));
		}
		catch (Exception e)
		{
			ARLogger.logger.warning("Config Load Failure.");
			//FMLLog.log(Level.SEVERE, e, AdditionalRecipe.CONSOLE + "Config Load Failure.");
		}
		finally
		{
			cfg.save();
		}
	}
	private static boolean ARSet(String par1category,String par2key,boolean par3default,String par4comment)
	{
		Property prop = cfg.get(par1category, par2key, par3default);
		prop.comment  = par4comment;
		return prop.getBoolean(par3default);
	}
	private static boolean ARSet(String par1category,String par2key,boolean par3default)
	{
		Property prop = cfg.get(par1category, par2key, par3default);
		return prop.getBoolean(par3default);
	}
	private static int ARSet(String par1category,String par2key,int par3default,String par4comment)
	{
		Property prop = cfg.get(par1category, par2key, par3default);
		prop.comment  = par4comment;
		return prop.getInt();
	}
	private static int ARSet(String par1category,String par2key,int par3default)
	{
		Property prop = cfg.get(par1category, par2key, par3default);
		return prop.getInt();
	}
	private static int ARSetID(String par1category,String par2key,int par3defaultID,String par4comment)
	{
		Property prop = cfg.get(par1category, par2key, par3defaultID);
		prop.comment  = par4comment;
		return prop.getInt();
	}
	private static int ARSetID(String par1category,String par2key,int par3defaultID)
	{
		Property prop = cfg.get(par1category, par2key, par3defaultID);
		return prop.getInt();
	}
	public static boolean ARGetSmelting(String par1key,boolean par2default)
	{
		if(ARSmelting.containsKey(par1key))
		{
			return ARSmelting.get(par1key);
		}
		else
		{
			return par2default;
		}
	}
	public static boolean ARGetCrafting(String par1key,boolean par2default)
	{
		if(ARCrafting.containsKey(par1key))
		{
			return ARCrafting.get(par1key);
		}
		else
		{
			return par2default;
		}
	}
	public static int ARGetCfgOther(String par1key,int par2default)
	{
		if(ARCfgOther.containsKey(par1key))
		{
			return ARCfgOther.get(par1key);
		}
		else
		{
			return par2default;
		}
	}
	public static boolean ARGetAnother(String par1key,boolean par2default)
	{
		if(ARAnother.containsKey(par1key))
		{
			return ARAnother.get(par1key);
		}
		else
		{
			return par2default;
		}
	}
}
