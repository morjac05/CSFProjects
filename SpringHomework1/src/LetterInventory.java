public class LetterInventory {
	static String matches = "abcdefghijklmnopqrstuvwxyz";
	static int[] count = new int[matches.length()];
	static int sum=0;
	static boolean empty=false;
	
	public LetterInventory(String data) {
		data = data.toLowerCase();
		for(int i=0; i<data.length(); i++) {
			int index = matches.indexOf(data.charAt(i));
			if(index<0) {
				continue;
			}
			count[index]++;
		}
		for(int i : count) {
			LetterInventory.sum +=i;
		}
		if(sum==0) {
			empty=true;
		}
	}
		//for(int i=0; i<count.length; i++) {
			//if(count[i]<1) {
				//continue;
			//}
			//System.out.println(matches.charAt(i) + ":" + count[i]);
		//}
	//}
	
	static int get(char letter) {
		int countindex = matches.indexOf(letter);
		int lettercount = count[countindex];
		System.out.println(count[countindex]);
		return lettercount;
	}
	
	static void set(char letter, int value) {
		int countindex = matches.indexOf(letter);
		LetterInventory.sum -=count[countindex];
		count[countindex] = value;
		LetterInventory.sum += count[countindex];
		if(sum==0 && empty!=false) {
			empty=true;
		}
		
		if(value<0) {
			throw new IllegalArgumentException("Value too low. Cannot pass negative integers.");
		}
		else if(countindex<0) {
			throw new IllegalArgumentException("Incorrect character. Please enter an alphabetic character.");
		}
	}
	
	static int getSize() {
		System.out.println(sum);
		return LetterInventory.sum;
	}
	
	boolean isEmpty() {
		if(empty=true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String inventory = "";
		for(int i=0;i<matches.length();i++) {
			char ch = matches.charAt(i);
			for(int j=0;j<count[i];j++) {
				if(count[i]==0) {
					continue;
				}
				inventory +=ch;
			}
		}
		return inventory;
	}
	
	@SuppressWarnings("static-access")
	LetterInventory add(LetterInventory other) {
		String bothdata = "";
		LetterInventory combination = new LetterInventory(bothdata);
		for(int i=0; i<other.count.length; i++) {
			combination.count[i]=this.count[i] + other.count[i];
		}
		System.out.println(combination.toString());
		return combination;
	}
	
	@SuppressWarnings("static-access")
	LetterInventory subtract(LetterInventory other) {
		String bothdata = "";
		LetterInventory result = new LetterInventory(bothdata);
		for(int i=0;i<this.count.length;i++) {
			result.count[i] = this.count[i] - other.count[i];
			if(result.count[i]<0) {
				return null;
			}
			else {
				continue;
			}
		}
		System.out.println(result.toString());
		return result;
	}
}
