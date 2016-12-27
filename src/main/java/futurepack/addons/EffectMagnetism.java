package futurepack.addons;

import java.util.List;

import forestry.api.apiculture.IAlleleBeeEffect;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public class EffectMagnetism implements IAlleleBeeEffect
{

	@Override
	public boolean isCombinable()
	{
		return false;
	}

	@Override
	public IEffectData validateStorage(IEffectData storedData)
	{
		return storedData;
	}

	@Override
	public String getUID()
	{
		return "magnetic";
	}

	@Override
	public boolean isDominant()
	{
		return true;
	}

	@Override
	public String getUnlocalizedName()
	{
		return "fpf.bee.effect." + getUID();
	}

	@Override
	public IEffectData doEffect(IBeeGenome genome, IEffectData storedData, IBeeHousing housing)
	{
		Vec3i ter = genome.getTerritory();
		AxisAlignedBB bb = new AxisAlignedBB(-ter.getX()/2D, -ter.getY()/2D, -ter.getZ()/2D, ter.getX()/2D, ter.getY()/2D, ter.getZ()/2D);
		BlockPos c = housing.getCoordinates();
		bb.addCoord((double)c.getX(), (double)c.getY(), (double)c.getZ());
		List<EntityLivingBase> list = housing.getWorldObj().getEntitiesWithinAABB(EntityLivingBase.class, bb);
		for(EntityLivingBase base : list)
		{
			base.addPotionEffect(new PotionEffect(PotionManager.magnetism, 40));
		}
		return storedData;
	}

	@Override
	public IEffectData doFX(IBeeGenome genome, IEffectData storedData, IBeeHousing housing)
	{
		
		return storedData;
	}

	@Override
	public String getName()
	{
		return "magnetism";
	}

}
