package chibivaru.additionalrecipe.recipe;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import chibivaru.additionalrecipe.AdditionalRecipe;

public class RecipeExelectorFirst implements IRecipe
{
	private ItemStack recipeItem = new ItemStack(AdditionalRecipe.swordExelectorFirst);
	private ItemStack outItem = new ItemStack(AdditionalRecipe.swordExelectorSecond);

	@Override
	public boolean matches(InventoryCrafting inventorycrafting, World world) {
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventorycrafting) {
		return null;
	}

	@Override
	public int getRecipeSize() {
		return 0;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return null;
	}

}
