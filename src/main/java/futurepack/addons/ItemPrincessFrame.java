package futurepack.addons;

import java.util.List;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.apiculture.IBeeHousingInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemPrincessFrame extends ItemFuturepackHiveFrame 
{
//	IIcon empty;

	public ItemPrincessFrame(FrameType type)
	{	
		super(type);
	}
	
//	@Override
//	public void registerIcons(IIconRegister r)
//	{
//		super.registerIcons(r);
//		empty=r.registerIcon(FPForestryAddon.ID + ":framenoprinzess");
//	}
//	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		String er = stack.hasTagCompound() && stack.getTagCompound().hasKey("Genome") ?"":".empty";	
		return super.getUnlocalizedName()+er;
	}
	
	@Override
	public void addInformation(ItemStack it, EntityPlayer pl, List l, boolean p_77624_4_) 
	{
		
		
		if(it.hasTagCompound() && it.getTagCompound().hasKey("Genome"))
		{
			IBee bee = BeeManager.beeRoot.getMember(it.getTagCompound());
			l.add(bee.getDisplayName());
			bee.addTooltip(l);
//			NBTTagCompound tag =it.getTagCompound().getCompoundTag("Genome");
//			NBTTagList list = tag.getTagList("Chromosomes", NBT.TAG_COMPOUND);
//			for(int i=0;i<list.tagCount();i++)
//			{
//				NBTTagCompound nbt = list.getCompoundTagAt(i);
//				if(nbt.getByte("Slot")==0)
//				{
//					String a = nbt.getString("UID0");
//					String b = nbt.getString("UID1");
//					a = a.substring("forestry.species".length()).toLowerCase();
//					b = b.substring("forestry.species".length()).toLowerCase();
//					a = I18n.format("for.bees.species."+a);
//					b = I18n.format("for.bees.species."+b);
//					l.add(a + "-" + b);
//				}
//			}
			
		}	
		super.addInformation(it, pl, l, p_77624_4_);
	}
	
	@Override
	public ItemStack frameUsed(IBeeHousing housing, ItemStack frame, IBee queen, int wear)
	{
		ItemStack it = super.frameUsed(housing, frame, queen, wear);
		if(it==null)
		{
			if(frame.hasTagCompound() && frame.getTagCompound().hasKey("Genome"))
			{
				ItemStack princess = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("Forestry:beePrincessGE")));
				princess.setTagCompound(frame.getTagCompound());
				IBeeHousingInventory inv = housing.getBeeInventory();
				inv.addProduct(princess, false);
			}
			
		}
		return it;
	}
	
//	@Override
//	public IIcon getIconIndex(ItemStack stack)
//	{
//		return (stack.hasTagCompound() && stack.getTagCompound().hasKey("Genome"))? itemIcon : empty;
//	}
}
