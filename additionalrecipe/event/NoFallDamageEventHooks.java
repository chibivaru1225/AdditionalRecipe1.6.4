package chibivaru.additionalrecipe.event;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import chibivaru.additionalrecipe.AdditionalRecipe;

public class NoFallDamageEventHooks
{
	private boolean noFallDamage = false;
	@ForgeSubscribe//(1.6までは@ForgeSubscribe)
	public void LivingUpdate(LivingUpdateEvent event)
	{
		if(event.entityLiving != null && event.entityLiving instanceof EntityPlayer && event.entityLiving .worldObj.isRemote)
		{
			EntityPlayerSP player = (EntityPlayerSP) event.entityLiving;
			Falling(player);
		}
	}
	private void Falling(EntityPlayerSP player)
	{
		//クリエイティブでないなら
		if(!player.capabilities.isCreativeMode)
		{
			//飛行が許可されていないなら
			if(!player.capabilities.allowFlying)
			{
				if((player.inventory.armorItemInSlot(0) != null)&&(player.inventory.armorItemInSlot(0).getItem().itemID == AdditionalRecipe.armorBedrockBootsID))
				{
					this.noFallDamage = true;
				}
				else if((player.inventory.hasItem(AdditionalRecipe.gravitationFeatherItemID))||(player.inventory.hasItem(AdditionalRecipe.superGravitationFeatherItemID)))
				{
					this.noFallDamage = true;
				}
				else if((player.inventory.hasItem(AdditionalRecipe.exchangeIgnitionItemID))||(player.inventory.hasItem(AdditionalRecipe.ultimateExchangeIgnitionItemID)))
				{
					this.noFallDamage = true;
				}
				else
				{
					this.noFallDamage = false;
				}
			}
		}
	}
	//落下時ダメージ無効化処理。LivingFallEventが実装されたバージョンのみ
	@ForgeSubscribe
	public void onPlayerFall(LivingFallEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			if (this.noFallDamage)
			{
				event.setCanceled(true);
			}
		}
	}
}
