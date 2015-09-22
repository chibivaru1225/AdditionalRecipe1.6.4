package chibivaru.additionalrecipe.recipe;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeSmelting {
	public void init()
	{
		if(AdditionalRecipe.smeltingNetherBrick)
		{
			GameRegistry.addSmelting(Block.stoneBrick.blockID,new ItemStack(Block.netherBrick,1),0.0f);
		}
		if(AdditionalRecipe.smeltingNetherrack)
		{
			GameRegistry.addSmelting(Block.dirt.blockID,new ItemStack(Block.netherrack,1),0.0f);
		}
		if(AdditionalRecipe.smeltingLeather)
		{
			GameRegistry.addSmelting(Item.rottenFlesh.itemID,new ItemStack(Item.leather,1),0.0f);
		}
		if(AdditionalRecipe.smeltingGlowStoneDust)
		{
			GameRegistry.addSmelting(Item.redstone.itemID,new ItemStack(Item.glowstone,1),0.0f);
		}
		if(AdditionalRecipe.smeltingMinecartEmpty)
		{
			GameRegistry.addSmelting(Item.minecartEmpty.itemID,new ItemStack(Item.ingotIron,5),0.0f);
		}
		if(AdditionalRecipe.smeltingIronDoor)
		{
			GameRegistry.addSmelting(Item.doorIron.itemID,new ItemStack(Item.ingotIron,6),0.0f);
		}
		if(AdditionalRecipe.smeltingWoodDoor)
		{
			GameRegistry.addSmelting(Item.doorWood.itemID,new ItemStack(Item.coal,2,1),0.0f);
		}
		if(AdditionalRecipe.smeltingTool)
		{
			if(AdditionalRecipe.smeltingToolWood)
			{
				FurnaceRecipes.smelting().addSmelting(Item.axeWood.itemID,new ItemStack(Item.coal,1,1),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.hoeWood.itemID,new ItemStack(Item.coal,1,1),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.pickaxeWood.itemID,new ItemStack(Item.coal,1,1),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.swordWood.itemID,new ItemStack(Item.coal,1,1),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.shovelWood.itemID,new ItemStack(Item.coal,1,1),0.0f);
			}
			if(AdditionalRecipe.smeltingToolStone)
			{
				FurnaceRecipes.smelting().addSmelting(Item.axeStone.itemID,new ItemStack(Block.stone,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.hoeStone.itemID,new ItemStack(Block.stone,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.pickaxeStone.itemID,new ItemStack(Block.stone,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.swordStone.itemID,new ItemStack(Block.stone,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.shovelStone.itemID,new ItemStack(Block.stone,1,0),0.0f);
			}
			if(AdditionalRecipe.smeltingToolIron)
			{
				FurnaceRecipes.smelting().addSmelting(Item.axeIron.itemID,new ItemStack(Item.ingotIron,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.hoeIron.itemID,new ItemStack(Item.ingotIron,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.pickaxeIron.itemID,new ItemStack(Item.ingotIron,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.swordIron.itemID,new ItemStack(Item.ingotIron,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.shovelIron.itemID,new ItemStack(Item.ingotIron,1,0),0.0f);
			}
			if(AdditionalRecipe.smeltingToolGold)
			{
				FurnaceRecipes.smelting().addSmelting(Item.axeGold.itemID,new ItemStack(Item.ingotGold,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.hoeGold.itemID,new ItemStack(Item.ingotGold,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.pickaxeGold.itemID,new ItemStack(Item.ingotGold,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.swordGold.itemID,new ItemStack(Item.ingotGold,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.shovelGold.itemID,new ItemStack(Item.ingotGold,1,0),0.0f);
			}
			if(AdditionalRecipe.smeltingToolDiamond)
			{
				FurnaceRecipes.smelting().addSmelting(Item.axeDiamond.itemID,new ItemStack(Item.diamond,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.hoeDiamond.itemID,new ItemStack(Item.diamond,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.pickaxeDiamond.itemID,new ItemStack(Item.diamond,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.swordDiamond.itemID,new ItemStack(Item.diamond,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.shovelDiamond.itemID,new ItemStack(Item.diamond,1,0),0.0f);
			}
			if(AdditionalRecipe.smeltingToolBow)
			{
				FurnaceRecipes.smelting().addSmelting(Item.bow.itemID,new ItemStack(Item.silk,3,0),0.0f);
			}
		}
		if(AdditionalRecipe.smeltingArmor)
		{
			if(AdditionalRecipe.smeltingArmorChain)
			{
				FurnaceRecipes.smelting().addSmelting(Item.helmetChain.itemID,new ItemStack(Item.ingotIron,5,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.plateChain.itemID,new ItemStack(Item.ingotIron,8,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.legsChain.itemID,new ItemStack(Item.ingotIron,7,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.bootsChain.itemID,new ItemStack(Item.ingotIron,4,0),0.0f);
			}
			if(AdditionalRecipe.smeltingArmorIron)
			{
				FurnaceRecipes.smelting().addSmelting(Item.helmetIron.itemID,new ItemStack(Item.ingotIron,5,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.plateIron.itemID,new ItemStack(Item.ingotIron,8,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.legsIron.itemID,new ItemStack(Item.ingotIron,7,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.bootsIron.itemID,new ItemStack(Item.ingotIron,4,0),0.0f);
			}
			if(AdditionalRecipe.smeltingArmorGold)
			{
				FurnaceRecipes.smelting().addSmelting(Item.helmetGold.itemID,new ItemStack(Item.ingotGold,5,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.plateGold.itemID,new ItemStack(Item.ingotGold,8,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.legsGold.itemID,new ItemStack(Item.ingotGold,7,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.bootsGold.itemID,new ItemStack(Item.ingotGold,4,0),0.0f);
			}
			if(AdditionalRecipe.smeltingArmorDiamond)
			{
				FurnaceRecipes.smelting().addSmelting(Item.helmetDiamond.itemID,new ItemStack(Item.diamond,5,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.plateDiamond.itemID,new ItemStack(Item.diamond,8,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.legsDiamond.itemID,new ItemStack(Item.diamond,7,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.bootsDiamond.itemID,new ItemStack(Item.diamond,4,0),0.0f);
			}
			if(AdditionalRecipe.smeltingArmorLeather)
			{
				FurnaceRecipes.smelting().addSmelting(Item.helmetLeather.itemID,new ItemStack(Item.leather,5,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.plateLeather.itemID,new ItemStack(Item.leather,8,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.legsLeather.itemID,new ItemStack(Item.leather,7,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(Item.bootsLeather.itemID,new ItemStack(Item.leather,4,0),0.0f);
			}
		}
		if((AdditionalRecipe.furnaceDustIngot)&&(AdditionalRecipe.craftingCraftingFurnace))
		{
			if(OreDictionary.getOres("dustIron").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						Item.ingotIron,
						new Object[]{"dustIron",AdditionalRecipe.craftingFurnaceItem}));
			}
			if(OreDictionary.getOres("dustGold").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						Item.ingotGold,
						new Object[]{"dustGold",AdditionalRecipe.craftingFurnaceItem}));
			}
			if((OreDictionary.getOres("dustCopper").size() > 0) && (OreDictionary.getOres("ingotCopper").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotCopper").get(0).getItem(),1,OreDictionary.getOres("ingotCopper").get(0).getItemDamage()),
						new Object[]{"dustCopper",AdditionalRecipe.craftingFurnaceItem}));
			}
			if((OreDictionary.getOres("dustTin").size() > 0) && (OreDictionary.getOres("ingotTin").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotTin").get(0).getItem(),1,OreDictionary.getOres("ingotTin").get(0).getItemDamage()),
						new Object[]{"dustTin",AdditionalRecipe.craftingFurnaceItem}));
			}
			if((OreDictionary.getOres("dustSilver").size() > 0) && (OreDictionary.getOres("ingotSilver").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotSilver").get(0).getItem(),1,OreDictionary.getOres("ingotSilver").get(0).getItemDamage()),
						new Object[]{"dustSilver",AdditionalRecipe.craftingFurnaceItem}));
			}
			if((OreDictionary.getOres("dustLead").size() > 0) && (OreDictionary.getOres("ingotLead").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotLead").get(0).getItem(),1,OreDictionary.getOres("ingotLead").get(0).getItemDamage()),
						new Object[]{"dustLead",AdditionalRecipe.craftingFurnaceItem}));
			}
			if((OreDictionary.getOres("dustNickel").size() > 0) && (OreDictionary.getOres("ingotNickel").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotNickel").get(0).getItem(),1,OreDictionary.getOres("ingotNickel").get(0).getItemDamage()),
						new Object[]{"dustNickel",AdditionalRecipe.craftingFurnaceItem}));
			}
			if((OreDictionary.getOres("dustPlatinum").size() > 0) && (OreDictionary.getOres("ingotPlatinum").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotPlatinum").get(0).getItem(),1,OreDictionary.getOres("ingotPlatinum").get(0).getItemDamage()),
						new Object[]{"dustPlatinum",AdditionalRecipe.craftingFurnaceItem}));
			}
		}
	}
}
