package futurepack.addons;

import java.util.Iterator;
import java.util.Random;
import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.EnumBeeType;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.apiculture.IBeeModifier;
import net.minecraft.item.ItemStack;

public class ItemRetiumFrame extends ItemFuturepackHiveFrame
{

	public ItemRetiumFrame(FrameType type)
	{
		super(type);
	}
	
	
	@Override
	public ItemStack frameUsed(IBeeHousing housing, ItemStack frame, IBee queen, int wear)
	{
		if(queen!=null)
		{
			IBee copy = (IBee) queen.copy();
			float life = 1f;
			Iterator<IBeeModifier> iter = housing.getBeeModifiers().iterator();
			while(iter.hasNext())
			{
				life = iter.next().getLifespanModifier(queen.getGenome(), queen.getMate(), life);
			}
			copy.age(housing.getWorldObj(),life);
			if(!copy.isAlive())
			{
				System.out.println("Spawn Drones");
				IBee[] drones = queen.spawnDrones(housing);
				int r = new Random().nextInt(drones.length);
				
				ItemStack bee = BeeManager.beeRoot.getMemberStack(drones[r], EnumBeeType.DRONE);
			}
			
		}
	
		return super.frameUsed(housing, frame, queen, wear);
	}
}
