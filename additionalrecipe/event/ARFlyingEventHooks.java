package chibivaru.additionalrecipe.event;

import static chibivaru.additionalrecipe.AdditionalRecipe.*;
import static chibivaru.additionalrecipe.common.ARItemHandler.*;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class ARFlyingEventHooks
{
	private boolean allowLevitatiton = false;//飛べるかどうか
	private boolean isLevitation     = false;//飛んでいるかどうか
	private int flyToggleTimer       = 0;//Jumpキーの入力間隔
	private int sprintToggleTimer    = 0;//ダッシュの入力間隔（何故必要なのかは後述）
	public static boolean flyBoost;
	private int flySpeed             = 1;
	private int potionduration       = 4;
	private byte potionamplifier     = 4;
	private boolean exchange         = false;
	private boolean ultimate         = false;
	private boolean bedrock          = false;
	private boolean angelus          = false;
	private boolean angelus2         = false;
	private boolean k2               = false;
	private boolean k22              = false;
	private boolean gluttony         = false;

	@ForgeSubscribe//(1.6までは@ForgeSubscribe)
	public void LivingUpdate(LivingUpdateEvent event)
	{
		if(event.entityLiving != null && event.entityLiving instanceof EntityPlayer && event.entityLiving .worldObj.isRemote)
		{
			EntityPlayerSP player = (EntityPlayerSP) event.entityLiving;
			Flight(player);
		}
	}
	//落下時ダメージ無効化処理。LivingFallEventが実装されたバージョンのみ
	public void Flight(EntityPlayerSP player)
	{
		exchange = player.inventory.hasItem(ARGetItemIDRegister("exchangeiginiton"));
		ultimate = player.inventory.hasItem(ARGetItemIDRegister("ultimateexchangeiginiton"));
		bedrock  = equipArmor(ARGetItemIDRegister("bedrockhelmet"),ARGetItemIDRegister("bedrockplate"),ARGetItemIDRegister("bedrocklegs"),ARGetItemIDRegister("bedrockboots"), player);
		gluttony = equipArmor(ARGetItemIDRegister("gluttonyhood"),ARGetItemIDRegister("gluttonyvestment"),ARGetItemIDRegister("gluttonyskirt"),ARGetItemIDRegister("gluttonyboots"), player);
		angelus  = equipArmor(ARGetItemIDRegister("angelushood"),ARGetItemIDRegister("angelusvestment"),ARGetItemIDRegister("angelusskirt"),ARGetItemIDRegister("angelusboots"), player,true);
		angelus2 = equipArmor(ARGetItemIDRegister("angelushood"),ARGetItemIDRegister("angelusvestment"),ARGetItemIDRegister("angelusskirt"),ARGetItemIDRegister("angelusboots"), player);
		k2       = equipArmor(ARGetItemIDRegister("k2helmet"),ARGetItemIDRegister("k2plate"),ARGetItemIDRegister("k2legs"),ARGetItemIDRegister("k2boots"), player,true);
		k22      = equipArmor(ARGetItemIDRegister("k2helmet"),ARGetItemIDRegister("k2plate"),ARGetItemIDRegister("k2legs"),ARGetItemIDRegister("k2boots"), player);
		//クリエイティブでないなら
		if(!player.capabilities.isCreativeMode)
		{
			//飛行が許可されていないなら
			if(!player.capabilities.allowFlying)
			{
				if(exchange||ultimate||bedrock||angelus||angelus2||gluttony||k2||k22)
				{
					this.allowLevitatiton = true;
				}
				else
				{
					this.allowLevitatiton = false;
				}
			}
			else
			{
				this.allowLevitatiton = false;
			}
		}
		else
		{
			this.allowLevitatiton = false;
		}
		//this.allowLevitatiton = !(player.capabilities.isCreativeMode || player.capabilities.allowFlying || !player.inventory.hasItem(AdditionalRecipe.exchangeIgnitionItemID));
		//クリエイティブ時と他MODでクリエイティブの飛行モードが許可されている場合は実行しないように
		if(!this.allowLevitatiton)
		{
			//飛行が許可されていない状況では落ちるように
			this.isLevitation = false;
			return;
		}/*
		if(this.flyBoost)
		{
			this.flySpeed = 2;
		}
		else
		{
			this.flySpeed = 1;
		}*/
		//後述するLivingFallEventが未実装のバージョンの場合。
		//player.fallDistance = 0.0f;//これを挟まないと飛びつつ足首を挫ける．
		boolean jump = ((EntityPlayerSP)player).movementInput.jump;//ジャンプ入力があるか
		float var2 = 0.8F;//ダッシュのための変数
		boolean var3 = ((EntityPlayerSP)player).movementInput.moveForward >= var2;//一定距離以上前に進んだか．ダッシュ用
		((EntityPlayerSP)player).movementInput.updatePlayerMoveState();//入力ステートを更新
		if (this.allowLevitatiton && !jump && ((EntityPlayerSP)player).movementInput.jump)//Jumpキーを押して離したかどうか
		{
			if (this.flyToggleTimer == 0)//Jumpキー入力1回目
			{
				this.flyToggleTimer = 7;//入力間隔のタイマー：7tick
			}
			else//2回目
			{
				this.isLevitation = !this.isLevitation;//飛行モードのトグル
				this.flyToggleTimer = 0;
			}
		}
		//ここからダッシュ関係
		boolean var4 = (float)((EntityPlayerSP)player).getFoodStats().getFoodLevel() > 6.0F;
		if (((EntityPlayerSP)player).onGround && !var3 && ((EntityPlayerSP)player).movementInput.moveForward >= var2 && !((EntityPlayerSP)player).isSprinting() && var4 && !((EntityPlayerSP)player).isUsingItem() && !((EntityPlayerSP)player).isPotionActive(Potion.blindness))
		{
			if (this.sprintToggleTimer == 0)
			{
				this.sprintToggleTimer = 7;
			}
			else
			{
				((EntityPlayerSP)player).setSprinting(true);
				this.sprintToggleTimer = 0;
			}
		}
		if (this.sprintToggleTimer > 0)
		{
			--this.sprintToggleTimer;
		}
		//ここまでダッシュ関係
		if (this.flyToggleTimer > 0)
		{
			--this.flyToggleTimer;//入力間隔の判定タイマーのカウントを減らす．
		}
		if (player.onGround && this.isLevitation)
		{
			this.isLevitation = false;//地面についたら飛行から歩行へ
		}
		if (this.isLevitation)//飛行中の処理
		{
			if(exchange||bedrock||angelus||gluttony||k2)
			{
				player.motionY = 0D;//Y軸方向への移動量は入力なしでは滞空
				player.jumpMovementFactor = 0.1f;//滞空時の滞空移動速度．クリエイティブより少し早い
				if (((EntityPlayerSP)player).movementInput.sneak)
				{
					//player.motionY -= 0.4D;//スニークで下降．クリエイティブより少し早い
					player.motionY -= 0.4D;
				}
				if (((EntityPlayerSP)player).movementInput.jump)
				{
					//player.motionY += 0.4D;//Jumpキーで上昇．クリエ〈略〉
					player.motionY += 0.4D;
				}
			}
			if(ultimate||angelus2||k22)
			{
				player.motionY = 0D;//Y軸方向への移動量は入力なしでは滞空
				player.jumpMovementFactor = 0.15f;//滞空時の滞空移動速度．クリエイティブより少し早い
				if (((EntityPlayerSP)player).movementInput.sneak)
				{
					player.motionY -= 0.6D;//スニークで下降．クリエイティブより少し早い
				}
				if (((EntityPlayerSP)player).movementInput.jump)
				{
					player.motionY += 0.6D;//Jumpキーで上昇．クリエ〈略〉
				}
			}
		}
		else
		{
			player.jumpMovementFactor = 0.02f;//歩行時の滞空移動速度は通常と同じに
		}
	}
}