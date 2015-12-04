package chibivaru.additionalrecipe.event;

import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import chibivaru.additionalrecipe.AdditionalRecipe;

public class CirceForceEventHooks {
	@ForgeSubscribe//(1.6までは@ForgeSubscribe)
	public void LivingUpdate(LivingUpdateEvent event)
	{
		EntityLivingBase livingBase = ((LivingEvent) (event)).entityLiving;
		if(livingBase != null && (livingBase instanceof EntityPlayer))
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			Circe(player);
		}
	}
	public void Circe(EntityPlayer player)
	{
		boolean circeForce = AdditionalRecipe.hasItem(AdditionalRecipe.circeForceItemID, player);
		if(circeForce)
		{
			if(player.isInWater())
			{
				double dashAmount = 1.0D;
				player.motionX *= dashAmount;
				player.motionZ *= dashAmount;
				if (((EntityPlayerSP)player).movementInput.sneak)
				{
					//player.motionY -= 0.4D;//スニークで下降．クリエイティブより少し早い
					player.motionY -= 0.4D;
				}
				if (((EntityPlayerSP)player).movementInput.jump)
				{
					//player.motionY += 0.4D;//Jumpキーで上昇．クリエ〈略〉
					player.motionY += 0.4D;
				}
			}
			if(player.isInsideOfMaterial(Material.water))
			{
				player.setAir(300);
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 20, 1));
			}
		}
	}
}
