package chibivaru.additionalrecipe.recipe;

import static chibivaru.additionalrecipe.common.ARConfiguration.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeItems {
	public void init()
	{
		if(ARGetCrafting("Skull",true))
		{
			for(int var1 = 0;var1 < 5;++var1)
			{
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Item.skull,1,1),new Object[]{new ItemStack(Item.skull,1,var1)}));
			}
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					new ItemStack(Item.skull,1,1),
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Item.enderPearl,
						Character.valueOf('Y'),"ExchangeIgnition"}));
		}
		if(ARGetCrafting("DragonEgg",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.dragonEgg,
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Item.netherStar,
						Character.valueOf('Y'),"ExchangeIgnition"}));
		}
		if(ARGetCrafting("Bedrock",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.bedrock,
					new Object[]{"XYX","YZY","XYX",
						Character.valueOf('X'),Item.netherStar,
						Character.valueOf('Y'),Block.obsidian,
						Character.valueOf('Z'),"ExchangeIgnition"}));
		}
		if(ARGetCrafting("NetherStar",true))
		{
			switch(AdditionalRecipe.craftingDifficulty)
			{
				case 0:
				{
					GameRegistry.addRecipe(
						new ShapelessOreRecipe(
							Item.netherStar,
							new Object[]{new ItemStack(Item.skull,1,1),"ExchangeIgnition"}));
					break;
				}
				case 1:
				{
					GameRegistry.addRecipe(
						new ShapelessOreRecipe(
							Item.netherStar,
							new Object[]{new ItemStack(Item.skull,1,1),new ItemStack(Item.skull,1,1),new ItemStack(Item.skull,1,1),"ExchangeIgnition"}));
					break;
				}
				case 2:
				{
					GameRegistry.addRecipe(
						new ShapelessOreRecipe(
							Item.netherStar,
							new Object[]{new ItemStack(Item.skull,1,1),new ItemStack(Item.skull,1,1),new ItemStack(Item.skull,1,1),new ItemStack(Item.skull,1,1),"ExchangeIgnition"}));
					break;
				}
				case 3:
				{
					GameRegistry.addRecipe(
						new ShapelessOreRecipe(
							new ItemStack(Item.netherStar,2),
							new Object[]{new ItemStack(Item.skull,1,1),new ItemStack(Item.skull,1,1),new ItemStack(Item.skull,1,1),Item.netherStar,"ExchangeIgnition"}));
					break;
				}
				case 4:
				{
					GameRegistry.addRecipe(
						new ShapelessOreRecipe(
							new ItemStack(Item.netherStar,2),
							new Object[]{new ItemStack(Item.skull,1,1),new ItemStack(Item.skull,1,1),new ItemStack(Item.skull,1,1),new ItemStack(Item.skull,1,1),new ItemStack(Item.skull,1,1),new ItemStack(Item.skull,1,1),Item.netherStar,"ExchangeIgnition"}));
					break;
				}
			}
		}
		if(ARGetCrafting("Jewel",true))
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Item.emerald,
					new Object[]{Item.diamond,"ExchangeIgnition"}));
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Item.diamond,
					new Object[]{Item.emerald,"ExchangeIgnition"}));
		}
		if(ARGetCrafting("NetherStar",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Item.enderPearl,
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Item.rottenFlesh,
						Character.valueOf('Y'),"ExchangeIgnition"}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Item.enderPearl,
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Item.bone,
						Character.valueOf('Y'),"ExchangeIgnition"}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Item.enderPearl,
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Item.gunpowder,
						Character.valueOf('Y'),"ExchangeIgnition"}));
			if(AdditionalRecipe.craftingDifficulty == 0)
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						Item.enderPearl,
						new Object[]{"XXX","XYX","XXX",
							Character.valueOf('X'),new ItemStack(Block.sapling,1,32767),
							Character.valueOf('Y'),Item.slimeBall}));
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						Item.enderPearl,
						new Object[]{"XXX","XYX","XXX",
							Character.valueOf('X'),"treeSapling",
							Character.valueOf('Y'),Item.slimeBall}));
			}
		}
		if(ARGetCrafting("PowerStone",true))
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Item.glowstone,
					new Object[]{"ExchangeIgnition",Item.redstone}));
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Item.redstone,
					new Object[]{"ExchangeIgnition",Item.glowstone}));
		}
		if(ARGetCrafting("Obsidian",true))
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					new ItemStack(Block.obsidian,8,0),
					new Object[]{Item.bucketLava,Item.bucketWater,"ExchangeIgnition"}));
		}
		if(ARGetCrafting("Grass",true))
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Block.grass,
					new Object[]{Item.seeds,Block.dirt}));
		}
		if(ARGetCrafting("Cactus",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.cactus,
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Item.seeds,
						Character.valueOf('Y'),Block.sand}));
		}
		if(ARGetCrafting("BlazeRod",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Item.blazeRod,
					new Object[]{"XYX","XYX","XYX",
						Character.valueOf('X'),Item.glowstone,
						Character.valueOf('Y'),Item.stick}));
			if(AdditionalRecipe.craftingDifficulty == 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						Item.blazeRod,
						new Object[]{Item.blazePowder,Item.blazePowder}));
			}
		}
		if(ARGetCrafting("BookOld",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Item.book,
					new Object[]{"XXX",
						Character.valueOf('X'),Item.paper}));
		}
		if(ARGetCrafting("Cray",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					new ItemStack(Item.clay,8),
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Block.sand,
						Character.valueOf('Y'),Block.gravel}));
		}
		if(ARGetCrafting("Piston",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.pistonBase,
					new Object[]{"XXX","YZY","YWY",
						Character.valueOf('X'),"plankWood",
						Character.valueOf('Y'),"cobblestone",
						Character.valueOf('Z'),"ingotBronze",
						Character.valueOf('W'),Item.redstone}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.pistonBase,
					new Object[]{"XXX","YZY","YWY",
						Character.valueOf('X'),"plankWood",
						Character.valueOf('Y'),"cobblestone",
						Character.valueOf('Z'),"ingotSteel",
						Character.valueOf('W'),Item.redstone}));
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.pistonBase,
					new Object[]{"XXX","YZY","YWY",
						Character.valueOf('X'),"plankWood",
						Character.valueOf('Y'),"cobblestone",
						Character.valueOf('Z'),"ingotInvar",
						Character.valueOf('W'),Item.redstone}));
		}
		if(ARGetCrafting("ExpBottle",true))
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					new ItemStack(Item.expBottle,3),
					new Object[]{Item.glassBottle,Item.glassBottle,Item.glassBottle,Item.eyeOfEnder}));
		}
		if(ARGetCrafting("SlimeBall",true))
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Item.slimeBall,
					new Object[]{Item.seeds,Item.seeds,Item.seeds,Item.seeds}));
		}
		if(ARGetCrafting("Mushroom",true))
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Block.mushroomBrown,
					new Object[]{Block.mushroomRed}));
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Block.mushroomRed,
					new Object[]{Block.mushroomBrown}));
		}
		if(ARGetCrafting("EndPortal",true))
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.endPortalFrame,
					new Object[]{" X ","YZY","WVW",
						Character.valueOf('X'),Item.eyeOfEnder,
						Character.valueOf('Y'),Block.blockEmerald,
						Character.valueOf('Z'),Item.cauldron,
						Character.valueOf('W'),Block.obsidian,
						Character.valueOf('V'),Block.blockDiamond}));
		}
		if(ARGetCrafting("GlowStoneDust",true))
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					new ItemStack(Item.glowstone,4),
					new Object[]{"dustGold",Item.redstone,"dustGold",Item.redstone}));
		}
		if(ARGetCrafting("Button",true))
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Block.planks,
					new Object[]{Block.woodenButton}));
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Block.stone,
					new Object[]{Block.stoneButton}));
		}
	}
}
