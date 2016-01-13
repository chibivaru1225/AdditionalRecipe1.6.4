package chibivaru.additionalrecipe.event;

import static chibivaru.additionalrecipe.AdditionalRecipe.*;
import static chibivaru.additionalrecipe.common.ARItemHandler.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class WrathArmorLivingEventHooks
{
	private char timer = 0;
	public boolean timer(boolean mode)
	{
		if(mode)
		{
			if(timer == 0)
			{
				timer++;
				return true;
			}
			else if(timer == 20 * 60)
			{
				timer = 0;
				return false;
			}
			else
			{
				timer++;
				return false;
			}
		}
		else
		{
			if(timer == 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	@ForgeSubscribe//(1.6までは@ForgeSubscribe)
	public void LivingUpdate(LivingUpdateEvent event)
	{
		EntityLivingBase livingBase = ((LivingEvent) (event)).entityLiving;
		if(livingBase != null && (livingBase instanceof EntityPlayer))
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			Bedrock(player);
			timer(true);
		}
	}
	private void Bedrock(EntityPlayer player)
	{
		boolean isHelmet = equipArmor(ARGetItemIDRegister("wrathhood"), player, ARMOR_HELMET);
		boolean isPlate  = equipArmor(ARGetItemIDRegister("wrathvestment"), player, ARMOR_PLATE);
		boolean isLegs   = equipArmor(ARGetItemIDRegister("wrathskirt"), player, ARMOR_LEGS);
		boolean isBoots  = equipArmor(ARGetItemIDRegister("wrathboots"), player, ARMOR_BOOTS);
		boolean wrath    = equipArmor(ARGetItemIDRegister("wrathhood"),ARGetItemIDRegister("wrathvestment"),ARGetItemIDRegister("wrathskirt"),ARGetItemIDRegister("wrathboots"), player);
		//System.out.println("[AdditionalRecipe]:Gluttony isHelmet=" + isHelmet + " isPlate=" + isPlate + " isLegs=" + isLegs + " isBoots=" + isBoots);
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
		if(wrath)
		{
			if(timer(false))
			{
				player.getFoodStats().addStats(-1,-1F);
			}
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.id,3,20));
		}
	}
}
