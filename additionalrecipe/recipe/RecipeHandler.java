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
		}

		OreDictionary.registerOre("dustNetherStar",AdditionalRecipe.dustNetherStarItem);
		OreDictionary.registerOre("dustBedrock",AdditionalRecipe.dustBedrockItem);

		OreDictionary.registerOre("MortarTier01",AdditionalRecipe.bedrockMortar);
		OreDictionary.registerOre("MortarTier02",AdditionalRecipe.bedrockMortar);
		OreDictionary.registerOre("MortarTier03",AdditionalRecipe.bedrockMortar);
		OreDictionary.registerOre("MortarOreTier03",AdditionalRecipe.bedrockMortar);

		OreDictionary.registerOre("MortarTier01",new ItemStack(AdditionalRecipe.diamondMortar,1,32767));
		OreDictionary.registerOre("MortarTier02",new ItemStack(AdditionalRecipe.diamondMortar,1,32767));
		OreDictionary.registerOre("MortarOreTier02",new ItemStack(AdditionalRecipe.diamondMortar,1,32767));

		OreDictionary.registerOre("MortarTier01",new ItemStack(AdditionalRecipe.ironMortar,1,32767));
		OreDictionary.registerOre("MortarOreTier01",new ItemStack(AdditionalRecipe.ironMortar,1,32767));

		OreDictionary.registerOre("ExchangeIgnition",AdditionalRecipe.exchangeIgniniton);
		OreDictionary.registerOre("ExchangeIgnition",AdditionalRecipe.ultimateExchangeIgnition);
		OreDictionary.registerOre("ExchangeIgnition",new ItemStack(AdditionalRecipe.cheaperExchangeIgnition,1,32767));
	}
}
