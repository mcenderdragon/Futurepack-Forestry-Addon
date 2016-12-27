/*package futurepack.addons.bees;

import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.genetics.IAllele;

public class BeeKonstruction extends BeeRobotic
{

	public BeeKonstruction(String name, int firstCol, int secondCol)
	{
		super(name, firstCol, secondCol);
		
	}

	@Override
	public IAllele[] getChromosomes()
	{
		IAllele[] array = super.getChromosomes();
//		BreedingManager.set(array, EnumBeeChromosome.SPEED, BreedingManager.getEnumAllele("Speed", "FASTEST"));
//		BreedingManager.set(array, EnumBeeChromosome.LIFESPAN, BreedingManager.getEnumAllele("Lifespan", "SHORT"));
		BreedingManager.set(array, EnumBeeChromosome.FERTILITY, BreedingManager.getEnumAllele("Fertility", "MAXIMUM"));
//		BreedingManager.set(array, EnumBeeChromosome.TEMPERATURE_TOLERANCE, BreedingManager.getEnumAllele("Tolerance", "BOTH_5"));
//		BreedingManager.set(array, EnumBeeChromosome.NOCTURNAL, true);
//		BreedingManager.set(array, EnumBeeChromosome.HUMIDITY, null);
//		BreedingManager.set(array, EnumBeeChromosome.HUMIDITY_TOLERANCE, BreedingManager.getEnumAllele("Tolerance" ,"BOTH_5"));
//		BreedingManager.set(array, EnumBeeChromosome.TOLERANT_FLYER, false);
//		BreedingManager.set(array, EnumBeeChromosome.CAVE_DWELLING, true);
//		array[EnumBeeChromosome.FLOWER_PROVIDER.ordinal()] = FlowerTypes.Erze;
//		BreedingManager.set(array, EnumBeeChromosome.FLOWERING, BreedingManager.getEnumAllele("Flowering", "SLOWEST"));
//		BreedingManager.set(array, EnumBeeChromosome.TERRITORY, BreedingManager.getEnumAllele("Territory", "AVERAGE"));
		BreedingManager.set(array, EnumBeeChromosome.EFFECT, BreedingManager.getEffect("Exploration"));
		
		return array;
	}
}
*/