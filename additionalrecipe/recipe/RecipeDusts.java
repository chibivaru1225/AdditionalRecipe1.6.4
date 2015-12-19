package chibivaru.additionalrecipe.recipe;

import static chibivaru.additionalrecipe.common.ARConfiguration.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeDusts {
	public void init()
	{
		//鉱石粉クラフト
		if(OreDictionary.getOres("dustCoal").size() > 0)
		{
			GameRegistry.addRecipe(
				new ShapelessOreRecipe(
					OreDictionary.getOres("dustCoal").get(0),
					new Object[]{Item.coal,"MortarTier01"}));
		}
		if(AdditionalRecipe.craftingDustNetherStar)
		{
			if(OreDictionary.getOres("dustNetherStar").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						OreDictionary.getOres("dustNetherStar").get(0),
						new Object[]{Item.netherStar,"MortarTier03"}));
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						Item.netherStar,
						new Object[]{"dustNetherStar"}));
			}
		}
		if(AdditionalRecipe.craftingDustBedrock)
		{
			if(OreDictionary.getOres("dustBedrock").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						OreDictionary.getOres("dustBedrock").get(0),
						new Object[]{Block.bedrock,"MortarTier03"}));
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(Block.bedrock,1),
						new Object[]{"dustBedrock"}));
			}
		}
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.coal,ARGetCfgOther("IronMortarDust",2)),
				new Object[]{"MortarOreTier01",Block.oreCoal}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.diamond,ARGetCfgOther("IronMortarDust",2)),
				new Object[]{"MortarOreTier01",Block.oreDiamond}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.emerald,ARGetCfgOther("IronMortarDust",2)),
				new Object[]{"MortarOreTier01",Block.oreEmerald}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.coal,ARGetCfgOther("DiamondMortarDust",4)),
				new Object[]{"MortarOreTier02",Block.oreCoal}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.diamond,ARGetCfgOther("DiamondMortarDust",4)),
				new Object[]{"MortarOreTier02",Block.oreDiamond}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.emerald,ARGetCfgOther("DiamondMortarDust",4)),
				new Object[]{"MortarOreTier02",Block.oreEmerald}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.coal,ARGetCfgOther("BedrockMortarDust",8)),
				new Object[]{"MortarOreTier03",Block.oreCoal}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.diamond,ARGetCfgOther("BedrockMortarDust",8)),
				new Object[]{"MortarOreTier03",Block.oreDiamond}));
		GameRegistry.addRecipe(
			new ShapelessOreRecipe(
				new ItemStack(Item.emerald,ARGetCfgOther("BedrockMortarDust",8)),
				new Object[]{"MortarOreTier03",Block.oreEmerald}));
		//Mod鉱石+バニラ鉱石粉
		if(AdditionalRecipe.mortarOreDust)
		{
			if(OreDictionary.getOres("dustIron").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustIron").get(0).getItem(),ARGetCfgOther("IronMortarDust",2),OreDictionary.getOres("dustIron").get(0).getItemDamage()),
						new Object[]{Block.oreIron,"MortarOreTier01"}));
			}
			if(OreDictionary.getOres("dustGold").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustGold").get(0).getItem(),ARGetCfgOther("IronMortarDust",2),OreDictionary.getOres("dustGold").get(0).getItemDamage()),
						new Object[]{Block.oreGold,"MortarOreTier01"}));
			}
			if((OreDictionary.getOres("dustCopper").size() > 0) && (OreDictionary.getOres("oreCopper").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustCopper").get(0).getItem(),ARGetCfgOther("IronMortarDust",2),OreDictionary.getOres("dustCopper").get(0).getItemDamage()),
						new Object[]{"oreCopper","MortarOreTier01"}));
			}
			if((OreDictionary.getOres("dustTin").size() > 0) && (OreDictionary.getOres("oreTin").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustTin").get(0).getItem(),ARGetCfgOther("IronMortarDust",2),OreDictionary.getOres("dustTin").get(0).getItemDamage()),
						new Object[]{"oreTin","MortarOreTier01"}));
			}
			if((OreDictionary.getOres("dustSilver").size() > 0) && (OreDictionary.getOres("oreSilver").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustSilver").get(0).getItem(),ARGetCfgOther("IronMortarDust",2),OreDictionary.getOres("dustSilver").get(0).getItemDamage()),
						new Object[]{"oreSilver","MortarOreTier01"}));
			}
			if((OreDictionary.getOres("dustLead").size() > 0) && (OreDictionary.getOres("oreLead").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustLead").get(0).getItem(),ARGetCfgOther("IronMortarDust",2),OreDictionary.getOres("dustLead").get(0).getItemDamage()),
						new Object[]{"oreLead","MortarOreTier01"}));
			}

			if(OreDictionary.getOres("dustIron").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustIron").get(0).getItem(),ARGetCfgOther("DiamondMortarDust",4),OreDictionary.getOres("dustIron").get(0).getItemDamage()),
						new Object[]{Block.oreIron,"MortarOreTier02"}));
			}
			if(OreDictionary.getOres("dustGold").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustGold").get(0).getItem(),ARGetCfgOther("DiamondMortarDust",4),OreDictionary.getOres("dustGold").get(0).getItemDamage()),
						new Object[]{Block.oreGold,"MortarOreTier02"}));
			}
			if((OreDictionary.getOres("dustCopper").size() > 0) && (OreDictionary.getOres("oreCopper").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustCopper").get(0).getItem(),ARGetCfgOther("DiamondMortarDust",4),OreDictionary.getOres("dustCopper").get(0).getItemDamage()),
						new Object[]{"oreCopper","MortarOreTier02"}));
			}
			if((OreDictionary.getOres("dustTin").size() > 0) && (OreDictionary.getOres("oreTin").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustTin").get(0).getItem(),ARGetCfgOther("DiamondMortarDust",4),OreDictionary.getOres("dustTin").get(0).getItemDamage()),
						new Object[]{"oreTin","MortarOreTier02"}));
			}
			if((OreDictionary.getOres("dustSilver").size() > 0) && (OreDictionary.getOres("oreSilver").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustSilver").get(0).getItem(),ARGetCfgOther("DiamondMortarDust",4),OreDictionary.getOres("dustSilver").get(0).getItemDamage()),
						new Object[]{"oreSilver","MortarOreTier02"}));
			}
			if((OreDictionary.getOres("dustLead").size() > 0) && (OreDictionary.getOres("oreLead").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustLead").get(0).getItem(),ARGetCfgOther("DiamondMortarDust",4),OreDictionary.getOres("dustLead").get(0).getItemDamage()),
						new Object[]{"oreLead","MortarOreTier02"}));
			}

			if(OreDictionary.getOres("dustIron").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustIron").get(0).getItem(),ARGetCfgOther("BedrockMortarDust",8),OreDictionary.getOres("dustIron").get(0).getItemDamage()),
						new Object[]{Block.oreIron,"MortarOreTier03"}));
			}
			if(OreDictionary.getOres("dustGold").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustGold").get(0).getItem(),ARGetCfgOther("BedrockMortarDust",8),OreDictionary.getOres("dustGold").get(0).getItemDamage()),
						new Object[]{Block.oreGold,"MortarOreTier03"}));
			}
			if((OreDictionary.getOres("dustCopper").size() > 0) && (OreDictionary.getOres("oreCopper").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustCopper").get(0).getItem(),ARGetCfgOther("BedrockMortarDust",8),OreDictionary.getOres("dustCopper").get(0).getItemDamage()),
						new Object[]{"oreCopper","MortarOreTier03"}));
			}
			if((OreDictionary.getOres("dustTin").size() > 0) && (OreDictionary.getOres("oreTin").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustTin").get(0).getItem(),ARGetCfgOther("BedrockMortarDust",8),OreDictionary.getOres("dustTin").get(0).getItemDamage()),
						new Object[]{"oreTin","MortarOreTier03"}));
			}
			if((OreDictionary.getOres("dustSilver").size() > 0) && (OreDictionary.getOres("oreSilver").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustSilver").get(0).getItem(),ARGetCfgOther("BedrockMortarDust",8),OreDictionary.getOres("dustSilver").get(0).getItemDamage()),
						new Object[]{"oreSilver","MortarOreTier03"}));
			}
			if((OreDictionary.getOres("dustLead").size() > 0) && (OreDictionary.getOres("oreLead").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustLead").get(0).getItem(),ARGetCfgOther("BedrockMortarDust",8),OreDictionary.getOres("dustLead").get(0).getItemDamage()),
						new Object[]{"oreLead","MortarOreTier03"}));
			}
		}
		if(AdditionalRecipe.mortarIngotDust)
		{
			if(OreDictionary.getOres("dustIron").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustIron").get(0).getItem(),1,OreDictionary.getOres("dustIron").get(0).getItemDamage()),
						new Object[]{Item.ingotIron,"MortarTier01"}));
			}
			if(OreDictionary.getOres("dustGold").size() > 0)
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustGold").get(0).getItem(),1,OreDictionary.getOres("dustGold").get(0).getItemDamage()),
						new Object[]{Item.ingotGold,"MortarTier01"}));
			}
			if((OreDictionary.getOres("dustCopper").size() > 0) && (OreDictionary.getOres("ingotCopper").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustCopper").get(0).getItem(),1,OreDictionary.getOres("dustCopper").get(0).getItemDamage()),
						new Object[]{"ingotCopper","MortarTier01"}));
			}
			if((OreDictionary.getOres("dustTin").size() > 0) && (OreDictionary.getOres("ingotTin").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustTin").get(0).getItem(),1,OreDictionary.getOres("dustTin").get(0).getItemDamage()),
						new Object[]{"ingotTin","MortarTier01"}));
			}
			if((OreDictionary.getOres("dustSilver").size() > 0) && (OreDictionary.getOres("ingotSilver").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustSilver").get(0).getItem(),1,OreDictionary.getOres("dustSilver").get(0).getItemDamage()),
						new Object[]{"ingotSilver","MortarTier01"}));
			}
			if((OreDictionary.getOres("dustLead").size() > 0) && (OreDictionary.getOres("ingotLead").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustLead").get(0).getItem(),1,OreDictionary.getOres("dustLead").get(0).getItemDamage()),
						new Object[]{"ingotLead","MortarTier01"}));
			}
			if((OreDictionary.getOres("dustNickel").size() > 0) && (OreDictionary.getOres("ingotNickel").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustNickel").get(0).getItem(),1,OreDictionary.getOres("dustNickel").get(0).getItemDamage()),
						new Object[]{"ingotNickel","MortarTier01"}));
			}
			if((OreDictionary.getOres("dustPlatinum").size() > 0) && (OreDictionary.getOres("ingotPlatinum").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustPlatinum").get(0).getItem(),1,OreDictionary.getOres("dustPlatinum").get(0).getItemDamage()),
						new Object[]{"ingotPlatinum","MortarTier01"}));
			}
			if((OreDictionary.getOres("dustInvar").size() > 0) && (OreDictionary.getOres("ingotInvar").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustInvar").get(0).getItem(),1,OreDictionary.getOres("dustInvar").get(0).getItemDamage()),
						new Object[]{"ingotInvar","MortarTier01"}));
			}
			if((OreDictionary.getOres("dustBronse").size() > 0) && (OreDictionary.getOres("ingotBronse").size() > 0))
			{
				GameRegistry.addRecipe(
					new ShapelessOreRecipe(
						new ItemStack(OreDictionary.getOres("dustBronse").get(0).getItem(),1,OreDictionary.getOres("dustBronse").get(0).getItemDamage()),
						new Object[]{"ingotBronse","MortarTier01"}));
			}
		}
	}
}
