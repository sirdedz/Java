public class LockString implements Lock{

	
		private String combination;


		public boolean openLock(int input) {
			
			String temp = Integer.toString(input);
			
			if(temp == combination) {
				return true;
			}else {
				return false;
			}
		}

		public boolean changeCombination(int input, int newComInput) {
			
			String temp = Integer.toString(input);
			
			if(temp == combination) {
				combination = Integer.toString(newComInput);
				
				return true;
				
			}else {
				return false;
			}
		}

		public boolean closeLock() {
			
			return true;
		}
		
}