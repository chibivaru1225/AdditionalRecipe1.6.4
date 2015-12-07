package chibivaru.additionalrecipe.event;

import chibivaru.additionalrecipe.AdditionalRecipe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

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
		if(spearDAYO)
		{
			if(!(player.experienceLevel > 10))
			{
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10, 1));
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 10, 1));
			}
			player.addPotionEffect(new PotionEffect(Potion.poison.id, 10, 1));
		}
	}
}
