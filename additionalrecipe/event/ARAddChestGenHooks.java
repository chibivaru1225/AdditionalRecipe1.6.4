package chibivaru.additionalrecipe.event;

import chibivaru.additionalrecipe.AdditionalRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class ARAddChestGenHooks {
	ChestGenHooks mineshaft  = ChestGenHooks.getInfo("MINESHAFT_CORRIDOR");
	ChestGenHooks stronghold = ChestGenHooks.getInfo("STRONGHOLD_CROSSING");
	ChestGenHooks pyramid    = ChestGenHooks.getInfo("PYRAMID_DESERT_CHEST");
	ChestGenHooks dungeon    = ChestGenHooks.getInfo("DUNGEON_CHEST");
	public void AddChestItems()
	{
		//WeightRandomChestContent(ItemStack,MaxValue,MinValue,Rarity)
		mineshaft.addItem(new WeightedRandomChestContent(new ItemStack(AdditionalRecipe.cheaperExchangeIgnitionItem),1,1,10));
		mineshaft.addItem(new WeightedRandomChestContent(new ItemStack(AdditionalRecipe.ironMortarItem),1,1,50));
		stronghold.addItem(new WeightedRandomChestContent(new ItemStack(AdditionalRecipe.cheaperExchangeIgnitionItem),1,1,10));
		stronghold.addItem(new WeightedRandomChestContent(new ItemStack(AdditionalRecipe.diamondMortarItem),1,1,50));
		pyramid.addItem(new WeightedRandomChestContent(new ItemStack(AdditionalRecipe.cheaperExchangeIgnitionItem),1,1,10));
		pyramid.addItem(new WeightedRandomChestContent(new ItemStack(AdditionalRecipe.diamondMortarItem),1,1,50));
		dungeon.addItem(new WeightedRandomChestContent(new ItemStack(AdditionalRecipe.cheaperExchangeIgnitionItem),1,1,10));
		dungeon.addItem(new WeightedRandomChestContent(new ItemStack(AdditionalRecipe.ironMortarItem),1,1,50));
	}
}
