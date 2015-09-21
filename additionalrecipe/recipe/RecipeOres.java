package chibivaru.additionalrecipe.recipe;

import net.minecraft.block.Block;
import net.minecraftforge.oredict.ShapedOreRecipe;
import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeOres {
	public void init()
	{
		if(AdditionalRecipe.craftingOre)
		{
			//鉱石増殖
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreIron,
					new Object[]{"X  "," X ","   ",
						Character.valueOf('X'),AdditionalRecipe.ultimateExchangeIgnition}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreGold,
					new Object[]{" X "," X ","   ",
						Character.valueOf('X'),AdditionalRecipe.ultimateExchangeIgnition}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreCoal,
					new Object[]{"  X"," X ","   ",
						Character.valueOf('X'),AdditionalRecipe.ultimateExchangeIgnition}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreDiamond,
					new Object[]{"   ","XX ","   ",
						Character.valueOf('X'),AdditionalRecipe.ultimateExchangeIgnition}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreEmerald,
					new Object[]{"   "," XX","   ",
						Character.valueOf('X'),AdditionalRecipe.ultimateExchangeIgnition}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreLapis,
					new Object[]{"   "," X ","X  ",
						Character.valueOf('X'),AdditionalRecipe.ultimateExchangeIgnition}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreNetherQuartz,
					new Object[]{"   "," X "," X ",
						Character.valueOf('X'),AdditionalRecipe.ultimateExchangeIgnition}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreRedstone,
					new Object[]{"   "," X ","  X",
						Character.valueOf('X'),AdditionalRecipe.ultimateExchangeIgnition}));
		}
	}

}
