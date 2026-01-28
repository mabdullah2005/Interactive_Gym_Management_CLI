package gymMembers;
import java.util.Scanner;
import java.util.HashMap;

public class GymMember {
	
	private int age;
	private String gender;
	private float weight_kg;
	private float height_m;
	private int maxBPM;
	private int avgBPM;
	private int restingBPM;
	private float sessionDuration_hrs;
	private float caloriesBurned;
	private String workoutType;
	private HashMap<Integer, String> workoutTypeMap;
	private float fatPercentage;
	private float waterIntake_litres;
	private int workoutFreq_daysPerWeek;
	private int experienceLevel;
	private float BMI;
	private Scanner input;
	
	//Constructor Class
	public GymMember(int age) {
		this.age = age;
		input = new Scanner(System.in);
		
		workoutTypeMap = new HashMap<>();
		workoutTypeMap.put(1, "Yoga");
		workoutTypeMap.put(2, "HIIT");
		workoutTypeMap.put(3, "Cardio");
		workoutTypeMap.put(4, "Strength");
	}
	
	public void fillOut() {
		fillGender();
		fillWeight();
		fillHeight();
		fillMaxBPM();
		fillAvgBPM();
		fillRestBPM();
		fillSessionDuration();
		fillCaloriesBurned();
		fillWorkoutType();
		fillFatPercentage();
		fillWaterIntake();
		fillWorkoutFreq();
		fillExperienceLevel();
		setBMI((Math.round((weight_kg/(height_m*height_m))*100)/100));
	}
	
	private void fillGender() {
		System.out.println("Gender: \n1. Male \n2.Female");
		int genderOption = input.nextInt();
		
		if(genderOption == 1) {
			setGender("Male");
		}
		else if(genderOption == 2) {
			setGender("Female");
		}
		else {
			fillGender();
		}
		
	}
	
	
	private void fillWeight() {
		System.out.println("Weight (KG): ");
		float weightOption = input.nextFloat();
		
		setWeight(weightOption);
	}
	
	private void fillHeight() {
		System.out.println("Height (m): ");
		float heightOption = input.nextFloat();
		
		setHeight(heightOption);
	}
	
	private void fillMaxBPM() {
		System.out.println("Max BPM: ");
		int maxBPMOption = input.nextInt();
		
		setMaxBPM(maxBPMOption);
	}
	
	private void fillAvgBPM() {
		System.out.println("Average BPM: ");
		int avgBPMOption = input.nextInt();
		
		setAvgBPM(avgBPMOption);
	}
	
	private void fillRestBPM() {
		System.out.println("Resting BPM: ");
		int restBPMOption = input.nextInt();
		
		setRestBPM(restBPMOption);
	}
	
	private void fillSessionDuration() {
		System.out.println("Session Duration (Hrs): ");
		float sessionDurationOption = input.nextFloat();
		
		setSessionDuration(sessionDurationOption);
	}
	
	private void fillCaloriesBurned() {
		System.out.println("Calories Burned: ");
		float caloriesBurnedOption = input.nextFloat();
		
		setCaloriesBurned(caloriesBurnedOption);
	}
	
	private void fillWorkoutType() {
		System.out.println("Workout Type: \n1. Yoga \n2. HIIT \n3. Cardio \n4. Strength");
		int workoutTypeOption = input.nextInt();
		
		if(workoutTypeOption > 0 && workoutTypeOption < 5) {
			setWorkoutType(workoutTypeMap.get(workoutTypeOption));
		}
		else {
			fillWorkoutType();
		}
	}
	
	private void fillFatPercentage() {
		System.out.println("Fat Percentage: ");
		float fatPercentageOption = input.nextFloat();
		
		setFatPercentage(fatPercentageOption);
	}
	
	private void fillWaterIntake() {
		System.out.println("Water Intake (Litres): ");
		float waterIntakeOption = input.nextFloat();
		
		setWaterIntake(waterIntakeOption);
	}
	
	private void fillWorkoutFreq() {
		System.out.println("Workout Frequency (Days/Week): ");
		int workoutFreqOption = input.nextInt();
		
		if(workoutFreqOption > 0 && workoutFreqOption <= 7) {
			setWorkoutFrequency(workoutFreqOption);
		}
		else {
			fillWorkoutFreq();
		}
	}
	
	private void fillExperienceLevel() {
		System.out.println("Experience Level: ");
		int experienceLevelOption = input.nextInt();
		
		if(experienceLevelOption > 0 && experienceLevelOption <= 3) {
			setExperienceLevel(experienceLevelOption);
		}
		else {
			fillExperienceLevel();
		}
	}
	
	
	public String toString() {
		String result = "[ Age: " + age + ", Gender: " + gender + ", Weight (KG): " + weight_kg + ", Height (M): " + height_m + ", Max BPM: " + maxBPM + ", Average BPM: " + avgBPM + ", Resting BPM: " + restingBPM + ", Session Duration (Hrs): " + sessionDuration_hrs + ", Calories Burned: " + caloriesBurned + ", Workout Type: " + workoutType + ", Fat Percentage: " + fatPercentage + ", Water Intake (Litres): " + waterIntake_litres + ", Workout Frequency (Days/Week): " + workoutFreq_daysPerWeek + ", Experience Level: " + experienceLevel + ", BMI: " + BMI + " ]\n\n";
		
		return result;
	}
	
	//Getter and Setter Methods
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public float getWeight() {
		return weight_kg;
	}
	
	public void setWeight(float weight) {
		weight_kg = weight;
	}
	
	public float getHeight() {
		return height_m;
	}
	
	public void setHeight(float height) {
		height_m = height;
	}
	
	public int getMaxBPM() {
		return maxBPM;
	}
	
	public void setMaxBPM(int maxBPM) {
		this.maxBPM = maxBPM;
	}
	
	public int getAvgBPM() {
		return avgBPM;
	}
	
	public void setAvgBPM(int avgBPM) {
		this.avgBPM = avgBPM;
	}
	
	public int getRestBPM() {
		return restingBPM;
	}
	
	public void setRestBPM(int restingBPM) {
		this.restingBPM = restingBPM;
	}
	
	public float getSessionDuration() {
		return sessionDuration_hrs;
	}
	
	public void setSessionDuration(float sessionDuration) {
		sessionDuration_hrs = sessionDuration;
	}
	
	public float getCaloriesBurned() {
		return caloriesBurned;
	}
	
	public void setCaloriesBurned(float caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	
	public String getWorkoutType() {
		return workoutType;
	}
	
	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}
	
	public float getFatPercentage() {
		return fatPercentage;
	}
	
	public void setFatPercentage(float fatPercentage) {
		this.fatPercentage = fatPercentage;
	}
	
	public float getWaterIntake() {
		return waterIntake_litres;
	}
	
	public void setWaterIntake(float waterIntake) {
		waterIntake_litres = waterIntake;
	}
	
	public int getWorkoutFrequency() {
		return workoutFreq_daysPerWeek;
	}
	
	public void setWorkoutFrequency(int workoutFreq) {
		workoutFreq_daysPerWeek = workoutFreq;
	}
	
	public int getExperienceLevel() {
		return experienceLevel;
	}
	
	public void setExperienceLevel(int experienceLevel) {
		this.experienceLevel = experienceLevel;
	}
	
	public float getBMI() {
		return BMI;
	}
	
	public void setBMI(float BMI) {
		this.BMI = BMI;
	}
}
