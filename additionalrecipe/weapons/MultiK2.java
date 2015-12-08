package chibivaru.additionalrecipe.weapons;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MultiK2 extends ItemSword
//public class MultiK2 extends Item
{
	private float weaponDamage = 10.0f;
    private boolean effect;
    public int mode;
    private EnumToolMaterial toolMaterial;
    private Icon[] icons = new Icon[4];
    public MultiK2(int par1,EnumToolMaterial par2toolMaterial)
    //public MultiK2(int par1)
	{
		//super(par1);
		super(par1, par2toolMaterial);
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		this.setTextureName("additionalrecipe:K2GS");
		this.mode = 0;//0 = Great Sword,1 = Long Sword,2 = Lapier,3 = Wand
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		super.registerIcons(register);
		//this.itemIcon = register.registerIcon(AdditionalRecipe.MODID + ":" + this.getUnlocalizedName());
		icons[0] = register.registerIcon(AdditionalRecipe.MODID + ":K2GS");
		icons[1] = register.registerIcon(AdditionalRecipe.MODID + ":K2LS");
		icons[2] = register.registerIcon(AdditionalRecipe.MODID + ":K2LP");
		icons[3] = register.registerIcon(AdditionalRecipe.MODID + ":K2WA");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		NBTTagCompound nbttagcompound = itemStack.getTagCompound();
		int mk2;
		if(nbttagcompound == null)
		{
			System.out.println();
			nbttagcompound = new NBTTagCompound();
			itemStack.setTagCompound(nbttagcompound);
			mk2 = 0;
		}
		else
		{
			mk2 = nbttagcompound.getInteger("adr.mk2");
		}
		mk2 = mk2 + 1;
		if(mk2 > 3)
		{
			mk2 = 0;
		}
		switch(mk2)
		{
			case 0:
			{
				this.weaponDamage = 40.0f;
				break;
			}
			case 1:
			{
				this.weaponDamage = 20.0f;
				break;
			}
			case 2:
			{
				this.weaponDamage = 10.0f;
				break;
			}
			case 3:
			{
				this.weaponDamage = 5.0f;
				break;
			}
		}
		nbttagcompound.setInteger("adr.mk2",mk2);
		System.out.println(mk2);
		return itemStack;
	}
	@Override
	public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer player, Entity entity)
	{
		NBTTagCompound nbttagcompound = itemStack.getTagCompound();
		int mk2;
		if(nbttagcompound == null)
		{
			nbttagcompound = new NBTTagCompound();
			itemStack.setTagCompound(nbttagcompound);
			mk2 = 0;
		}
		else
		{
			mk2 = nbttagcompound.getInteger("adr.mk2");
		}
		//System.out.println(weaponDamage);
		if(mk2 == 2)
		{
			entity.hurtResistantTime = 10;
			System.out.println(weaponDamage);
		}
		return entity.attackEntityFrom(DamageSource.causePlayerDamage(player),weaponDamage);
	}
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();
		int mk2;
		if(nbttagcompound == null)
		{
			nbttagcompound = new NBTTagCompound();
			par1ItemStack.setTagCompound(nbttagcompound);
			mk2 = 0;
		}
		else
		{
			mk2 = nbttagcompound.getInteger("adr.mk2");
		}
		switch(mk2)
		{
			case 0:
			{
				par3List.add((new StringBuilder()).append(EnumChatFormatting.YELLOW).append("Mode ").append(EnumChatFormatting.LIGHT_PURPLE).append("Great Sword").toString());
				//par3List.add((new StringBuilder()).append(EnumChatFormatting.BLUE).append("+39").append(EnumChatFormatting.RED).append(" Attack Power").toString());
				break;
			}
			case 1:
			{
				par3List.add((new StringBuilder()).append(EnumChatFormatting.YELLOW).append("Mode ").append(EnumChatFormatting.LIGHT_PURPLE).append("Long Sword").toString());
				//par3List.add((new StringBuilder()).append(EnumChatFormatting.BLUE).append("+19").append(EnumChatFormatting.RED).append(" Attack Power").toString());
				break;
			}
			case 2:
			{
				par3List.add((new StringBuilder()).append(EnumChatFormatting.YELLOW).append("Mode ").append(EnumChatFormatting.LIGHT_PURPLE).append("Lapier").toString());
				//par3List.add((new StringBuilder()).append(EnumChatFormatting.BLUE).append("+9").append(EnumChatFormatting.RED).append(" Attack Power").toString());
				break;
			}
			case 3:
			{
				par3List.add((new StringBuilder()).append(EnumChatFormatting.YELLOW).append("Mode ").append(EnumChatFormatting.LIGHT_PURPLE).append("Wand").toString());
				//par3List.add((new StringBuilder()).append(EnumChatFormatting.BLUE).append("+4").append(EnumChatFormatting.RED).append(" Attack Power").toString());
				break;
			}
		}
	}
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean held)
	{
		if(entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)entity;
			if(player.inventory.hasItem(AdditionalRecipe.multiK2ItemID))
			{
				NBTTagCompound nbttagcompound = stack.getTagCompound();
				int mk2;
				if(nbttagcompound == null)
				{
					nbttagcompound = new NBTTagCompound();
					stack.setTagCompound(nbttagcompound);
					mk2 = 0;
				}
				else
				{
					mk2 = nbttagcompound.getInteger("adr.mk2");
				}
				switch(mk2)
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
					case 1:
					{
						break;
					}
					case 2:
					{
						break;
					}
					case 3:
					{
						if(player.shouldHeal())
						{
							player.heal(1.0f);
						}
						break;
					}
				}
			}
		}
	}
	@Override
	public Icon getIconIndex(ItemStack itemStack)
	{
		if(itemStack.hasTagCompound())
		{
			NBTTagCompound nbttagcompound = itemStack.getTagCompound();
			int mk2 = nbttagcompound.getInteger("adr.mk2");
			return this.icons[mk2];
		}
		else
		{
			return this.icons[0];
		}
	}
	@Override
	public Icon getIcon(ItemStack itemStack, int pass)
	{
		if(itemStack.hasTagCompound())
		{
			NBTTagCompound nbttagcompound = itemStack.getTagCompound();
			int mk2 = nbttagcompound.getInteger("adr.mk2");
			return this.icons[mk2];
		}
		else
		{
			return this.icons[0];
		}
	}
	public Icon[] getIcons()
	{
		return icons;
	}
}