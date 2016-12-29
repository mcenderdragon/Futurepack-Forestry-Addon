package futurepack.addons.forestry.crafting;

import forestry.api.recipes.ISqueezerManager;
import forestry.api.recipes.RecipeManagers;
import futurepack.addons.forestry.items.FPFAItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class FPFAForestryCrafting {

	public static void setup() 
	{
		ISqueezerManager sqee = RecipeManagers.squeezerManager;
		
		Item erse = (Item) Item.REGISTRY.getObject(new ResourceLocation("fp:erse"));
		if(erse==null)
		{
			System.err.println("Erse is Null!!!");
			return;
		}
		Item mulch = (Item) Item.REGISTRY.getObject(new ResourceLocation("Forestry:mulch"));
		if(mulch==null)
		{
			System.err.println("Mulch is Null!!!");
			return;
		}
		
		Fluid fluid = FluidRegistry.getFluid("juice");
		if(fluid==null)
		{
			System.err.println("Juice was not found");
			return;
		}
		FluidStack juice = new FluidStack(fluid, 300);
		
		sqee.addRecipe(5*20, new ItemStack[]{new ItemStack(erse)}, juice, new ItemStack(mulch), 10);
		
		fluid = FluidRegistry.getFluid("for.honey");
		if(fluid==null)
		{
			System.err.println("Honey was not found");
			return;
		}
		FluidStack honey = new FluidStack(fluid, 10000);
		ItemStack royal = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("Forestry:cratedRoyalJelly")));
		ItemStack pollen = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("Forestry:cratedPollen")));
		ItemStack frame = new ItemStack(FPFAItems.ironFrame);
		
		RecipeManagers.carpenterManager.addRecipe(600, honey, null, new ItemStack(FPFAItems.princessFrame), "RPR","PFP","RPR",
				'R', royal,
				'P', pollen,
				'F', frame);	
	}

}
