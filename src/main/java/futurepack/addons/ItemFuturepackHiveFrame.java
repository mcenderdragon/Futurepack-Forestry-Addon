package futurepack.addons;

import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.apiculture.IHiveFrame;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


//@Optional.InterfaceList(
//{
//	@Optional.Interface(iface="forestry.api.apiculture.IHiveFrame", modid="Forestry")
//})
public class ItemFuturepackHiveFrame extends Item implements IHiveFrame, IBeeModifier
{
	private FrameType type;
	
	public ItemFuturepackHiveFrame(FrameType type)
	{
		this.type=type;
		this.setMaxStackSize(1);
		this.setMaxDamage(type.maxDamage);
		this.setCreativeTab(FPForestryAddon.instance.tab);
		this.setUnlocalizedName("frame."+type.name);
	}
	
//	@Override
//	public void registerIcons(IIconRegister r)
//	{
//		this.itemIcon = r.registerIcon(FPForestryAddon.ID + ":frame"+type.name);
//	}
	
//	@Optional.Method(modid="Forestry")
	@Override
	public float getTerritoryModifier(IBeeGenome genome, float currentModifier)
	{
		return type.territoryMod;
	}

//	@Optional.Method(modid="Forestry")
	@Override
	public float getMutationModifier(IBeeGenome genome, IBeeGenome mate, float currentModifier) 
	{
		return type.mutationMod;
	}

//	@Optional.Method(modid="Forestry")
	@Override
	public float getLifespanModifier(IBeeGenome genome, IBeeGenome mate, float currentModifier)
	{
		return type.lifespanMod;
	}

//	@Optional.Method(modid="Forestry")
	@Override
	public float getProductionModifier(IBeeGenome genome, float currentModifier)
	{
		return type.productionMod;
	}

//	@Optional.Method(modid="Forestry")
	@Override
	public float getFloweringModifier(IBeeGenome genome, float currentModifier)
	{
		return type.floweringMod;
	}

//	@Optional.Method(modid="Forestry")
	@Override
	public float getGeneticDecay(IBeeGenome genome, float currentModifier)
	{
		return type.geneticDecay;
	}

//	@Optional.Method(modid="Forestry")
	@Override
	public boolean isSealed()
	{
		return type.isSealed;
	}

//	@Optional.Method(modid="Forestry")
	@Override
	public boolean isSelfLighted()
	{
		return type.isSelfLighted;
	}

//	@Optional.Method(modid="Forestry")
	@Override
	public boolean isSunlightSimulated()
	{
		return type.isSunlightSimulated;
	}

//	@Optional.Method(modid="Forestry")
	@Override
	public boolean isHellish()
	{
		return type.isHellish;
	}

//	@Optional.Method(modid="Forestry")
	@Override
	public ItemStack frameUsed(IBeeHousing housing, ItemStack frame, IBee queen, int wear)
	{
		
		
		frame.setItemDamage(frame.getItemDamage() + wear);
		if(frame.getItemDamage() > frame.getMaxDamage())
		{
			frame = null;
		}
		return frame;
	}

	@Override
	public IBeeModifier getBeeModifier()
	{
		return this;
	}

}
