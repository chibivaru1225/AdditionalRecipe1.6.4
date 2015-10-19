package chibivaru.additionalrecipe.recipe;

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
		if(AdditionalRecipe.craftingSkull)
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
		if(AdditionalRecipe.craftingDragonEgg)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.dragonEgg,
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Item.netherStar,
						Character.valueOf('Y'),"ExchangeIgnition"}));
		}
		if(AdditionalRecipe.craftingBedrock)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.bedrock,
					new Object[]{"XYX","YZY","XYX",
						Character.valueOf('X'),Item.netherStar,
						Character.valueOf('Y'),Block.obsidian,
						Character.valueOf('Z'),"ExchangeIgnition"}));
		}
		if(AdditionalRecipe.craftingNetherStar)
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
		if(AdditionalRecipe.craftingJewel)
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
		if(AdditionalRecipe.craftingEnderPearl)
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
		if(AdditionalRecipe.craftingPowerStone)
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
		if(AdditionalRecipe.craftingObsidian)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					new ItemStack(Block.obsidian,8,0),
					new Object[]{Item.bucketLava,Item.bucketWater,"ExchangeIgnition"}));
		}
		if(AdditionalRecipe.craftingGrass)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Block.grass,
					new Object[]{Item.seeds,Block.dirt}));
		}
		if(AdditionalRecipe.craftingCactus)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Block.cactus,
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Item.seeds,
						Character.valueOf('Y'),Block.sand}));
		}
		if(AdditionalRecipe.craftingBlazeRod)
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
		if(AdditionalRecipe.craftingBookOld)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Item.book,
					new Object[]{"XXX",
						Character.valueOf('X'),Item.paper}));
		}
		if(AdditionalRecipe.craftingCray)
		{
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					new ItemStack(Item.clay,8),
					new Object[]{"XXX","XYX","XXX",
						Character.valueOf('X'),Block.sand,
						Character.valueOf('Y'),Block.gravel}));
		}
		if(AdditionalRecipe.craftingPiston)
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
		if(AdditionalRecipe.craftingExpBottle)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					new ItemStack(Item.expBottle,3),
					new Object[]{Item.glassBottle,Item.glassBottle,Item.glassBottle,Item.eyeOfEnder}));
		}
		if(AdditionalRecipe.craftingSlimeBall)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					Item.slimeBall,
					new Object[]{Item.seeds,Item.seeds,Item.seeds,Item.seeds}));
		}
		if(AdditionalRecipe.craftingMushroom)
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
		if(AdditionalRecipe.craftingEndPortal)
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
		if(AdditionalRecipe.craftingGlowStoneDust)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					new ItemStack(Item.glowstone,4),
					new Object[]{"dustGold",Item.redstone,"dustGold",Item.redstone}));
		}
	}
}
