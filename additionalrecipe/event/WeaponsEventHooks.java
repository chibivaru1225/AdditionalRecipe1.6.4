package chibivaru.additionalrecipe.event;

import static chibivaru.additionalrecipe.common.ARItemHandler.*;
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
		boolean spearDAYO = AdditionalRecipe.hasItem(ARGetItemIDRegister("dayo"), player);
		boolean swordYORU = AdditionalRecipe.hasItem(ARGetItemIDRegister("yoru"), player);
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
	}
}
