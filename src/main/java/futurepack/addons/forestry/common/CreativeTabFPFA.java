package futurepack.addons.forestry.common;

import futurepack.addons.forestry.items.FPFAItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabFPFA extends CreativeTabs 
{
	public CreativeTabFPFA() 
	{
		super(CreativeTabs.getNextID(), "tab.fpfa");	
	}

	@Override
	public Item getTabIconItem()
	{
		return FPFAItems.ironFrame;
	}
}
