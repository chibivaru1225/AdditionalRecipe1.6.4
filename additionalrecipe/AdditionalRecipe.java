package chibivaru.additionalrecipe;

import static chibivaru.additionalrecipe.common.ARConfiguration.*;
import static chibivaru.additionalrecipe.common.ARItemHandler.*;
import static chibivaru.additionalrecipe.common.ARModInfo.*;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import chibivaru.additionalrecipe.common.ARConfiguration;
import chibivaru.additionalrecipe.common.ARCreativeTab;
import chibivaru.additionalrecipe.common.ARLogger;
import chibivaru.additionalrecipe.event.ARAddChestGenHooks;
import chibivaru.additionalrecipe.event.ARFlyingEventHooks;
import chibivaru.additionalrecipe.event.ARNoFallDamageEventHooks;
import chibivaru.additionalrecipe.event.AngelusArmorLivingEventHooks;
import chibivaru.additionalrecipe.event.BedrockArmorLivingEventHooks;
import chibivaru.additionalrecipe.event.CirceForceEventHooks;
import chibivaru.additionalrecipe.event.GluttonyArmorLivingEventHooks;
import chibivaru.additionalrecipe.event.WeaponsEventHooks;
import chibivaru.additionalrecipe.recipe.RecipeHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(
		modid   = AdditionalRecipe.MODID,
		name    = AdditionalRecipe.MODNAME,
		version = AdditionalRecipe.VERSION,
		dependencies="after:Waila;"
				+ "after:AppliedEnergistics;"
				+ "after:GeoStrata;"
				+ "after:MineFactoryReloaded;"
				+ "after:MoreInventoryMod;"
				+ "after:ThermalExpansion;"
				+ "after:BuildCraftCore;"
				+ "after:Railcraft"
	)

@NetworkMod(
		clientSideRequired = true,
		serverSideRequired = false
	)

public class AdditionalRecipe {
	public static final String MODID   = "additionalrecipe";
	public static final String MODNAME = "AdditionalRecipe";
	public static final String VERSION = "2.03";

	@Metadata(MODID)
	public static ModMetadata meta;

