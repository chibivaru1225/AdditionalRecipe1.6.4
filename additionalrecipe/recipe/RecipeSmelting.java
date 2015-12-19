package chibivaru.additionalrecipe.recipe;

import static chibivaru.additionalrecipe.common.ARConfiguration.*;
import static chibivaru.additionalrecipe.common.ARItemHandler.*;
import static net.minecraft.block.Block.*;
import static net.minecraft.item.Item.*;
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
		if(ARGetSmelting("NetherBrick"))
		{
			GameRegistry.addSmelting(stoneBrick.blockID,new ItemStack(netherBrick,1),0.0f);
		}
		if(ARGetSmelting("Netherrack"))
		{
			GameRegistry.addSmelting(dirt.blockID,new ItemStack(netherrack,1),0.0f);
		}
		if(ARGetSmelting("Leather"))
		{
			GameRegistry.addSmelting(rottenFlesh.itemID,new ItemStack(leather,1),0.0f);
		}
		if(ARGetSmelting("GlowStoneDust"))
		{
			GameRegistry.addSmelting(redstone.itemID,new ItemStack(glowstone,1),0.0f);
		}
		if(ARGetSmelting("MinecartEmpty"))
		{
			GameRegistry.addSmelting(minecartEmpty.itemID,new ItemStack(ingotIron,5),0.0f);
		}
		if(ARGetSmelting("IronDoor"))
		{
			GameRegistry.addSmelting(Item.doorIron.itemID,new ItemStack(ingotIron,6),0.0f);
		}
		if(ARGetSmelting("WoodDoor"))
		{
			GameRegistry.addSmelting(Item.doorWood.itemID,new ItemStack(coal,2,1),0.0f);
		}
		if(ARGetSmelting("RecycleTool"))
		{
			if(ARGetSmelting("WoodTool"))
			{
				FurnaceRecipes.smelting().addSmelting(axeWood.itemID,new ItemStack(coal,1,1),0.0f);
				FurnaceRecipes.smelting().addSmelting(hoeWood.itemID,new ItemStack(coal,1,1),0.0f);
				FurnaceRecipes.smelting().addSmelting(pickaxeWood.itemID,new ItemStack(coal,1,1),0.0f);
				FurnaceRecipes.smelting().addSmelting(swordWood.itemID,new ItemStack(coal,1,1),0.0f);
				FurnaceRecipes.smelting().addSmelting(shovelWood.itemID,new ItemStack(coal,1,1),0.0f);
			}
			if(ARGetSmelting("StoneTool"))
			{
				FurnaceRecipes.smelting().addSmelting(axeStone.itemID,new ItemStack(stone,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(hoeStone.itemID,new ItemStack(stone,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(pickaxeStone.itemID,new ItemStack(stone,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(swordStone.itemID,new ItemStack(stone,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(shovelStone.itemID,new ItemStack(stone,1,0),0.0f);
			}
			if(ARGetSmelting("IronTool"))
			{
				FurnaceRecipes.smelting().addSmelting(axeIron.itemID,new ItemStack(ingotIron,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(hoeIron.itemID,new ItemStack(ingotIron,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(pickaxeIron.itemID,new ItemStack(ingotIron,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(swordIron.itemID,new ItemStack(ingotIron,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(shovelIron.itemID,new ItemStack(ingotIron,1,0),0.0f);
			}
			if(ARGetSmelting("GoldTool"))
			{
				FurnaceRecipes.smelting().addSmelting(axeGold.itemID,new ItemStack(ingotGold,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(hoeGold.itemID,new ItemStack(ingotGold,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(pickaxeGold.itemID,new ItemStack(ingotGold,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(swordGold.itemID,new ItemStack(ingotGold,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(shovelGold.itemID,new ItemStack(ingotGold,1,0),0.0f);
			}
			if(ARGetSmelting("DiamondTool"))
			{
				FurnaceRecipes.smelting().addSmelting(axeDiamond.itemID,new ItemStack(diamond,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(hoeDiamond.itemID,new ItemStack(diamond,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(pickaxeDiamond.itemID,new ItemStack(diamond,3,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(swordDiamond.itemID,new ItemStack(diamond,2,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(shovelDiamond.itemID,new ItemStack(diamond,1,0),0.0f);
			}
			if(ARGetSmelting("Bow"))
			{
				FurnaceRecipes.smelting().addSmelting(bow.itemID,new ItemStack(silk,3,0),0.0f);
			}
		}
		if(ARGetSmelting("RecycleArmor"))
		{
			if(ARGetSmelting("ChainArmor"))
			{
				FurnaceRecipes.smelting().addSmelting(helmetChain.itemID,new ItemStack(ingotIron,5,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(plateChain.itemID,new ItemStack(ingotIron,8,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(legsChain.itemID,new ItemStack(ingotIron,7,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(bootsChain.itemID,new ItemStack(ingotIron,4,0),0.0f);
			}
			if(ARGetSmelting("IronArmor"))
			{
				FurnaceRecipes.smelting().addSmelting(helmetIron.itemID,new ItemStack(ingotIron,5,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(plateIron.itemID,new ItemStack(ingotIron,8,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(legsIron.itemID,new ItemStack(ingotIron,7,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(bootsIron.itemID,new ItemStack(ingotIron,4,0),0.0f);
			}
			if(ARGetSmelting("IronArmor"))
			{
				FurnaceRecipes.smelting().addSmelting(helmetGold.itemID,new ItemStack(ingotGold,5,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(plateGold.itemID,new ItemStack(ingotGold,8,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(legsGold.itemID,new ItemStack(ingotGold,7,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(bootsGold.itemID,new ItemStack(ingotGold,4,0),0.0f);
			}
			if(ARGetSmelting("DiamondArmor"))
			{
				FurnaceRecipes.smelting().addSmelting(helmetDiamond.itemID,new ItemStack(diamond,5,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(plateDiamond.itemID,new ItemStack(diamond,8,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(legsDiamond.itemID,new ItemStack(diamond,7,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(bootsDiamond.itemID,new ItemStack(diamond,4,0),0.0f);
			}
			if(ARGetSmelting("LeatherArmor"))
			{
				FurnaceRecipes.smelting().addSmelting(helmetLeather.itemID,new ItemStack(leather,5,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(plateLeather.itemID,new ItemStack(leather,8,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(legsLeather.itemID,new ItemStack(leather,7,0),0.0f);
				FurnaceRecipes.smelting().addSmelting(bootsLeather.itemID,new ItemStack(leather,4,0),0.0f);
			}
		}
		if((AdditionalRecipe.furnaceDustIngot)&&(AdditionalRecipe.craftingCraftingFurnace))
		{
			if(OreDictionary.getOres("dustIron").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						ingotIron,
						new Object[]{"dustIron",ARGetItemRegister("craftingfurnace")}));
			}
			if(OreDictionary.getOres("dustGold").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						ingotGold,
						new Object[]{"dustGold",ARGetItemRegister("craftingfurnace")}));
			}
			if((OreDictionary.getOres("dustCopper").size() > 0) && (OreDictionary.getOres("ingotCopper").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotCopper").get(0).getItem(),1,OreDictionary.getOres("ingotCopper").get(0).getItemDamage()),
						new Object[]{"dustCopper",ARGetItemRegister("craftingfurnace")}));
			}
			if((OreDictionary.getOres("dustTin").size() > 0) && (OreDictionary.getOres("ingotTin").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotTin").get(0).getItem(),1,OreDictionary.getOres("ingotTin").get(0).getItemDamage()),
						new Object[]{"dustTin",ARGetItemRegister("craftingfurnace")}));
			}
			if((OreDictionary.getOres("dustSilver").size() > 0) && (OreDictionary.getOres("ingotSilver").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotSilver").get(0).getItem(),1,OreDictionary.getOres("ingotSilver").get(0).getItemDamage()),
						new Object[]{"dustSilver",ARGetItemRegister("craftingfurnace")}));
			}
			if((OreDictionary.getOres("dustLead").size() > 0) && (OreDictionary.getOres("ingotLead").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotLead").get(0).getItem(),1,OreDictionary.getOres("ingotLead").get(0).getItemDamage()),
						new Object[]{"dustLead",ARGetItemRegister("craftingfurnace")}));
			}
			if((OreDictionary.getOres("dustNickel").size() > 0) && (OreDictionary.getOres("ingotNickel").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotNickel").get(0).getItem(),1,OreDictionary.getOres("ingotNickel").get(0).getItemDamage()),
						new Object[]{"dustNickel",ARGetItemRegister("craftingfurnace")}));
			}
			if((OreDictionary.getOres("dustPlatinum").size() > 0) && (OreDictionary.getOres("ingotPlatinum").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("ingotPlatinum").get(0).getItem(),1,OreDictionary.getOres("ingotPlatinum").get(0).getItemDamage()),
						new Object[]{"dustPlatinum",ARGetItemRegister("craftingfurnace")}));
			}
		}
	}
}
