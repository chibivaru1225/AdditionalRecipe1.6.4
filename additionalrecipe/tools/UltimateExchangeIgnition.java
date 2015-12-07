package chibivaru.additionalrecipe.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import chibivaru.additionalrecipe.AdditionalRecipe;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UltimateExchangeIgnition extends Item implements ICraftingHandler
{
    private boolean repair;
    private boolean effect;

    public UltimateExchangeIgnition(int par1)
    {
        super(par1);
        this.setMaxStackSize(1);
    }

    //アイテムがクラフト後に戻らないようにする
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
    {
        return false;
    }

    //クラフト後にgetContainerItemStackを呼び出す
    public boolean hasContainerItem()
    {
        return !repair;
    }

    //クラフト後のアイテムを、ダメージを与えて返す
    public ItemStack getContainerItemStack(ItemStack itemStack)
    {
        return itemStack;
    }

    @Override
    public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
    {
        this.repair = this.itemID == item.itemID;
    }

    @Override
    public void onSmelting(EntityPlayer player, ItemStack item){};

    //既存のハサミと見分けるため、テクスチャを赤で乗算
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
        return 0x666666;
    }

    //1.5.2のテクスチャ指定
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = Item.eyeOfEnder.getIconFromDamage(0);
    }
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return !this.effect;
    }
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par3EntityPlayer.swingItem();
		par3EntityPlayer.addExperienceLevel(1);
		return par1ItemStack;
	}
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean held)
	{
		if(entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)entity;
			if(player.inventory.hasItem(AdditionalRecipe.ultimateExchangeIgnitionItemID))
			{
				if(AdditionalRecipe.ultimateExchangeIgnitionEffect)
				{
					player.addPotionEffect(new PotionEffect(Potion.damageBoost.id,20*30,75));
					player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id,20*30,75));
					player.addPotionEffect(new PotionEffect(Potion.regeneration.id,20*30,75));
					player.addPotionEffect(new PotionEffect(Potion.digSpeed.id,20*30,75));
					player.addPotionEffect(new PotionEffect(Potion.nightVision.id,20*30));
				}
			}
		}
	}
}
