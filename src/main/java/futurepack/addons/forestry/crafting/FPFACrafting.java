package futurepack.addons.forestry.crafting;

import futurepack.addons.forestry.items.FPFAItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class FPFACrafting 
{
	public static void setup()
	{
		Item tools = (Item) Item.REGISTRY.getObject(new ResourceLocation("fp:spaceship"));
		
		if(tools==null)
		{
			System.err.println("tools is null");
		}
		
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(FPFAItems.ironFrame, "SSS","SFS","SSS",
				'S',new ItemStack(tools,1,12),
				'F', Items.STRING));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(FPFAItems.neonFrame, "SSS","SFS","SSS",
				'S',new ItemStack(tools,1,12),
				'F', "ingotNeon"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(FPFAItems.retiumFrame, "SSS","SFS","SSS",
				'S',new ItemStack(tools,1,12),
				'F', "ingotRetium"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(FPFAItems.glowtitFrame, "SSS","SFS","SSS",
				'S',new ItemStack(tools,1,12),
				'F', "ingotGlowtit"));
		
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(FPFAItems.bioteriumFrame, "SSS","SFS","SSS",
				'S',new ItemStack(tools,1,12),
				'F', "ingotBioterium"));
		
		CraftingManager.getInstance().addRecipe(new ItemStack(FPFAItems.princessFrame), "DLD", "PPP","DFD",
				'D', Item.REGISTRY.getObject(new ResourceLocation("Forestry:honeydew")),
				'L', Item.REGISTRY.getObject(new ResourceLocation("Forestry:beeLarvaeGE")),
				'P', Item.REGISTRY.getObject(new ResourceLocation("Forestry:propolis")),
				'F', FPFAItems.princessFrame);	
	}
	
	
}
