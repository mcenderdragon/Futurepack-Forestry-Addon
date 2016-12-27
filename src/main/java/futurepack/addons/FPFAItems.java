package futurepack.addons;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FPFAItems
{
	public static final Item ironFrame = new ItemFuturepackHiveFrame(FrameType.ironFrame);
	public static final Item neonFrame = new ItemFuturepackHiveFrame(FrameType.neonFrame);
	public static final Item retiumFrame = new ItemRetiumFrame(FrameType.retiumFrame);
	public static final Item glowtitFrame = new ItemFuturepackHiveFrame(FrameType.glowtitFrame);
	public static final Item bioteriumFrame = new ItemFuturepackHiveFrame(FrameType.bioteriumFrame);
	public static final Item impirialFrame = new ItemFuturepackHiveFrame(FrameType.impirialFrame);
	
	public static final Item princessFrame = new ItemPrincessFrame(FrameType.princessFrame);
	
	public static final Item specialCombs = new ItemCombs().setUnlocalizedName("comb");
	
	public static void register()
	{
		register(ironFrame);
		register(neonFrame);
		register(retiumFrame);
		register(glowtitFrame);
		register(bioteriumFrame);
		register(princessFrame);
		register(impirialFrame);
		register(specialCombs);
	}
	
	private static void register(Item item)
	{
		GameRegistry.register(item, new ResourceLocation(FPForestryAddon.ID, item.getUnlocalizedName()));
	}
	
	@SideOnly(Side.CLIENT)
	public static void setupRendering()
	{
		try
		{
			Field[] fields = FPFAItems.class.getFields();
			for(Field f : fields)
			{
				if(Modifier.isStatic(f.getModifiers()))
				{
					if(Item.class.isAssignableFrom(f.getType()))
					{	
						Item item = (Item) f.get(null);
						
						if(item==null)
							continue;
						
//						if(item instanceof IItemMetaSubtypes)
//						{
//							IItemMetaSubtypes meta = (IItemMetaSubtypes) item;
//							for(int i=0;i<meta.getMaxMetas();i++)
//							{
//								registerItem(meta.getMetaName(i), item, i);
//							}
//						}
//						else
						{
							registerItem(item.getUnlocalizedName().substring(5), item, 0);
						}
					}
 				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
//		ItemMeshDefinition def = new ItemMeshDefinition()
//		{		
//			@Override
//			public ModelResourceLocation getModelLocation(ItemStack stack)
//			{
//				return new ModelResourceLocation(FPMain.modID +":items/dust", "inventory");
//			}
//		};
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(dust, def);
//		ModelLoader.setCustomMeshDefinition(dust, def);
	}
	
	@SideOnly(Side.CLIENT)
	private static void registerItem(String s, Item i, int meta)
	{
		RenderItem render = Minecraft.getMinecraft().getRenderItem();
		s = FPForestryAddon.ID +":items/" + s.toLowerCase();
		ModelLoader.setCustomModelResourceLocation(i, meta, new ModelResourceLocation(s, "inventory"));
		//ModelBakery.registerItemVariants(i, new ResourceLocation(s));
		//FPLog.logger.debug(String.format("Add Item %s(%s) with %s",i,meta,s));
		//render.getItemModelMesher().register(i, meta, new ModelResourceLocation(s, "inventory"));
	}
}
