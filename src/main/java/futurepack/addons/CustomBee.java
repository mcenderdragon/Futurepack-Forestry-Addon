//package futurepack.addons;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.world.World;
//import net.minecraft.world.biome.BiomeGenBase;
//import forestry.api.apiculture.IBee;
//import forestry.api.apiculture.IBeeGenome;
//import forestry.api.apiculture.IBeeHousing;
//import forestry.api.core.IErrorState;
//import forestry.api.genetics.IChromosomeType;
//import forestry.api.genetics.IEffectData;
//import forestry.api.genetics.IIndividual;
//
//public class CustomBee implements IBee {
//
//	@Override
//	public int getHealth() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int getMaxHealth() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void age(World world, float ageModifier) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mate(IIndividual individual) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public boolean isAlive() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public String getIdent() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getDisplayName() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void addTooltip(List<String> list) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public boolean analyze() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isAnalyzed() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean hasEffect() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isSecret() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isGeneticEqual(IIndividual other) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public IIndividual copy() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isPureBred(IChromosomeType chromosomeType) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void readFromNBT(NBTTagCompound nbttagcompound) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void writeToNBT(NBTTagCompound nbttagcompound) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public IBeeGenome getGenome() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public IBeeGenome getMate() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isNatural() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public int getGeneration() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void setIsNatural(boolean flag) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public IEffectData[] doEffect(IEffectData[] storedData, IBeeHousing housing) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public IEffectData[] doFX(IEffectData[] storedData, IBeeHousing housing) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean canSpawn() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Set<IErrorState> getCanWork(IBeeHousing housing) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean hasFlower(IBeeHousing housing) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public ArrayList<BiomeGenBase> getSuitableBiomes() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ItemStack[] getProduceList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ItemStack[] getSpecialtyList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ItemStack[] produceStacks(IBeeHousing housing) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public IBee spawnPrincess(IBeeHousing housing) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public IBee[] spawnDrones(IBeeHousing housing) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void plantFlowerRandom(IBeeHousing housing) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public IIndividual retrievePollen(IBeeHousing housing) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean pollinateRandom(IBeeHousing housing, IIndividual pollen) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public IErrorState canWork(IBeeHousing housing) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
