package chibivaru.additionalrecipe;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.xcompwiz.mystcraft.api.MystObjects;

import chibivaru.additionalrecipe.dust.DustBedrock;
import chibivaru.additionalrecipe.dust.DustNetherStar;
import chibivaru.additionalrecipe.event.ExchangeIgnitionLivingEventHooks;
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
import chibivaru.additionalrecipe.item.UltimateExchangeIgnition;
import chibivaru.additionalrecipe.recipe.RecipeHandler;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(
		modid = "AdditionalRecipe",
		name  = "AdditionalRecipe",
		version = "1.12",
		dependencies="after:Waila;after:AppliedEnergistics;after:GeoStrata;after:MineFactoryReloaded;after:MoreInventoryMod;after:MoreInventory Mod;after:MoreInventory;after:Thermal Expansion;after:ThermalExpansion;after:BuildCraftCore"
	)
@NetworkMod(
		clientSideRequired = true,
		serverSideRequired = false
	)

public class AdditionalRecipe {
	public static final String modid = "additionalrecipe";

	private static Class MoInv;
	private static Class MFR;
	private static Class BC;
	public static int bedrockMortarItemID,diamondMortarItemID,ironMortarItemID,exchangeIgnitionItemID,dustNetherStarItemID,dustBedrockItemID,gravitationFeatherItemID,superGravitationFeatherItemID,craftingFurnaceItemID,ultimateExchangeIgnitionItemID,dustExchangeIgnitionItemID,cheaperExchangeIgnitionItemID,blackRottenFleshItemID,nightVisionTorchItemID;
	public static int diamondMortarDamage,iromMortarDamage;
	public static int cheaperExchangeIgnitionDamage;
	static int bedrockMortarCrafting;
	static int diamondMortarCrafting;
	static int ironMortarCrafting;
	static int craftingDifficulty;
	public static BedrockMortar bedrockMortar;
	public static DiamondMortar diamondMortar;
	public static IronMortar ironMortar;
	public static ExchangeIgnition exchangeIgniniton;
	public static UltimateExchangeIgnition ultimateExchangeIgnition;
	public static CraftingFurnace craftingFurnace;
	public static CheaperExchangeIgnition cheaperExchangeIgnition;
	public static Item bedrockMortarItem,exchangeIgnitionItem,ironMortarItem,diamondMortarItem,dustNetherStarItem,dustBedrockItem,gravitationFeatherItem,superGravitationFeatherItem,craftingFurnaceItem,ultimateExchangeIgnitionItem,dustExchangeIgnitionItem,blackRottenFleshItem,cheaperExchangeIgnitionItem,nightVisionTorchItem;
	public static boolean smeltingTool,craftingCrystal,mortarOreDust,mortarIngotDust,furnaceDustIngot,craftingOre,digBCSpring,digEndPortal,craftingEndPortal;
	public static RecipeHandler recipehandler;

	@Mod.PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			cfg.load();
			Property BedrockMortarItemIDProp            = cfg.getItem("ItemID"         ,"BedrockMortarItemID"           ,12503);
			Property DiamondMortarItemIDProp            = cfg.getItem("ItemID"         ,"DiamondMortarItemID"           ,12502);
			Property IronMortarItemIDProp               = cfg.getItem("ItemID"         ,"IronMortarItemID"              ,12501);

			Property UltimateExchangeIgnitionItemIDProp = cfg.getItem("ItemID"         ,"UltimateExchangeIgnitionItemID",12506);
			Property ExchangeIgnitionItemIDProp         = cfg.getItem("ItemID"         ,"ExchangeIgnitionItemID"        ,12500);
			Property CheaperExchangeIgnitionItemIDProp  = cfg.getItem("ItemID"         ,"CheaperExchangeIgnitionItemID" ,12507);

			Property CraftingFurnaceItemIDProp          = cfg.getItem("ItemID"         ,"CraftingFurnaceItemID"         ,12505);
			Property BlackRottenFleshItemIDProp         = cfg.getItem("ItemID"         ,"BlackRottenFleshItemID"        ,12508);
			Property GravitationFeatherItemIDProp       = cfg.getItem("ItemID"         ,"GravitationFeatherItemID"      ,12504);
			Property SuperGravitationFeatherItemIDProp  = cfg.getItem("ItemID"         ,"SuperGravitationFeatherItemID" ,12510);
			Property NightVisionTorchItemIDProp         = cfg.getItem("ItemID"         ,"NightVisionTorchItemID"        ,12509);

			Property DustNetherStarItemIDProp           = cfg.getItem("DustItemID"     ,"DustNetherStarItemID"          ,12600);
			Property DustBedrockItemIDProp              = cfg.getItem("DustItemID"     ,"DustBedrockItemID"             ,12601);
			Property DustExchangeIgnitionItemIDProp     = cfg.getItem("DustItemID"     ,"DustExchangeIgnitionID"        ,12602);

			Property DiamondMortarDamageProp            = cfg.get("ItemDamage"         ,"DiamondMortar"                 ,1561);
			Property IromMortarDamageProp               = cfg.get("ItemDamage"         ,"IromMortar"                    ,250);
			Property CheaperExchangeIgnitionDamageProp  = cfg.get("ItemDamage"         ,"CheaperExchangeIgnition"       ,128);

			Property CraftingCrystalProp                = cfg.get("Crafting"           ,"Crystal"                       ,true);

			Property SmeltingToolProp                   = cfg.get("Smelting"           ,"RecycleTool"                   ,true);

			Property MortarOreDustProp                  = cfg.get("MortarCrafting"     ,"CraftingOreDust"               ,true);
			Property MortarIngotDustProp                = cfg.get("MortarCrafting"     ,"CraftingIngotDust"             ,true);

			Property FurnaceDustIngotProp               = cfg.get("FurnaceCrafting"    ,"DustIngot"                     ,true);

			Property CraftingEndPortalProp              = cfg.get("Crafting"           ,"EndPortal"                     ,false);
			Property CraftingOreProp                    = cfg.get("Crafting"           ,"Ore"                           ,true);
			Property CraftingDifficultyProp             = cfg.get("Crafting"           ,"Difficulty"                    ,0);

			Property BedrockMortarCraftingProp          = cfg.get("MortarCrafting"     ,"BedrockMortarDust"             ,8);
			Property DiamondMortarCraftingProp          = cfg.get("MortarCrafting"     ,"DiamondMortarDust"             ,4);
			Property IronMortarCraftingProp             = cfg.get("MortarCrafting"     ,"IronMortarDust"                ,2);

			Property DigBCSpringProp                    = cfg.get("Dig"                ,"BuildCraft_Spring"             ,true);
			Property DigEndPortalProp                   = cfg.get("Dig"                ,"EndPortal"                     ,false);

			CraftingDifficultyProp.comment = "0=easy 1=normal 2=hard 3=lunatic 4=ultimate The others are easy.";

			bedrockMortarItemID                  = BedrockMortarItemIDProp.getInt();
			diamondMortarItemID                  = DiamondMortarItemIDProp.getInt();
			ironMortarItemID                     = IronMortarItemIDProp.getInt();

