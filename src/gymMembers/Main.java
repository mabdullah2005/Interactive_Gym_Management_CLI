package gymMembers;
import java.util.Scanner;

public class Main {
	static MemberList members;
	
	public static MemberList readData() {
		String filename = "src/gymMembers/gym_members_exercise_tracking.csv";
		Scanner in = InputReader.getScanner(filename);
		
		members = new MemberList();
		
		//Header of the dataset
		String header  = in.nextLine();
		
		//Splits each field of singular record and adds data to GymMember object using setter methods.
		//After, the object is added to the ArrayList.
		while(in.hasNext()) {
			String currentLine = in.nextLine();
			String[] split = currentLine.split(",");
			
			GymMember current = new GymMember(Integer.parseInt(split[0]));
			
			current.setGender(split[1]);
			current.setWeight(Float.parseFloat(split[2]));
			current.setHeight(Float.parseFloat(split[3]));
			current.setMaxBPM(Integer.parseInt(split[4]));
			current.setAvgBPM(Integer.parseInt(split[5]));
			current.setRestBPM(Integer.parseInt(split[6]));
			current.setSessionDuration(Float.parseFloat(split[7]));
			current.setCaloriesBurned(Float.parseFloat(split[8]));
			current.setWorkoutType(split[9]);
			current.setFatPercentage(Float.parseFloat(split[10]));
			current.setWaterIntake(Float.parseFloat(split[11]));
			current.setWorkoutFrequency(Integer.parseInt(split[12]));
			current.setExperienceLevel(Integer.parseInt(split[13]));
			current.setBMI(Float.parseFloat(split[14]));
			
			members.addMember(current);			
		}
		
		members.setListHeader(header);
		
		return members;
	}
	
	public static void main(String[] args) {
		
		MemberList members = readData();
		
		Scanner menu = new Scanner(System.in);
		
		while(true) {
			//Printing menu options
			System.out.println("Gym Members Database Menu");
			System.out.println("\n1. View All Members");
			System.out.println("2. Search Database");
			System.out.println("3. Find the Top 5 Members Based on Calories Burned");
			System.out.println("4. Display BMI Categories (Underweight, Normal, Overweight, Obese)");
			System.out.println("5. Add or Remove Gym Members\n");
			
			int optionSelected = menu.nextInt();
			
			//View all Members
			if(optionSelected == 1) {
				members.listRecords();
				
				System.out.println("Returning to Main Menu...");				
			}
			
			//Filter Members by Experience Level, Workout Type, or Age Group
			else if(optionSelected == 2) {
				members.searchList();
			}
			
			//Find the Top 5 Members Based on Calories Burned or Workout Frequency
			else if(optionSelected == 3) {
				System.out.println("Top 5 Members by Calories Burned: \n");
				Selection selection = new Selection(members);
				selection.top5Calories();
				
				System.out.println("Returning to Main Menu...\n");
			}
			
			//Display BMI Categories (Underweight, Normal, Overweight, Obese)
			else if(optionSelected == 4) {
				bmiAnalyzer bmi = new bmiAnalyzer(members);
				bmi.printCategoryTotals();
				
				System.out.println("\nDo you wish to see BMI record by record? ");
				System.out.println("\n1. Yes");
				System.out.println("2. No");
				int bmiOption = menu.nextInt();
				
				if(bmiOption == 1) {
					bmi.printBMI();
				}
				
				System.out.println("\nReturning to Main Menu...\n");
			}
			
			//Add or Remove Gym Members
			else if(optionSelected == 5) {
				System.out.println("\nSpecify Whether You Wish to Add or Remove Members: \n1.Add \n2.Remove");
				int fifthOption = menu.nextInt();
				
				if (fifthOption == 1) {
					System.out.println("\nInput Age: ");
					int age = menu.nextInt();
					GymMember newMember = new GymMember(age);
					
					newMember.fillOut();
					members.addMember(newMember);
				}
				else if(fifthOption == 2) {
					System.out.println("\nSpecify Record Number between 0 and " + (members.getListSize() - 1)+ ": ");
					int deleteMemberNumber = menu.nextInt();
					if(deleteMemberNumber >= 0 && deleteMemberNumber < members.getListSize()) {
						System.out.println("Confirm you Wish to Delete the Below Record: ");
						System.out.println(members.get(deleteMemberNumber));
						System.out.println("\n1. Yes \n2. No");
						int deleteMemberOption = menu.nextInt();
						
						if(deleteMemberOption == 1) {
							members.deleteMember(deleteMemberNumber);
						}	
					}
				}
			}
			else {
				System.out.println("Incorrect Input. Try Again Please");
			}
		}
	}

}
