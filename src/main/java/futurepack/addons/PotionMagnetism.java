package futurepack.addons;

import java.util.List;

import forestry.api.genetics.AlleleManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.potion.Potion;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

public class PotionMagnetism extends Potion
{
	
	public static EffectMagnetism effect  = new EffectMagnetism();
	
	protected PotionMagnetism()
	{
		super(false, 0x777777);
		AlleleManager.alleleRegistry.registerAllele(effect);
	}
	
	@Override
	public void performEffect(EntityLivingBase base, int lvl)
	{
		AxisAlignedBB bb = base.getEntityBoundingBox().expand(lvl*2D, lvl*2D, lvl*2D);
		List<EntityItem> list = base.worldObj.getEntitiesWithinAABB(EntityItem.class, bb);
		for(EntityItem entity : list)
		{
			Vec3d spieler = new Vec3d(base.posX, base.posY, base.posZ);
			Vec3d item = new Vec3d(entity.posX, entity.posY, entity.posZ);
			Vec3d motion = item.subtract(spieler);
			entity.moveEntity(motion.xCoord, motion.yCoord, motion.zCoord);
		}
	}
	

}
