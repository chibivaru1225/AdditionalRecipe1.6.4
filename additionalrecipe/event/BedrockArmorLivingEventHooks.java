package chibivaru.additionalrecipe.event;

import static chibivaru.additionalrecipe.AdditionalRecipe.*;
import static chibivaru.additionalrecipe.common.ARItemHandler.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class BedrockArmorLivingEventHooks
{
	@ForgeSubscribe//(1.6までは@ForgeSubscribe)
	public void LivingUpdate(LivingUpdateEvent event)
	{
		EntityLivingBase livingBase = ((LivingEvent) (event)).entityLiving;
		if(livingBase != null && (livingBase instanceof EntityPlayer))
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			Bedrock(player);
		}
	}
	private void Bedrock(EntityPlayer player)
	{
		boolean isHelmet = equipArmor(ARGetItemIDRegister("bedrockhelmet"), player, ARMOR_HELMET);
		boolean isPlate  = equipArmor(ARGetItemIDRegister("bedrockplate"), player, ARMOR_PLATE);
		boolean isLegs   = equipArmor(ARGetItemIDRegister("bedrocklegs"), player, ARMOR_LEGS);
		boolean isBoots  = equipArmor(ARGetItemIDRegister("bedrockboots"), player, ARMOR_BOOTS);
		//System.out.println("[AdditionalRecipe]:Bedrock isHelmet=" + isHelmet + " isPlate=" + isPlate + " isLegs=" + isLegs + " isBoots=" + isBoots);
		if(isHelmet)
		{
			if(player.isInsideOfMaterial(Material.water))
			{
				player.setAir(300);
				//System.out.println("[AdditionalRecipe]:SetAir.");
			}
		}
		if(isPlate)
		{
			for(int i = 0; i < Potion.potionTypes.length; i++)
			{
				if(Potion.potionTypes[i] != null && player.isPotionActive(i) && Potion.potionTypes[i].isBadEffect())
				{
					player.removePotionEffect(i);
				}
			}
		}
		if(isLegs)
		{
			if(player.isBurning())
			{
				player.extinguish();
				//System.out.println("[AdditionalRecipe]:Exitnguish.");
			}
		}
	}
}
