
public class LockInt implements Lock{

	
		private int combination;


		public boolean openLock(int input) {
			
			if(input == combination) {
				return true;
			}else {
				return false;
			}
		}

		public boolean changeCombination(int input, int newComInput) {
			
			if(input == combination) {
				combination = newComInput;
				
				return true;
			}else {
				return false;
			}
		}

		public boolean closeLock() {
			
			return true;
		}
		
}
