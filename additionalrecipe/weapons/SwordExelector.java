package chibivaru.additionalrecipe.weapons;

import java.util.List;

import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class SwordExelector extends ItemSword
{
    private boolean effect;
    private EnumToolMaterial toolMaterial;
    private Icon[] icons = new Icon[3];
    private float[] dmg = {1.0f,10.0f,20.0f};
    private final int[] exptbl = {5,10,15};
    //private final int[] exptbl = {AdditionalRecipe.exelectorFirstExp,AdditionalRecipe.exelectorSecondExp,AdditionalRecipe.exelectorLastExp};
    private String str = "Exp = ";
	public SwordExelector(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setMaxStackSize(1);
		this.setMaxDamage(3);
		this.setTextureName("additionalrecipe:exelectorFirst");
		//this.level = 0; 0 = Great Sword,1 = Long Sword,2 = Lapier,3 = Wand
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		super.registerIcons(register);
		//this.itemIcon = register.registerIcon(AdditionalRecipe.MODID + ":" + this.getUnlocalizedName());
		icons[0] = register.registerIcon(AdditionalRecipe.MODID + ":exelectorFirst");
		icons[1] = register.registerIcon(AdditionalRecipe.MODID + ":exelectorSecond");
		icons[2] = register.registerIcon(AdditionalRecipe.MODID + ":exelectorLast");
	}
	@Override
	public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer player, Entity entity)
	{
		NBTTagCompound nbttagcompound = itemStack.getTagCompound();
		int exp,lvl;
		if(nbttagcompound == null)
		{
			nbttagcompound = new NBTTagCompound();
			itemStack.setTagCompound(nbttagcompound);
			exp = 0;
			lvl = 0;
		}
		else
		{
			exp = nbttagcompound.getInteger("adr.exp");
			lvl = nbttagcompound.getInteger("adr.lvl");
		}
		exp++;
		if(exp >= exptbl[2])
		{
			lvl = 2;
			this.setDamage(itemStack,0);
		}
		else if(exp >= exptbl[1])
		{
			lvl = 2;
			this.setDamage(itemStack,1);
		}
		else if(exp >= exptbl[0])
		{
			lvl = 1;
			this.setDamage(itemStack,2);
		}
		else
		{
			lvl = 0;
			this.setDamage(itemStack,3);
		}
		nbttagcompound.setInteger("adr.exp",exp);
		nbttagcompound.setInteger("adr.lvl",lvl);
		return entity.attackEntityFrom(DamageSource.causePlayerDamage(player),dmg[lvl]);
	}
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();
		int lvl,exp;
		if(nbttagcompound == null)
		{
			nbttagcompound = new NBTTagCompound();
			par1ItemStack.setTagCompound(nbttagcompound);
			exp = 0;
			lvl = 0;
		}
		else
		{
			exp = nbttagcompound.getInteger("adr.exp");
			lvl = nbttagcompound.getInteger("adr.lvl");
		}
		par3List.add((new StringBuilder()).append(EnumChatFormatting.BLUE).append("Level : ").append(lvl + 1).toString());
		par3List.add((new StringBuilder()).append(EnumChatFormatting.BLUE).append(str).append(EnumChatFormatting.LIGHT_PURPLE).append(exp).append(" / ").append(exptbl[lvl]).toString());
	}
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean held)
	{
		NBTTagCompound nbttagcompound = stack.getTagCompound();
		int exp,lvl;
		if(nbttagcompound == null)
		{
			nbttagcompound = new NBTTagCompound();
			stack.setTagCompound(nbttagcompound);
			exp = 0;
			lvl = 0;
		}
		else
		{
			exp = nbttagcompound.getInteger("adr.exp");
			lvl = nbttagcompound.getInteger("adr.lvl");
		}
		if(exp >= exptbl[2])
		{
			lvl = 2;
			this.setDamage(stack,0);
		}
		else if(exp >= exptbl[1])
		{
			lvl = 2;
			this.setDamage(stack,1);
		}
		else if(exp >= exptbl[0])
		{
			lvl = 1;
			this.setDamage(stack,2);
		}
		else
		{
			lvl = 0;
			this.setDamage(stack,3);
		}
		nbttagcompound.setInteger("adr.exp",exp);
		nbttagcompound.setInteger("adr.lvl",lvl);
	}
	@Override
	public Icon getIconIndex(ItemStack itemStack)
	{
		if(itemStack.hasTagCompound())
		{
			NBTTagCompound nbttagcompound = itemStack.getTagCompound();
			int lvl = nbttagcompound.getInteger("adr.lvl");
			return this.icons[lvl];
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
			int lvl = nbttagcompound.getInteger("adr.lvl");
			return this.icons[lvl];
		}
		else
		{
			return this.icons[0];
		}
	}
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
		if(par1ItemStack.hasTagCompound())
		{
			NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();
			int exp = nbttagcompound.getInteger("adr.exp");
			if(exp >= exptbl[2])
			{
				return true;
			}
		}
		return false;
    }
	public Icon[] getIcons()
	{
		return icons;
	}
}
