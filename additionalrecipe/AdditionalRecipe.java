package chibivaru.additionalrecipe;

import static chibivaru.additionalrecipe.common.ARItemHandler.*;

import java.util.HashMap;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import chibivaru.additionalrecipe.armor.BedrockArmor;
import chibivaru.additionalrecipe.common.ARConfiguration;
import chibivaru.additionalrecipe.common.ARCreativeTab;
import chibivaru.additionalrecipe.common.ARLogger;
import chibivaru.additionalrecipe.common.ARModInfo;
import chibivaru.additionalrecipe.dust.DustBedrock;
import chibivaru.additionalrecipe.dust.DustExchangeIgnition;
import chibivaru.additionalrecipe.dust.DustNetherStar;
import chibivaru.additionalrecipe.event.ARAddChestGenHooks;
import chibivaru.additionalrecipe.event.ARFlyingEventHooks;
import chibivaru.additionalrecipe.event.ARNoFallDamageEventHooks;
import chibivaru.additionalrecipe.event.AngelusArmorLivingEventHooks;
import chibivaru.additionalrecipe.event.BedrockArmorLivingEventHooks;
import chibivaru.additionalrecipe.event.CirceForceEventHooks;
import chibivaru.additionalrecipe.event.WeaponsEventHooks;
import chibivaru.additionalrecipe.item.BlackRottenFlesh;
import chibivaru.additionalrecipe.item.CirceForce;
import chibivaru.additionalrecipe.item.ForceBall;
import chibivaru.additionalrecipe.item.GravitationFeather;
import chibivaru.additionalrecipe.item.NightVisionTorch;
import chibivaru.additionalrecipe.item.SuperGravitationFeather;
import chibivaru.additionalrecipe.recipe.RecipeHandler;
import chibivaru.additionalrecipe.tools.BedrockMortar;
import chibivaru.additionalrecipe.tools.CheaperExchangeIgnition;
import chibivaru.additionalrecipe.tools.CraftingFurnace;
import chibivaru.additionalrecipe.tools.DiamondMortar;
import chibivaru.additionalrecipe.tools.ExchangeIgnition;
import chibivaru.additionalrecipe.tools.IronMortar;
import chibivaru.additionalrecipe.tools.UltimateExchangeIgnition;
import chibivaru.additionalrecipe.weapons.BladeNIOH;
import chibivaru.additionalrecipe.weapons.SpearDAYO;
import chibivaru.additionalrecipe.weapons.SwordExelector;
import chibivaru.additionalrecipe.weapons.SwordYORU;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
	public static HashMap<String,String>  ARItemName   = new HashMap<String,String>();
	public static HashMap<String,Integer> ARItemDamage = new HashMap<String,Integer>();
	public static int[] armorBedrockID = new int[4];
	public static int[] armorAngelusID = new int[4];
	public static int armorSlothHoodID,armorSlothVestmentID,armorSlothSkirtID,armorSlothBootsID;
	public static int diamondMortarDamage,iromMortarDamage,bladeNIOHDamage;
	public static int cheaperExchangeIgnitionDamage;
	public static int bedrockMortarCrafting;
	public static int diamondMortarCrafting;
	public static int ironMortarCrafting;
	public static int craftingDifficulty,exelectorFirstExp,exelectorSecondExp,exelectorLastExp;
	public static int textureIronMortar,textureDiamondMortar,textureBedrockMortar;
	public static Item[] armorBedrockItem = new Item[4];
	public static Item[] armorAngelusItem = new Item[4];
	public static boolean craftingCrystal,mortarOreDust,mortarIngotDust,furnaceDustIngot,craftingOre,digBCSpring,digEndPortal,craftingEndPortal,craftingPinkSlimeBall,craftingFlour,craftingLinkModifer;
	public static boolean smeltingTool,smeltingToolWood,smeltingToolStone,smeltingToolIron,smeltingToolGold,smeltingToolDiamond,smeltingToolBow;
	public static boolean smeltingArmor,smeltingArmorChain,smeltingArmorLeather,smeltingArmorIron,smeltingArmorGold,smeltingArmorDiamond;
	public static boolean smeltingNetherBrick,smeltingNetherrack,smeltingLeather,smeltingGlowStoneDust;
	public static boolean smeltingMinecartEmpty,smeltingIronDoor,smeltingWoodDoor;
	public static boolean craftingAlchemic,craftingExchangeIgnition,craftingUltimateExchangeIgnition,craftingDustExchangeIgnition,craftingCheaperExchangeIgnition;
	public static boolean craftingCraftingFurnace,craftingBlackRottenFlesh,craftingNightVisionTorch,craftingGravitationFeather,craftingSuperGravitationFeather,craftingCirceForce;
	public static boolean craftingMortar,craftingIronMortar,craftingDiamondMortar,craftingBedrockMortar,craftingDustNetherStar,craftingDustBedrock;
	public static boolean craftingBedrockArmor,craftingAngelusArmor;
	public static boolean craftingWeapons,craftingExelector,craftingNIOH,craftingDAYO,craftingYORU,craftingItemsK2,craftingMultiK2;
	public static boolean craftingMushroom,craftingPiston,craftingJewel,craftingSkull,craftingBedrock,craftingDragonEgg,craftingNetherStar,craftingExpBottle;
	public static boolean craftingEnderPearl,craftingPowerStone,craftingGrass,craftingObsidian,craftingBlazeRod,craftingBookOld,craftingCray,craftingCactus,craftingSlimeBall,craftingGlowStoneDust,craftingButton;
	public static boolean smeltingToolSteel,smeltingArmorSteel,smeltingToolInvar,smeltingArmorInvar,addOreDicExpBottle;
	public static boolean consoleOut,ultimateExchangeIgnitionEffect,bladeNIOHPreventDamage;
	public static RecipeHandler recipehandler;
	public static ARAddChestGenHooks addchestgenhooks;
	public EnumArmorMaterial ARMOR_BEDROCK,ARMOR_PRIDE,ARMOR_WRATH,ARMOR_ENVY,ARMOR_SLOTH,ARMOR_AVARICE,ARMOR_GLUTTONY,ARMOR_LUST,ARMOR_ANGELUS;
	public EnumToolMaterial WEAPON_ULTIMATE,WEAPON_BASIC,WEAPON_POOR,WEAPON_PHANTASM;
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

			Property ArmorBedrockHelmetIDProp             = cfg.getItem("ArmorItemID"    ,"BedrockHelmetItemID"             ,12700);
			Property ArmorBedrockPlateIDProp              = cfg.getItem("ArmorItemID"    ,"BedrockPlateItemID"              ,12701);
			Property ArmorBedrockLegsIDProp               = cfg.getItem("ArmorItemID"    ,"BedrockLegsItemID"               ,12702);
			Property ArmorBedrockBootsIDProp              = cfg.getItem("ArmorItemID"    ,"BedrockBootsItemID"              ,12703);

			Property ArmorAngelusHoodIDProp               = cfg.getItem("ArmorItemID"    ,"AngelusHoodItemID"               ,12704);
			Property ArmorAngelusVestmentIDProp           = cfg.getItem("ArmorItemID"    ,"AngelusVestmentItemID"           ,12705);
			Property ArmorAngelusSkirtIDProp              = cfg.getItem("ArmorItemID"    ,"AngelusSkirtItemID"              ,12706);
			Property ArmorAngelusBootsIDProp              = cfg.getItem("ArmorItemID"    ,"AngelusBootsItemID"              ,12707);

			Property DiamondMortarDamageProp              = cfg.get("ItemDamage"         ,"DiamondMortar"                   ,1561);
			Property IromMortarDamageProp                 = cfg.get("ItemDamage"         ,"IromMortar"                      ,250);
			Property CheaperExchangeIgnitionDamageProp    = cfg.get("ItemDamage"         ,"CheaperExchangeIgnition"         ,128);
			Property BladeNIOHDamageProp                  = cfg.get("ItemDamage"         ,"NIOH"                            ,4);

			Property SmeltingToolProp                     = cfg.get("Smelting"           ,"RecycleTool"                     ,true);
			Property SmeltingToolWoodProp                 = cfg.get("Smelting"           ,"WoodTool"                        ,true);
			Property SmeltingToolStoneProp                = cfg.get("Smelting"           ,"StoneTool"                       ,true);
			Property SmeltingToolIronProp                 = cfg.get("Smelting"           ,"IronTool"                        ,true);
			Property SmeltingToolGoldProp                 = cfg.get("Smelting"           ,"GoldTool"                        ,true);
			Property SmeltingToolDiamondProp              = cfg.get("Smelting"           ,"DiamondTool"                     ,true);
			Property SmeltingToolBowProp                  = cfg.get("Smelting"           ,"Bow"                             ,true);
			Property SmeltingToolSteelProp                = cfg.get("Smelting"           ,"SteelTool"                       ,true);
			Property SmeltingToolInvarProp                = cfg.get("Smelting"           ,"InvarTool"                       ,true);

			Property SmeltingArmorProp                    = cfg.get("Smelting"           ,"RecycleArmor"                    ,true);
			Property SmeltingArmorChainProp               = cfg.get("Smelting"           ,"ChainArmor"                      ,true);
			Property SmeltingArmorLeatherProp             = cfg.get("Smelting"           ,"LeatherArmor"                    ,true);
			Property SmeltingArmorIronProp                = cfg.get("Smelting"           ,"IronArmor"                       ,true);
			Property SmeltingArmorGoldProp                = cfg.get("Smelting"           ,"GoldArmor"                       ,true);
			Property SmeltingArmorDiamondProp             = cfg.get("Smelting"           ,"DiamondArmor"                    ,true);
			Property SmeltingArmorSteelProp               = cfg.get("Smelting"           ,"SteelArmor"                      ,true);
			Property SmeltingArmorInvarProp               = cfg.get("Smelting"           ,"InvarArmor"                      ,true);

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
			//Property ExelectorAttackPowerVanilaProp       = cfg.get("Another"            ,"Exelector Attack Power Vanila"   ,false);
			//Property ExelectroFirstAttackPowerProp        = cfg.get("Another"            ,"Exelector First Attack Power"    ,);

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

			armorBedrockID[ARMOR_HELMET]                  = ArmorBedrockHelmetIDProp.getInt();
			armorBedrockID[ARMOR_PLATE]                   = ArmorBedrockPlateIDProp.getInt();
			armorBedrockID[ARMOR_LEGS]                    = ArmorBedrockLegsIDProp.getInt();
			armorBedrockID[ARMOR_BOOTS]                   = ArmorBedrockBootsIDProp.getInt();

			armorAngelusID[ARMOR_HELMET]                  = ArmorAngelusHoodIDProp.getInt();
			armorAngelusID[ARMOR_PLATE]                   = ArmorAngelusVestmentIDProp.getInt();
			armorAngelusID[ARMOR_LEGS]                    = ArmorAngelusSkirtIDProp.getInt();
			armorAngelusID[ARMOR_BOOTS]                   = ArmorAngelusBootsIDProp.getInt();

			diamondMortarDamage                           = DiamondMortarDamageProp.getInt();
			iromMortarDamage                              = IromMortarDamageProp.getInt();
			cheaperExchangeIgnitionDamage                 = CheaperExchangeIgnitionDamageProp.getInt();
			bladeNIOHDamage                               = BladeNIOHDamageProp.getInt();

			smeltingTool                                  = SmeltingToolProp.getBoolean(true);
			smeltingToolWood                              = SmeltingToolWoodProp.getBoolean(true);
			smeltingToolStone                             = SmeltingToolStoneProp.getBoolean(true);
			smeltingToolIron                              = SmeltingToolIronProp.getBoolean(true);
			smeltingToolGold                              = SmeltingToolGoldProp.getBoolean(true);
			smeltingToolDiamond                           = SmeltingToolDiamondProp.getBoolean(true);
			smeltingToolBow                               = SmeltingToolBowProp.getBoolean(true);
			smeltingToolSteel                             = SmeltingToolSteelProp.getBoolean(true);
			smeltingToolInvar                             = SmeltingToolInvarProp.getBoolean(true);

			smeltingArmor                                 = SmeltingArmorProp.getBoolean(true);
			smeltingArmorChain                            = SmeltingArmorChainProp.getBoolean(true);
			smeltingArmorLeather                          = SmeltingArmorLeatherProp.getBoolean(true);
			smeltingArmorIron                             = SmeltingArmorIronProp.getBoolean(true);
			smeltingArmorGold                             = SmeltingArmorGoldProp.getBoolean(true);
			smeltingArmorDiamond                          = SmeltingArmorDiamondProp.getBoolean(true);
			smeltingArmorSteel                            = SmeltingArmorSteelProp.getBoolean(true);
			smeltingArmorInvar                            = SmeltingArmorInvarProp.getBoolean(true);

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
		ARNewItemRegister(new SwordExelector(ARGetItemIDRegister("toolk2") - 256, WEAPON_POOR), "toolk2", ARTabs, "K2",new StringBuilder().append(EnumChatFormatting.LIGHT_PURPLE).append("K2's Multi-Weapon").toString());

		ARNewItemRegister(new DustNetherStar(ARGetItemIDRegister("dustnetherstar") - 256), "dustnetherstar", ARTabs, "DustNetherStar");
		ARNewItemRegister(new DustBedrock(ARGetItemIDRegister("dustbedrock") - 256), "dustbedrock", ARTabs, "DustBedrock");
		ARNewItemRegister(new DustExchangeIgnition(ARGetItemIDRegister("dustexchangeignition") - 256), "dustexchangeignition", ARTabs, "DustExchangeIgnition");

		armorBedrockItem[ARMOR_HELMET] = new BedrockArmor(armorBedrockID[ARMOR_HELMET] - 256, ARMOR_BEDROCK, ARMOR_DEFAULT, ARMOR_HELMET, BEDROCK);
		armorBedrockItem[ARMOR_HELMET].setUnlocalizedName("bedrockhelmet");
		armorBedrockItem[ARMOR_HELMET].setTextureName("additionalrecipe:BedrockHelmet");
		armorBedrockItem[ARMOR_HELMET].setCreativeTab(ARTabs);
		LanguageRegistry.addName(armorBedrockItem[ARMOR_HELMET], "BedrockHelmet");
		GameRegistry.registerItem(armorBedrockItem[ARMOR_HELMET], "BedrockHelmet");

		armorBedrockItem[ARMOR_PLATE] = new BedrockArmor(armorBedrockID[ARMOR_PLATE] - 256, ARMOR_BEDROCK, ARMOR_DEFAULT, ARMOR_PLATE, BEDROCK);
		armorBedrockItem[ARMOR_PLATE].setUnlocalizedName("bedrockplate");
		armorBedrockItem[ARMOR_PLATE].setTextureName("additionalrecipe:BedrockPlate");
		armorBedrockItem[ARMOR_PLATE].setCreativeTab(ARTabs);
		LanguageRegistry.addName(armorBedrockItem[ARMOR_PLATE], "BedrockChestplate");
		GameRegistry.registerItem(armorBedrockItem[ARMOR_PLATE], "BedrockChestplate");

		armorBedrockItem[ARMOR_LEGS] = new BedrockArmor(armorBedrockID[ARMOR_LEGS] - 256, ARMOR_BEDROCK, ARMOR_DEFAULT, ARMOR_LEGS, BEDROCK);
		armorBedrockItem[ARMOR_LEGS].setUnlocalizedName("bedrocklegs");
		armorBedrockItem[ARMOR_LEGS].setTextureName("additionalrecipe:BedrockLegs");
		armorBedrockItem[ARMOR_LEGS].setCreativeTab(ARTabs);
		LanguageRegistry.addName(armorBedrockItem[ARMOR_LEGS], "BedrockLeggings");
		GameRegistry.registerItem(armorBedrockItem[ARMOR_LEGS], "BedrockLeggings");

		armorBedrockItem[ARMOR_BOOTS] = new BedrockArmor(armorBedrockID[ARMOR_BOOTS] - 256, ARMOR_BEDROCK, ARMOR_DEFAULT, ARMOR_BOOTS, BEDROCK);
		armorBedrockItem[ARMOR_BOOTS].setUnlocalizedName("bedrockboots");
		armorBedrockItem[ARMOR_BOOTS].setTextureName("additionalrecipe:BedrockBoots");
		armorBedrockItem[ARMOR_BOOTS].setCreativeTab(ARTabs);
		LanguageRegistry.addName(armorBedrockItem[ARMOR_BOOTS], "BedrockBoots");
		GameRegistry.registerItem(armorBedrockItem[ARMOR_BOOTS], "BedrockBoots");

		armorAngelusItem[ARMOR_HELMET] = new BedrockArmor(armorAngelusID[ARMOR_HELMET] - 256, ARMOR_ANGELUS, ARMOR_DEFAULT, ARMOR_HELMET, ANGELUS);
		armorAngelusItem[ARMOR_HELMET].setUnlocalizedName("angelushood");
		armorAngelusItem[ARMOR_HELMET].setTextureName("additionalrecipe:AngelusHood");
		armorAngelusItem[ARMOR_HELMET].setCreativeTab(ARTabs);
		LanguageRegistry.addName(armorAngelusItem[ARMOR_HELMET], "AngelusHood");
		GameRegistry.registerItem(armorAngelusItem[ARMOR_HELMET], "AngelusHood");

		armorAngelusItem[ARMOR_PLATE] = new BedrockArmor(armorAngelusID[ARMOR_PLATE] - 256, ARMOR_ANGELUS, ARMOR_DEFAULT, ARMOR_PLATE, ANGELUS);
		armorAngelusItem[ARMOR_PLATE].setUnlocalizedName("angelusvestment");
		armorAngelusItem[ARMOR_PLATE].setTextureName("additionalrecipe:AngelusVestment");
		armorAngelusItem[ARMOR_PLATE].setCreativeTab(ARTabs);
		LanguageRegistry.addName(armorAngelusItem[ARMOR_PLATE], "AngelusVestment");
		GameRegistry.registerItem(armorAngelusItem[ARMOR_PLATE], "AngelusVestment");

		armorAngelusItem[ARMOR_LEGS] = new BedrockArmor(armorAngelusID[ARMOR_LEGS] - 256, ARMOR_ANGELUS, ARMOR_DEFAULT, ARMOR_LEGS, ANGELUS);
		armorAngelusItem[ARMOR_LEGS].setUnlocalizedName("angelusskirt");
		armorAngelusItem[ARMOR_LEGS].setTextureName("additionalrecipe:AngelusSkirt");
		armorAngelusItem[ARMOR_LEGS].setCreativeTab(ARTabs);
		LanguageRegistry.addName(armorAngelusItem[ARMOR_LEGS], "AngelusSkirt");
		GameRegistry.registerItem(armorAngelusItem[ARMOR_LEGS], "AngelusSkirt");

		armorAngelusItem[ARMOR_BOOTS] = new BedrockArmor(armorAngelusID[ARMOR_BOOTS] - 256, ARMOR_ANGELUS, ARMOR_DEFAULT, ARMOR_BOOTS, ANGELUS);
		armorAngelusItem[ARMOR_BOOTS].setUnlocalizedName("angelusboots");
		armorAngelusItem[ARMOR_BOOTS].setTextureName("additionalrecipe:AngelusBoots");
		armorAngelusItem[ARMOR_BOOTS].setCreativeTab(ARTabs);
		LanguageRegistry.addName(armorAngelusItem[ARMOR_BOOTS], "AngelusBoots");
		GameRegistry.registerItem(armorAngelusItem[ARMOR_BOOTS], "AngelusBoots");

		addchestgenhooks = new ARAddChestGenHooks();
		addchestgenhooks.AddChestItems();

		ARModInfo.loadInfo(meta);

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
	public static boolean equipArmor(int armorIDs[],EntityPlayer player,int armorType)
	{
		switch(armorType)
		{
			case ARMOR_HELMET:
			{
				return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem().itemID == armorIDs[armorType];
			}
			case ARMOR_PLATE:
			{
				return player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem().itemID == armorIDs[armorType];
			}
			case ARMOR_LEGS:
			{
				return player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem().itemID == armorIDs[armorType];
			}
			case ARMOR_BOOTS:
			{
				return player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem().itemID == armorIDs[armorType];
			}
		}
		return false;
	}
	public static boolean equipArmor(int armorIDs[],EntityPlayer player,boolean mode)
	{
		if(mode)
		{
			if((player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem().itemID == armorIDs[AdditionalRecipe.ARMOR_HELMET]))
			{
				return true;
			}
			else if((player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem().itemID == armorIDs[AdditionalRecipe.ARMOR_PLATE]))
			{
				return true;
			}
			else if((player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem().itemID == armorIDs[AdditionalRecipe.ARMOR_LEGS]))
			{
				return true;
			}
			else if((player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem().itemID == armorIDs[AdditionalRecipe.ARMOR_BOOTS]))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return equipArmor(armorIDs,player);
		}
	}
	public static boolean hasItem(int itemID,EntityPlayer player)
	{
		return player.inventory.hasItem(itemID);
	}
}