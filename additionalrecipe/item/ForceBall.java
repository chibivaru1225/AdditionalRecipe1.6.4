package chibivaru.additionalrecipe.item;
import static chibivaru.additionalrecipe.common.ARConfiguration.*;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ForceBall extends Item
{
	private boolean effect;
	public ForceBall(int par1)
	{
		super(par1);
		this.setMaxStackSize(16);
	}
    //既存のハサミと見分けるため、テクスチャを赤で乗算
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
        return 0xCCCCCC;
    }

    //1.5.2のテクスチャ指定
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = Item.enderPearl.getIconFromDamage(0);
    }
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return !this.effect;
    }
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(ARGetAnother("ForceBallSwingForExperience",true))
		{
			par3EntityPlayer.swingItem();
			par3EntityPlayer.addExperienceLevel(ARGetCfgOther("ForceBallExperience",25));
			par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "random.orb", 0.2F, 0.6F);
			par1ItemStack.stackSize--;
		}
		return par1ItemStack;
	}
}
