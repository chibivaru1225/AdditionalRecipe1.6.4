package chibivaru.additionalrecipe.recipe;

import static chibivaru.additionalrecipe.common.ARConfiguration.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import chibivaru.additionalrecipe.common.ARItemHandler;

public class RecipeHandler {
	RecipeARItems         recipeadditionalitems;
	RecipeAnotherMod      recipeanothermod;
	RecipeCrystal         recipecrystal;
	RecipeDusts           recipedusts;
	RecipeItems           recipeitems;
	RecipeMortar          recipemortar;
	RecipeOreDic          recipeoredic;
	RecipeOres            recipeores;
	RecipeSmelting        recipesmelting;
	public final static String RECIPE   = " crafting recipe";
	public final static String OREDIC   = " oredictionary";
	public final static String ADDED    = " was added.";
	public final static String NOTADDED = " was not added.";
	public void init()
	{
		recipeadditionalitems = new RecipeARItems();
		recipeanothermod      = new RecipeAnotherMod();
		recipecrystal         = new RecipeCrystal();
		recipedusts           = new RecipeDusts();
		recipeitems           = new RecipeItems();
		recipemortar          = new RecipeMortar();
		recipeoredic          = new RecipeOreDic();
		recipeores            = new RecipeOres();
		recipesmelting        = new RecipeSmelting();

		recipeadditionalitems.init();
		recipeanothermod.init();
		recipecrystal.init();
		recipedusts.init();
		recipeitems.init();
		recipemortar.init();
		recipeoredic.init();
		recipeores.init();
		recipesmelting.init();
	}
	public void oredic()
	{
		if(ARGetAnother("ExpBottle",false))
		{
			OreDictionary.registerOre("item_Fragment",Item.expBottle);
		}

		OreDictionary.registerOre("dustNetherStar",ARItemHandler.ARGetItemRegister("dustnetherstar"));
		OreDictionary.registerOre("dustBedrock",ARItemHandler.ARGetItemRegister("dustbedrock"));

		OreDictionary.registerOre("MortarTier01",ARItemHandler.ARGetItemRegister("bedrockmortar"));
		OreDictionary.registerOre("MortarTier02",ARItemHandler.ARGetItemRegister("bedrockmortar"));
		OreDictionary.registerOre("MortarTier03",ARItemHandler.ARGetItemRegister("bedrockmortar"));
		OreDictionary.registerOre("MortarOreTier03",ARItemHandler.ARGetItemRegister("bedrockmortar"));

		OreDictionary.registerOre("MortarTier01",new ItemStack(ARItemHandler.ARGetItemRegister("diamondmortar"),1,32767));
		OreDictionary.registerOre("MortarTier02",new ItemStack(ARItemHandler.ARGetItemRegister("diamondmortar"),1,32767));
		OreDictionary.registerOre("MortarOreTier02",new ItemStack(ARItemHandler.ARGetItemRegister("diamondmortar"),1,32767));

		OreDictionary.registerOre("MortarTier01",new ItemStack(ARItemHandler.ARGetItemRegister("ironmortar"),1,32767));
		OreDictionary.registerOre("MortarOreTier01",new ItemStack(ARItemHandler.ARGetItemRegister("ironmortar"),1,32767));

		OreDictionary.registerOre("ExchangeIgnition",ARItemHandler.ARGetItemRegister("exchangeiginiton"));
		OreDictionary.registerOre("ExchangeIgnition",ARItemHandler.ARGetItemRegister("ultimateexchangeiginiton"));
		OreDictionary.registerOre("ExchangeIgnition",new ItemStack(ARItemHandler.ARGetItemRegister("cheaperexchangeiginiton"),1,32767));
	}
}
