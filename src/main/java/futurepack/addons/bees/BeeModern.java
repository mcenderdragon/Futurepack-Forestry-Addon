package futurepack.addons.bees;

import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.genetics.IAllele;

public class BeeModern extends BeeTypes
{

	public BeeModern(String name, int firstCol, int secondCol)
	{
		super(name, firstCol, secondCol);
	}
	
	@Override
	public IAllele[] getChromosomes()
	{
		IAllele[] array = super.getChromosomes();
		BreedingManager.set(array, EnumBeeChromosome.SPEED, BreedingManager.getEnumAllele("Speed", "SLOW"));
		BreedingManager.set(array, EnumBeeChromosome.LIFESPAN, BreedingManager.getEnumAllele("Lifespan", "SHORTENED"));
		BreedingManager.set(array, EnumBeeChromosome.FERTILITY, BreedingManager.getEnumAllele("Fertility", "NORMAL"));
		BreedingManager.set(array, EnumBeeChromosome.TEMPERATURE_TOLERANCE, BreedingManager.getEnumAllele("Tolerance", "DOWN_2"));
		BreedingManager.set(array, EnumBeeChromosome.NEVER_SLEEPS, true);
//		BreedingManager.set(array, EnumBeeChromosome.HUMIDITY, null);
		BreedingManager.set(array, EnumBeeChromosome.HUMIDITY_TOLERANCE, BreedingManager.getEnumAllele("Tolerance" ,"NONE"));
		BreedingManager.set(array, EnumBeeChromosome.TOLERATES_RAIN, false);
		BreedingManager.set(array, EnumBeeChromosome.CAVE_DWELLING, false);
		BreedingManager.set(array, EnumBeeChromosome.FLOWER_PROVIDER, BreedingManager.getEnumAllele("Flowers", "VANILLA"));
		BreedingManager.set(array, EnumBeeChromosome.FLOWERING, BreedingManager.getEnumAllele("Flowering", "SLOW"));
		BreedingManager.set(array, EnumBeeChromosome.TERRITORY, BreedingManager.getEnumAllele("Territory", "LARGER"));
		BreedingManager.set(array, EnumBeeChromosome.EFFECT, BreedingManager.getEffect("None"));
		
		return array;
	}
	
	@Override
	protected void postRegister()
	{
		super.postRegister();
		allele.setNocturnal();
	}
}