			ultimateExchangeIgnitionItemID       = UltimateExchangeIgnitionItemIDProp.getInt();
			exchangeIgnitionItemID               = ExchangeIgnitionItemIDProp.getInt();
			cheaperExchangeIgnitionItemID        = CheaperExchangeIgnitionItemIDProp.getInt();

			craftingFurnaceItemID                = CraftingFurnaceItemIDProp.getInt();
			blackRottenFleshItemID               = BlackRottenFleshItemIDProp.getInt();
			gravitationFeatherItemID             = GravitationFeatherItemIDProp.getInt();
			superGravitationFeatherItemID        = SuperGravitationFeatherItemIDProp.getInt();
			nightVisionTorchItemID               = NightVisionTorchItemIDProp.getInt();

			dustNetherStarItemID                 = DustNetherStarItemIDProp.getInt();
			dustBedrockItemID                    = DustBedrockItemIDProp.getInt();
			dustExchangeIgnitionItemID           = DustExchangeIgnitionItemIDProp.getInt();

			diamondMortarDamage                  = DiamondMortarDamageProp.getInt();
			iromMortarDamage                     = IromMortarDamageProp.getInt();
			cheaperExchangeIgnitionDamage        = CheaperExchangeIgnitionDamageProp.getInt();

			craftingCrystal                      = CraftingCrystalProp.getBoolean(true);

			smeltingTool                         = SmeltingToolProp.getBoolean(true);

			furnaceDustIngot                     = FurnaceDustIngotProp.getBoolean(true);

			craftingEndPortal                    = CraftingEndPortalProp.getBoolean(false);
			craftingOre                          = CraftingOreProp.getBoolean(true);
			craftingDifficulty                   = CraftingDifficultyProp.getInt();

			mortarOreDust                        = MortarOreDustProp.getBoolean(true);
			mortarIngotDust                      = MortarIngotDustProp.getBoolean(true);

			bedrockMortarCrafting                = BedrockMortarCraftingProp.getInt();
			diamondMortarCrafting                = DiamondMortarCraftingProp.getInt();
			ironMortarCrafting                   = IronMortarCraftingProp.getInt();

			digBCSpring                          = DigBCSpringProp.getBoolean(true);
			digEndPortal                         = DigEndPortalProp.getBoolean(false);

