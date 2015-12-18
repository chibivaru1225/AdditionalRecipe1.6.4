package chibivaru.additionalrecipe.common;

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

			ARNewItemIDRegister(ARSetID("WeaponItemID","DustNetherStarItemID",12600),"dustnetherstar");
			ARNewItemIDRegister(ARSetID("WeaponItemID","DustBedrockItemID",12601),"dustbedrock");
			ARNewItemIDRegister(ARSetID("WeaponItemID","DustExchangeIgnitionID",12602),"dustexchangeignition");
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
}
