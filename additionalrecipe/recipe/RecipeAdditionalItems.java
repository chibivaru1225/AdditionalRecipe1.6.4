package chibivaru.additionalrecipe.recipe;

import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeAdditionalItems {
	public void init()
	{
		GameRegistry.addSmelting(AdditionalRecipe.exchangeIgnitionItemID,new ItemStack(AdditionalRecipe.dustExchangeIgnitionItem,1,0),0.0f);

		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				AdditionalRecipe.ultimateExchangeIgnition,
				new Object[]{"XYX","YZY","XYX",
					Character.valueOf('X'),Block.bedrock,
					Character.valueOf('Y'),Block.dragonEgg,
					Character.valueOf('Z'),AdditionalRecipe.dustExchangeIgnitionItem}));

		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				AdditionalRecipe.blackRottenFleshItem,
				new Object[]{"XXX","XXX","XXX",
					Character.valueOf('X'),Item.rottenFlesh}));

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
					AdditionalRecipe.cheaperExchangeIgnition,
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),AdditionalRecipe.blackRottenFleshItem,
						Character.valueOf('Y'),Block.blockDiamond}));

		//モルタル作成
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				AdditionalRecipe.bedrockMortarItem,
				new Object[]{"XYX"," X ",
					Character.valueOf('X'),Item.netherStar,
					Character.valueOf('Y'),Block.dragonEgg}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				AdditionalRecipe.diamondMortarItem,
				new Object[]{"XYX"," X ",
					Character.valueOf('X'),Item.diamond,
					Character.valueOf('Y'),Item.ingotIron}));
		GameRegistry.addRecipe(
			new ShapedOreRecipe(
				AdditionalRecipe.ironMortarItem,
				new Object[]{"XYX"," X ",
					Character.valueOf('X'),Item.ingotIron,
					Character.valueOf('Y'),Item.flint}));
	}
}
