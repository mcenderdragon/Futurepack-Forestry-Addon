package futurepack.addons.items;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

public class ItemColorizer implements IItemColor
{

	@Override
	public int getColorFromItemstack(ItemStack stack, int tintIndex)
	{
		if(stack.getItem() instanceof ItemCombs)
		{
			CombTypes comb = ItemCombs.getType(stack);
			int color = comb.color;
			if(tintIndex==0)
			{
				color = color & (1<<23|1<<15|1<<7);
			}
			return color;
		}
		return 0;
	}

}
