package chibivaru.additionalrecipe.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import chibivaru.additionalrecipe.AdditionalRecipe;

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
			if(player.shouldHeal() && (((Entity) (player)).ticksExisted % 20) * 12 == 0)
			{
				((Entity) (player)).worldObj.playSoundAtEntity(player, "random.pop", 1.0F, 1.0F);
				player.heal(1.0F);
			}
		}
		if(isLegs)
		{
			double width = player.experienceLevel / 2;
			List list = player.worldObj.getEntitiesWithinAABBExcludingEntity(player, player.boundingBox.expand(width, 1.5D, width));
			Entity entity = null;
			if(list != null && list.size() > 0)
			{
				for(int j1 = 0; j1 < list.size(); j1++)
				{
					entity = (Entity)list.get(j1);
					if(!(entity instanceof EntityLiving) || !(entity instanceof IMob))
					{
						continue;
					}
					EntityLiving target = (EntityLiving)entity;
					target.addPotionEffect(new PotionEffect(Potion.weakness.id, 20, 1));
					target.addPotionEffect(new PotionEffect(Potion.confusion.id, 20, 9));
					target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20, 9));
				}
			}
		}
		if(isBoots)
		{
			double dashAmount = 1.0D;
			if(player.onGround)
			{
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
			}
			player.motionX *= dashAmount;
			player.motionZ *= dashAmount;
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
	@ForgeSubscribe
	public void onPlateAttackedEvent(LivingAttackEvent event)
	{
		EntityLivingBase livingBase = ((LivingEvent) (event)).entityLiving;
		DamageSource source         = event.source;
		float damageAmount          = event.ammount;
		if(livingBase instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)livingBase;
			boolean isPlate     = AdditionalRecipe.equipArmor(AdditionalRecipe.armorAngelusID, player, AdditionalRecipe.ARMOR_PLATE);
			if(isPlate && source != DamageSource.starve)
			{
				float damageResistant = damageAmount * (float)(player.experienceLevel);
				if(damageAmount < damageResistant)
				{
					event.setCanceled(true);
				}
			}
		}
	}
	@ForgeSubscribe
	public void onPlateLivingHurt(LivingHurtEvent event)
	{
		EntityLivingBase livingBase = ((LivingEvent) (event)).entityLiving;
		DamageSource source         = event.source;
		float damageAmount          = event.ammount;
		if(livingBase instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)livingBase;
			boolean isPlate     = AdditionalRecipe.equipArmor(AdditionalRecipe.armorAngelusID, player, AdditionalRecipe.ARMOR_PLATE);
			if(isPlate && source != DamageSource.starve)
			{
				float damageResistant = damageAmount * (float)(player.experienceLevel);
				event.ammount = damageAmount - damageResistant;
			}
		}
	}
	@ForgeSubscribe
	public void onLegsAttackedEvent(LivingAttackEvent event)
	{
		EntityLivingBase livingBase = ((LivingEvent) (event)).entityLiving;
		DamageSource source = event.source;
		float damageAmount = event.ammount;
		World world = ((Entity) (livingBase)).worldObj;
		if(livingBase instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)livingBase;
			boolean isLegs = AdditionalRecipe.equipArmor(AdditionalRecipe.armorAngelusID, player, AdditionalRecipe.ARMOR_LEGS);
			if(isLegs && (source.getEntity() instanceof EntityLivingBase))
			{
				float reflectDamage = damageAmount * (float)(player.experienceLevel / 5);
				double width = player.experienceLevel / 2;
				source.getEntity().attackEntityFrom(DamageSource.causeMobDamage(player), reflectDamage);
				List list = source.getEntity().worldObj.getEntitiesWithinAABBExcludingEntity(source.getEntity(), source.getEntity().boundingBox.expand(width, width, width));
				ArrayList arraylist = new ArrayList();
				Iterator iterator = list.iterator();
				do
				{
					if(!iterator.hasNext())
					{
						break;
					}
					Entity entity = (Entity)iterator.next();
					if(entity instanceof EntityMob)
					{
						arraylist.add((EntityMob)entity);
					}
				}
				while(true);
				if(arraylist.size() < 2)
				{
					return;
				}
				for(int i = 0; i < arraylist.size(); i++)
				{
					EntityMob mob = (EntityMob)arraylist.get(i);
					EntityMob otherMob = (EntityMob)arraylist.get(i == 0 ? arraylist.size() - 1 : i - 1);
					mob.attackEntityFrom(DamageSource.causeMobDamage(otherMob), reflectDamage);
					otherMob.setTarget(mob);
				}
				world.playSoundAtEntity(player, "random.anvil_land", 1.0F, 1.0F);
			}
		}
	}
}
