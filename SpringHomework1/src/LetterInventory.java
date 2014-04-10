public class LetterInventory {
	char[] characterArray;
	String matches = "abcdefghijklmnopqrstuvwxyz";
	int[] count = new int[matches.length()];
	static int sum=0;
	boolean empty=false;
	
	public LetterInventory(String data) {
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
	
	int get(char letter) {
		int countindex = matches.indexOf(letter);
		int lettercount = count[countindex];
		System.out.println(count[countindex]);
		return lettercount;
	}
	
	void set(char letter, int value) {
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
	
	static int size() {
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
	
	LetterInventory add(LetterInventory other) {
		String bothdata = "";
		LetterInventory combination = new LetterInventory(bothdata);
		for(int i=0; i<other.count.length; i++) {
			combination.count[i]=this.count[i] + other.count[i];
		}
		System.out.println(combination.toString());
		return combination;
	}
	
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
	
	public static void main(String[] args) {
		String datatest = "AAABCDDDFaabbc";
		String test2 = "AAABCD";
		LetterInventory alphabetchecker = new LetterInventory(datatest);
		LetterInventory inventory2 = new LetterInventory(test2);
		alphabetchecker.subtract(inventory2);
	}
}
