
public interface Lock {

	public boolean openLock(int combination);
	
	public boolean changeCombination(int combination, int newCom);
	
	public boolean closeLock();
	
}
