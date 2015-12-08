package chibivaru.additionalrecipe.weapons;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

//public class MultiK2 extends ItemSword
public class MultiK2 extends Item
{
	private float weaponDamage = 10.0f;
    private boolean effect;
    public int mode;
    private EnumToolMaterial toolMaterial;
    private Icon[] icons = new Icon[4];
    public MultiK2(int par1)
	{
		super(par1);
		//super(par1, par2toolMaterial);
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
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityPlayer)
	{
		if(world.isRemote)
		{
			mode++;
			if(mode > 3)
			{
				mode = 0;
			}
			switch(mode)
			{
				case 0:
				{
					this.weaponDamage = 40.0f;
					this.setTextureName(AdditionalRecipe.MODID + ":K2GS");
					break;
				}
				case 1:
				{
					this.weaponDamage = 20.0f;
					this.setTextureName(AdditionalRecipe.MODID + ":K2LS");
					break;
				}
				case 2:
				{
					this.weaponDamage = 10.0f;
					this.setTextureName(AdditionalRecipe.MODID + ":K2LP");
					break;
				}
				case 3:
				{
					this.weaponDamage = 5.0f;
					this.setTextureName(AdditionalRecipe.MODID + ":K2WA");
					break;
				}
			}
			//System.out.println(this.weaponDamage);
		}
		return itemstack;
	}
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		//System.out.println(weaponDamage);
		return entity.attackEntityFrom(DamageSource.causePlayerDamage(player),weaponDamage);
	}
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		switch(mode)
		{
			case 0:
			{
				par3List.add((new StringBuilder()).append(EnumChatFormatting.YELLOW).append("Mode ").append(EnumChatFormatting.LIGHT_PURPLE).append("Great Sword").toString());
				par3List.add((new StringBuilder()).append(EnumChatFormatting.BLUE).append("+39").append(EnumChatFormatting.RED).append(" Attack Power").toString());
				break;
			}
			case 1:
			{
				par3List.add((new StringBuilder()).append(EnumChatFormatting.YELLOW).append("Mode ").append(EnumChatFormatting.LIGHT_PURPLE).append("Long Sword").toString());
				par3List.add((new StringBuilder()).append(EnumChatFormatting.BLUE).append("+19").append(EnumChatFormatting.RED).append(" Attack Power").toString());
				break;
			}
			case 2:
			{
				par3List.add((new StringBuilder()).append(EnumChatFormatting.YELLOW).append("Mode ").append(EnumChatFormatting.LIGHT_PURPLE).append("Lapier").toString());
				par3List.add((new StringBuilder()).append(EnumChatFormatting.BLUE).append("+9").append(EnumChatFormatting.RED).append(" Attack Power").toString());
				break;
			}
			case 3:
			{
				par3List.add((new StringBuilder()).append(EnumChatFormatting.YELLOW).append("Mode ").append(EnumChatFormatting.LIGHT_PURPLE).append("Wand").toString());
				par3List.add((new StringBuilder()).append(EnumChatFormatting.BLUE).append("+4").append(EnumChatFormatting.RED).append(" Attack Power").toString());
				break;
			}
		}
	}
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean held)
	{
		if(world.isRemote)
		{
			if(entity instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)entity;
				if(player.inventory.hasItem(AdditionalRecipe.ultimateExchangeIgnitionItemID))
				{
					switch(mode)
					{
						case 0:
						{
							this.weaponDamage = 40.0f;
							setTextureName(AdditionalRecipe.MODID + ":K2GS");
							break;
						}
						case 1:
						{
							this.weaponDamage = 20.0f;
							setTextureName(AdditionalRecipe.MODID + ":K2LS");
							break;
						}
						case 2:
						{
							this.weaponDamage = 10.0f;
							setTextureName(AdditionalRecipe.MODID + ":K2LP");
							break;
						}
						case 3:
						{
							this.weaponDamage = 5.0f;
							setTextureName(AdditionalRecipe.MODID + ":K2WA");
							break;
						}
					}
				}
			}
		}
	}
	public Icon[] getIcons()
	{
		return icons;
	}
}