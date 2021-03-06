package chibivaru.additionalrecipe.recipe;

import static chibivaru.additionalrecipe.common.ARConfiguration.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import chibivaru.additionalrecipe.AdditionalRecipe;

import com.xcompwiz.mystcraft.api.MystObjects;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeAnotherMod {
	private static Class MFR;
	private static Class BC;
	private static Class MoInv;

	public void init()
	{
		if(Loader.isModLoaded("Mystcraft"))
		{
			if(ARGetCrafting("LinkModifer",true))
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						new ItemStack(MystObjects.link_modifer),
						new Object[]{"XXX","XYX","XXX",
							Character.valueOf('X'),Block.blockDiamond,
							Character.valueOf('Y'),Block.blockGold}));
			}
		}
		if(Loader.isModLoaded("AppliedEnergistics"))
		{
			if(OreDictionary.getOres("dustWheat").size() > 0)
			{
				if(ARGetCrafting("Flour",true))
				{
					GameRegistry.addRecipe(
						new ShapelessOreRecipe(
							OreDictionary.getOres("dustWheat").get(0),
							new Object[]{Item.wheat}));
				}
			}
		}
		if(Loader.isModLoaded("Railcraft"))
		{
			if(OreDictionary.getOres("ingotSteel").size() != 0)
			{
				if(ARGetSmelting("SteelTool",true))
				{
					if(GameRegistry.findItem("Railcraft","railcraft.tool.steel.axe") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","railcraft.tool.steel.axe").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),3,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					}
					if(GameRegistry.findItem("Railcraft","railcraft.tool.steel.hoe") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","railcraft.tool.steel.hoe").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),2,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					}
					if(GameRegistry.findItem("Railcraft","railcraft.tool.steel.pickaxe") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","railcraft.tool.steel.pickaxe").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),3,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					}
					if(GameRegistry.findItem("Railcraft","railcraft.tool.steel.shovel") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","railcraft.tool.steel.shovel").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),1,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					}
					if(GameRegistry.findItem("Railcraft","railcraft.tool.steel.sword") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","railcraft.tool.steel.sword").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),2,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					}
				}
				if(ARGetSmelting("SteelArmor",true))
				{
					if(GameRegistry.findItem("Railcraft","railcraft.armor.steel.boots") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","railcraft.armor.steel.boots").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),4,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					}
					if(GameRegistry.findItem("Railcraft","railcraft.armor.steel.helmet") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","railcraft.armor.steel.helmet").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),5,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					}
					if(GameRegistry.findItem("Railcraft","railcraft.armor.steel.legs") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","railcraft.armor.steel.legs").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),7,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					}
					if(GameRegistry.findItem("Railcraft","railcraft.armor.steel.plate") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","railcraft.armor.steel.plate").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),8,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					}
				}
			}
		}
		if(Loader.isModLoaded("ThermalExpansion"))
		{
			if(OreDictionary.getOres("ingotInvar").size() != 0)
			{
				if(ARGetSmelting("InvarTool",true))
				{
					if(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.tool.invarAxe") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.tool.invarAxe").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),3,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					}
					if(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.tool.invarHoe") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.tool.invarHoe").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),3,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					}
					if(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.tool.invarPickaxe") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.tool.invarPickaxe").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),3,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					}
					if(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.tool.invarShovel") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.tool.invarShovel").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),3,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					}
					if(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.tool.invarSword") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.tool.invarSword").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),3,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					}
				}
				if(ARGetSmelting("InvarArmor",true))
				{
					if(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.armor.invarBoots") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.armor.invarBoots").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),3,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					}
					if(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.armor.invarHelmet") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.armor.invarHelmet").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),3,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					}
					if(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.armor.invarLegs") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.armor.invarLegs").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),3,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					}
					if(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.armor.invarPlate") != null)
					{
						FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","item.thermalexpansion.armor.invarPlate").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),3,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					}
				}
			}
			if(ARGetCrafting("EnderiumDust",true))
			{
				if(OreDictionary.getOres("dustEnderium").size() > 0)
				{
					ItemStack dend = OreDictionary.getOres("dustEnderium").get(0);
					dend.stackSize = 4;
					GameRegistry.addRecipe(
						new ShapelessOreRecipe(
							dend,
							new Object[]{"ExchangeIgnition",
									"dustTin","dustTin","dustTin",
									"dustPlatinum",
									Item.enderPearl,Item.enderPearl,Item.enderPearl,Item.enderPearl}));
				}
			}
		}
		try
		{
			MFR = Class.forName("powercrystals.minefactoryreloaded.MineFactoryReloadedCore");
			Object pinkSlimeBall = MFR.getField("pinkSlimeballItem").get(null);
			ItemStack pink = new ItemStack((Item)pinkSlimeBall);
			if(ARGetCrafting("PinkSlimeBall",true))
			{
				GameRegistry.addRecipe(
					new ShapedOreRecipe(
						pink,
						new Object[]{"XXX","XYX","XXX",
							Character.valueOf('X'),Item.rottenFlesh,
							Character.valueOf('Y'),Item.slimeBall}));
			}
		}
		catch(Exception e)
		{
			System.out.println(AdditionalRecipe.CONSOLE + "Can't Find MineFactory Reloaded.");
		}
		try
		{
			BC = Class.forName("buildcraft.BuildCraftCore");
			Object springBlock = BC.getField("springBlock").get(null);
			Block spring = (Block)springBlock;
			if(ARGetAnother("BuildCraft_Spring",true))
			{
				spring.setHardness(60F);
			}
		}
		catch(Exception e)
		{
			System.out.println(AdditionalRecipe.CONSOLE + "Can't Find BuildCraft.");
		}
		if((OreDictionary.getOres("oreTofu").size() > 0) && (OreDictionary.getOres("tofuGem").size() > 0))
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					new ItemStack(OreDictionary.getOres("tofuGem").get(0).getItem(),2,OreDictionary.getOres("tofuGem").get(0).getItemDamage()),
					new Object[]{"oreTofu","MortarTier01"}));
			FurnaceRecipes.smelting().addSmelting(
				OreDictionary.getOres("oreTofu").get(0).getItem().itemID,
				OreDictionary.getOres("oreTofu").get(0).getItemDamage(),
				new ItemStack(OreDictionary.getOres("tofuGem").get(0).getItem(),2,OreDictionary.getOres("tofuGem").get(0).getItemDamage()),
				0.0f);
		}
		try
		{
			MoInv = Class.forName("moreinventory.MoreInventoryMod");
			Object WoodContainer = MoInv.getField("StorageBox").get(null);
			ItemStack Diamond = new ItemStack((Item)WoodContainer,1,3);
			ItemStack Emerald = new ItemStack((Item)WoodContainer,3,10);
			GameRegistry.addRecipe(
				new ShapedOreRecipe(
					Emerald,
					new Object[]{"XYX","XZX","XYX",
						Character.valueOf('X'),Item.emerald,
						Character.valueOf('Y'),Block.stoneSingleSlab,
						Character.valueOf('Z'),Diamond}));
		}
		catch(Exception e)
		{
			System.out.println(AdditionalRecipe.CONSOLE + "Can't Find MoreInventoryMod.");
		}
		if(Loader.isModLoaded("TConstruct"))
		{
			if(GameRegistry.findItem("TConstruct","canister") != null)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "Find TConstruct and Canister1.");
			}
			else if(GameRegistry.findItem("TConstruct","Heart Canister") != null)
			{
				System.out.println(AdditionalRecipe.CONSOLE + "Find TConstruct and Canister2.");
			}
		}
	}
}
