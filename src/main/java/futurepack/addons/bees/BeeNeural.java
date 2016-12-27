package futurepack.addons.bees;

import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.genetics.IAllele;

public class BeeNeural extends BeeCybren
{

	public BeeNeural(String name, int firstCol, int secondCol)
	{
		super(name, firstCol, secondCol);
	}

	@Override
	public IAllele[] getChromosomes()
	{
		IAllele[] array = super.getChromosomes();	
		BreedingManager.set(array, EnumBeeChromosome.LIFESPAN, BreedingManager.getEnumAllele("Lifespan", "NORMAL"));
		
		return array;
	}
}
