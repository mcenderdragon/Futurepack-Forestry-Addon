package futurepack.addons;

import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.genetics.IAllele;

public class BeeGlowtit extends BeeNeon
{

	public BeeGlowtit(String name, int firstCol, int secondCol)
	{
		super(name, firstCol, secondCol);
		
	}
	
	@Override
	public IAllele[] getChromosomes()
	{
		IAllele[] array = super.getChromosomes();
		
		BreedingManager.set(array, EnumBeeChromosome.LIFESPAN, BreedingManager.getEnumAllele("Lifespan", "NORMAL"));
		BreedingManager.set(array, EnumBeeChromosome.FLOWERING, BreedingManager.getEnumAllele("Flowering", "AVERAGE"));
		BreedingManager.set(array, EnumBeeChromosome.EFFECT, BreedingManager.getEffect("Aggressive"));
		
		return array;
	}
}
