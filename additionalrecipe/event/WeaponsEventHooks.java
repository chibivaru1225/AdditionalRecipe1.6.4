package chibivaru.additionalrecipe.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import chibivaru.additionalrecipe.AdditionalRecipe;

public class WeaponsEventHooks {
	@ForgeSubscribe//(1.6までは@ForgeSubscribe)
	public void LivingUpdate(LivingUpdateEvent event)
	{
		EntityLivingBase livingBase = ((LivingEvent) (event)).entityLiving;
		if(livingBase != null && (livingBase instanceof EntityPlayer))
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			Weapons(player);
		}
	}
	public void Weapons(EntityPlayer player)
	{
		boolean spearDAYO = AdditionalRecipe.hasItem(AdditionalRecipe.spearDAYOItemID, player);
		boolean swordYORU = AdditionalRecipe.hasItem(AdditionalRecipe.swordYORUItemID, player);
		boolean multiK2   = AdditionalRecipe.hasItem(AdditionalRecipe.multiK2ItemID, player);
		if(spearDAYO)
		{
			if(!(player.experienceLevel > 10))
			{
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10));
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 10));
			}
			player.addPotionEffect(new PotionEffect(Potion.poison.id, 10));
		}
		if(swordYORU)
		{
			if(player.experienceLevel < 50)
			{
				player.addPotionEffect(new PotionEffect(Potion.hunger.id, 10));
				player.addPotionEffect(new PotionEffect(Potion.weakness.id, 10));
			}
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 10));
		}
		/*
		if(multiK2)
		{
			switch(AdditionalRecipe.multiK2.mode)
			{
				case 0:
				{
					if(!player.isPotionActive(Potion.moveSlowdown.id))
					{
						player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id,20*30));
					}
					if(!player.isPotionActive(Potion.digSlowdown.id))
					{
						player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id,20*30));
					}
					break;
				}
				case 4:
				{
					if(!player.isPotionActive(Potion.regeneration.id))
					{
						player.addPotionEffect(new PotionEffect(Potion.regeneration.id,20*30));
					}
					break;
				}
			}
		}
		*/
	}
}
