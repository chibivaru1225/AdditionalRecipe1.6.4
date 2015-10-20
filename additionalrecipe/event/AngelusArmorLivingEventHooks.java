package chibivaru.additionalrecipe.event;

import chibivaru.additionalrecipe.AdditionalRecipe;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;

public class AngelusArmorLivingEventHooks
{
	@ForgeSubscribe//(1.6までは@ForgeSubscribe)
	public void LivingUpdate(net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent event)
	{
		EntityLivingBase livingBase = ((LivingEvent) (event)).entityLiving;
		if(livingBase != null && (livingBase instanceof EntityPlayer))
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			Angelus(player);
		}
	}
	private void Angelus(EntityPlayer player)
	{
		boolean isHelmet = AdditionalRecipe.equipArmor(AdditionalRecipe.armorAngelusID, player, AdditionalRecipe.ARMOR_HELMET);
		boolean isPlate  = AdditionalRecipe.equipArmor(AdditionalRecipe.armorAngelusID, player, AdditionalRecipe.ARMOR_PLATE);
		boolean isLegs   = AdditionalRecipe.equipArmor(AdditionalRecipe.armorAngelusID, player, AdditionalRecipe.ARMOR_LEGS);
		boolean isBoots  = AdditionalRecipe.equipArmor(AdditionalRecipe.armorAngelusID, player, AdditionalRecipe.ARMOR_BOOTS);
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
			if(player.isBurning())
			{
				player.extinguish();
				//System.out.println("[AdditionalRecipe]:Exitnguish.");
			}
		}
	}
}
