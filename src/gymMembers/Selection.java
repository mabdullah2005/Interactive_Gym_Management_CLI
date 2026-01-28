package gymMembers;

public class Selection {
	
	private int position;
	private int lowest;
	private GymMember[] top5;
	private MemberList members;	
	private int listSize;

	public Selection(MemberList members) {
		this.members = members;
		top5 = new GymMember[5];
		listSize = members.getListSize();
		lowest = 4;
		
		reset();
	}
	
	private void reset() {		
		for(int i=0; i<5; i++) {
			top5[i] = members.get(i);
		}
	}
	
	public void top5Calories() {
		quickSortByCalories(top5, 0, 4);
		
		for(position = 5; position < listSize; position++) {
			
			if(members.get(position).getCaloriesBurned() > top5[lowest].getCaloriesBurned()) {
				top5[lowest] = members.get(position);
				quickSortByCalories(top5, 0, 4);
			}
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.println("Position " + (i+1) + ": " + top5[i]);
		}
		reset();
			
	}
	
	
	//Implements Quick Sort Algorithm
	private void quickSortByCalories(GymMember[] list, int start, int end) {
		if(start < end) {
			int pivot = end;
			
			for(int compareForHigher = start; compareForHigher <= pivot; compareForHigher++) {
				if(list[compareForHigher].getCaloriesBurned() >= list[pivot].getCaloriesBurned()) {
					
					for(int compareForLower = start; compareForLower < compareForHigher; compareForLower++) {
						if(list[compareForLower].getCaloriesBurned() < list[pivot].getCaloriesBurned()) {
							swap(list, compareForLower, compareForHigher);
							
							if(compareForHigher == pivot) {
								pivot = compareForLower;
							}
							break;
						}
					}//end of inner for-Loop
				}
			}//end of outer for-Loop
			
			quickSortByCalories(list, start, (pivot-1));
			quickSortByCalories(list, (pivot+1), end);
			
		}//end of (low < high) if
	}//end of quickSortByCalories
	
	//Swaps two values in the list
	private void swap(GymMember[] list, int x, int y) {
		GymMember swap1 = list[x];
		GymMember swap2 = list[y];
		
		list[x] = swap2;
		list[y] = swap1;
	}

}
