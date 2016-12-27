package futurepack.addons.forestry.bees;

import java.util.Locale;

import forestry.Forestry;
import forestry.api.apiculture.EnumBeeType;
import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.api.apiculture.IBeeModelProvider;
import forestry.api.core.IModelManager;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;
import forestry.apiculture.genetics.DefaultBeeModelProvider;
import forestry.apiculture.items.ItemBeeGE;
import forestry.core.genetics.ItemGE;
import futurepack.addons.forestry.common.FPForestryAddon;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CyberBeeModelProvider implements IBeeModelProvider{

	public static final CyberBeeModelProvider instance = new CyberBeeModelProvider();

	private CyberBeeModelProvider() 
	{
	}

	@SideOnly(Side.CLIENT)
	private static ModelResourceLocation[] models;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels(Item item, IModelManager manager) 
	{
		String beeIconDir = "bees/cyber/";
		EnumBeeType beeType = ((ItemBeeGE) item).getType();
		String beeTypeNameBase = beeIconDir + beeType.toString().toLowerCase(Locale.ENGLISH);

		if (models == null) {
			models = new ModelResourceLocation[EnumBeeType.values().length];
		}

		models[beeType.ordinal()] = manager.getModelLocation(beeTypeNameBase);
		ModelBakery.registerItemVariants(item, new ResourceLocation("forestry:" + beeTypeNameBase));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelResourceLocation getModel(EnumBeeType type) {
		return models[type.ordinal()];
	}
}
