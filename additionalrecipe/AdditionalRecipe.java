package chibivaru.additionalrecipe;

import static chibivaru.additionalrecipe.common.ARItemHandler.*;
import static chibivaru.additionalrecipe.common.ARModInfo.*;

import java.util.HashMap;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import chibivaru.additionalrecipe.common.ARConfiguration;
import chibivaru.additionalrecipe.common.ARCreativeTab;
import chibivaru.additionalrecipe.common.ARLogger;
import chibivaru.additionalrecipe.event.ARAddChestGenHooks;
import chibivaru.additionalrecipe.event.ARFlyingEventHooks;
import chibivaru.additionalrecipe.event.ARNoFallDamageEventHooks;
import chibivaru.additionalrecipe.event.AngelusArmorLivingEventHooks;
import chibivaru.additionalrecipe.event.BedrockArmorLivingEventHooks;
import chibivaru.additionalrecipe.event.CirceForceEventHooks;
import chibivaru.additionalrecipe.event.WeaponsEventHooks;
import chibivaru.additionalrecipe.recipe.RecipeHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
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
	public static final String VERSION = "2.02";

	@Metadata(MODID)
	public static ModMetadata meta;

	public static final CreativeTabs ARTabs = new ARCreativeTab("AdditionalRecipe");
	public static final String CONSOLE = "[AdditionalRecipe]:";
	public static final String ADDID = " added ID ";
	public static HashMap<String,Integer> ARItemID     = new HashMap<String,Integer>();
	public static HashMap<String,Item>    ARItem       = new HashMap<String,Item>();
	public static HashMap<String,Boolean> ARSmelting   = new HashMap<String,Boolean>();
	public static HashMap<String,Boolean> ARCrafting   = new HashMap<String,Boolean>();
	public static int armorSlothHoodID,armorSlothVestmentID,armorSlothSkirtID,armorSlothBootsID;
	public static int diamondMortarDamage,iromMortarDamage,bladeNIOHDamage;
	public static int cheaperExchangeIgnitionDamage;
	public static int bedrockMortarCrafting;
	public static int diamondMortarCrafting;
	public static int ironMortarCrafting;
	public static int craftingDifficulty,exelectorFirstExp,exelectorSecondExp,exelectorLastExp;
	public static int textureIronMortar,textureDiamondMortar,textureBedrockMortar;
	public static boolean craftingCrystal,mortarOreDust,mortarIngotDust,furnaceDustIngot,craftingOre,digBCSpring,digEndPortal,craftingEndPortal,craftingPinkSlimeBall,craftingFlour,craftingLinkModifer;
	public static boolean smeltingNetherBrick,smeltingNetherrack,smeltingLeather,smeltingGlowStoneDust;
	public static boolean smeltingMinecartEmpty,smeltingIronDoor,smeltingWoodDoor;
	public static boolean craftingAlchemic,craftingExchangeIgnition,craftingUltimateExchangeIgnition,craftingDustExchangeIgnition,craftingCheaperExchangeIgnition;
	public static boolean craftingCraftingFurnace,craftingBlackRottenFlesh,craftingNightVisionTorch,craftingGravitationFeather,craftingSuperGravitationFeather,craftingCirceForce;
	public static boolean craftingMortar,craftingIronMortar,craftingDiamondMortar,craftingBedrockMortar,craftingDustNetherStar,craftingDustBedrock;
	public static boolean craftingBedrockArmor,craftingAngelusArmor;
	public static boolean craftingWeapons,craftingExelector,craftingNIOH,craftingDAYO,craftingYORU,craftingItemsK2,craftingMultiK2;
	public static boolean craftingMushroom,craftingPiston,craftingJewel,craftingSkull,craftingBedrock,craftingDragonEgg,craftingNetherStar,craftingExpBottle;
	public static boolean craftingEnderPearl,craftingPowerStone,craftingGrass,craftingObsidian,craftingBlazeRod,craftingBookOld,craftingCray,craftingCactus,craftingSlimeBall,craftingGlowStoneDust,craftingButton;
	public static boolean addOreDicExpBottle;
	public static boolean consoleOut,ultimateExchangeIgnitionEffect,bladeNIOHPreventDamage;
	public static RecipeHandler recipehandler;
	public static ARAddChestGenHooks addchestgenhooks;
	public static EnumArmorMaterial ARMOR_BEDROCK,ARMOR_PRIDE,ARMOR_WRATH,ARMOR_ENVY,ARMOR_SLOTH,ARMOR_AVARICE,ARMOR_GLUTTONY,ARMOR_LUST,ARMOR_ANGELUS;
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
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			cfg.load();

			Property DiamondMortarDamageProp              = cfg.get("ItemDamage"         ,"DiamondMortar"                   ,1561);
			Property IromMortarDamageProp                 = cfg.get("ItemDamage"         ,"IromMortar"                      ,250);
			Property CheaperExchangeIgnitionDamageProp    = cfg.get("ItemDamage"         ,"CheaperExchangeIgnition"         ,128);
			Property BladeNIOHDamageProp                  = cfg.get("ItemDamage"         ,"NIOH"                            ,4);

			Property SmeltingNetherBrickProp              = cfg.get("Smelting"           ,"NetherBrick"                     ,true);
			Property SmeltingNetherrackProp               = cfg.get("Smelting"           ,"Netherrack"                      ,false);
			Property SmeltingLeatherProp                  = cfg.get("Smelting"           ,"Leather"                         ,true);
			Property SmeltingGlowStoneDustProp            = cfg.get("Smelting"           ,"GlowStoneDust"                   ,false);

			Property SmeltingMinecartEmptyProp            = cfg.get("Smelting"           ,"MinecartEmpty"                   ,true);
			Property SmeltingIronDoorProp                 = cfg.get("Smelting"           ,"IronDoor"                        ,true);
			Property SmeltingWoodDoorProp                 = cfg.get("Smelting"           ,"WoodDoor"                        ,true);

			Property MortarOreDustProp                    = cfg.get("MortarCrafting"     ,"CraftingOreDust"                 ,true);
			Property MortarIngotDustProp                  = cfg.get("MortarCrafting"     ,"CraftingIngotDust"               ,true);

			Property FurnaceDustIngotProp                 = cfg.get("FurnaceCrafting"    ,"DustIngot"                       ,false);

			Property AddOreDicExpBottleProp               = cfg.get("OreDicitionary"     ,"ExpBottle"                       ,false);

			Property CraftingEndPortalProp                = cfg.get("Crafting"           ,"EndPortal"                       ,false);
			Property CraftingOreProp                      = cfg.get("Crafting"           ,"Ore"                             ,false);
			Property CraftingCrystalProp                  = cfg.get("Crafting"           ,"Crystal"                         ,true);
			Property CraftingPinkSlimeBallProp            = cfg.get("Crafting"           ,"PinkSlimeBall"                   ,true);
			Property CraftingFlourProp                    = cfg.get("Crafting"           ,"Flour"                           ,true);
			Property CraftingLinkModiferProp              = cfg.get("Crafting"           ,"LinkModifer"                     ,true);
			Property CraftingMushroomProp                 = cfg.get("Crafting"           ,"Mushroom"                        ,true);
			Property CraftingPistonProp                   = cfg.get("Crafting"           ,"Piston"                          ,true);
			Property CraftingJewelProp                    = cfg.get("Crafting"           ,"Jewel"                           ,true);
			Property CraftingSkullProp                    = cfg.get("Crafting"           ,"Skull"                           ,true);
			Property CraftingBedrockProp                  = cfg.get("Crafting"           ,"Bedrock"                         ,false);
			Property CraftingDragonEggProp                = cfg.get("Crafting"           ,"DragonEgg"                       ,true);
			Property CraftingNetherStarProp               = cfg.get("Crafting"           ,"NetherStar"                      ,true);
			Property CraftingEnderPearlProp               = cfg.get("Crafting"           ,"EnderPearl"                      ,true);
			Property CraftingPowerStoneProp               = cfg.get("Crafting"           ,"PowerStone"                      ,true);
			Property CraftingGrassProp                    = cfg.get("Crafting"           ,"Grass"                           ,true);
			Property CraftingObsidianProp                 = cfg.get("Crafting"           ,"Obsidian"                        ,false);
			Property CraftingBlazeRodProp                 = cfg.get("Crafting"           ,"BlazeRod"                        ,true);
			Property CraftingBookOldProp                  = cfg.get("Crafting"           ,"BookOld"                         ,true);
			Property CraftingCrayProp                     = cfg.get("Crafting"           ,"Cray"                            ,false);
			Property CraftingCactusProp                   = cfg.get("Crafting"           ,"Cactus"                          ,false);
			Property CraftingSlimeBallProp                = cfg.get("Crafting"           ,"SlimeBall"                       ,true);
			Property CraftingExpBottleProp                = cfg.get("Crafting"           ,"ExpBottle"                       ,true);
			Property CraftingGlowStoneDustProp            = cfg.get("Crafting"           ,"GlowStoneDust"                   ,true);
			Property CraftingButtonProp                   = cfg.get("Crafting"           ,"Button"                          ,true);

			Property BedrockMortarCraftingProp            = cfg.get("MortarCrafting"     ,"BedrockMortarDust"               ,8);
			Property DiamondMortarCraftingProp            = cfg.get("MortarCrafting"     ,"DiamondMortarDust"               ,4);
			Property IronMortarCraftingProp               = cfg.get("MortarCrafting"     ,"IronMortarDust"                  ,2);

			Property DigBCSpringProp                      = cfg.get("Dig"                ,"BuildCraft_Spring"               ,true);
			Property DigEndPortalProp                     = cfg.get("Dig"                ,"EndPortal"                       ,false);

			Property TextureIronMortarProp                = cfg.get("Texture"            ,"IronMortal"                      ,0x777777);
			Property TextureDiamondMortarProp             = cfg.get("Texture"            ,"DiamondMortal"                   ,0x8888FF);
			Property TextureBedrockMortarProp             = cfg.get("Texture"            ,"BedrockMortal"                   ,0x666666);

			Property CraftingAlchemicProp                 = cfg.get("AdditionalRecipe"   ,"AlchemicItem"                    ,true);
			Property CraftingExchangeIgnitionProp         = cfg.get("AdditionalRecipe"   ,"ExchangeIgnition"                ,true);
			Property CraftingDustExchangeIgnitionProp     = cfg.get("AdditionalRecipe"   ,"DustExchangeIgnition"            ,true);
			Property CraftingUltimateExchangeIgnitionProp = cfg.get("AdditionalRecipe"   ,"UltimateExchangeIgnition"        ,false);
			Property CraftingCheaperExchangeIgnitionProp  = cfg.get("AdditionalRecipe"   ,"CheaperExchangeIgnition"         ,true);
			Property CraftingBlackRottenFleshProp         = cfg.get("AdditionalRecipe"   ,"BlackRottenFlesh"                ,true);
			Property CraftingCraftingFurnaceProp          = cfg.get("AdditionalRecipe"   ,"CraftingFurnace"                 ,false);
			Property CraftingNightVisionTorchProp         = cfg.get("AdditionalRecipe"   ,"NightVisionTorch"                ,true);
			Property CraftingGravitationFeatherProp       = cfg.get("AdditionalRecipe"   ,"GravitationFeather"              ,true);
			Property CraftingSuperGravitationFeatherProp  = cfg.get("AdditionalRecipe"   ,"SuperGravitationFeather"         ,false);
			Property CraftingMortarProp                   = cfg.get("AdditionalRecipe"   ,"Mortar"                          ,true);
			Property CraftingIronMortarProp               = cfg.get("AdditionalRecipe"   ,"IronMortar"                      ,true);
			Property CraftingDiamondMortarProp            = cfg.get("AdditionalRecipe"   ,"DiamondMortar"                   ,true);
			Property CraftingBedrockMortarProp            = cfg.get("AdditionalRecipe"   ,"BedrockMortar"                   ,true);
			Property CraftingCirceForceProp               = cfg.get("AdditionalRecipe"   ,"CirceForce"                      ,false);
			Property CraftingDustNetherStarProp           = cfg.get("AdditionalRecipe"   ,"DustNetherStar"                  ,false);
			Property CraftingDustBedrockProp              = cfg.get("AdditionalRecipe"   ,"DustBedrock"                     ,false);
			Property CraftingBedrockArmorProp             = cfg.get("AdditionalRecipe"   ,"BedrockArmor"                    ,true);
			Property CraftingAngelusArmorProp             = cfg.get("AdditionalRecipe"   ,"AngelusArmor"                    ,true);
			Property CraftingWeaponsProp                  = cfg.get("AdditionalRecipe"   ,"Weapons"                         ,true);
			Property CraftigExelectorProp                 = cfg.get("AdditionalRecipe"   ,"Exelector"                       ,true);
			Property CraftingNIOHProp                     = cfg.get("AdditionalRecipe"   ,"NIOH"                            ,true);
			Property CraftingDAYOProp                     = cfg.get("AdditionalRecipe"   ,"Evil Spear DAYO"                 ,true);
			Property CraftingYORUProp                     = cfg.get("AdditionalRecipe"   ,"Villany Sword YORU"              ,true);
			Property CraftingItemsK2Prop                  = cfg.get("AdditionalRecipe"   ,"K2 Items"                        ,true);
			Property CraftingMultiK2Prop                  = cfg.get("AdditionalRecipe"   ,"Multi-Tool K2"                   ,true);

			Property ConsoleOutProp                       = cfg.get("Another"            ,"ConsoleOut"                      ,true);
			Property UltimateExchangeIgnitionEffectProp   = cfg.get("Another"            ,"UltimateExchangeIgnitionEffect"  ,false);
			Property BladeNIOHPreventDamageProp           = cfg.get("Another"            ,"NIOHPreventDamage"               ,true);
			Property ExelectorFirstExpProp                = cfg.get("Another"            ,"Exelector First-Lv Exp"          ,100);
			Property ExelectorSecondExpProp               = cfg.get("Another"            ,"Exelector Second-Lv Exp"         ,250);
			Property ExelectorLastExpProp                 = cfg.get("Another"            ,"Exelector Last-Lv Exp"           ,500);
			Property CraftingDifficultyProp               = cfg.get("Another"            ,"Difficulty"                      ,0);

			SmeltingNetherBrickProp.comment               = "Require StoneBrick";
			SmeltingNetherrackProp.comment                = "Require Dirt";
			SmeltingLeatherProp.comment                   = "Require RottenFlesh";
			SmeltingGlowStoneDustProp.comment             = "Require RedstoneDust";

			CraftingDifficultyProp.comment                = "0=easy 1=normal 2=hard 3=lunatic 4=ultimate The others are easy.";
			CraftingCrystalProp.comment                   = "crystals with Geostrata.";
			CraftingPinkSlimeBallProp.comment             = "PinkSlimeBall with MineFactoryReloaded.";
			CraftingFlourProp.comment                     = "Flour with AppliedEnergistics.";
			CraftingLinkModiferProp.comment               = "Link Modifer with MystCraft.";
			CraftingPistonProp.comment                    = "It's possible to use bronze, invar and steel to make a piston.";

			diamondMortarDamage                           = DiamondMortarDamageProp.getInt();
			iromMortarDamage                              = IromMortarDamageProp.getInt();
			cheaperExchangeIgnitionDamage                 = CheaperExchangeIgnitionDamageProp.getInt();
			bladeNIOHDamage                               = BladeNIOHDamageProp.getInt();

			smeltingNetherBrick                           = SmeltingNetherBrickProp.getBoolean(true);
			smeltingNetherrack                            = SmeltingNetherrackProp.getBoolean(false);
			smeltingLeather                               = SmeltingLeatherProp.getBoolean(true);
			smeltingGlowStoneDust                         = SmeltingGlowStoneDustProp.getBoolean(false);

			smeltingMinecartEmpty                         = SmeltingMinecartEmptyProp.getBoolean(true);
			smeltingIronDoor                              = SmeltingIronDoorProp.getBoolean(true);
			smeltingWoodDoor                              = SmeltingWoodDoorProp.getBoolean(true);

			addOreDicExpBottle                            = AddOreDicExpBottleProp.getBoolean(false);

			furnaceDustIngot                              = FurnaceDustIngotProp.getBoolean(true);

			craftingEndPortal                             = CraftingEndPortalProp.getBoolean(false);
			craftingOre                                   = CraftingOreProp.getBoolean(true);
			craftingDifficulty                            = CraftingDifficultyProp.getInt();
			craftingCrystal                               = CraftingCrystalProp.getBoolean(true);
			craftingPinkSlimeBall                         = CraftingPinkSlimeBallProp.getBoolean(true);
			craftingFlour                                 = CraftingFlourProp.getBoolean(true);
			craftingLinkModifer                           = CraftingLinkModiferProp.getBoolean(true);
			craftingMushroom                              = CraftingMushroomProp.getBoolean(true);
			craftingPiston                                = CraftingPistonProp.getBoolean(true);
			craftingJewel                                 = CraftingJewelProp.getBoolean(true);
			craftingSkull                                 = CraftingSkullProp.getBoolean(true);
			craftingBedrock                               = CraftingBedrockProp.getBoolean(false);
			craftingDragonEgg                             = CraftingDragonEggProp.getBoolean(true);
			craftingNetherStar                            = CraftingNetherStarProp.getBoolean(true);
			craftingEnderPearl                            = CraftingEnderPearlProp.getBoolean(true);
			craftingPowerStone                            = CraftingPowerStoneProp.getBoolean(true);
			craftingGrass                                 = CraftingGrassProp.getBoolean(true);
			craftingObsidian                              = CraftingObsidianProp.getBoolean(false);
			craftingBlazeRod                              = CraftingBlazeRodProp.getBoolean(true);
			craftingBookOld                               = CraftingBookOldProp.getBoolean(true);
			craftingCray                                  = CraftingCrayProp.getBoolean(false);
			craftingCactus                                = CraftingCactusProp.getBoolean(false);
			craftingSlimeBall                             = CraftingSlimeBallProp.getBoolean(true);
			craftingExpBottle                             = CraftingExpBottleProp.getBoolean(true);
			craftingGlowStoneDust                         = CraftingGlowStoneDustProp.getBoolean(true);
			craftingButton                                = CraftingButtonProp.getBoolean(true);

			mortarOreDust                                 = MortarOreDustProp.getBoolean(true);
			mortarIngotDust                               = MortarIngotDustProp.getBoolean(true);

			bedrockMortarCrafting                         = BedrockMortarCraftingProp.getInt();
			diamondMortarCrafting                         = DiamondMortarCraftingProp.getInt();
			ironMortarCrafting                            = IronMortarCraftingProp.getInt();

			exelectorFirstExp                             = ExelectorFirstExpProp.getInt();
			exelectorSecondExp                            = ExelectorSecondExpProp.getInt();
			exelectorLastExp                              = ExelectorLastExpProp.getInt();

			digBCSpring                                   = DigBCSpringProp.getBoolean(true);
			digEndPortal                                  = DigEndPortalProp.getBoolean(false);

			textureIronMortar                             = TextureIronMortarProp.getInt();
			textureDiamondMortar                          = TextureDiamondMortarProp.getInt();
			textureBedrockMortar                          = TextureBedrockMortarProp.getInt();

			craftingAlchemic                              = CraftingAlchemicProp.getBoolean(true);
			craftingExchangeIgnition                      = CraftingExchangeIgnitionProp.getBoolean(true);
			craftingDustExchangeIgnition                  = CraftingDustExchangeIgnitionProp.getBoolean(true);
			craftingUltimateExchangeIgnition              = CraftingUltimateExchangeIgnitionProp.getBoolean(false);
			craftingCheaperExchangeIgnition               = CraftingCheaperExchangeIgnitionProp.getBoolean(true);
			craftingBlackRottenFlesh                      = CraftingBlackRottenFleshProp.getBoolean(true);
			craftingCraftingFurnace                       = CraftingCraftingFurnaceProp.getBoolean(false);
			craftingNightVisionTorch                      = CraftingNightVisionTorchProp.getBoolean(true);
			craftingGravitationFeather                    = CraftingGravitationFeatherProp.getBoolean(true);
			craftingSuperGravitationFeather               = CraftingSuperGravitationFeatherProp.getBoolean(false);
			craftingMortar                                = CraftingMortarProp.getBoolean(true);
			craftingIronMortar                            = CraftingIronMortarProp.getBoolean(true);
			craftingDiamondMortar                         = CraftingDiamondMortarProp.getBoolean(true);
			craftingBedrockMortar                         = CraftingBedrockMortarProp.getBoolean(true);
			craftingCirceForce                            = CraftingCirceForceProp.getBoolean(true);
			craftingDustNetherStar                        = CraftingDustNetherStarProp.getBoolean(false);
			craftingDustBedrock                           = CraftingDustBedrockProp.getBoolean(false);
			craftingBedrockArmor                          = CraftingBedrockArmorProp.getBoolean(true);
			craftingAngelusArmor                          = CraftingAngelusArmorProp.getBoolean(true);
			craftingWeapons                               = CraftingWeaponsProp.getBoolean(true);
			craftingExelector                             = CraftigExelectorProp.getBoolean(true);
			craftingNIOH                                  = CraftingNIOHProp.getBoolean(true);
			craftingDAYO                                  = CraftingDAYOProp.getBoolean(true);
			craftingYORU                                  = CraftingYORUProp.getBoolean(true);
			craftingItemsK2                               = CraftingItemsK2Prop.getBoolean(true);
			craftingMultiK2                               = CraftingMultiK2Prop.getBoolean(true);

			consoleOut                                    = ConsoleOutProp.getBoolean(true);
			ultimateExchangeIgnitionEffect                = UltimateExchangeIgnitionEffectProp.getBoolean(false);
			bladeNIOHPreventDamage                        = BladeNIOHPreventDamageProp.getBoolean(true);
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, CONSOLE + "Config Load Failure.");
		}
		finally
		{
			cfg.save();
		}
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		if((craftingDifficulty < 0) && (4 < craftingDifficulty))
		{
			craftingDifficulty = 0;
		}

		ARMOR_BEDROCK  = EnumHelper.addArmorMaterial("BEDROCK" , 1, new int[] {10,10,10,10},20);
		ARMOR_PRIDE    = EnumHelper.addArmorMaterial("PRIDE"   , 1, new int[] {15,15,15,15},30);
		ARMOR_WRATH    = EnumHelper.addArmorMaterial("WRATH"   , 1, new int[] {15,15,15,15},30);
		ARMOR_ENVY     = EnumHelper.addArmorMaterial("ENVY"    , 1, new int[] {15,15,15,15},30);
		ARMOR_SLOTH    = EnumHelper.addArmorMaterial("SLOTH"   , 1, new int[] {15,15,15,15},30);
		ARMOR_AVARICE  = EnumHelper.addArmorMaterial("AVARICE" , 1, new int[] {15,15,15,15},30);
		ARMOR_GLUTTONY = EnumHelper.addArmorMaterial("GLUTTONY", 1, new int[] {15,15,15,15},30);
		ARMOR_LUST     = EnumHelper.addArmorMaterial("LUST"    , 1, new int[] {15,15,15,15},30);
		ARMOR_ANGELUS  = EnumHelper.addArmorMaterial("ANGELUS" , 1, new int[] {20,20,20,20},40);

		WEAPON_POOR     = EnumHelper.addToolMaterial("POOR"     , 2, 1, 6.0f, 0,  100);
		WEAPON_BASIC    = EnumHelper.addToolMaterial("BASIC"    , 3, 1, 6.0f, 5,  100);
		WEAPON_ULTIMATE = EnumHelper.addToolMaterial("ULTIMATE" , 4, 1, 6.0f, 15, 100);
		WEAPON_PHANTASM = EnumHelper.addToolMaterial("PHANTASM" , 4, 1, 6.0f, 95, 100);

		ARItemRegister();

		addchestgenhooks = new ARAddChestGenHooks();
		addchestgenhooks.AddChestItems();

		loadInfo(meta);

		MinecraftForge.EVENT_BUS.register(new ARNoFallDamageEventHooks());
		MinecraftForge.EVENT_BUS.register(new ARFlyingEventHooks());
		MinecraftForge.EVENT_BUS.register(new BedrockArmorLivingEventHooks());
		MinecraftForge.EVENT_BUS.register(new AngelusArmorLivingEventHooks());
		MinecraftForge.EVENT_BUS.register(new CirceForceEventHooks());
		MinecraftForge.EVENT_BUS.register(new WeaponsEventHooks());

		if(digEndPortal)
		{
			Block.endPortalFrame.setHardness(60F);
		}
	}
	@EventHandler
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