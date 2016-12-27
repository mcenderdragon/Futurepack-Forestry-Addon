package futurepack.addons;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCombs extends Item
{
//	IIcon base, overlay;
	
	
	public ItemCombs()
	{
		setHasSubtypes(true);
		this.setCreativeTab(FPForestryAddon.instance.tab);
	}
	
//	@Override
//	public void registerIcons(IIconRegister r)
//	{
//		base = r.registerIcon("Forestry:beeCombs.0");
//		overlay = r.registerIcon("Forestry:beeCombs.1");
//	}
//	
//	@Override
//	public IIcon getIcon(ItemStack stack, int pass)
//	{
//		return pass==0?base : overlay;
//	}
	
	@Override
	public String getUnlocalizedName(ItemStack it)
	{
		CombTypes comb = getType(it);
		return super.getUnlocalizedName(it) + "." + comb.name;
	}
	
	public static CombTypes getType(ItemStack it)
	{
		int id = it.getItemDamage() % CombTypes.globalID;
		return CombTypes.idMap[id];
	}
	
//	@Override
//	public boolean requiresMultipleRenderPasses() 
//	{
//		return true;
//	}
	
	@Override
	public void getSubItems(Item p_150895_1_, CreativeTabs p_150895_2_, List l)
	{
		for(int i=0;i<CombTypes.globalID;i++)
		{
			l.add(new ItemStack(this,1,i));
		}
	}
}
