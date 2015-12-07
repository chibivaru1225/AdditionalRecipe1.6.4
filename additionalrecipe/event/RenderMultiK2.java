package chibivaru.additionalrecipe.event;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import chibivaru.additionalrecipe.weapons.MultiK2;

public class RenderMultiK2 implements IItemRenderer
{
	private RenderItem renderItem = new RenderItem();
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		// TODO 自動生成されたメソッド・スタブ
		return !(type == ItemRenderType.FIRST_PERSON_MAP);
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,ItemRendererHelper helper)
	{
		switch (type)
		{
			case ENTITY:
			{
				return (helper == ItemRendererHelper.ENTITY_BOBBING ||helper == ItemRendererHelper.ENTITY_ROTATION );
			}
			case EQUIPPED:
			{
				return (helper == ItemRendererHelper.BLOCK_3D);
			}
			case EQUIPPED_FIRST_PERSON:
			{
				return (helper == ItemRendererHelper.EQUIPPED_BLOCK);
			}
			default:
			{
				return false;
			}
		}
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		// TODO 自動生成されたメソッド・スタブ
		if(item.getItem() instanceof MultiK2 && !(type == ItemRenderType.FIRST_PERSON_MAP))
		{
			MultiK2 k2 = (MultiK2)item.getItem();
			this.renderItem.renderIcon(0, 0, k2.getIcons()[k2.mode], 16, 16);
		}
	}

}
