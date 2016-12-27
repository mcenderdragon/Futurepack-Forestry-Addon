package futurepack.addons.forestry.bees;

import forestry.api.apiculture.IAlleleBeeSpeciesBuilder;
import forestry.api.apiculture.IBeeFactory;
import forestry.api.genetics.IClassification;
import forestry.apiculture.genetics.BranchBees;
import forestry.apiculture.genetics.alleles.AlleleBeeSpecies;

public class CyberBeeFactory implements IBeeFactory {

	public static CyberBeeFactory instance = new CyberBeeFactory();
	
	@Override
	public IAlleleBeeSpeciesBuilder createSpecies(String uid, boolean dominant, String authority,
			String unlocalizedName, String unlocalizedDescription, IClassification branch, String binomial,
			int primaryColor, int secondaryColor) {
		AlleleBeeSpecies bee = new AlleleBeeSpecies(uid, unlocalizedName, authority, unlocalizedDescription, dominant, branch, binomial, primaryColor, secondaryColor);
		bee.setCustomBeeModelProvider(CyberBeeModelProvider.instance);	
		return bee;
	}

	@Override
	public IClassification createBranch(String uid, String scientific) {
		return new BranchBees(uid, scientific);
	}

}