			//grassMobSpawn                        = GrassMobSpawnProp.getBoolean(true);
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "Error Message");
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

		dustNetherStarItem = new DustNetherStar(dustNetherStarItemID - 256).setUnlocalizedName("dustnetherstar");
		LanguageRegistry.addName(dustNetherStarItem, "DustNetherStar");
		GameRegistry.registerItem(dustNetherStarItem, "DustNetherStar");

		dustBedrockItem = new DustBedrock(dustBedrockItemID - 256).setUnlocalizedName("dustbedrock");
		LanguageRegistry.addName(dustBedrockItem, "DustBedrock");
		GameRegistry.registerItem(dustBedrockItem, "DustBedrock");

		dustExchangeIgnitionItem = new DustBedrock(dustExchangeIgnitionItemID - 256).setUnlocalizedName("dustexchangeignition");
		LanguageRegistry.addName(dustExchangeIgnitionItem, "DustExchangeIgnition");
		GameRegistry.registerItem(dustExchangeIgnitionItem, "DustExchangeIgnition");

		/*
		OreDictionary.registerOre("item_Fragment",Item.expBottle);

		OreDictionary.registerOre("dustNetherStar",dustNetherStarItem);
		OreDictionary.registerOre("dustBedrock",dustBedrockItem);

		OreDictionary.registerOre("MortarTier01",bedrockMortar);
		OreDictionary.registerOre("MortarTier02",bedrockMortar);
		OreDictionary.registerOre("MortarTier03",bedrockMortar);
		OreDictionary.registerOre("MortarOreTier03",bedrockMortar);

		OreDictionary.registerOre("MortarTier01",new ItemStack(diamondMortar,1,32767));
		OreDictionary.registerOre("MortarTier02",new ItemStack(diamondMortar,1,32767));
		OreDictionary.registerOre("MortarOreTier02",new ItemStack(diamondMortar,1,32767));

		OreDictionary.registerOre("MortarTier01",new ItemStack(ironMortar,1,32767));
		OreDictionary.registerOre("MortarOreTier01",new ItemStack(ironMortar,1,32767));

		OreDictionary.registerOre("ExchangeIgnition",exchangeIgniniton);
		OreDictionary.registerOre("ExchangeIgnition",ultimateExchangeIgnition);
		OreDictionary.registerOre("ExchangeIgnition",new ItemStack(cheaperExchangeIgnition,1,32767));
		*/

		recipehandler = new RecipeHandler();
		recipehandler.oredic();
		recipehandler.init();

		/*
		GameRegistry.addSmelting(exchangeIgnitionItemID,new ItemStack(dustExchangeIgnitionItem,1,0),0.0f);

		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				ultimateExchangeIgnition,
				new Object[]{"XYX","YZY","XYX",
					Character.valueOf('X'),Block.bedrock,
					Character.valueOf('Y'),Block.dragonEgg,
					Character.valueOf('Z'),dustExchangeIgnitionItem}));

		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				blackRottenFleshItem,
				new Object[]{"XXX","XXX","XXX",
					Character.valueOf('X'),Item.rottenFlesh}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
					cheaperExchangeIgnition,
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),blackRottenFleshItem,
						Character.valueOf('Y'),Block.blockDiamond}));

		//モルタル作成
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				bedrockMortarItem,
				new Object[]{"XYX"," X ",
					Character.valueOf('X'),Item.netherStar,
					Character.valueOf('Y'),Block.dragonEgg}));
		GameRegistry.addRecipe(
				new ShapedOreRecipe(
					diamondMortarItem,
					new Object[]{"XYX"," X ",
						Character.valueOf('X'),Item.diamond,
						Character.valueOf('Y'),Item.ingotIron}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				ironMortarItem,
				new Object[]{"XYX"," X ",
					Character.valueOf('X'),Item.ingotIron,
					Character.valueOf('Y'),Item.flint}));
		*/

		//粉砕
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Item.silk,
				new Object[]{new ItemStack(Block.sapling,1,32767),"MortarTier01"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Item.silk,
				new Object[]{new ItemStack(Block.leaves,1,32767),"MortarTier01"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Item.silk,
				new Object[]{"treeSapling","MortarTier01"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Item.silk,
				new Object[]{"treeLeaves","MortarTier01"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.dyePowder,8,15),
				new Object[]{Item.bone,"MortarTier01"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Block.sand,
				new Object[]{Block.cobblestone,"MortarTier01"}));
		GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Block.sand,
					new Object[]{"cobblestone","MortarTier01"}));
		GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					new ItemStack(Item.silk,8),
					new Object[]{Block.web,"MortarTier01"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.silk,1),
				new Object[]{new ItemStack(Item.silk,1,1)}));
		GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Block.web,
					new Object[]{Item.silk,Item.silk,Item.silk,Item.silk,Item.silk,Item.silk,Item.silk,Item.silk}));;
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Block.cobblestone,
				new Object[]{Block.stone,"MortarTier01"}));
		GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Block.cobblestone,
					new Object[]{"stone","MortarTier01"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.flint,4),
				new Object[]{Block.gravel,"MortarTier01"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Block.netherrack,
				new Object[]{Block.netherBrick,"MortarTier02"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Block.slowSand,
				new Object[]{Block.netherrack,"MortarTier02"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.blazePowder,4),
				new Object[]{Item.blazeRod,"MortarTier02"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.feather,8),
				new Object[]{new ItemStack(Block.cloth,1,32767),"MortarTier01"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.redstone,4),
				new Object[]{Item.poisonousPotato,"MortarTier01"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Block.stone,64),
				new Object[]{ultimateExchangeIgnition,craftingFurnace}));
		if(craftingOre)
		{
			//鉱石増殖
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreIron,
					new Object[]{"X  "," X ","   ",
						Character.valueOf('X'),ultimateExchangeIgnition}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreGold,
					new Object[]{" X "," X ","   ",
						Character.valueOf('X'),ultimateExchangeIgnition}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreCoal,
					new Object[]{"  X"," X ","   ",
						Character.valueOf('X'),ultimateExchangeIgnition}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreDiamond,
					new Object[]{"   ","XX ","   ",
						Character.valueOf('X'),ultimateExchangeIgnition}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreEmerald,
					new Object[]{"   "," XX","   ",
						Character.valueOf('X'),ultimateExchangeIgnition}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreLapis,
					new Object[]{"   "," X ","X  ",
						Character.valueOf('X'),ultimateExchangeIgnition}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreNetherQuartz,
					new Object[]{"   "," X "," X ",
						Character.valueOf('X'),ultimateExchangeIgnition}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreRedstone,
					new Object[]{"   "," X ","  X",
						Character.valueOf('X'),ultimateExchangeIgnition}));
		}

		//鉱石粉クラフト
		if(OreDictionary.getOres("dustCoal").size() > 0)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					OreDictionary.getOres("dustCoal").get(0),
					new Object[]{Item.coal,"MortarTier01"}));
		}
		if(OreDictionary.getOres("dustNetherStar").size() > 0)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					OreDictionary.getOres("dustNetherStar").get(0),
					new Object[]{Item.netherStar,"MortarTier03"}));
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Item.netherStar,
					new Object[]{"dustNetherStar"}));
		}
		if(OreDictionary.getOres("dustBedrock").size() > 0)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					OreDictionary.getOres("dustBedrock").get(0),
					new Object[]{Block.bedrock,"MortarTier03"}));
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					new ItemStack(Block.bedrock,1),
					new Object[]{"dustBedrock"}));
		}
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.coal,ironMortarCrafting),
				new Object[]{"MortarOreTier01",Block.oreCoal}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.diamond,ironMortarCrafting),
				new Object[]{"MortarOreTier01",Block.oreDiamond}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.emerald,ironMortarCrafting),
				new Object[]{"MortarOreTier01",Block.oreEmerald}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.coal,diamondMortarCrafting),
				new Object[]{"MortarOreTier02",Block.oreCoal}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.diamond,diamondMortarCrafting),
				new Object[]{"MortarOreTier02",Block.oreDiamond}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.emerald,diamondMortarCrafting),
				new Object[]{"MortarOreTier02",Block.oreEmerald}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.coal,bedrockMortarCrafting),
				new Object[]{"MortarOreTier03",Block.oreCoal}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.diamond,bedrockMortarCrafting),
				new Object[]{"MortarOreTier03",Block.oreDiamond}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.emerald,bedrockMortarCrafting),
				new Object[]{"MortarOreTier03",Block.oreEmerald}));
		//Mod鉱石+バニラ鉱石粉
		if(mortarOreDust)
		{
			if(OreDictionary.getOres("dustIron").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustIron").get(0).getItem(),ironMortarCrafting,OreDictionary.getOres("dustIron").get(0).getItemDamage()),
						new Object[]{Block.oreIron,"MortarOreTier01"}));
			}
			if(OreDictionary.getOres("dustGold").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustGold").get(0).getItem(),ironMortarCrafting,OreDictionary.getOres("dustGold").get(0).getItemDamage()),
						new Object[]{Block.oreGold,"MortarOreTier01"}));
			}
			if((OreDictionary.getOres("dustCopper").size() > 0) && (OreDictionary.getOres("oreCopper").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustCopper").get(0).getItem(),ironMortarCrafting,OreDictionary.getOres("dustCopper").get(0).getItemDamage()),
						new Object[]{"oreCopper","MortarOreTier01"}));
			}
			if((OreDictionary.getOres("dustTin").size() > 0) && (OreDictionary.getOres("oreTin").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustTin").get(0).getItem(),ironMortarCrafting,OreDictionary.getOres("dustTin").get(0).getItemDamage()),
						new Object[]{"oreTin","MortarOreTier01"}));
			}
			if((OreDictionary.getOres("dustSilver").size() > 0) && (OreDictionary.getOres("oreSilver").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustSilver").get(0).getItem(),ironMortarCrafting,OreDictionary.getOres("dustSilver").get(0).getItemDamage()),
						new Object[]{"oreSilver","MortarOreTier01"}));
			}
			if((OreDictionary.getOres("dustLead").size() > 0) && (OreDictionary.getOres("oreLead").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustLead").get(0).getItem(),ironMortarCrafting,OreDictionary.getOres("dustLead").get(0).getItemDamage()),
						new Object[]{"oreLead","MortarOreTier01"}));
			}

			if(OreDictionary.getOres("dustIron").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustIron").get(0).getItem(),diamondMortarCrafting,OreDictionary.getOres("dustIron").get(0).getItemDamage()),
						new Object[]{Block.oreIron,"MortarOreTier02"}));
			}
			if(OreDictionary.getOres("dustGold").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustGold").get(0).getItem(),diamondMortarCrafting,OreDictionary.getOres("dustGold").get(0).getItemDamage()),
						new Object[]{Block.oreGold,"MortarOreTier02"}));
			}
			if((OreDictionary.getOres("dustCopper").size() > 0) && (OreDictionary.getOres("oreCopper").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustCopper").get(0).getItem(),diamondMortarCrafting,OreDictionary.getOres("dustCopper").get(0).getItemDamage()),
						new Object[]{"oreCopper","MortarOreTier02"}));
			}
			if((OreDictionary.getOres("dustTin").size() > 0) && (OreDictionary.getOres("oreTin").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustTin").get(0).getItem(),diamondMortarCrafting,OreDictionary.getOres("dustTin").get(0).getItemDamage()),
						new Object[]{"oreTin","MortarOreTier02"}));
			}
			if((OreDictionary.getOres("dustSilver").size() > 0) && (OreDictionary.getOres("oreSilver").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustSilver").get(0).getItem(),diamondMortarCrafting,OreDictionary.getOres("dustSilver").get(0).getItemDamage()),
						new Object[]{"oreSilver","MortarOreTier02"}));
			}
			if((OreDictionary.getOres("dustLead").size() > 0) && (OreDictionary.getOres("oreLead").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustLead").get(0).getItem(),diamondMortarCrafting,OreDictionary.getOres("dustLead").get(0).getItemDamage()),
						new Object[]{"oreLead","MortarOreTier02"}));
			}

			if(OreDictionary.getOres("dustIron").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustIron").get(0).getItem(),bedrockMortarCrafting,OreDictionary.getOres("dustIron").get(0).getItemDamage()),
						new Object[]{Block.oreIron,"MortarOreTier03"}));
			}
			if(OreDictionary.getOres("dustGold").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustGold").get(0).getItem(),bedrockMortarCrafting,OreDictionary.getOres("dustGold").get(0).getItemDamage()),
						new Object[]{Block.oreGold,"MortarOreTier03"}));
			}
			if((OreDictionary.getOres("dustCopper").size() > 0) && (OreDictionary.getOres("oreCopper").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustCopper").get(0).getItem(),bedrockMortarCrafting,OreDictionary.getOres("dustCopper").get(0).getItemDamage()),
						new Object[]{"oreCopper","MortarOreTier03"}));
			}
			if((OreDictionary.getOres("dustTin").size() > 0) && (OreDictionary.getOres("oreTin").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustTin").get(0).getItem(),bedrockMortarCrafting,OreDictionary.getOres("dustTin").get(0).getItemDamage()),
						new Object[]{"oreTin","MortarOreTier03"}));
			}
			if((OreDictionary.getOres("dustSilver").size() > 0) && (OreDictionary.getOres("oreSilver").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustSilver").get(0).getItem(),bedrockMortarCrafting,OreDictionary.getOres("dustSilver").get(0).getItemDamage()),
						new Object[]{"oreSilver","MortarOreTier03"}));
			}
			if((OreDictionary.getOres("dustLead").size() > 0) && (OreDictionary.getOres("oreLead").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustLead").get(0).getItem(),bedrockMortarCrafting,OreDictionary.getOres("dustLead").get(0).getItemDamage()),
						new Object[]{"oreLead","MortarOreTier03"}));
			}
		}
		if(mortarIngotDust)
		{
			if(OreDictionary.getOres("dustIron").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustIron").get(0).getItem(),1,OreDictionary.getOres("dustIron").get(0).getItemDamage()),
						new Object[]{Item.ingotIron,"MortarTier01"}));
			}
			if(OreDictionary.getOres("dustGold").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustGold").get(0).getItem(),1,OreDictionary.getOres("dustGold").get(0).getItemDamage()),
						new Object[]{Item.ingotGold,"MortarTier01"}));
			}
			if((OreDictionary.getOres("dustCopper").size() > 0) && (OreDictionary.getOres("ingotCopper").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustCopper").get(0).getItem(),1,OreDictionary.getOres("dustCopper").get(0).getItemDamage()),
						new Object[]{"ingotCopper","MortarTier01"}));
			}
			if((OreDictionary.getOres("dustTin").size() > 0) && (OreDictionary.getOres("ingotTin").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustTin").get(0).getItem(),1,OreDictionary.getOres("dustTin").get(0).getItemDamage()),
						new Object[]{"ingotTin","MortarTier01"}));
			}
			if((OreDictionary.getOres("dustSilver").size() > 0) && (OreDictionary.getOres("ingotSilver").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustSilver").get(0).getItem(),1,OreDictionary.getOres("dustSilver").get(0).getItemDamage()),
						new Object[]{"ingotSilver","MortarTier01"}));
			}
			if((OreDictionary.getOres("dustLead").size() > 0) && (OreDictionary.getOres("ingotLead").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustLead").get(0).getItem(),1,OreDictionary.getOres("dustLead").get(0).getItemDamage()),
						new Object[]{"ingotLead","MortarTier01"}));
			}
			if((OreDictionary.getOres("dustNickel").size() > 0) && (OreDictionary.getOres("ingotNickel").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustNickel").get(0).getItem(),1,OreDictionary.getOres("dustNickel").get(0).getItemDamage()),
						new Object[]{"ingotNickel","MortarTier01"}));
			}
			if((OreDictionary.getOres("dustPlatinum").size() > 0) && (OreDictionary.getOres("ingotPlatinum").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustPlatinum").get(0).getItem(),1,OreDictionary.getOres("dustPlatinum").get(0).getItemDamage()),
						new Object[]{"ingotPlatinum","MortarTier01"}));
			}
			if((OreDictionary.getOres("dustInvar").size() > 0) && (OreDictionary.getOres("ingotInvar").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustInvar").get(0).getItem(),1,OreDictionary.getOres("dustInvar").get(0).getItemDamage()),
						new Object[]{"ingotInvar","MortarTier01"}));
			}
			if((OreDictionary.getOres("dustBronse").size() > 0) && (OreDictionary.getOres("ingotBronse").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustBronse").get(0).getItem(),1,OreDictionary.getOres("dustBronse").get(0).getItemDamage()),
						new Object[]{"ingotBronse","MortarTier01"}));
			}
		}
		if(furnaceDustIngot)
		{
			if(OreDictionary.getOres("dustIron").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						Item.ingotIron,
						new Object[]{"dustIron",craftingFurnaceItem}));
			}
			if(OreDictionary.getOres("dustGold").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						Item.ingotGold,
						new Object[]{"dustGold",craftingFurnaceItem}));
			}
			if((OreDictionary.getOres("dustCopper").size() > 0) && (OreDictionary.getOres("ingotCopper").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotCopper").get(0).getItem(),1,OreDictionary.getOres("ingotCopper").get(0).getItemDamage()),
						new Object[]{"dustCopper",craftingFurnaceItem}));
			}
			if((OreDictionary.getOres("dustTin").size() > 0) && (OreDictionary.getOres("ingotTin").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotTin").get(0).getItem(),1,OreDictionary.getOres("ingotTin").get(0).getItemDamage()),
						new Object[]{"dustTin",craftingFurnaceItem}));
			}
			if((OreDictionary.getOres("dustSilver").size() > 0) && (OreDictionary.getOres("ingotSilver").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotSilver").get(0).getItem(),1,OreDictionary.getOres("ingotSilver").get(0).getItemDamage()),
						new Object[]{"dustSilver",craftingFurnaceItem}));
			}
			if((OreDictionary.getOres("dustLead").size() > 0) && (OreDictionary.getOres("ingotLead").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotLead").get(0).getItem(),1,OreDictionary.getOres("ingotLead").get(0).getItemDamage()),
						new Object[]{"dustLead",craftingFurnaceItem}));
			}
			if((OreDictionary.getOres("dustNickel").size() > 0) && (OreDictionary.getOres("ingotNickel").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotNickel").get(0).getItem(),1,OreDictionary.getOres("ingotNickel").get(0).getItemDamage()),
						new Object[]{"dustNickel",craftingFurnaceItem}));
			}
			if((OreDictionary.getOres("dustPlatinum").size() > 0) && (OreDictionary.getOres("ingotPlatinum").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotPlatinum").get(0).getItem(),1,OreDictionary.getOres("ingotPlatinum").get(0).getItemDamage()),
						new Object[]{"dustPlatinum",craftingFurnaceItem}));
			}
		}
		if((OreDictionary.getOres("oreTofu").size() > 0) && (OreDictionary.getOres("tofuGem").size() > 0))
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					new ItemStack(OreDictionary.getOres("tofuGem").get(0).getItem(),2,OreDictionary.getOres("tofuGem").get(0).getItemDamage()),
					new Object[]{"oreTofu","MortarTier01"}));
			FurnaceRecipes.smelting().addSmelting(
				OreDictionary.getOres("oreTofu").get(0).getItem().itemID,
				OreDictionary.getOres("oreTofu").get(0).getItemDamage(),
				new ItemStack(OreDictionary.getOres("tofuGem").get(0).getItem(),2,OreDictionary.getOres("tofuGem").get(0).getItemDamage()),
				0.0f);
		}
		//鉱石粉統一
		if(OreDictionary.getOres("dustCoal").size() > 1)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					OreDictionary.getOres("dustCoal").get(0),
					new Object[]{"dustCoal"}));
		}
		if(OreDictionary.getOres("dustObsidian").size() > 1)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					OreDictionary.getOres("dustObsidian").get(0),
					new Object[]{"dustObsidian"}));
		}
		if(OreDictionary.getOres("dustSulfur").size() > 1)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					OreDictionary.getOres("dustSulfur").get(0),
					new Object[]{"dustSulfur"}));
		}
		if(OreDictionary.getOres("dustSaltpeter").size() > 1)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					OreDictionary.getOres("dustSaltpeter").get(0),
					new Object[]{"dustSaltpeter"}));
		}
		if(OreDictionary.getOres("dustCopper").size() > 1)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					OreDictionary.getOres("dustCopper").get(0),
					new Object[]{"dustCopper"}));
		}
		if(OreDictionary.getOres("dustTin").size() > 1)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					OreDictionary.getOres("dustTin").get(0),
					new Object[]{"dustTin"}));
		}
		if(OreDictionary.getOres("dustIron").size() > 1)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					OreDictionary.getOres("dustIron").get(0),
					new Object[]{"dustIron"}));
		}
		if(OreDictionary.getOres("dustGold").size() > 1)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					OreDictionary.getOres("dustGold").get(0),
					new Object[]{"dustGold"}));
		}

		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				exchangeIgnitionItem,
				new Object[]{" X ","XYX"," X ",
					Character.valueOf('X'),Item.netherStar,
					Character.valueOf('Y'),Block.dragonEgg}));

		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				gravitationFeatherItem,
				new Object[]{" X ","XYX"," X ",
					Character.valueOf('X'),Item.feather,
					Character.valueOf('Y'),Item.diamond}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				superGravitationFeatherItem,
				new Object[]{" X ","XYX"," X ",
					Character.valueOf('X'),Block.blockDiamond,
					Character.valueOf('Y'),gravitationFeatherItem}));

		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				Block.dragonEgg,
				new Object[]{"XXX","XYX","XXX",
					Character.valueOf('X'),Item.netherStar,
					Character.valueOf('Y'),"ExchangeIgnition"}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				Block.bedrock,
				new Object[]{"XYX","YZY","XYX",
					Character.valueOf('X'),Item.netherStar,
					Character.valueOf('Y'),Block.obsidian,
					Character.valueOf('Z'),"ExchangeIgnition"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Item.netherStar,
				new Object[]{new ItemStack(Item.skull,1,1),"ExchangeIgnition"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Item.emerald,
				new Object[]{Item.diamond,"ExchangeIgnition"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Item.diamond,
				new Object[]{Item.emerald,"ExchangeIgnition"}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				craftingFurnaceItem,
				new Object[]{"XYX","YZY","XYX",
					Character.valueOf('X'),Item.diamond,
					Character.valueOf('Y'),Item.coal,
					Character.valueOf('Z'),"ExchangeIgnition"}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				new ItemStack(Item.skull,1,1),
				new Object[]{"XXX","XYX","XXX",
					Character.valueOf('X'),Item.enderPearl,
					Character.valueOf('Y'),"ExchangeIgnition"}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				Item.enderPearl,
				new Object[]{"XXX","XYX","XXX",
					Character.valueOf('X'),Item.rottenFlesh,
					Character.valueOf('Y'),"ExchangeIgnition"}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				Item.enderPearl,
				new Object[]{"XXX","XYX","XXX",
					Character.valueOf('X'),Item.bone,
					Character.valueOf('Y'),"ExchangeIgnition"}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				Item.enderPearl,
				new Object[]{"XXX","XYX","XXX",
					Character.valueOf('X'),Item.gunpowder,
					Character.valueOf('Y'),"ExchangeIgnition"}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Item.glowstone,
				new Object[]{"ExchangeIgnition",Item.redstone}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Block.obsidian,8,0),
				new Object[]{Item.bucketLava,Item.bucketWater,"ExchangeIgnition"}));

		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Block.grass,
				new Object[]{Item.seeds,Block.dirt}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				Block.cactus,
				new Object[]{"XXX","XYX","XXX",
					Character.valueOf('X'),Item.seeds,
					Character.valueOf('Y'),Block.sand}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				Item.blazeRod,
				new Object[]{"XYX","XYX","XYX",
					Character.valueOf('X'),Item.glowstone,
					Character.valueOf('Y'),Item.stick}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				Item.book,
				new Object[]{"XXX",
					Character.valueOf('X'),Item.paper}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				nightVisionTorchItem,
				new Object[]{"XXX","XYX","XXX",
					Character.valueOf('X'),Block.glowStone,
					Character.valueOf('Y'),Item.blazeRod}));
		/*
		if(Loader.isModLoaded("Mystcraft"))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					new ItemStack(MystObjects.link_modifer),
						new Object[]{"XXX","XYX","XXX",
							Character.valueOf('X'),Block.blockDiamond,
							Character.valueOf('Y'),Block.blockGold}));
		}
		if(Loader.isModLoaded("AppliedEnergistics"))
		{
			if(OreDictionary.getOres("dustWheat").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						OreDictionary.getOres("dustWheat").get(0),
						new Object[]{Item.wheat}));
			}
		}
		MinecraftForge.EVENT_BUS.register(new ExchangeIgnitionLivingEventHooks());
		try
		{
			MFR = Class.forName("powercrystals.minefactoryreloaded.MineFactoryReloadedCore");
			Object pinkSlimeBall = MFR.getField("pinkSlimeballItem").get(null);
			ItemStack pink = new ItemStack((Item)pinkSlimeBall);
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					pink,
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Item.rottenFlesh,
						Character.valueOf('Y'),Item.slimeBall}));
		}
		catch(Exception e)
		{
			System.out.println("[AdditionalRecipe]:Can't Find MineFactory Reloaded");
		}
		try
		{
			BC = Class.forName("buildcraft.BuildCraftCore");
			Object springBlock = BC.getField("springBlock").get(null);
			Block spring = (Block)springBlock;
			if(digBCSpring)
			{
				spring.setHardness(60F);
			}
		}
		catch(Exception e)
		{
			System.out.println("[AdditionalRecipe]:Can't Find BuildCraft");
		}
		*/
		if(digEndPortal)
		{
			Block.endPortalFrame.setHardness(60F);
		}
		if(craftingEndPortal)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.endPortalFrame,
					new Object[]{" X ","YZY","WVW",
						Character.valueOf('X'),Item.eyeOfEnder,
						Character.valueOf('Y'),Block.blockEmerald,
						Character.valueOf('Z'),Item.cauldron,
						Character.valueOf('W'),Block.obsidian,
						Character.valueOf('V'),Block.blockDiamond}));
		}
		
		try
		{
			MoInv = Class.forName("moreinventory.MoreInventoryMod");
			Object WoodContainer = MoInv.getField("StorageBox").get(null);
			ItemStack Diamond = new ItemStack((Item)WoodContainer,1,3);
			ItemStack Emerald = new ItemStack((Item)WoodContainer,3,10);
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Emerald,
					new Object[]{"XYX","XZX","XYX",
						Character.valueOf('X'),Item.emerald,
						Character.valueOf('Y'),Block.stoneSingleSlab,
						Character.valueOf('Z'),Diamond}));
		}
		catch(Exception e)
		{
			System.out.println("[AdditionalRecipe]:Can't Find MoreInventoryMod");
		}
		for(int var1 = 0;var1 < 5;++var1)
		{
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Item.skull,1,1),new Object[]{new ItemStack(Item.skull,1,var1)}));
		}
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				Item.enderPearl,
				new Object[]{"XXX","XYX","XXX",
					Character.valueOf('X'),new ItemStack(Block.sapling,1,32767),
					Character.valueOf('Y'),Item.slimeBall}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				Item.enderPearl,
				new Object[]{"XXX","XYX","XXX",
					Character.valueOf('X'),"treeSapling",
					Character.valueOf('Y'),Item.slimeBall}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				new ItemStack(Item.clay,8),
				new Object[]{"XXX","XYX","XXX",
					Character.valueOf('X'),Block.sand,
					Character.valueOf('Y'),Block.gravel}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				Block.pistonBase,
				new Object[]{"XXX","YZY","YWY",
					Character.valueOf('X'),"plankWood",
					Character.valueOf('Y'),"cobblestone",
					Character.valueOf('Z'),"ingotBronze",
					Character.valueOf('W'),Item.redstone}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				Block.pistonBase,
				new Object[]{"XXX","YZY","YWY",
					Character.valueOf('X'),"plankWood",
					Character.valueOf('Y'),"cobblestone",
					Character.valueOf('Z'),"ingotSteel",
					Character.valueOf('W'),Item.redstone}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				Block.pistonBase,
				new Object[]{"XXX","YZY","YWY",
					Character.valueOf('X'),"plankWood",
					Character.valueOf('Y'),"cobblestone",
					Character.valueOf('Z'),"ingotInvar",
					Character.valueOf('W'),Item.redstone}));

		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.expBottle,3),
				new Object[]{Item.glassBottle,Item.glassBottle,Item.glassBottle,Item.eyeOfEnder}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Item.blazeRod,
				new Object[]{Item.blazePowder,Item.blazePowder}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Item.slimeBall,
				new Object[]{Item.seeds,Item.seeds,Item.seeds,Item.seeds}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Block.mushroomBrown,
				new Object[]{Block.mushroomRed}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				Block.mushroomRed,
				new Object[]{Block.mushroomBrown}));
		ItemStack CertusQuartz,CertusDust,NetherDust;
		ItemStack BlackShard,BlackCrystal;
		ItemStack RedShard,RedCrystal;
		ItemStack GreenShard,GreenCrystal;
		ItemStack BrownShard,BrownCrystal;
		ItemStack BlueShard,BlueCrystal;
		ItemStack PurpleShard,PurpleCrystal;
		ItemStack CyanShard,CyanCrystal;
		ItemStack LightGrayShard,LightGrayCrystal;
		ItemStack GrayShard,GrayCrystal;
		ItemStack PinkShard,PinkCrystal;
		ItemStack LimeShard,LimeCrystal;
		ItemStack YellowShard,YellowCrystal;
		ItemStack LightBlueShard,LightBlueCrystal;
		ItemStack MagentaShard,MagentaCrystal;
		ItemStack OrangeShard,OrangeCrystal;
		ItemStack WhiteShard,WhiteCrystal;
		if((OreDictionary.getOres("crystalCertusQuartz").size() != 0) && (OreDictionary.getOres("dustCertusQuartz").size() != 0) && (OreDictionary.getOres("dustNetherQuartz").size() != 0))
		{
			CertusQuartz = OreDictionary.getOres("crystalCertusQuartz").get(0);
			CertusDust   = OreDictionary.getOres("dustCertusQuartz").get(0);
			NetherDust   = OreDictionary.getOres("dustNetherQuartz").get(0);
			GameRegistry.addSmelting(Block.whiteStone.blockID, new ItemStack(CertusDust.getItem(),4,7), 0.0f);
			GameRegistry.addShapelessRecipe(CertusQuartz,new Object[]{CertusDust,Block.sand});
			GameRegistry.addShapelessRecipe(new ItemStack(Item.netherQuartz,1,0),new Object[]{NetherDust,Block.sand});
			if(craftingCrystal)
			{
				if((OreDictionary.getOres("dyeBlackCrystalShard").size() != 0) && (OreDictionary.getOres("dyeBlackCrystal").size() != 0))
				{
					BlackShard = OreDictionary.getOres("dyeBlackCrystalShard").get(0);
					BlackCrystal = OreDictionary.getOres("dyeBlackCrystal").get(0);
					GameRegistry.addShapelessRecipe(BlackShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,0)});
					GameRegistry.addShapelessRecipe(BlackCrystal,new Object[]{BlackShard,BlackShard,BlackShard,BlackShard});
					FurnaceRecipes.smelting().addSmelting(BlackCrystal.itemID,0,new ItemStack(BlackShard.getItem(),4,0), 0.0f);
				}
				if((OreDictionary.getOres("dyeRedCrystalShard").size() != 0) && (OreDictionary.getOres("dyeRedCrystal").size() != 0))
				{
					RedShard = OreDictionary.getOres("dyeRedCrystalShard").get(0);
					RedCrystal = OreDictionary.getOres("dyeRedCrystal").get(0);
					GameRegistry.addShapelessRecipe(RedShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,1)});
					GameRegistry.addShapelessRecipe(RedCrystal,new Object[]{RedShard,RedShard,RedShard,RedShard});
					FurnaceRecipes.smelting().addSmelting(RedCrystal.itemID,1,new ItemStack(RedShard.getItem(),4,1), 0.0f);
				}
				if((OreDictionary.getOres("dyeGreenCrystalShard").size() != 0) && (OreDictionary.getOres("dyeGreenCrystal").size() != 0))
				{
					GreenShard = OreDictionary.getOres("dyeGreenCrystalShard").get(0);
					GreenCrystal = OreDictionary.getOres("dyeGreenCrystal").get(0);
					GameRegistry.addShapelessRecipe(GreenShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,2)});
					GameRegistry.addShapelessRecipe(GreenCrystal,new Object[]{GreenShard,GreenShard,GreenShard,GreenShard});
					FurnaceRecipes.smelting().addSmelting(GreenCrystal.itemID,2,new ItemStack(GreenShard.getItem(),4,2), 0.0f);
				}
				if((OreDictionary.getOres("dyeBrownCrystalShard").size() != 0) && (OreDictionary.getOres("dyeBrownCrystal").size() != 0))
				{
					BrownShard = OreDictionary.getOres("dyeBrownCrystalShard").get(0);
					BrownCrystal = OreDictionary.getOres("dyeBrownCrystal").get(0);
					GameRegistry.addShapelessRecipe(BrownShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,3)});
					GameRegistry.addShapelessRecipe(BrownCrystal,new Object[]{BrownShard,BrownShard,BrownShard,BrownShard});
					FurnaceRecipes.smelting().addSmelting(BrownCrystal.itemID,3,new ItemStack(BrownShard.getItem(),4,3), 0.0f);
				}
				if((OreDictionary.getOres("dyeBlueCrystalShard").size() != 0) && (OreDictionary.getOres("dyeBlueCrystal").size() != 0))
				{
					BlueShard = OreDictionary.getOres("dyeBlueCrystalShard").get(0);
					BlueCrystal = OreDictionary.getOres("dyeBlueCrystal").get(0);
					GameRegistry.addShapelessRecipe(BlueShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,4)});
					GameRegistry.addShapelessRecipe(BlueCrystal,new Object[]{BlueShard,BlueShard,BlueShard,BlueShard});
					FurnaceRecipes.smelting().addSmelting(BlueCrystal.itemID,4,new ItemStack(BlueShard.getItem(),4,4), 0.0f);
				}
				if((OreDictionary.getOres("dyePurpleCrystalShard").size() != 0) && (OreDictionary.getOres("dyePurpleCrystal").size() != 0))
				{
					PurpleShard = OreDictionary.getOres("dyePurpleCrystalShard").get(0);
					PurpleCrystal = OreDictionary.getOres("dyePurpleCrystal").get(0);
					GameRegistry.addShapelessRecipe(PurpleShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,5)});
					GameRegistry.addShapelessRecipe(PurpleCrystal,new Object[]{PurpleShard,PurpleShard,PurpleShard,PurpleShard});
					FurnaceRecipes.smelting().addSmelting(PurpleCrystal.itemID,5,new ItemStack(PurpleShard.getItem(),4,5), 0.0f);
				}
				if((OreDictionary.getOres("dyeCyanCrystalShard").size() != 0) && (OreDictionary.getOres("dyeCyanCrystal").size() != 0))
				{
					CyanShard = OreDictionary.getOres("dyeCyanCrystalShard").get(0);
					CyanCrystal = OreDictionary.getOres("dyeCyanCrystal").get(0);
					GameRegistry.addShapelessRecipe(CyanShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,6)});
					GameRegistry.addShapelessRecipe(CyanCrystal,new Object[]{CyanShard,CyanShard,CyanShard,CyanShard});
					FurnaceRecipes.smelting().addSmelting(CyanCrystal.itemID,6,new ItemStack(CyanShard.getItem(),4,6), 0.0f);
				}
				if((OreDictionary.getOres("dyeLightGrayCrystalShard").size() != 0) && (OreDictionary.getOres("dyeLightGrayCrystal").size() != 0))
				{
					LightGrayShard = OreDictionary.getOres("dyeLightGrayCrystalShard").get(0);
					LightGrayCrystal = OreDictionary.getOres("dyeLightGrayCrystal").get(0);
					GameRegistry.addShapelessRecipe(LightGrayShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,7)});
					GameRegistry.addShapelessRecipe(LightGrayCrystal,new Object[]{LightGrayShard,LightGrayShard,LightGrayShard,LightGrayShard});
					FurnaceRecipes.smelting().addSmelting(LightGrayCrystal.itemID,7,new ItemStack(LightGrayShard.getItem(),4,7), 0.0f);
				}
				if((OreDictionary.getOres("dyeGrayCrystalShard").size() != 0) && (OreDictionary.getOres("dyeGrayCrystal").size() != 0))
				{
					GrayShard = OreDictionary.getOres("dyeGrayCrystalShard").get(0);
					GrayCrystal = OreDictionary.getOres("dyeGrayCrystal").get(0);
					GameRegistry.addShapelessRecipe(GrayShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,8)});
					GameRegistry.addShapelessRecipe(GrayCrystal,new Object[]{GrayShard,GrayShard,GrayShard,GrayShard});
					FurnaceRecipes.smelting().addSmelting(GrayCrystal.itemID,8,new ItemStack(GrayShard.getItem(),4,8), 0.0f);
				}
				if((OreDictionary.getOres("dyePinkCrystalShard").size() != 0) && (OreDictionary.getOres("dyePinkCrystal").size() != 0))
				{
					PinkShard = OreDictionary.getOres("dyePinkCrystalShard").get(0);
					PinkCrystal = OreDictionary.getOres("dyePinkCrystal").get(0);
					GameRegistry.addShapelessRecipe(PinkShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,9)});
					GameRegistry.addShapelessRecipe(PinkCrystal,new Object[]{PinkShard,PinkShard,PinkShard,PinkShard});
					FurnaceRecipes.smelting().addSmelting(PinkCrystal.itemID,9,new ItemStack(PinkShard.getItem(),4,9), 0.0f);
				}
				if((OreDictionary.getOres("dyeLimeCrystalShard").size() != 0) && (OreDictionary.getOres("dyeLimeCrystal").size() != 0))
				{
					LimeShard = OreDictionary.getOres("dyeLimeCrystalShard").get(0);
					LimeCrystal = OreDictionary.getOres("dyeLimeCrystal").get(0);
					GameRegistry.addShapelessRecipe(LimeShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,10)});
					GameRegistry.addShapelessRecipe(LimeCrystal,new Object[]{LimeShard,LimeShard,LimeShard,LimeShard});
					FurnaceRecipes.smelting().addSmelting(LimeCrystal.itemID,10,new ItemStack(LimeShard.getItem(),4,10), 0.0f);
				}
				if((OreDictionary.getOres("dyeYellowCrystalShard").size() != 0) && (OreDictionary.getOres("dyeYellowCrystal").size() != 0))
				{
					YellowShard = OreDictionary.getOres("dyeYellowCrystalShard").get(0);
					YellowCrystal = OreDictionary.getOres("dyeYellowCrystal").get(0);
					GameRegistry.addShapelessRecipe(YellowShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,11)});
					GameRegistry.addShapelessRecipe(YellowCrystal,new Object[]{YellowShard,YellowShard,YellowShard,YellowShard});
					FurnaceRecipes.smelting().addSmelting(YellowCrystal.itemID,11,new ItemStack(YellowShard.getItem(),4,11), 0.0f);
				}
				if((OreDictionary.getOres("dyeLightBlueCrystalShard").size() != 0) && (OreDictionary.getOres("dyeLightBlueCrystal").size() != 0))
				{
					LightBlueShard = OreDictionary.getOres("dyeLightBlueCrystalShard").get(0);
					LightBlueCrystal = OreDictionary.getOres("dyeLightBlueCrystal").get(0);
					GameRegistry.addShapelessRecipe(LightBlueShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,12)});
					GameRegistry.addShapelessRecipe(LightBlueCrystal,new Object[]{LightBlueShard,LightBlueShard,LightBlueShard,LightBlueShard});
					FurnaceRecipes.smelting().addSmelting(LightBlueCrystal.itemID,12,new ItemStack(LightBlueShard.getItem(),4,12), 0.0f);
				}
				if((OreDictionary.getOres("dyeMagentaCrystalShard").size() != 0) && (OreDictionary.getOres("dyeMagentaCrystal").size() != 0))
				{
					MagentaShard = OreDictionary.getOres("dyeMagentaCrystalShard").get(0);
					MagentaCrystal = OreDictionary.getOres("dyeMagentaCrystal").get(0);
					GameRegistry.addShapelessRecipe(MagentaShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,13)});
					GameRegistry.addShapelessRecipe(MagentaCrystal,new Object[]{MagentaShard,MagentaShard,MagentaShard,MagentaShard});
					FurnaceRecipes.smelting().addSmelting(MagentaCrystal.itemID,13,new ItemStack(MagentaShard.getItem(),4,13), 0.0f);
				}
				if((OreDictionary.getOres("dyeOrangeCrystalShard").size() != 0) && (OreDictionary.getOres("dyeOrangeCrystal").size() != 0))
				{
					OrangeShard = OreDictionary.getOres("dyeOrangeCrystalShard").get(0);
					OrangeCrystal = OreDictionary.getOres("dyeOrangeCrystal").get(0);
					GameRegistry.addShapelessRecipe(OrangeShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,14)});
					GameRegistry.addShapelessRecipe(OrangeCrystal,new Object[]{OrangeShard,OrangeShard,OrangeShard,OrangeShard});
					FurnaceRecipes.smelting().addSmelting(OrangeCrystal.itemID,14,new ItemStack(OrangeShard.getItem(),4,14), 0.0f);
				}
				if((OreDictionary.getOres("dyeWhiteCrystalShard").size() != 0) && (OreDictionary.getOres("dyeWhiteCrystal").size() != 0))
				{
					WhiteShard = OreDictionary.getOres("dyeWhiteCrystalShard").get(0);
					WhiteCrystal = OreDictionary.getOres("dyeWhiteCrystal").get(0);
					GameRegistry.addShapelessRecipe(WhiteShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,15)});
					GameRegistry.addShapelessRecipe(WhiteCrystal,new Object[]{WhiteShard,WhiteShard,WhiteShard,WhiteShard});
					FurnaceRecipes.smelting().addSmelting(WhiteCrystal.itemID,15,new ItemStack(WhiteShard.getItem(),4,15), 0.0f);
				}
			}
		}
		GameRegistry.addSmelting(Block.stoneBrick.blockID,new ItemStack(Block.netherBrick,1),0.0f);
		GameRegistry.addSmelting(Block.dirt.blockID,new ItemStack(Block.netherrack,1),0.0f);
		GameRegistry.addSmelting(Item.rottenFlesh.itemID,new ItemStack(Item.leather,1),0.0f);
		GameRegistry.addSmelting(Item.redstone.itemID,new ItemStack(Item.glowstone,1),0.0f);
		GameRegistry.addSmelting(Item.minecartEmpty.itemID,new ItemStack(Item.ingotIron,5),0.0f);
		GameRegistry.addSmelting(Item.doorIron.itemID,new ItemStack(Item.ingotIron,6),0.0f);
		GameRegistry.addSmelting(Item.doorWood.itemID,new ItemStack(Item.coal,2,1),0.0f);
		if(smeltingTool)
		{
			FurnaceRecipes.smelting().addSmelting(Item.axeWood.itemID,new ItemStack(Item.coal,1,1),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.hoeWood.itemID,new ItemStack(Item.coal,1,1),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.pickaxeWood.itemID,new ItemStack(Item.coal,1,1),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.swordWood.itemID,new ItemStack(Item.coal,1,1),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.shovelWood.itemID,new ItemStack(Item.coal,1,1),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.axeStone.itemID,new ItemStack(Block.stone,3,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.hoeStone.itemID,new ItemStack(Block.stone,2,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.pickaxeStone.itemID,new ItemStack(Block.stone,3,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.swordStone.itemID,new ItemStack(Block.stone,2,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.shovelStone.itemID,new ItemStack(Block.stone,1,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.axeIron.itemID,new ItemStack(Item.ingotIron,3,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.hoeIron.itemID,new ItemStack(Item.ingotIron,2,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.pickaxeIron.itemID,new ItemStack(Item.ingotIron,3,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.swordIron.itemID,new ItemStack(Item.ingotIron,2,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.shovelIron.itemID,new ItemStack(Item.ingotIron,1,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.axeGold.itemID,new ItemStack(Item.ingotGold,3,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.hoeGold.itemID,new ItemStack(Item.ingotGold,2,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.pickaxeGold.itemID,new ItemStack(Item.ingotGold,3,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.swordGold.itemID,new ItemStack(Item.ingotGold,2,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.shovelGold.itemID,new ItemStack(Item.ingotGold,1,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.axeDiamond.itemID,new ItemStack(Item.diamond,3,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.hoeDiamond.itemID,new ItemStack(Item.diamond,2,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.pickaxeDiamond.itemID,new ItemStack(Item.diamond,3,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.swordDiamond.itemID,new ItemStack(Item.diamond,2,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.shovelDiamond.itemID,new ItemStack(Item.diamond,1,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.helmetChain.itemID,new ItemStack(Item.ingotIron,5,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.plateChain.itemID,new ItemStack(Item.ingotIron,8,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.legsChain.itemID,new ItemStack(Item.ingotIron,7,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.bootsChain.itemID,new ItemStack(Item.ingotIron,4,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.helmetIron.itemID,new ItemStack(Item.ingotIron,5,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.plateIron.itemID,new ItemStack(Item.ingotIron,8,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.legsIron.itemID,new ItemStack(Item.ingotIron,7,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.bootsIron.itemID,new ItemStack(Item.ingotIron,4,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.helmetGold.itemID,new ItemStack(Item.ingotGold,5,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.plateGold.itemID,new ItemStack(Item.ingotGold,8,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.legsGold.itemID,new ItemStack(Item.ingotGold,7,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.bootsGold.itemID,new ItemStack(Item.ingotGold,4,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.helmetDiamond.itemID,new ItemStack(Item.diamond,5,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.plateDiamond.itemID,new ItemStack(Item.diamond,8,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.legsDiamond.itemID,new ItemStack(Item.diamond,7,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.bootsDiamond.itemID,new ItemStack(Item.diamond,4,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.helmetLeather.itemID,new ItemStack(Item.leather,5,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.plateLeather.itemID,new ItemStack(Item.leather,8,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.legsLeather.itemID,new ItemStack(Item.leather,7,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.bootsLeather.itemID,new ItemStack(Item.leather,4,0),0.0f);
			FurnaceRecipes.smelting().addSmelting(Item.bow.itemID,new ItemStack(Item.silk,3,0),0.0f);
		}
	}
}