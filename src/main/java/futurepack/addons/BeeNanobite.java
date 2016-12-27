package futurepack.addons;

import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.genetics.IAllele;

public class BeeNanobite extends BeeMetalic
{

	public BeeNanobite(String name, int firstCol, int secondCol)
	{
		super(name, firstCol, secondCol);
	}
	
	@Override
	public IAllele[] getChromosomes()
	{
		IAllele[] array = super.getChromosomes();
		BreedingManager.set(array, EnumBeeChromosome.SPEED, BreedingManager.getEnumAllele("Speed", "SLOWER"));
		BreedingManager.set(array, EnumBeeChromosome.LIFESPAN, BreedingManager.getEnumAllele("Lifespan", "LONGEST"));
//		BreedingManager.set(array, EnumBeeChromosome.FERTILITY, BreedingManager.getEnumAllele("Fertility", "LOW"));
		BreedingManager.set(array, EnumBeeChromosome.TEMPERATURE_TOLERANCE, BreedingManager.getEnumAllele("Tolerance", "NONE"));
//		BreedingManager.set(array, EnumBeeChromosome.NOCTURNAL, true);
//		BreedingManager.set(array, EnumBeeChromosome.HUMIDITY, null);
		BreedingManager.set(array, EnumBeeChromosome.HUMIDITY_TOLERANCE, BreedingManager.getEnumAllele("Tolerance" ,"NONE"));
		BreedingManager.set(array, EnumBeeChromosome.TOLERATES_RAIN, true);
//		BreedingManager.set(array, EnumBeeChromosome.CAVE_DWELLING, true);
//		array[EnumBeeChromosome.FLOWER_PROVIDER.ordinal()] = FlowerTypes.Erze;
		BreedingManager.set(array, EnumBeeChromosome.FLOWERING, BreedingManager.getEnumAllele("Flowering", "MAXIMUM"));
//		BreedingManager.set(array, EnumBeeChromosome.TERRITORY, BreedingManager.getEnumAllele("Territory", "AVERAGE"));
		BreedingManager.set(array, EnumBeeChromosome.EFFECT, BreedingManager.getEffect("Heroic"));
		
		return array;
	}

}
