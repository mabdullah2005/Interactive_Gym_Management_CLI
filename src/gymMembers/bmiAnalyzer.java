package gymMembers;

public class bmiAnalyzer {
	private MemberList members;
	private String[] bmiList;
	private int numOfUnderweight;
	private int numOfNormal;
	private int numOfOverweight;
	private int numOfObese;
	private String underweight;
	private String normal;
	private String overweight;
	private String obese;
	
	public bmiAnalyzer(MemberList members) {
		this.members = members;
		bmiList = new String[members.getListSize()];
		numOfUnderweight = 0;
		numOfNormal = 0;
		numOfOverweight = 0;
		numOfObese = 0;
		
		underweight = "Underweight";
		normal = "Normal";
		overweight = "Overweight";
		obese = "Obese";
		
		analyzeBMI();
	}
	
	private void analyzeBMI() {
		for(int i = 0; i<members.getListSize(); i++) {
			float memberWeight = members.get(i).getWeight();
			float memberHeight = members.get(i).getHeight();
			
			float memberBMI = calculateBMI(memberWeight, memberHeight);
			String memberCategory = getCategory(memberBMI);
			bmiList[i] = "Record " + (i+1) + ":\n -------> BMI: " + memberBMI + ", Category: " + memberCategory;
		}
	}
	
	public void printCategoryTotals() {
		System.out.println("\nBMI Category Totals:\n");
		System.out.println("---------> Underweight: " + getUnderweight());
		System.out.println("---------> Normal: " + getNormalWeight());
		System.out.println("---------> Overweight: " + getOverweight());
		System.out.println("---------> Obese: " + getObese());
	}
	
	public void printBMI() {
		for(int i = 0; i < bmiList.length; i++) {
			System.out.println(bmiList[i]);
		}
	}
	
	private float calculateBMI(float weight, float height) {
		return Math.round((weight/(height*height))*100)/100;
	}
	
	private String getCategory(float memberBMI) {
		String category = "";
		if(memberBMI >= 25) {
			if(memberBMI >= 30) {
				numOfObese += 1;
				category =  obese;
			}
			else {
				numOfOverweight += 1;
				category = overweight;
			}
		}
		else if(memberBMI < 25) {
			if(memberBMI < 18.5) {
				numOfUnderweight += 1;
				category = underweight;
			}
			else {
				numOfNormal += 1;
				category =  normal;
			}
		}
		return category;
	}
	
	private int getUnderweight() {
		return numOfUnderweight;
	}
	
	private int getNormalWeight() {
		return numOfNormal;
	}
	
	private int getOverweight() {
		return numOfOverweight;
	}
	
	private int getObese() {
		return numOfObese;
	}
	
}
