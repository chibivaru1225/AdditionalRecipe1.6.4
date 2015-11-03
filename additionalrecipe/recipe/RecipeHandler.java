package chibivaru.additionalrecipe.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import chibivaru.additionalrecipe.AdditionalRecipe;

public class RecipeHandler {
	RecipeAdditionalItems recipeadditionalitems;
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
		recipeadditionalitems = new RecipeAdditionalItems();
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
		if(AdditionalRecipe.addOreDicExpBottle)
		{
			OreDictionary.registerOre("item_Fragment",Item.expBottle);
			if(AdditionalRecipe.printInAddRecipe)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "ExpBottle" + OREDIC + ADDED);
			}
		}
		else
		{
			if(AdditionalRecipe.printInAddRecipe)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "ExpBottle" + OREDIC + NOTADDED);
			}
		}

		OreDictionary.registerOre("dustNetherStar",AdditionalRecipe.dustNetherStarItem);
		if(AdditionalRecipe.printInAddRecipe)
		{
			System.out.println(AdditionalRecipe.CONSOLE + "DustNetherStar" + OREDIC + ADDED);
		}
		OreDictionary.registerOre("dustBedrock",AdditionalRecipe.dustBedrockItem);
		if(AdditionalRecipe.printInAddRecipe)
		{
			System.out.println(AdditionalRecipe.CONSOLE + "DustBedrock" + OREDIC + ADDED);
		}

		OreDictionary.registerOre("MortarTier01",AdditionalRecipe.bedrockMortar);
		OreDictionary.registerOre("MortarTier02",AdditionalRecipe.bedrockMortar);
		OreDictionary.registerOre("MortarTier03",AdditionalRecipe.bedrockMortar);
		OreDictionary.registerOre("MortarOreTier03",AdditionalRecipe.bedrockMortar);
		if(AdditionalRecipe.printInAddRecipe)
		{
			System.out.println(AdditionalRecipe.CONSOLE + "BedrockMortar" + OREDIC + ADDED);
		}

		OreDictionary.registerOre("MortarTier01",new ItemStack(AdditionalRecipe.diamondMortar,1,32767));
		OreDictionary.registerOre("MortarTier02",new ItemStack(AdditionalRecipe.diamondMortar,1,32767));
		OreDictionary.registerOre("MortarOreTier02",new ItemStack(AdditionalRecipe.diamondMortar,1,32767));
		if(AdditionalRecipe.printInAddRecipe)
		{
			System.out.println(AdditionalRecipe.CONSOLE + "DiamondMortar" + OREDIC + ADDED);
		}

		OreDictionary.registerOre("MortarTier01",new ItemStack(AdditionalRecipe.ironMortar,1,32767));
		OreDictionary.registerOre("MortarOreTier01",new ItemStack(AdditionalRecipe.ironMortar,1,32767));
		if(AdditionalRecipe.printInAddRecipe)
		{
			System.out.println(AdditionalRecipe.CONSOLE + "IronMortar" + OREDIC + ADDED);
		}

		OreDictionary.registerOre("ExchangeIgnition",AdditionalRecipe.exchangeIgniniton);
		if(AdditionalRecipe.printInAddRecipe)
		{
			System.out.println(AdditionalRecipe.CONSOLE + "ExchangeIgnition" + OREDIC + ADDED);
		}
		OreDictionary.registerOre("ExchangeIgnition",AdditionalRecipe.ultimateExchangeIgnition);
		if(AdditionalRecipe.printInAddRecipe)
		{
			System.out.println(AdditionalRecipe.CONSOLE + "UltimateExchangeIgnition" + OREDIC + ADDED);
		}
		OreDictionary.registerOre("ExchangeIgnition",new ItemStack(AdditionalRecipe.cheaperExchangeIgnition,1,32767));
		if(AdditionalRecipe.printInAddRecipe)
		{
			System.out.println(AdditionalRecipe.CONSOLE + "CheaperExchangeIgnition" + OREDIC + ADDED);
		}
	}
}