	public static final CreativeTabs ARTabs = new ARCreativeTab("AdditionalRecipe");
	public static final String CONSOLE = "[AdditionalRecipe]:";
	public static final String ADDID = " added ID ";
	public static HashMap<String,Integer> ARItemID         = new HashMap<String,Integer>();
	public static HashMap<String,Item>    ARItem           = new HashMap<String,Item>();
	public static HashMap<String,Boolean> ARSmelting       = new HashMap<String,Boolean>();
	public static HashMap<String,Boolean> ARItemCrafting   = new HashMap<String,Boolean>();
	public static HashMap<String,Boolean> ARCrafting       = new HashMap<String,Boolean>();
	public static HashMap<String,Integer> ARCfgOther       = new HashMap<String,Integer>();
	public static HashMap<String,Boolean> ARAnother        = new HashMap<String,Boolean>();
	public static HashMap<String,Boolean> ARMortar         = new HashMap<String,Boolean>();
	public static int craftingDifficulty;
	public static RecipeHandler recipehandler;
	public static ARAddChestGenHooks addchestgenhooks;
	public static EnumArmorMaterial ARMOR_BEDROCK,ARMOR_PRIDE,ARMOR_WRATH,ARMOR_ENVY,ARMOR_SLOTH,ARMOR_AVARICE,ARMOR_GLUTTONY,ARMOR_LUST,ARMOR_ANGELUS,ARMOR_DRAGONE,ARMOR_NIGHTMARE;
	public static EnumToolMaterial WEAPON_ULTIMATE,WEAPON_BASIC,WEAPON_POOR,WEAPON_PHANTASM;
	public static String BEDROCK          = "bedrock";
	public static String PRIDE            = "pride";
	public static String WRATH            = "wrath";
	public static String ENVY             = "envy";
	public static String SLOTH            = "sloth";
	public static String AVARICE          = "avarice";
	public static String GLUTTONY         = "gluttony";
	public static String LUST             = "lust";
	public static String ANGELUS          = "angelus";
	public static String DRAGONE          = "dragone";
	public static String NIGHTMARE        = "nightmare";
	public static final int ARMOR_DEFAULT = 0;
	public static final int ARMOR_HELMET  = 0;
	public static final int ARMOR_PLATE   = 1;
	public static final int ARMOR_LEGS    = 2;
	public static final int ARMOR_BOOTS   = 3;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ARLogger.init(MODNAME);
		ARConfiguration.init(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		craftingDifficulty = ARGetCfgOther("Difficulty",0);
		if((craftingDifficulty < 0) && (4 < craftingDifficulty))
		{
			craftingDifficulty = 0;
		}

		ARMOR_BEDROCK   = EnumHelper.addArmorMaterial("BEDROCK"  , 1, new int[] {10,10,10,10},20);
		ARMOR_PRIDE     = EnumHelper.addArmorMaterial("PRIDE"    , 1, new int[] {15,15,15,15},30);
		ARMOR_WRATH     = EnumHelper.addArmorMaterial("WRATH"    , 1, new int[] {15,15,15,15},30);
		ARMOR_ENVY      = EnumHelper.addArmorMaterial("ENVY"     , 1, new int[] {15,15,15,15},30);
		ARMOR_SLOTH     = EnumHelper.addArmorMaterial("SLOTH"    , 1, new int[] {15,15,15,15},30);
		ARMOR_AVARICE   = EnumHelper.addArmorMaterial("AVARICE"  , 1, new int[] {15,15,15,15},30);
		ARMOR_GLUTTONY  = EnumHelper.addArmorMaterial("GLUTTONY" , 1, new int[] {15,15,15,15},30);
		ARMOR_LUST      = EnumHelper.addArmorMaterial("LUST"     , 1, new int[] {15,15,15,15},30);
		ARMOR_DRAGONE   = EnumHelper.addArmorMaterial("DRAGONE"  , 1, new int[] {20,20,20,20},40);
		ARMOR_NIGHTMARE = EnumHelper.addArmorMaterial("NIGHTMARE", 1, new int[] {30,30,30,30},40);
		ARMOR_ANGELUS   = EnumHelper.addArmorMaterial("ANGELUS"  , 1, new int[] {40,40,40,40},40);

		WEAPON_POOR     = EnumHelper.addToolMaterial("POOR"     , 2, 1, 6.0f, 0,  100);
		WEAPON_BASIC    = EnumHelper.addToolMaterial("BASIC"    , 3, 1, 6.0f, 5,  100);
		WEAPON_ULTIMATE = EnumHelper.addToolMaterial("ULTIMATE" , 4, 1, 6.0f, 15, 100);
		WEAPON_PHANTASM = EnumHelper.addToolMaterial("PHANTASM" , 4, 1, 6.0f, 95, 100);

		ARItemRegister();

		addchestgenhooks = new ARAddChestGenHooks();
		if(ARGetAnother("ARItemsBonusChest",true))
		{
			addchestgenhooks.AddChestItems();
		}

		loadInfo(meta);

		MinecraftForge.EVENT_BUS.register(new ARNoFallDamageEventHooks());
		MinecraftForge.EVENT_BUS.register(new ARFlyingEventHooks());
		MinecraftForge.EVENT_BUS.register(new BedrockArmorLivingEventHooks());
		MinecraftForge.EVENT_BUS.register(new AngelusArmorLivingEventHooks());
		MinecraftForge.EVENT_BUS.register(new GluttonyArmorLivingEventHooks());
		MinecraftForge.EVENT_BUS.register(new CirceForceEventHooks());
		MinecraftForge.EVENT_BUS.register(new WeaponsEventHooks());

		if(ARGetAnother("EndPortal",true))
		{
			Block.endPortalFrame.setHardness(60F);
		}
	}
	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
	{
		recipehandler = new RecipeHandler();
		recipehandler.oredic();
		recipehandler.init();
    }
	public static boolean equipArmor(int armorIDs[],EntityPlayer player)
	{
		if((player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem().itemID == armorIDs[AdditionalRecipe.ARMOR_HELMET]))
		{
			if((player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem().itemID == armorIDs[AdditionalRecipe.ARMOR_PLATE]))
			{
				if((player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem().itemID == armorIDs[AdditionalRecipe.ARMOR_LEGS]))
				{
					if((player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem().itemID == armorIDs[AdditionalRecipe.ARMOR_BOOTS]))
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean equipArmor(int armorID,EntityPlayer player,int armorType)
	{
		switch(armorType)
		{
			case ARMOR_HELMET:
			{
				return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem().itemID == armorID;
			}
			case ARMOR_PLATE:
			{
				return player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem().itemID == armorID;
			}
			case ARMOR_LEGS:
			{
				return player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem().itemID == armorID;
			}
			case ARMOR_BOOTS:
			{
				return player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem().itemID == armorID;
			}
		}
		return false;
	}
	public static boolean equipArmor(int par1HeadID,int par2PlateID,int par3LegID,int par4BootsID,EntityPlayer player)
	{
		if(player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem().itemID == par1HeadID)
		{
			if(player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem().itemID == par2PlateID)
			{
				if(player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem().itemID == par3LegID)
				{
					if(player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem().itemID == par4BootsID)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean equipArmor(int par1HeadID,int par2PlateID,int par3LegID,int par4BootsID,EntityPlayer par5Player,boolean par6Mode)
	{
		if((par5Player.inventory.armorItemInSlot(3) != null && par5Player.inventory.armorItemInSlot(3).getItem().itemID == par1HeadID))
		{
			return true;
		}
		else if((par5Player.inventory.armorItemInSlot(2) != null && par5Player.inventory.armorItemInSlot(2).getItem().itemID == par2PlateID))
		{
			return true;
		}
		else if((par5Player.inventory.armorItemInSlot(1) != null && par5Player.inventory.armorItemInSlot(1).getItem().itemID == par3LegID))
		{
			return true;
		}
		else if((par5Player.inventory.armorItemInSlot(0) != null && par5Player.inventory.armorItemInSlot(0).getItem().itemID == par4BootsID))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean hasItem(int itemID,EntityPlayer player)
	{
		return player.inventory.hasItem(itemID);
	}
}