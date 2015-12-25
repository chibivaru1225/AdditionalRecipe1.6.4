package chibivaru.additionalrecipe.recipe;

import static chibivaru.additionalrecipe.common.ARConfiguration.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeCrystal {
	ItemStack CertusQuartz,CertusDust,NetherDust;
	ItemStack BlackShard,BlackCrystal;
	ItemStack RedShard,RedCrystal;
	ItemStack GreenShard,GreenCrystal;
	ItemStack BrownShard,BrownCrystal;
	ItemStack BlueShard,BlueCrystal;
	ItemStack PurpleShard,PurpleCrystal;
	ItemStack CyanShard,CyanCrystal;
	ItemStack LightGrayShard,LightGrayCrystal;
	ItemStack GrayShard,GrayCrystal;
	ItemStack PinkShard,PinkCrystal;
	ItemStack LimeShard,LimeCrystal;
	ItemStack YellowShard,YellowCrystal;
	ItemStack LightBlueShard,LightBlueCrystal;
	ItemStack MagentaShard,MagentaCrystal;
	ItemStack OrangeShard,OrangeCrystal;
	ItemStack WhiteShard,WhiteCrystal;
	public void init()
	{
		if((OreDictionary.getOres("crystalCertusQuartz").size() != 0) && (OreDictionary.getOres("dustCertusQuartz").size() != 0) && (OreDictionary.getOres("dustNetherQuartz").size() != 0))
		{
			CertusQuartz = OreDictionary.getOres("crystalCertusQuartz").get(0);
			CertusDust   = OreDictionary.getOres("dustCertusQuartz").get(0);
			NetherDust   = OreDictionary.getOres("dustNetherQuartz").get(0);
			GameRegistry.addSmelting(Block.whiteStone.blockID, new ItemStack(CertusDust.getItem(),4,7), 0.0f);
			GameRegistry.addShapelessRecipe(CertusQuartz,new Object[]{CertusDust,Block.sand});
			GameRegistry.addShapelessRecipe(new ItemStack(Item.netherQuartz,1,0),new Object[]{NetherDust,Block.sand});
			if(ARGetCrafting("Crystal",true))
			{
				if((OreDictionary.getOres("dyeBlackCrystalShard").size() != 0) && (OreDictionary.getOres("dyeBlackCrystal").size() != 0))
				{
					BlackShard = OreDictionary.getOres("dyeBlackCrystalShard").get(0);
					BlackCrystal = OreDictionary.getOres("dyeBlackCrystal").get(0);
					GameRegistry.addShapelessRecipe(BlackShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,0)});
					GameRegistry.addShapelessRecipe(BlackCrystal,new Object[]{BlackShard,BlackShard,BlackShard,BlackShard});
					FurnaceRecipes.smelting().addSmelting(BlackCrystal.itemID,0,new ItemStack(BlackShard.getItem(),4,0), 0.0f);
				}
				if((OreDictionary.getOres("dyeRedCrystalShard").size() != 0) && (OreDictionary.getOres("dyeRedCrystal").size() != 0))
				{
					RedShard = OreDictionary.getOres("dyeRedCrystalShard").get(0);
					RedCrystal = OreDictionary.getOres("dyeRedCrystal").get(0);
					GameRegistry.addShapelessRecipe(RedShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,1)});
					GameRegistry.addShapelessRecipe(RedCrystal,new Object[]{RedShard,RedShard,RedShard,RedShard});
					FurnaceRecipes.smelting().addSmelting(RedCrystal.itemID,1,new ItemStack(RedShard.getItem(),4,1), 0.0f);
				}
				if((OreDictionary.getOres("dyeGreenCrystalShard").size() != 0) && (OreDictionary.getOres("dyeGreenCrystal").size() != 0))
				{
					GreenShard = OreDictionary.getOres("dyeGreenCrystalShard").get(0);
					GreenCrystal = OreDictionary.getOres("dyeGreenCrystal").get(0);
					GameRegistry.addShapelessRecipe(GreenShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,2)});
					GameRegistry.addShapelessRecipe(GreenCrystal,new Object[]{GreenShard,GreenShard,GreenShard,GreenShard});
					FurnaceRecipes.smelting().addSmelting(GreenCrystal.itemID,2,new ItemStack(GreenShard.getItem(),4,2), 0.0f);
				}
				if((OreDictionary.getOres("dyeBrownCrystalShard").size() != 0) && (OreDictionary.getOres("dyeBrownCrystal").size() != 0))
				{
					BrownShard = OreDictionary.getOres("dyeBrownCrystalShard").get(0);
					BrownCrystal = OreDictionary.getOres("dyeBrownCrystal").get(0);
					GameRegistry.addShapelessRecipe(BrownShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,3)});
					GameRegistry.addShapelessRecipe(BrownCrystal,new Object[]{BrownShard,BrownShard,BrownShard,BrownShard});
					FurnaceRecipes.smelting().addSmelting(BrownCrystal.itemID,3,new ItemStack(BrownShard.getItem(),4,3), 0.0f);
				}
				if((OreDictionary.getOres("dyeBlueCrystalShard").size() != 0) && (OreDictionary.getOres("dyeBlueCrystal").size() != 0))
				{
					BlueShard = OreDictionary.getOres("dyeBlueCrystalShard").get(0);
					BlueCrystal = OreDictionary.getOres("dyeBlueCrystal").get(0);
					GameRegistry.addShapelessRecipe(BlueShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,4)});
					GameRegistry.addShapelessRecipe(BlueCrystal,new Object[]{BlueShard,BlueShard,BlueShard,BlueShard});
					FurnaceRecipes.smelting().addSmelting(BlueCrystal.itemID,4,new ItemStack(BlueShard.getItem(),4,4), 0.0f);
				}
				if((OreDictionary.getOres("dyePurpleCrystalShard").size() != 0) && (OreDictionary.getOres("dyePurpleCrystal").size() != 0))
				{
					PurpleShard = OreDictionary.getOres("dyePurpleCrystalShard").get(0);
					PurpleCrystal = OreDictionary.getOres("dyePurpleCrystal").get(0);
					GameRegistry.addShapelessRecipe(PurpleShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,5)});
					GameRegistry.addShapelessRecipe(PurpleCrystal,new Object[]{PurpleShard,PurpleShard,PurpleShard,PurpleShard});
					FurnaceRecipes.smelting().addSmelting(PurpleCrystal.itemID,5,new ItemStack(PurpleShard.getItem(),4,5), 0.0f);
				}
				if((OreDictionary.getOres("dyeCyanCrystalShard").size() != 0) && (OreDictionary.getOres("dyeCyanCrystal").size() != 0))
				{
					CyanShard = OreDictionary.getOres("dyeCyanCrystalShard").get(0);
					CyanCrystal = OreDictionary.getOres("dyeCyanCrystal").get(0);
					GameRegistry.addShapelessRecipe(CyanShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,6)});
					GameRegistry.addShapelessRecipe(CyanCrystal,new Object[]{CyanShard,CyanShard,CyanShard,CyanShard});
					FurnaceRecipes.smelting().addSmelting(CyanCrystal.itemID,6,new ItemStack(CyanShard.getItem(),4,6), 0.0f);
				}
				if((OreDictionary.getOres("dyeLightGrayCrystalShard").size() != 0) && (OreDictionary.getOres("dyeLightGrayCrystal").size() != 0))
				{
					LightGrayShard = OreDictionary.getOres("dyeLightGrayCrystalShard").get(0);
					LightGrayCrystal = OreDictionary.getOres("dyeLightGrayCrystal").get(0);
					GameRegistry.addShapelessRecipe(LightGrayShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,7)});
					GameRegistry.addShapelessRecipe(LightGrayCrystal,new Object[]{LightGrayShard,LightGrayShard,LightGrayShard,LightGrayShard});
					FurnaceRecipes.smelting().addSmelting(LightGrayCrystal.itemID,7,new ItemStack(LightGrayShard.getItem(),4,7), 0.0f);
				}
				if((OreDictionary.getOres("dyeGrayCrystalShard").size() != 0) && (OreDictionary.getOres("dyeGrayCrystal").size() != 0))
				{
					GrayShard = OreDictionary.getOres("dyeGrayCrystalShard").get(0);
					GrayCrystal = OreDictionary.getOres("dyeGrayCrystal").get(0);
					GameRegistry.addShapelessRecipe(GrayShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,8)});
					GameRegistry.addShapelessRecipe(GrayCrystal,new Object[]{GrayShard,GrayShard,GrayShard,GrayShard});
					FurnaceRecipes.smelting().addSmelting(GrayCrystal.itemID,8,new ItemStack(GrayShard.getItem(),4,8), 0.0f);
				}
				if((OreDictionary.getOres("dyePinkCrystalShard").size() != 0) && (OreDictionary.getOres("dyePinkCrystal").size() != 0))
				{
					PinkShard = OreDictionary.getOres("dyePinkCrystalShard").get(0);
					PinkCrystal = OreDictionary.getOres("dyePinkCrystal").get(0);
					GameRegistry.addShapelessRecipe(PinkShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,9)});
					GameRegistry.addShapelessRecipe(PinkCrystal,new Object[]{PinkShard,PinkShard,PinkShard,PinkShard});
					FurnaceRecipes.smelting().addSmelting(PinkCrystal.itemID,9,new ItemStack(PinkShard.getItem(),4,9), 0.0f);
				}
				if((OreDictionary.getOres("dyeLimeCrystalShard").size() != 0) && (OreDictionary.getOres("dyeLimeCrystal").size() != 0))
				{
					LimeShard = OreDictionary.getOres("dyeLimeCrystalShard").get(0);
					LimeCrystal = OreDictionary.getOres("dyeLimeCrystal").get(0);
					GameRegistry.addShapelessRecipe(LimeShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,10)});
					GameRegistry.addShapelessRecipe(LimeCrystal,new Object[]{LimeShard,LimeShard,LimeShard,LimeShard});
					FurnaceRecipes.smelting().addSmelting(LimeCrystal.itemID,10,new ItemStack(LimeShard.getItem(),4,10), 0.0f);
				}
				if((OreDictionary.getOres("dyeYellowCrystalShard").size() != 0) && (OreDictionary.getOres("dyeYellowCrystal").size() != 0))
				{
					YellowShard = OreDictionary.getOres("dyeYellowCrystalShard").get(0);
					YellowCrystal = OreDictionary.getOres("dyeYellowCrystal").get(0);
					GameRegistry.addShapelessRecipe(YellowShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,11)});
					GameRegistry.addShapelessRecipe(YellowCrystal,new Object[]{YellowShard,YellowShard,YellowShard,YellowShard});
					FurnaceRecipes.smelting().addSmelting(YellowCrystal.itemID,11,new ItemStack(YellowShard.getItem(),4,11), 0.0f);
				}
				if((OreDictionary.getOres("dyeLightBlueCrystalShard").size() != 0) && (OreDictionary.getOres("dyeLightBlueCrystal").size() != 0))
				{
					LightBlueShard = OreDictionary.getOres("dyeLightBlueCrystalShard").get(0);
					LightBlueCrystal = OreDictionary.getOres("dyeLightBlueCrystal").get(0);
					GameRegistry.addShapelessRecipe(LightBlueShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,12)});
					GameRegistry.addShapelessRecipe(LightBlueCrystal,new Object[]{LightBlueShard,LightBlueShard,LightBlueShard,LightBlueShard});
					FurnaceRecipes.smelting().addSmelting(LightBlueCrystal.itemID,12,new ItemStack(LightBlueShard.getItem(),4,12), 0.0f);
				}
				if((OreDictionary.getOres("dyeMagentaCrystalShard").size() != 0) && (OreDictionary.getOres("dyeMagentaCrystal").size() != 0))
				{
					MagentaShard = OreDictionary.getOres("dyeMagentaCrystalShard").get(0);
					MagentaCrystal = OreDictionary.getOres("dyeMagentaCrystal").get(0);
					GameRegistry.addShapelessRecipe(MagentaShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,13)});
					GameRegistry.addShapelessRecipe(MagentaCrystal,new Object[]{MagentaShard,MagentaShard,MagentaShard,MagentaShard});
					FurnaceRecipes.smelting().addSmelting(MagentaCrystal.itemID,13,new ItemStack(MagentaShard.getItem(),4,13), 0.0f);
				}
				if((OreDictionary.getOres("dyeOrangeCrystalShard").size() != 0) && (OreDictionary.getOres("dyeOrangeCrystal").size() != 0))
				{
					OrangeShard = OreDictionary.getOres("dyeOrangeCrystalShard").get(0);
					OrangeCrystal = OreDictionary.getOres("dyeOrangeCrystal").get(0);
					GameRegistry.addShapelessRecipe(OrangeShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,14)});
					GameRegistry.addShapelessRecipe(OrangeCrystal,new Object[]{OrangeShard,OrangeShard,OrangeShard,OrangeShard});
					FurnaceRecipes.smelting().addSmelting(OrangeCrystal.itemID,14,new ItemStack(OrangeShard.getItem(),4,14), 0.0f);
				}
				if((OreDictionary.getOres("dyeWhiteCrystalShard").size() != 0) && (OreDictionary.getOres("dyeWhiteCrystal").size() != 0))
				{
					WhiteShard = OreDictionary.getOres("dyeWhiteCrystalShard").get(0);
					WhiteCrystal = OreDictionary.getOres("dyeWhiteCrystal").get(0);
					GameRegistry.addShapelessRecipe(WhiteShard,new Object[]{CertusQuartz,new ItemStack(Item.dyePowder,1,15)});
					GameRegistry.addShapelessRecipe(WhiteCrystal,new Object[]{WhiteShard,WhiteShard,WhiteShard,WhiteShard});
					FurnaceRecipes.smelting().addSmelting(WhiteCrystal.itemID,15,new ItemStack(WhiteShard.getItem(),4,15), 0.0f);
				}
			}
		}
	}
}
