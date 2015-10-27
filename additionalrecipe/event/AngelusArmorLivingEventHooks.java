package chibivaru.additionalrecipe.event;

import java.util.Iterator;

import chibivaru.additionalrecipe.AdditionalRecipe;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class AngelusArmorLivingEventHooks
{
	@ForgeSubscribe//(1.6までは@ForgeSubscribe)
	public void LivingUpdate(LivingUpdateEvent event)
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
		if(isHelmet)
		{
			if(player.isInsideOfMaterial(Material.water))
			{
				player.setAir(300);
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
			}
		}
		if(isBoots)
		{
			if(player.onGround)
			{
				double dashAmount = 1.0D;
				if(player.isInWater())
				{
					dashAmount = 1.1799999999999999D;
				}
				if(player.isSprinting())
				{
					dashAmount = 1.7999999523162842D;
					if(player.isInWater())
					{
						dashAmount = 1.3999999999999999D;
					}
				}
				player.motionX *= dashAmount;
				player.motionZ *= dashAmount;
			}
			else if(player.isSprinting())
			{
				player.jumpMovementFactor = 0.08F;
			}
			else
			{
				player.jumpMovementFactor = 0.04F;
			}
		}
	}
	@ForgeSubscribe
	public void onHoodAttackedEntityEvent(AttackEntityEvent event)
	{
		EntityPlayer player = ((PlayerEvent)(event)).entityPlayer;
		Entity entity       = event.target;
		boolean isHelmet    = AdditionalRecipe.equipArmor(AdditionalRecipe.armorAngelusID, player, AdditionalRecipe.ARMOR_HELMET);
		if(isHelmet && (entity instanceof EntityLivingBase))
		{
			EntityLivingBase target = (EntityLivingBase)entity;
			target.hurtResistantTime = 0;
		}
	}
	@ForgeSubscribe
	public void onHoodDropEvent(LivingDropsEvent event)
	{
		EntityLivingBase LivingBase = ((LivingEvent) (event)).entityLiving;
		Entity entity               = event.source.getEntity();
		World world                 = ((Entity) (((LivingEvent) (event)).entityLiving)).worldObj;
		if(LivingBase instanceof EntityLiving)
		{
			EntityLiving target = (EntityLiving)LivingBase;
			if(entity instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)entity;
				boolean isHelmet    = AdditionalRecipe.equipArmor(AdditionalRecipe.armorAngelusID, player, AdditionalRecipe.ARMOR_HELMET);
				if(isHelmet)
				{
					Iterator i$ = event.drops.iterator();
					do
					{
						if(!i$.hasNext())
						{
							break;
						}
						EntityItem input = (EntityItem)i$.next();
						ItemStack resultStack = input.getEntityItem();
						if(1 < resultStack.stackSize)
						{
							EntityItem dropItem = new EntityItem(world, ((Entity) (target)).posX, ((Entity) (target)).posY, ((Entity) (target)).posZ, new ItemStack(resultStack.itemID, player.experienceLevel/2, resultStack.getItemDamage()));
							if(!world.isRemote)
							{
								world.spawnEntityInWorld(dropItem);
							}
						}
					}
					while(true);
					if(!world.isRemote)
					{
						world.spawnEntityInWorld(new EntityXPOrb(world, ((Entity) (target)).posX, ((Entity) (target)).posY, ((Entity) (target)).posZ, target.experienceValue));
					}
					world.playSoundAtEntity(target, "random.pop", 0.5F, 1.0F);
				}
			}
		}
	}
}
