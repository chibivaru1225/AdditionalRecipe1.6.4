package chibivaru.additionalrecipe.recipe;

import static chibivaru.additionalrecipe.common.ARConfiguration.*;
import static chibivaru.additionalrecipe.common.ARItemHandler.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeMortar {
	public void init()
	{
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
				Block.gravel,
				new Object[]{Block.cobblestone,Block.sand,Item.bowlEmpty}));
		if((ARGetCrafting("DustIngot",true))&&(ARGetCrafting("CraftingFurnace",true)))
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					new ItemStack(Block.stone,64),
					new Object[]{ARGetItemRegister("ultimateexchangeiginiton"),ARGetItemRegister("craftingfurnace")}));
		}
	}
}
