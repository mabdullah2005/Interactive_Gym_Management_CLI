package gymMembers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MemberList {
	
	private ArrayList<GymMember> gymMembers;
	private HashMap <Integer, Runnable> searchMap;
	private String header;
	private int listSize;
	private Scanner input;
	
	//Constructor Class
	public MemberList() {
		gymMembers = new ArrayList<GymMember>();
		input = new Scanner(System.in);
		
		searchMap = new HashMap<>();
		searchMap.put(1, this::searchByRecord);
		searchMap.put(2, this::searchByAge);
		searchMap.put(3, this::searchByGender);
		searchMap.put(4, this::searchByWeight);
		searchMap.put(5, this::searchByHeight);
		searchMap.put(6, this::searchByWorkoutType);
		searchMap.put(7, this::searchByExperienceLevel);
	}
	
	//Adds a GymMember object to the ArrayList
	public void addMember(GymMember member) {
		gymMembers.add(member);
		listSize = gymMembers.size();
	}
	
	public void deleteMember(int member) {
		gymMembers.remove(member);
		listSize = gymMembers.size();
	}
	
	//Sets List Header
	public void setListHeader(String header) {
		this.header = header;
	}
	
	
	//returns listSize
	public int getListSize() {
		return listSize;
	}
	
	public GymMember get(int x) {
		return gymMembers.get(x);
	}
	
	
	//Prints records from specified start position, all the way to the end position specified
	private void printNext(int start, int end) {	
		System.out.println(header + "\n");
		
		for(int index = start; index<end; index++) {
			System.out.print("Record " + (index+1) + ":");
			System.out.println(gymMembers.get(index));
		}
	}
	
	//Lists records of the whole database in batches of 100
	public void listRecords() {
		int loopTimes = (int)(Math.ceil((double)listSize/100));//How many batches of 100 records needed to list entire database
		int hundreds = 0;//How many hundred records that have been listed
		
		//Outer Loop
		for(int i = 0; i<(loopTimes); i++) {
			int currentPosition = hundreds * 100;//Current Index of Database
			
			//If there are 100 or less records left to list, this block is performed
			if(hundreds == (loopTimes-1)) {
				printNext(currentPosition, (listSize));
			}
			
			//If there are more than 100 records to list, this block is performed
			else {
				printNext(currentPosition, (currentPosition + 100));
			}
			while(true) {
				System.out.println("\nContinue to next page (Press 1)?");
				int optionSelected = input.nextInt();
				
				if(optionSelected == 1) {
					System.out.println("Displaying next page...");
					break;
				}
				else {
					System.out.println("Incorrect Input. Please Try Again.");
				}//else
			}
			
			hundreds += 1;//Increments hundreds by 1 before entering the next loop
		}
		System.out.println("\nYou have reached the end of the database.");
	}//end of listRecords
	
	
	public void searchList() {
		while(true) {
			System.out.println("\n1.Record Number \n2.Age \n3.Gender \n4.Weight \n5.Height \n6.Workout Type \n7.Experience Level");
			System.out.println("\nSelect which field you wish to search by: ");
			int option = input.nextInt();
			
			Runnable func = searchMap.get(option);
			if(func != null) {
				func.run();
			}
			else {
				System.out.println("Invalid Input.");
			}
			
			System.out.println("Do you wish to search again? \n1.Yes \n2.No");
			int returnOption = input.nextInt();
			if(returnOption == 2) {
				break;
			}
		}
	}
	
	
	//Searches the database by Index
	private void searchByRecord() {
		System.out.println("\nChoose a Record Number from 0 to " + (listSize - 1) + ": ");
		
		int recordNumber = input.nextInt();
		if(recordNumber >= 0 && recordNumber < listSize) {
			System.out.println("Record " + recordNumber + ": " + gymMembers.get(recordNumber));
		}
		else {
			System.out.println("Record Number Not in List.");
		}
	}
	
	
	//Takes in a lower and upper bound age, printing a list of records that meet the age criteria
	private void searchByAge() {
		ArrayList<GymMember> searchByAgeList = new ArrayList<>();
		
		System.out.println("\nPlease specify a lower bound age: ");
		int lowerBound = input.nextInt();
		
		System.out.println("\nPlease specify an upper bound age: ");
		int upperBound = input.nextInt();
		
		if((lowerBound <= upperBound)) {
			for(GymMember s: gymMembers) {
				if((s.getAge() >= lowerBound) && (s.getAge() <= upperBound)) {
					searchByAgeList.add(s);
				}
			}
			System.out.println(searchByAgeList);
		} 
		else {
			System.out.println("Lower Bound specified greater than Upper Bound. Please Try Again.");
		}
	}//end of searchByAge
	
	
	//Searches database by gender, printing records that meet the criteria that user specifies.
	private void searchByGender() {
		ArrayList<GymMember>searchByGenderList = new ArrayList<>();
		String gender = "";
		
		System.out.println("\nSpecify gender to search by:");
		System.out.println("\n1. Male \n2. Female");
		int option = input.nextInt();
		
		if(option == 1) {
			gender = "Male";
		}
		else if(option == 2) {
			gender = "Female";
		}
		else {
			System.out.println("\nInvalid Input. Please Try Again");
		}
		
		if(gender.length() > 0) {
			for(GymMember s: gymMembers) {
				if(s.getGender().equals(gender)) {
					searchByGenderList.add(s);
				}
			}
			System.out.println(searchByGenderList);
		}
		
	}//end of searchByGender
	
	
	//Searches and prints database by weight bounds specified by user
	private void searchByWeight() {
		ArrayList<GymMember> searchByWeightList = new ArrayList<>();
		
		System.out.println("\nPlease specify a lower bound weight: ");
		int lowerBound = input.nextInt();
		
		System.out.println("\nPlease specify an upper bound weight: ");
		int upperBound = input.nextInt();
		
		if((lowerBound <= upperBound)) {
			for(GymMember s: gymMembers) {
				if((s.getWeight() >= lowerBound) && (s.getWeight() <= upperBound)) {
					searchByWeightList.add(s);
				}
			}
			System.out.println(searchByWeightList);
		} 
		else {
			System.out.println("Lower Bound specified greater than Upper Bound. Please Try Again.");
		}
	}//end of searchByWeight
	
	private void searchByHeight() {
		ArrayList<GymMember> searchByHeightList = new ArrayList<>();
		
		System.out.println("\nPlease specify a lower bound height: ");
		float lowerBound = input.nextFloat();
		
		System.out.println("\nPlease specify an upper bound height: ");
		float upperBound = input.nextFloat();
		
		if((lowerBound <= upperBound)) {
			for(GymMember s: gymMembers) {
				if((s.getHeight() >= lowerBound) && (s.getHeight() <= upperBound)) {
					searchByHeightList.add(s);
				}
			}
			System.out.println(searchByHeightList);
		} 
		else {
			System.out.println("Lower Bound specified greater than Upper Bound. Please Try Again.");
		}
	}//end of searchByHeight
	
	
	//Searches and prints database by WorkoutType
	private void searchByWorkoutType() {
		ArrayList<GymMember> workoutTypeList = new ArrayList<>();
		
		System.out.println("\n1.Yoga\n2.HIIT\n3.Cardio\n4.Strength");
		System.out.println("Select Workout Type you wish to search by.");
		int option = input.nextInt();
		
		if(option == 1) {
			for(GymMember s: gymMembers) {
				if(s.getWorkoutType().equals("Yoga")) {
					workoutTypeList.add(s);
				}
			}
		}
		else if(option == 2) {
			for(GymMember s: gymMembers) {
				if(s.getWorkoutType().equals("HIIT")) {
					workoutTypeList.add(s);
				}
			}
		}
		else if(option == 3) {
			for(GymMember s: gymMembers) {
				if(s.getWorkoutType().equals("Cardio")) {
					workoutTypeList.add(s);
				}
			}
		}
		else if(option == 4) {
			for(GymMember s: gymMembers) {
				if(s.getWorkoutType().equals("Strength")) {
					workoutTypeList.add(s);
				}
			}
		}
		else {
			System.out.println("Invalid Input. Please Try Again.");
		}
		System.out.println(workoutTypeList);
	}//end of workoutTypeList
	
	
	//Searches and prints database by Experience Level
	private void searchByExperienceLevel() {
		ArrayList<GymMember> experienceLevelList = new ArrayList<>();
		
		System.out.println("\nAn experience level from either 1, 2 or 3 is assigned to each individual. Please specify which experience level you wish to search by: ");
		int level = input.nextInt();
		
		if(level >= 1 && level <= 3) {
			for(GymMember s: gymMembers) {
				if(s.getExperienceLevel() == level) {
					experienceLevelList.add(s);
				}
			}
			System.out.println(experienceLevelList);
		}
		else {
			System.out.println("Invalid Input. Please Try Again");
		}
	}//end of searchByExperienceLevel
	
	
	//toString Method
	public String toString() {
		String toStringResult = "";
		
		for(GymMember m: gymMembers) {
			String currentMember = "[ " + m.getAge() + m.getGender() + m.getWeight() + m.getHeight() + m.getMaxBPM() + m.getAvgBPM() + m.getRestBPM() + m.getSessionDuration() + m.getCaloriesBurned() + m.getWorkoutType() + m.getFatPercentage() + m.getWaterIntake() + m.getWorkoutFrequency() + m.getExperienceLevel() + m.getBMI() + " ]\n";
			toStringResult += currentMember;
		}
		
		return toStringResult;
	}

}
