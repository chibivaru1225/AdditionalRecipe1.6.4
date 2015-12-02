package chibivaru.additionalrecipe;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import chibivaru.additionalrecipe.armor.BedrockArmor;
import chibivaru.additionalrecipe.dust.DustBedrock;
import chibivaru.additionalrecipe.dust.DustNetherStar;
import chibivaru.additionalrecipe.event.AddChestGenHooks;
import chibivaru.additionalrecipe.event.AngelusArmorLivingEventHooks;
import chibivaru.additionalrecipe.event.BedrockArmorLivingEventHooks;
import chibivaru.additionalrecipe.event.FlyingEventHooks;
import chibivaru.additionalrecipe.event.ModInfo;
import chibivaru.additionalrecipe.event.NoFallDamageEventHooks;
import chibivaru.additionalrecipe.item.BedrockMortar;
import chibivaru.additionalrecipe.item.BlackRottenFlesh;
import chibivaru.additionalrecipe.item.CheaperExchangeIgnition;
import chibivaru.additionalrecipe.item.CraftingFurnace;
import chibivaru.additionalrecipe.item.DiamondMortar;
import chibivaru.additionalrecipe.item.ExchangeIgnition;
import chibivaru.additionalrecipe.item.GravitationFeather;
import chibivaru.additionalrecipe.item.IronMortar;
import chibivaru.additionalrecipe.item.NightVisionTorch;
import chibivaru.additionalrecipe.item.SuperGravitationFeather;
import chibivaru.additionalrecipe.item.SwordExelectorLast;
import chibivaru.additionalrecipe.item.UltimateExchangeIgnition;
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
	public static final String VERSION = "2.00beta";

	@Metadata(MODID)
	public static ModMetadata meta;

	public static final String CONSOLE = "[AdditionalRecipe]:";
	public static int bedrockMortarItemID,diamondMortarItemID,ironMortarItemID,exchangeIgnitionItemID,dustNetherStarItemID,dustBedrockItemID,gravitationFeatherItemID,superGravitationFeatherItemID,craftingFurnaceItemID,ultimateExchangeIgnitionItemID,dustExchangeIgnitionItemID,cheaperExchangeIgnitionItemID,blackRottenFleshItemID,nightVisionTorchItemID,swordMoonlightItemID,swordDarkslayerItemID,swordMoonlightPowerdItemID;
	public static int[] armorBedrockID = new int[4];
	public static int[] armorAngelusID = new int[4];
	public static int armorSlothHoodID,armorSlothVestmentID,armorSlothSkirtID,armorSlothBootsID;
	public static int diamondMortarDamage,iromMortarDamage;
	public static int cheaperExchangeIgnitionDamage;
	public static int bedrockMortarCrafting;
	public static int diamondMortarCrafting;
	public static int ironMortarCrafting;
	public static int craftingDifficulty;
	public static BedrockMortar bedrockMortar;
	public static DiamondMortar diamondMortar;
	public static IronMortar ironMortar;
	public static ExchangeIgnition exchangeIgniniton;
	public static UltimateExchangeIgnition ultimateExchangeIgnition;
	public static CraftingFurnace craftingFurnace;
	public static CheaperExchangeIgnition cheaperExchangeIgnition;
	public static SwordExelectorLast swordExelectorLast;
	public static Item bedrockMortarItem,exchangeIgnitionItem,ironMortarItem,diamondMortarItem,dustNetherStarItem,dustBedrockItem,gravitationFeatherItem,superGravitationFeatherItem,craftingFurnaceItem,ultimateExchangeIgnitionItem,dustExchangeIgnitionItem,blackRottenFleshItem,cheaperExchangeIgnitionItem,nightVisionTorchItem;
	public static Item swordMoonlight,swordDarkslayer,swordMoonlightPowerd,swordExelectorFirst,swordExelectorSecond;
	public static Item[] armorBedrockItem = new Item[4];
	public static Item[] armorAngelusItem = new Item[4];
	public static boolean craftingCrystal,mortarOreDust,mortarIngotDust,furnaceDustIngot,craftingOre,digBCSpring,digEndPortal,craftingEndPortal,craftingPinkSlimeBall,craftingFlour,craftingLinkModifer;
	public static boolean smeltingTool,smeltingToolWood,smeltingToolStone,smeltingToolIron,smeltingToolGold,smeltingToolDiamond,smeltingToolBow;
	public static boolean smeltingArmor,smeltingArmorChain,smeltingArmorLeather,smeltingArmorIron,smeltingArmorGold,smeltingArmorDiamond;
	public static boolean smeltingNetherBrick,smeltingNetherrack,smeltingLeather,smeltingGlowStoneDust;
	public static boolean smeltingMinecartEmpty,smeltingIronDoor,smeltingWoodDoor;
	public static boolean craftingAlchemic,craftingExchangeIgnition,craftingUltimateExchangeIgnition,craftingDustExchangeIgnition,craftingCheaperExchangeIgnition;
	public static boolean craftingCraftingFurnace,craftingBlackRottenFlesh,craftingNightVisionTorch,craftingGravitationFeather,craftingSuperGravitationFeather;
	public static boolean craftingMortar,craftingIronMortar,craftingDiamondMortar,craftingBedrockMortar,craftingDustNetherStar,craftingDustBedrock;
	public static boolean craftingBedrockArmor,craftingAngelusArmor;
	public static boolean craftingMushroom,craftingPiston,craftingJewel,craftingSkull,craftingBedrock,craftingDragonEgg,craftingNetherStar,craftingExpBottle;
	public static boolean craftingEnderPearl,craftingPowerStone,craftingGrass,craftingObsidian,craftingBlazeRod,craftingBookOld,craftingCray,craftingCactus,craftingSlimeBall,craftingGlowStoneDust;
	public static boolean smeltingToolSteel,smeltingArmorSteel,smeltingToolInvar,smeltingArmorInvar,addOreDicExpBottle;
	public static boolean printInAddRecipe,ultimateExchangeIgnitionEffect;
	public static RecipeHandler recipehandler;
	public static AddChestGenHooks addchestgenhooks;
	public EnumArmorMaterial ARMOR_BEDROCK,ARMOR_PRIDE,ARMOR_WRATH,ARMOR_ENVY,ARMOR_SLOTH,ARMOR_AVARICE,ARMOR_GLUTTONY,ARMOR_LUST,ARMOR_ANGELUS;
	public EnumToolMaterial SWORD_ULTIMATE,SWORD_BASIC,SWORD_POOR;
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
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			cfg.load();
			Property BedrockMortarItemIDProp              = cfg.getItem("ItemID"         ,"BedrockMortarItemID"             ,12503);
			Property DiamondMortarItemIDProp              = cfg.getItem("ItemID"         ,"DiamondMortarItemID"             ,12502);
			Property IronMortarItemIDProp                 = cfg.getItem("ItemID"         ,"IronMortarItemID"                ,12501);

			Property UltimateExchangeIgnitionItemIDProp   = cfg.getItem("ItemID"         ,"UltimateExchangeIgnitionItemID"  ,12506);
			Property ExchangeIgnitionItemIDProp           = cfg.getItem("ItemID"         ,"ExchangeIgnitionItemID"          ,12500);
			Property CheaperExchangeIgnitionItemIDProp    = cfg.getItem("ItemID"         ,"CheaperExchangeIgnitionItemID"   ,12507);

			Property CraftingFurnaceItemIDProp            = cfg.getItem("ItemID"         ,"CraftingFurnaceItemID"           ,12505);
			Property BlackRottenFleshItemIDProp           = cfg.getItem("ItemID"         ,"BlackRottenFleshItemID"          ,12508);
			Property GravitationFeatherItemIDProp         = cfg.getItem("ItemID"         ,"GravitationFeatherItemID"        ,12504);
			Property SuperGravitationFeatherItemIDProp    = cfg.getItem("ItemID"         ,"SuperGravitationFeatherItemID"   ,12510);
			Property NightVisionTorchItemIDProp           = cfg.getItem("ItemID"         ,"NightVisionTorchItemID"          ,12509);

			Property DustNetherStarItemIDProp             = cfg.getItem("DustItemID"     ,"DustNetherStarItemID"            ,12600);
			Property DustBedrockItemIDProp                = cfg.getItem("DustItemID"     ,"DustBedrockItemID"               ,12601);
			Property DustExchangeIgnitionItemIDProp       = cfg.getItem("DustItemID"     ,"DustExchangeIgnitionID"          ,12602);

			Property SwordMoonlightProp                   = cfg.getItem("SwordItemID"    ,"SwordMoonlightID"                ,12511);
			Property SwordDarkslayerProp                  = cfg.getItem("SwordItemID"    ,"SwordDarkslayerID"               ,12512);
			Property SwordMoonlightPowerdProp             = cfg.getItem("SwordItemID"    ,"SwordMoonlightPowerdID"          ,12513);
			Property SwordExelectorFirstProp              = cfg.getItem("SwordItemID"    ,"SwordExelectorFirstID"           ,12514);

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
			Property CraftingDifficultyProp               = cfg.get("Crafting"           ,"Difficulty"                      ,0);
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

			Property BedrockMortarCraftingProp            = cfg.get("MortarCrafting"     ,"BedrockMortarDust"               ,8);
			Property DiamondMortarCraftingProp            = cfg.get("MortarCrafting"     ,"DiamondMortarDust"               ,4);
			Property IronMortarCraftingProp               = cfg.get("MortarCrafting"     ,"IronMortarDust"                  ,2);

			Property DigBCSpringProp                      = cfg.get("Dig"                ,"BuildCraft_Spring"               ,true);
			Property DigEndPortalProp                     = cfg.get("Dig"                ,"EndPortal"                       ,false);

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
			Property CraftingDustNetherStarProp           = cfg.get("AdditionalRecipe"   ,"DustNetherStar"                  ,false);
			Property CraftingDustBedrockProp              = cfg.get("AdditionalRecipe"   ,"DustBedrock"                     ,false);
			Property CraftingBedrockArmorProp             = cfg.get("AdditionalRecipe"   ,"BedrockArmor"                    ,true);
			Property CraftingAngelusArmorProp             = cfg.get("AdditionalRecipe"   ,"AngelusArmor"                    ,true);
			Property CraftingSwordsProp                   = cfg.get("AdditionalRecipe"   ,"Swords"                          ,true);

			Property PrintInAddRecipeProp                 = cfg.get("Another"            ,"Add-Recipe Print-In"             ,true);
			Property UltimateExchangeIgnitionEffectProp   = cfg.get("Another"            ,"UltimateExchangeIgnitionEffect"  ,false);

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

			bedrockMortarItemID                           = BedrockMortarItemIDProp.getInt();
			diamondMortarItemID                           = DiamondMortarItemIDProp.getInt();
			ironMortarItemID                              = IronMortarItemIDProp.getInt();

			ultimateExchangeIgnitionItemID                = UltimateExchangeIgnitionItemIDProp.getInt();
			exchangeIgnitionItemID                        = ExchangeIgnitionItemIDProp.getInt();
			cheaperExchangeIgnitionItemID                 = CheaperExchangeIgnitionItemIDProp.getInt();

			craftingFurnaceItemID                         = CraftingFurnaceItemIDProp.getInt();
			blackRottenFleshItemID                        = BlackRottenFleshItemIDProp.getInt();
			gravitationFeatherItemID                      = GravitationFeatherItemIDProp.getInt();
			superGravitationFeatherItemID                 = SuperGravitationFeatherItemIDProp.getInt();
			nightVisionTorchItemID                        = NightVisionTorchItemIDProp.getInt();

			swordMoonlightItemID                          = SwordMoonlightProp.getInt();
			swordDarkslayerItemID                         = SwordDarkslayerProp.getInt();
			swordMoonlightPowerdItemID                    = SwordMoonlightPowerdProp.getInt();

			armorBedrockID[ARMOR_HELMET]                  = ArmorBedrockHelmetIDProp.getInt();
			armorBedrockID[ARMOR_PLATE]                   = ArmorBedrockPlateIDProp.getInt();
			armorBedrockID[ARMOR_LEGS]                    = ArmorBedrockLegsIDProp.getInt();
			armorBedrockID[ARMOR_BOOTS]                   = ArmorBedrockBootsIDProp.getInt();

			armorAngelusID[ARMOR_HELMET]                  = ArmorAngelusHoodIDProp.getInt();
			armorAngelusID[ARMOR_PLATE]                   = ArmorAngelusVestmentIDProp.getInt();
			armorAngelusID[ARMOR_LEGS]                    = ArmorAngelusSkirtIDProp.getInt();
			armorAngelusID[ARMOR_BOOTS]                   = ArmorAngelusBootsIDProp.getInt();

			dustNetherStarItemID                          = DustNetherStarItemIDProp.getInt();
			dustBedrockItemID                             = DustBedrockItemIDProp.getInt();
			dustExchangeIgnitionItemID                    = DustExchangeIgnitionItemIDProp.getInt();

			diamondMortarDamage                           = DiamondMortarDamageProp.getInt();
			iromMortarDamage                              = IromMortarDamageProp.getInt();
			cheaperExchangeIgnitionDamage                 = CheaperExchangeIgnitionDamageProp.getInt();

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

			mortarOreDust                                 = MortarOreDustProp.getBoolean(true);
			mortarIngotDust                               = MortarIngotDustProp.getBoolean(true);

			bedrockMortarCrafting                         = BedrockMortarCraftingProp.getInt();
			diamondMortarCrafting                         = DiamondMortarCraftingProp.getInt();
			ironMortarCrafting                            = IronMortarCraftingProp.getInt();

			digBCSpring                                   = DigBCSpringProp.getBoolean(true);
			digEndPortal                                  = DigEndPortalProp.getBoolean(false);

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
			craftingDustNetherStar                        = CraftingDustNetherStarProp.getBoolean(false);
			craftingDustBedrock                           = CraftingDustBedrockProp.getBoolean(false);
			craftingBedrockArmor                          = CraftingBedrockArmorProp.getBoolean(true);
			craftingAngelusArmor                          = CraftingAngelusArmorProp.getBoolean(true);

			printInAddRecipe                              = PrintInAddRecipeProp.getBoolean(true);
			ultimateExchangeIgnitionEffect                = UltimateExchangeIgnitionEffectProp.getBoolean(false);
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

		SWORD_ULTIMATE = EnumHelper.addToolMaterial("ULTIMATE" , 4, 1, 6.0f, 20, 100);

		bedrockMortar     = (BedrockMortar)(new BedrockMortar(bedrockMortarItemID - 256)).setUnlocalizedName("bedrockmortar");
		bedrockMortarItem = (Item)bedrockMortar;
		GameRegistry.registerItem(bedrockMortar, "BedrockMortar");
		GameRegistry.registerCraftingHandler(bedrockMortar);
		ModLoader.addName(bedrockMortar, "BedrockMortar");

		diamondMortar     = (DiamondMortar)(new DiamondMortar(diamondMortarItemID - 256)).setUnlocalizedName("diamondmortar");
		diamondMortarItem = (Item)diamondMortar;
		GameRegistry.registerItem(diamondMortar, "DiamondMortar");
		GameRegistry.registerCraftingHandler(diamondMortar);
		ModLoader.addName(diamondMortar, "DiamondMortar");

		ironMortar     = (IronMortar)(new IronMortar(ironMortarItemID - 256)).setUnlocalizedName("ironmortar");
		ironMortarItem = (Item)ironMortar;
		GameRegistry.registerItem(ironMortar, "IronMortar");
		GameRegistry.registerCraftingHandler(ironMortar);
		ModLoader.addName(ironMortar, "IronMortar");

		exchangeIgniniton     = (ExchangeIgnition)(new ExchangeIgnition(exchangeIgnitionItemID - 256)).setUnlocalizedName("exchangeiginiton");
		exchangeIgnitionItem = (Item)exchangeIgniniton;
		GameRegistry.registerItem(exchangeIgniniton, "ExchangeIgnition");
		GameRegistry.registerCraftingHandler(exchangeIgniniton);
		ModLoader.addName(exchangeIgniniton, "ExchangeIgnition");

		ultimateExchangeIgnition     = (UltimateExchangeIgnition)(new UltimateExchangeIgnition(ultimateExchangeIgnitionItemID - 256)).setUnlocalizedName("ultimateexchangeiginiton");
		ultimateExchangeIgnitionItem = (Item)ultimateExchangeIgnition;
		GameRegistry.registerItem(ultimateExchangeIgnition, "UltimateExchangeIgnition");
		GameRegistry.registerCraftingHandler(ultimateExchangeIgnition);
		ModLoader.addName(ultimateExchangeIgnition, "UltimateExchangeIgnition");

		cheaperExchangeIgnition     = (CheaperExchangeIgnition)(new CheaperExchangeIgnition(cheaperExchangeIgnitionItemID - 256)).setUnlocalizedName("cheaperexchangeiginiton");
		cheaperExchangeIgnitionItem = (Item)cheaperExchangeIgnition;
		GameRegistry.registerItem(cheaperExchangeIgnition, "CheaperExchangeIgnition");
		GameRegistry.registerCraftingHandler(cheaperExchangeIgnition);
		ModLoader.addName(cheaperExchangeIgnition, "CheaperExchangeIgnition");

		craftingFurnace = (CraftingFurnace)(new CraftingFurnace(craftingFurnaceItemID - 256)).setUnlocalizedName("craftingfurnace");
		craftingFurnaceItem = (Item)craftingFurnace;
		GameRegistry.registerItem(craftingFurnace,"CraftingFurnace");
		GameRegistry.registerCraftingHandler(craftingFurnace);
		ModLoader.addName(craftingFurnace, "CraftingFurnace");

		gravitationFeatherItem = new GravitationFeather(gravitationFeatherItemID - 256).setUnlocalizedName("gravitationfeather");
		LanguageRegistry.addName(gravitationFeatherItem, "GravitationFeather");
		GameRegistry.registerItem(gravitationFeatherItem, "GravitationFeather");

		superGravitationFeatherItem = new SuperGravitationFeather(superGravitationFeatherItemID - 256).setUnlocalizedName("supergravitationfeather");
		LanguageRegistry.addName(superGravitationFeatherItem, "SuperGravitationFeather");
		GameRegistry.registerItem(superGravitationFeatherItem, "SuperGravitationFeather");

		blackRottenFleshItem = new BlackRottenFlesh(blackRottenFleshItemID - 256).setUnlocalizedName("blackrottenflesh");
		LanguageRegistry.addName(blackRottenFleshItem, "BlackRottenFlesh");
		GameRegistry.registerItem(blackRottenFleshItem, "BlackRottenFlesh");

		nightVisionTorchItem = new NightVisionTorch(nightVisionTorchItemID - 256).setUnlocalizedName("nightvisiontorch");
		LanguageRegistry.addName(nightVisionTorchItem, "NightVisionTorch");
		GameRegistry.registerItem(nightVisionTorchItem, "NightVisionTorch");


		armorBedrockItem[ARMOR_HELMET] = new BedrockArmor(armorBedrockID[ARMOR_HELMET] - 256, ARMOR_BEDROCK, ARMOR_DEFAULT, ARMOR_HELMET, BEDROCK);
		armorBedrockItem[ARMOR_HELMET].setUnlocalizedName("bedrockhelmet");
		armorBedrockItem[ARMOR_HELMET].setTextureName("additionalrecipe:BedrockHelmet");
		LanguageRegistry.addName(armorBedrockItem[ARMOR_HELMET], "BedrockHelmet");
		GameRegistry.registerItem(armorBedrockItem[ARMOR_HELMET], "BedrockHelmet");

		armorBedrockItem[ARMOR_PLATE] = new BedrockArmor(armorBedrockID[ARMOR_PLATE] - 256, ARMOR_BEDROCK, ARMOR_DEFAULT, ARMOR_PLATE, BEDROCK);
		armorBedrockItem[ARMOR_PLATE].setUnlocalizedName("bedrockplate");
		armorBedrockItem[ARMOR_PLATE].setTextureName("additionalrecipe:BedrockPlate");
		LanguageRegistry.addName(armorBedrockItem[ARMOR_PLATE], "BedrockChestplate");
		GameRegistry.registerItem(armorBedrockItem[ARMOR_PLATE], "BedrockChestplate");

		armorBedrockItem[ARMOR_LEGS] = new BedrockArmor(armorBedrockID[ARMOR_LEGS] - 256, ARMOR_BEDROCK, ARMOR_DEFAULT, ARMOR_LEGS, BEDROCK);
		armorBedrockItem[ARMOR_LEGS].setUnlocalizedName("bedrocklegs");
		armorBedrockItem[ARMOR_LEGS].setTextureName("additionalrecipe:BedrockLegs");
		LanguageRegistry.addName(armorBedrockItem[ARMOR_LEGS], "BedrockLeggings");
		GameRegistry.registerItem(armorBedrockItem[ARMOR_LEGS], "BedrockLeggings");

		armorBedrockItem[ARMOR_BOOTS] = new BedrockArmor(armorBedrockID[ARMOR_BOOTS] - 256, ARMOR_BEDROCK, ARMOR_DEFAULT, ARMOR_BOOTS, BEDROCK);
		armorBedrockItem[ARMOR_BOOTS].setUnlocalizedName("bedrockboots");
		armorBedrockItem[ARMOR_BOOTS].setTextureName("additionalrecipe:BedrockBoots");
		LanguageRegistry.addName(armorBedrockItem[ARMOR_BOOTS], "BedrockBoots");
		GameRegistry.registerItem(armorBedrockItem[ARMOR_BOOTS], "BedrockBoots");

		armorAngelusItem[ARMOR_HELMET] = new BedrockArmor(armorAngelusID[ARMOR_HELMET] - 256, ARMOR_ANGELUS, ARMOR_DEFAULT, ARMOR_HELMET, ANGELUS);
		armorAngelusItem[ARMOR_HELMET].setUnlocalizedName("angelushood");
		armorAngelusItem[ARMOR_HELMET].setTextureName("additionalrecipe:AngelusHood");
		LanguageRegistry.addName(armorAngelusItem[ARMOR_HELMET], "AngelusHood");
		GameRegistry.registerItem(armorAngelusItem[ARMOR_HELMET], "AngelusHood");

		armorAngelusItem[ARMOR_PLATE] = new BedrockArmor(armorAngelusID[ARMOR_PLATE] - 256, ARMOR_ANGELUS, ARMOR_DEFAULT, ARMOR_PLATE, ANGELUS);
		armorAngelusItem[ARMOR_PLATE].setUnlocalizedName("angelusvestment");
		armorAngelusItem[ARMOR_PLATE].setTextureName("additionalrecipe:AngelusVestment");
		LanguageRegistry.addName(armorAngelusItem[ARMOR_PLATE], "AngelusVestment");
		GameRegistry.registerItem(armorAngelusItem[ARMOR_PLATE], "AngelusVestment");

		armorAngelusItem[ARMOR_LEGS] = new BedrockArmor(armorAngelusID[ARMOR_LEGS] - 256, ARMOR_ANGELUS, ARMOR_DEFAULT, ARMOR_LEGS, ANGELUS);
		armorAngelusItem[ARMOR_LEGS].setUnlocalizedName("angelusskirt");
		armorAngelusItem[ARMOR_LEGS].setTextureName("additionalrecipe:AngelusSkirt");
		LanguageRegistry.addName(armorAngelusItem[ARMOR_LEGS], "AngelusSkirt");
		GameRegistry.registerItem(armorAngelusItem[ARMOR_LEGS], "AngelusSkirt");

		armorAngelusItem[ARMOR_BOOTS] = new BedrockArmor(armorAngelusID[ARMOR_BOOTS] - 256, ARMOR_ANGELUS, ARMOR_DEFAULT, ARMOR_BOOTS, ANGELUS);
		armorAngelusItem[ARMOR_BOOTS].setUnlocalizedName("angelusboots");
		armorAngelusItem[ARMOR_BOOTS].setTextureName("additionalrecipe:AngelusBoots");
		LanguageRegistry.addName(armorAngelusItem[ARMOR_BOOTS], "AngelusBoots");
		GameRegistry.registerItem(armorAngelusItem[ARMOR_BOOTS], "AngelusBoots");


		dustNetherStarItem = new DustNetherStar(dustNetherStarItemID - 256).setUnlocalizedName("dustnetherstar");
		LanguageRegistry.addName(dustNetherStarItem, "DustNetherStar");
		GameRegistry.registerItem(dustNetherStarItem, "DustNetherStar");

		dustBedrockItem = new DustBedrock(dustBedrockItemID - 256).setUnlocalizedName("dustbedrock");
		LanguageRegistry.addName(dustBedrockItem, "DustBedrock");
		GameRegistry.registerItem(dustBedrockItem, "DustBedrock");

		dustExchangeIgnitionItem = new DustBedrock(dustExchangeIgnitionItemID - 256).setUnlocalizedName("dustexchangeignition");
		LanguageRegistry.addName(dustExchangeIgnitionItem, "DustExchangeIgnition");
		GameRegistry.registerItem(dustExchangeIgnitionItem, "DustExchangeIgnition");

		addchestgenhooks = new AddChestGenHooks();
		addchestgenhooks.AddChestItems();

		ModInfo.loadInfo(meta);

		MinecraftForge.EVENT_BUS.register(new NoFallDamageEventHooks());
		MinecraftForge.EVENT_BUS.register(new FlyingEventHooks());
		MinecraftForge.EVENT_BUS.register(new BedrockArmorLivingEventHooks());
		MinecraftForge.EVENT_BUS.register(new AngelusArmorLivingEventHooks());

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