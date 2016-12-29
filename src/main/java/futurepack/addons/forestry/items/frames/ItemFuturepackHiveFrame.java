package futurepack.addons.forestry.items.frames;

import java.util.List;

import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.apiculture.IHiveFrame;
import forestry.core.utils.Translator;
import futurepack.addons.forestry.common.FPForestryAddon;
import net.minecraft.entity.player.EntityPlayer;
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
	
	@Override
	public float getTerritoryModifier(IBeeGenome genome, float currentModifier)
	{
		return type.territoryMod;
	}

	@Override
	public float getMutationModifier(IBeeGenome genome, IBeeGenome mate, float currentModifier) 
	{
		return type.mutationMod;
	}

	@Override
	public float getLifespanModifier(IBeeGenome genome, IBeeGenome mate, float currentModifier)
	{
		return type.lifespanMod;
	}

	@Override
	public float getProductionModifier(IBeeGenome genome, float currentModifier)
	{
		return type.productionMod;
	}

	@Override
	public float getFloweringModifier(IBeeGenome genome, float currentModifier)
	{
		return type.floweringMod;
	}

	@Override
	public float getGeneticDecay(IBeeGenome genome, float currentModifier)
	{
		return type.geneticDecay;
	}

	@Override
	public boolean isSealed()
	{
		return type.isSealed;
	}
	
	@Override
	public boolean isSelfLighted()
	{
		return type.isSelfLighted;
	}
	
	@Override
	public boolean isSunlightSimulated()
	{
		return type.isSunlightSimulated;
	}

	@Override
	public boolean isHellish()
	{
		return type.isHellish;
	}

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
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
	{
		addInformation(getBeeModifier(), tooltip);
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

	
	private static void addInformation(IBeeModifier mod, List<String> tooltip)
	{
		tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.production", mod.getProductionModifier(null, 1F)));
		tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.genetic.decay", mod.getGeneticDecay(null, 1F)));
		tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.flowering", mod.getFloweringModifier(null, 1F)));
		tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.lifepsan", mod.getLifespanModifier(null,null, 1F)));
		tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.mutation", mod.getMutationModifier(null,null, 1F)));
		tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.territory", mod.getTerritoryModifier(null, 1F)));
		
		tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.sealed", mod.isSealed()));
		tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.selflighted", mod.isSelfLighted()));
		tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.sunlight.simulated", mod.isSunlightSimulated()));
		tooltip.add(Translator.translateToLocalFormatted("item.for.bee.modifier.hellish", mod.isHellish()));
	}
}
