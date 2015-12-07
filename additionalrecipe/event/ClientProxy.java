package chibivaru.additionalrecipe.event;

import net.minecraftforge.client.MinecraftForgeClient;
import chibivaru.additionalrecipe.AdditionalRecipe;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registers()
	{
		//描画の登録
		MinecraftForgeClient.registerItemRenderer(AdditionalRecipe.multiK2ItemID, new RenderMultiK2());
	}
}
