package forestryextras.items.bees.effects;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;
import forestryextras.helpers.EffectHelper;

public class EffectBloody extends BeeEffect{
	public EffectBloody(String name) {
		super(name);
		this.name = name;
	}
	
	@Override
	public IEffectData doEffect(IBeeGenome genome, IEffectData storedData,
			IBeeHousing housing, World world, int x, int y, int z){
		ArrayList<EntityPlayer> players = EffectHelper.getClosePlayers(world, x, y, z, 2D);

		for(EntityPlayer player : players){
			if(!player.capabilities.isCreativeMode){
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20));
//				player.setHealth(player.getHealth() - 0.5F);
//				
//				if(player.getHealth() < 0)
//		            player.onDeath(DamageSource.generic);
			}
		}
		
		return null;
	}
}