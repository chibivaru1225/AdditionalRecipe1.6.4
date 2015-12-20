package chibivaru.additionalrecipe.recipe;

import static chibivaru.additionalrecipe.common.ARConfiguration.*;
import static chibivaru.additionalrecipe.common.ARItemHandler.*;
import net.minecraft.block.Block;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeOres {
	public void init()
	{
		if(ARGetCrafting("Ore",true))
		{
			//鉱石増殖
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreIron,
					new Object[]{"X  "," X ","   ",
						Character.valueOf('X'),ARGetItemRegister("ultimateexchangeiginiton")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreGold,
					new Object[]{" X "," X ","   ",
						Character.valueOf('X'),ARGetItemRegister("ultimateexchangeiginiton")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreCoal,
					new Object[]{"  X"," X ","   ",
						Character.valueOf('X'),ARGetItemRegister("ultimateexchangeiginiton")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreDiamond,
					new Object[]{"   ","XX ","   ",
						Character.valueOf('X'),ARGetItemRegister("ultimateexchangeiginiton")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreEmerald,
					new Object[]{"   "," XX","   ",
						Character.valueOf('X'),ARGetItemRegister("ultimateexchangeiginiton")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreLapis,
					new Object[]{"   "," X ","X  ",
						Character.valueOf('X'),ARGetItemRegister("ultimateexchangeiginiton")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreNetherQuartz,
					new Object[]{"   "," X "," X ",
						Character.valueOf('X'),ARGetItemRegister("ultimateexchangeiginiton")}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.oreRedstone,
					new Object[]{"   "," X ","  X",
						Character.valueOf('X'),ARGetItemRegister("ultimateexchangeiginiton")}));
		}
	}

}
