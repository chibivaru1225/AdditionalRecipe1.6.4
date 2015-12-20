package chibivaru.additionalrecipe.weapons;

import static chibivaru.additionalrecipe.common.ARConfiguration.*;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SwordExelector extends ItemSword
{
    private boolean effect;
    private EnumToolMaterial toolMaterial;
    private Icon[] icons = new Icon[3];
    private float[] dmgtbl  = {toolMaterial.STONE.getDamageVsEntity(),toolMaterial.IRON.getDamageVsEntity() * 1.5f,toolMaterial.EMERALD.getDamageVsEntity() * 2.0f};
    //private float[] dmgtbl2 = {5.0f,10.0f,20.0f};
    //private final int[] exptbl = {5,10,15};
    private final int[] exptbl = {ARGetCfgOther("ExelectorFirstExp",4),ARGetCfgOther("ExelectorSecondExp",4),ARGetCfgOther("ExelectorLastExp",4)};
    private String str = "Exp = ";
	public SwordExelector(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setMaxStackSize(1);
		this.setMaxDamage(4);
		this.setContainerItem(this);
		this.setTextureName("additionalrecipe:exelectorFirst");
		//this.level = 0; 0 = Great Sword,1 = Long Sword,2 = Lapier,3 = Wand
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		super.registerIcons(register);
		//this.itemIcon = register.registerIcon(AdditionalRecipe.MODID + ":" + this.getUnlocalizedName());
		this.icons[0] = register.registerIcon(AdditionalRecipe.MODID + ":ExelectorFirst");
		this.icons[1] = register.registerIcon(AdditionalRecipe.MODID + ":ExelectorSecond");
		this.icons[2] = register.registerIcon(AdditionalRecipe.MODID + ":ExelectorLast");
	}
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack)
	{
		return true;
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
		boolean bool = entity.attackEntityFrom(DamageSource.causePlayerDamage(player),4.0F + dmgtbl[lvl]);
		if(bool)
		{
			exp++;
			if(exp == exptbl[2])
			{
				player.addChatMessage("Exelector can extract ForceBall!");
				player.swingItem();
				player.worldObj.playSoundAtEntity(player, "ambient.weather.thunder", 0.4F, 1.0F);
				lvl = 2;
				this.setDamage(itemStack,0);
			}
			else if(exp == exptbl[1])
			{
				player.addChatMessage("Exelector increase Level 3!");
				player.swingItem();
				player.worldObj.playSoundAtEntity(player, "ambient.weather.thunder", 0.4F, 1.0F);
				lvl = 2;
				this.setDamage(itemStack,1);
			}
			else if(exp == exptbl[0])
			{
				player.addChatMessage("Exelector increase Level 2!");
				player.swingItem();
				player.worldObj.playSoundAtEntity(player, "ambient.weather.thunder", 0.4F, 1.0F);
				lvl = 1;
				this.setDamage(itemStack,2);
			}
			nbttagcompound.setInteger("adr.exp",exp);
			nbttagcompound.setInteger("adr.lvl",lvl);
		}
		return bool;
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
		par3List.add((new StringBuilder()).append(EnumChatFormatting.BLUE).append((int)dmgtbl[lvl] + 4).append(EnumChatFormatting.RED).append(" Attack Power").toString());
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
    @Override
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
    	return true;
    }
	public Icon[] getIcons()
	{
		return icons;
	}
}
