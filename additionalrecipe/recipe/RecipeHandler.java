package chibivaru.additionalrecipe.recipe;

import chibivaru.additionalrecipe.AdditionalRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeHandler {
	RecipeAnotherMod      recipeanothermod;
	RecipeAdditionalItems recipeadditionalitems;
	public void init()
	{
		recipeanothermod      = new RecipeAnotherMod();
		recipeadditionalitems = new RecipeAdditionalItems();
		
		recipeanothermod.init();
		recipeadditionalitems.init();
	}
	public void oredic()
	{

		OreDictionary.registerOre("item_Fragment",Item.expBottle);

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
