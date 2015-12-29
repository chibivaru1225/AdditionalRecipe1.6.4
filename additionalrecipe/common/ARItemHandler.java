package chibivaru.additionalrecipe.common;

import static chibivaru.additionalrecipe.AdditionalRecipe.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.EnumChatFormatting;
import chibivaru.additionalrecipe.armor.AngelusArmor;
import chibivaru.additionalrecipe.armor.BedrockArmor;
import chibivaru.additionalrecipe.armor.GluttonyArmor;
import chibivaru.additionalrecipe.armor.K2Armor;
import chibivaru.additionalrecipe.dust.DustBedrock;
import chibivaru.additionalrecipe.dust.DustExchangeIgnition;
import chibivaru.additionalrecipe.dust.DustNetherStar;
import chibivaru.additionalrecipe.dust.DustUltimateExchangeIgnition;
import chibivaru.additionalrecipe.item.BlackRottenFlesh;
import chibivaru.additionalrecipe.item.CirceForce;
import chibivaru.additionalrecipe.item.ForceBall;
import chibivaru.additionalrecipe.item.GravitationFeather;
import chibivaru.additionalrecipe.item.NightVisionTorch;
import chibivaru.additionalrecipe.item.SuperGravitationFeather;
import chibivaru.additionalrecipe.tools.BedrockMortar;
import chibivaru.additionalrecipe.tools.CheaperExchangeIgnition;
import chibivaru.additionalrecipe.tools.CraftingFurnace;
import chibivaru.additionalrecipe.tools.DiamondMortar;
import chibivaru.additionalrecipe.tools.ExchangeIgnition;
import chibivaru.additionalrecipe.tools.IronMortar;
import chibivaru.additionalrecipe.tools.UltimateExchangeIgnition;
import chibivaru.additionalrecipe.weapons.BladeNIOH;
import chibivaru.additionalrecipe.weapons.MultiK2;
import chibivaru.additionalrecipe.weapons.SpearDAYO;
import chibivaru.additionalrecipe.weapons.SwordExelector;
import chibivaru.additionalrecipe.weapons.SwordYORU;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ARItemHandler
{
	public static void ARItemRegister()
	{
		ARNewItemRegister(new BedrockMortar(ARGetItemIDRegister("bedrockmortar") - 256), "bedrockmortar", ARTabs, "BedrockMortar");
		ARNewItemRegister(new DiamondMortar(ARGetItemIDRegister("diamondmortar") - 256), "diamondmortar", ARTabs, "DiamondMortar");
		ARNewItemRegister(new IronMortar(ARGetItemIDRegister("ironmortar") - 256), "ironmortar", ARTabs, "IronMortar");
		ARNewItemRegister(new ExchangeIgnition(ARGetItemIDRegister("exchangeiginiton") - 256), "exchangeiginiton", ARTabs, "ExchangeIgnition");
		ARNewItemRegister(new UltimateExchangeIgnition(ARGetItemIDRegister("ultimateexchangeiginiton") - 256), "ultimateexchangeiginiton", ARTabs, "UltimateExchangeIgnition");
		ARNewItemRegister(new CheaperExchangeIgnition(ARGetItemIDRegister("cheaperexchangeiginiton") - 256), "cheaperexchangeiginiton", ARTabs, "CheaperExchangeIgnition");
		ARNewItemRegister(new CraftingFurnace(ARGetItemIDRegister("craftingfurnace") - 256), "craftingfurnace",ARTabs, "CraftingFurnace");
		ARNewItemRegister(new GravitationFeather(ARGetItemIDRegister("gravitationfeather") - 256), "gravitationfeather", ARTabs, "GravitationFeather");
		ARNewItemRegister(new SuperGravitationFeather(ARGetItemIDRegister("supergravitationfeather") - 256), "supergravitationfeather" , ARTabs, "SuperGravitationFeather");
		ARNewItemRegister(new BlackRottenFlesh(ARGetItemIDRegister("blackrottenflesh") - 256), "blackrottenflesh", ARTabs, "BlackRottenFlesh");
		ARNewItemRegister(new NightVisionTorch(ARGetItemIDRegister("nightvisiontorch") - 256), "nightvisiontorch", ARTabs, "NightVisionTorch");
		ARNewItemRegister(new ForceBall(ARGetItemIDRegister("forceball") - 256), "forceball", ARTabs, "ForceBall");
		ARNewItemRegister(new CirceForce(ARGetItemIDRegister("circeforce") - 256), "circeforce", ARTabs, "CirceForce");

		ARNewItemRegister(new SwordExelector(ARGetItemIDRegister("exelector") - 256, WEAPON_POOR), "exelector", ARTabs, "Exelector",new StringBuilder().append(EnumChatFormatting.WHITE).append("Exelector").toString());
		ARNewItemRegister(new BladeNIOH(ARGetItemIDRegister("nioh") - 256, WEAPON_PHANTASM), "nioh", ARTabs, "NIOH");
		ARNewItemRegister(new SwordYORU(ARGetItemIDRegister("yoru") - 256, WEAPON_ULTIMATE), "yoru", ARTabs, "Villainy Sword 'YORU'","ja_JP","邪剣「夜」");
		ARNewItemRegister(new SpearDAYO(ARGetItemIDRegister("dayo") - 256, WEAPON_ULTIMATE), "dayo", ARTabs, "Evil Spear 'DAYO'","ja_JP","悪槍「堕那」");
		ARNewItemRegister(new MultiK2(ARGetItemIDRegister("toolk2") - 256, WEAPON_POOR), "toolk2", ARTabs, "K2",new StringBuilder().append(EnumChatFormatting.LIGHT_PURPLE).append("K2's Multi-Weapon").toString());

		ARNewItemRegister(new BedrockArmor(ARGetItemIDRegister("bedrockhelmet") - 256, ARMOR_BEDROCK, ARMOR_DEFAULT, ARMOR_HELMET, BEDROCK), "bedrockhelmet", ARTabs, "BedrockHelmet", "additionalrecipe:bedrockhelmet" ,ARMOR_HELMET);
		ARNewItemRegister(new BedrockArmor(ARGetItemIDRegister("bedrockplate") - 256, ARMOR_BEDROCK, ARMOR_DEFAULT, ARMOR_PLATE, BEDROCK), "bedrockplate", ARTabs, "BedrockChestplate", "additionalrecipe:bedrockplate" ,ARMOR_PLATE);
		ARNewItemRegister(new BedrockArmor(ARGetItemIDRegister("bedrocklegs") - 256, ARMOR_BEDROCK, ARMOR_DEFAULT, ARMOR_LEGS, BEDROCK), "bedrocklegs", ARTabs, "BedrockLeggings", "additionalrecipe:bedrocklegs" ,ARMOR_LEGS);
		ARNewItemRegister(new BedrockArmor(ARGetItemIDRegister("bedrockboots") - 256, ARMOR_BEDROCK, ARMOR_DEFAULT, ARMOR_BOOTS, BEDROCK), "bedrockboots", ARTabs, "BedrockBoots", "additionalrecipe:bedrockboots" ,ARMOR_BOOTS);
		ARNewItemRegister(new AngelusArmor(ARGetItemIDRegister("angelushood") - 256, ARMOR_ANGELUS, ARMOR_DEFAULT, ARMOR_HELMET, ANGELUS), "angelushood", ARTabs, "AngelusHood", "additionalrecipe:angelushood" ,ARMOR_HELMET);
		ARNewItemRegister(new AngelusArmor(ARGetItemIDRegister("angelusvestment") - 256, ARMOR_ANGELUS, ARMOR_DEFAULT, ARMOR_PLATE, ANGELUS), "angelusvestment", ARTabs, "AngelusVestment", "additionalrecipe:angelusvestment" ,ARMOR_PLATE);
		ARNewItemRegister(new AngelusArmor(ARGetItemIDRegister("angelusskirt") - 256, ARMOR_ANGELUS, ARMOR_DEFAULT, ARMOR_LEGS, ANGELUS), "angelusskirt", ARTabs, "AngelusSkirt", "additionalrecipe:angelusskirt" ,ARMOR_LEGS);
		ARNewItemRegister(new AngelusArmor(ARGetItemIDRegister("angelusboots") - 256, ARMOR_ANGELUS, ARMOR_DEFAULT, ARMOR_BOOTS, ANGELUS), "angelusboots", ARTabs, "AngelusBoots", "additionalrecipe:angelusboots" ,ARMOR_BOOTS);
		ARNewItemRegister(new GluttonyArmor(ARGetItemIDRegister("gluttonyhood") - 256, ARMOR_GLUTTONY, ARMOR_DEFAULT, ARMOR_HELMET, GLUTTONY), "gluttonyhood", ARTabs, "GluttonyHood", "additionalrecipe:gluttonyhood" ,ARMOR_HELMET);
		ARNewItemRegister(new GluttonyArmor(ARGetItemIDRegister("gluttonyvestment") - 256, ARMOR_GLUTTONY, ARMOR_DEFAULT, ARMOR_PLATE, GLUTTONY), "gluttonyvestment", ARTabs, "GluttonyVestment", "additionalrecipe:gluttonyvestment" ,ARMOR_PLATE);
		ARNewItemRegister(new GluttonyArmor(ARGetItemIDRegister("gluttonyskirt") - 256, ARMOR_GLUTTONY, ARMOR_DEFAULT, ARMOR_LEGS, GLUTTONY), "gluttonyskirt", ARTabs, "GluttonySkirt", "additionalrecipe:gluttonyskirt" ,ARMOR_LEGS);
		ARNewItemRegister(new GluttonyArmor(ARGetItemIDRegister("gluttonyboots") - 256, ARMOR_GLUTTONY, ARMOR_DEFAULT, ARMOR_BOOTS, GLUTTONY), "gluttonyboots", ARTabs, "GluttonyBoots", "additionalrecipe:gluttonyboots" ,ARMOR_BOOTS);
		ARNewItemRegister(new K2Armor(ARGetItemIDRegister("k2helmet") - 256, ARMOR_K2, ARMOR_DEFAULT, ARMOR_HELMET, K2), "k2helmet", ARTabs, "K2Helmet", "additionalrecipe:k2helmet" ,ARMOR_HELMET);
		ARNewItemRegister(new K2Armor(ARGetItemIDRegister("k2plate") - 256, ARMOR_K2, ARMOR_DEFAULT, ARMOR_PLATE, K2), "k2plate", ARTabs, "K2Chestplate", "additionalrecipe:k2plate" ,ARMOR_PLATE);
		ARNewItemRegister(new K2Armor(ARGetItemIDRegister("k2legs") - 256, ARMOR_K2, ARMOR_DEFAULT, ARMOR_LEGS, K2), "k2legs", ARTabs, "K2Leggings", "additionalrecipe:k2legs" ,ARMOR_LEGS);
		ARNewItemRegister(new K2Armor(ARGetItemIDRegister("k2boots") - 256, ARMOR_K2, ARMOR_DEFAULT, ARMOR_BOOTS, K2), "k2boots", ARTabs, "K2Boots", "additionalrecipe:k2boots" ,ARMOR_BOOTS);

		ARNewItemRegister(new DustNetherStar(ARGetItemIDRegister("dustnetherstar") - 256), "dustnetherstar", ARTabs, "DustNetherStar");
		ARNewItemRegister(new DustBedrock(ARGetItemIDRegister("dustbedrock") - 256), "dustbedrock", ARTabs, "DustBedrock");
		ARNewItemRegister(new DustExchangeIgnition(ARGetItemIDRegister("dustexchangeignition") - 256), "dustexchangeignition", ARTabs, "DustExchangeIgnition");
		ARNewItemRegister(new DustUltimateExchangeIgnition(ARGetItemIDRegister("dustultimateexchangeignition") - 256), "dustultimateexchangeignition", ARTabs, "DustUltimateExchangeIgnition");
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
	public static void ARNewItemRegister(Item par1Item,String par2UnlocalizedName,CreativeTabs par3CreativeTab,String par4Name,String par5TextureName,int par6ArmorType)
	{
		par1Item.setUnlocalizedName(par2UnlocalizedName);
		par1Item.setCreativeTab(par3CreativeTab);
		par1Item.setTextureName(par5TextureName);
		ARItem.put(par2UnlocalizedName, par1Item);
		GameRegistry.registerItem(par1Item, par4Name);
		LanguageRegistry.addName(par1Item, par4Name);
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
