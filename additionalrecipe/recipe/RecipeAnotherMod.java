package chibivaru.additionalrecipe.recipe;

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
			if(AdditionalRecipe.craftingLinkModifer)
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
				if(AdditionalRecipe.craftingFlour)
				{
					GameRegistry.addRecipe(
						new ShapelessOreRecipe(
							OreDictionary.getOres("dustWheat").get(0),
							new Object[]{Item.wheat}));
				}
			}
		}
		/*
		if(Loader.isModLoaded("Railcraft"))
		{
			if(OreDictionary.getOres("ingotSteel").size() != 0)
			{
				if(AdditionalRecipe.smeltingToolSteel)
				{
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","Steel Axe").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),3,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","Steel Hoe").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),2,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","Steel Pickaxe").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),3,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","Steel Shovel").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),1,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","Steel Sword").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),2,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
				}
				if(AdditionalRecipe.smeltingArmorSteel)
				{
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","Steel Boots").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),4,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","Steel Helmet").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),5,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","Steel Leggings").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),7,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("Railcraft","Steel Chestplate").itemID,new ItemStack(OreDictionary.getOres("ingotSteel").get(0).getItem(),8,OreDictionary.getOres("ingotSteel").get(0).getItemDamage()),0.0f);
				}
			}
		}
		if(Loader.isModLoaded("ThermalExpansion"))
		{
			if(OreDictionary.getOres("ingotInvar").size() != 0)
			{
				if(AdditionalRecipe.smeltingToolInvar)
				{
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","Invar Axe").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),3,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","Invar Hoe").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),2,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","Invar Pickaxe").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),3,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","Invar Shovel").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),1,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","Invar Sword").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),2,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
				}
				if(AdditionalRecipe.smeltingArmorInvar)
				{
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","Invar Boots").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),4,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","Invar Helmet").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),5,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","Invar Leggings").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),7,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
					FurnaceRecipes.smelting().addSmelting(GameRegistry.findItem("ThermalExpansion","Invar Chestplate").itemID,new ItemStack(OreDictionary.getOres("ingotInvar").get(0).getItem(),8,OreDictionary.getOres("ingotInvar").get(0).getItemDamage()),0.0f);
				}
			}
		}
		*/
		try
		{
			MFR = Class.forName("powercrystals.minefactoryreloaded.MineFactoryReloadedCore");
			Object pinkSlimeBall = MFR.getField("pinkSlimeballItem").get(null);
			ItemStack pink = new ItemStack((Item)pinkSlimeBall);
			if(AdditionalRecipe.craftingPinkSlimeBall)
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
			System.out.println("[AdditionalRecipe]:Can't Find MineFactory Reloaded");
		}
		try
		{
			BC = Class.forName("buildcraft.BuildCraftCore");
			Object springBlock = BC.getField("springBlock").get(null);
			Block spring = (Block)springBlock;
			if(AdditionalRecipe.digBCSpring)
			{
				spring.setHardness(60F);
			}
		}
		catch(Exception e)
		{
			System.out.println("[AdditionalRecipe]:Can't Find BuildCraft");
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
			System.out.println("[AdditionalRecipe]:Can't Find MoreInventoryMod");
		}
	}
}
