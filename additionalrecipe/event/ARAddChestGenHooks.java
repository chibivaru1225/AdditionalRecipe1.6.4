package chibivaru.additionalrecipe.event;

import static chibivaru.additionalrecipe.common.ARItemHandler.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class ARAddChestGenHooks {
	ChestGenHooks mineshaft  = ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR);
	ChestGenHooks stronghold = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING);
	ChestGenHooks pyramid    = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST);
	ChestGenHooks dungeon    = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
	public void AddChestItems()
	{
		//WeightRandomChestContent(ItemStack,MaxValue,MinValue,Rarity)
		mineshaft.addItem(new WeightedRandomChestContent(new ItemStack(ARGetItemRegister("cheaperexchangeiginiton")),1,1,5));
		mineshaft.addItem(new WeightedRandomChestContent(new ItemStack(ARGetItemRegister("ironmortar")),1,1,10));
		stronghold.addItem(new WeightedRandomChestContent(new ItemStack(ARGetItemRegister("cheaperexchangeiginiton")),1,1,5));
		stronghold.addItem(new WeightedRandomChestContent(new ItemStack(ARGetItemRegister("diamondmortar")),1,1,10));
		pyramid.addItem(new WeightedRandomChestContent(new ItemStack(ARGetItemRegister("cheaperexchangeiginiton")),1,1,5));
		pyramid.addItem(new WeightedRandomChestContent(new ItemStack(ARGetItemRegister("diamondmortar")),1,1,10));
		dungeon.addItem(new WeightedRandomChestContent(new ItemStack(ARGetItemRegister("cheaperexchangeiginiton")),1,1,5));
		dungeon.addItem(new WeightedRandomChestContent(new ItemStack(ARGetItemRegister("ironmortar")),1,1,10));
	}
}
