package chibivaru.additionalrecipe.event;

import static chibivaru.additionalrecipe.common.ARItemHandler.*;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import chibivaru.additionalrecipe.AdditionalRecipe;

public class CirceForceEventHooks {
	@ForgeSubscribe//(1.6までは@ForgeSubscribe)
	public void LivingUpdate(LivingUpdateEvent event)
	{
		if(event.entityLiving != null && event.entityLiving instanceof EntityPlayer && event.entityLiving .worldObj.isRemote)
		{
			EntityPlayer   player   = (EntityPlayer)   event.entityLiving;
			EntityPlayerSP playerSP = (EntityPlayerSP) event.entityLiving;
			Circe(player,playerSP);
		}
	}
	public void Circe(EntityPlayer par1player,EntityPlayerSP par2player)
	{
		boolean circeForce = AdditionalRecipe.hasItem(ARGetItemIDRegister("circeforce"), par1player);
		if(circeForce)
		{
			if(par1player.isInWater())
			{
				double dashAmount = 1.1D;
				par2player.motionX *= dashAmount;
				par2player.motionZ *= dashAmount;
				if (((EntityPlayerSP)par2player).movementInput.sneak)
				{
					//player.motionY -= 0.4D;//スニークで下降．クリエイティブより少し早い
					par2player.motionY -= 0.1D;
				}
				if (((EntityPlayerSP)par2player).movementInput.jump)
				{
					//player.motionY += 0.4D;//Jumpキーで上昇．クリエ〈略〉
					par2player.motionY += 0.1D;
				}
			}
			if(par1player.isBurning())
			{
				par1player.extinguish();
			}
		}
	}
}
