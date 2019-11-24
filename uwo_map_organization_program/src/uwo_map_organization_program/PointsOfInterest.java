package uwo_map_organization_program;

public class PointsOfInterest {

	private Room[] washrooms;
	private Room[] eateries;
	private Room[] elevator;
	private Room[] classrooms;
	private final int array_ini_size = 10;
	private int washroom_counter;
	private int eateries_counter;
	private int elevator_counter;
	private int classrooms_counter;
	
	public PointsOfInterest() {
		washrooms = new Room[array_ini_size];
		eateries = new Room[array_ini_size];
		elevator = new Room[array_ini_size];
		classrooms = new Room[array_ini_size];
		washroom_counter = 0;
		eateries_counter = 0;
		elevator_counter = 0;
		classrooms_counter = 0;
	}
	
	public void add_room(Room target) {
		if (washroom_counter == washrooms.length) {
			washrooms = expandCapacity(washrooms, washroom_counter);
		}
		if (eateries_counter == eateries.length) {
			eateries = expandCapacity(eateries, eateries_counter);
		}
		if (elevator_counter == elevator.length) {
			elevator = expandCapacity (elevator, elevator_counter);
		}
		if (classrooms_counter == classrooms.length) {
			classrooms = expandCapacity (classrooms, classrooms_counter);
		}
		
		if (target.getClass() == Washroom.class) {
			washrooms[washroom_counter] = target;
			washroom_counter++;
		}
		else if (target.getClass() == Elevator.class) {
			elevator[elevator_counter] = target;
			elevator_counter++;
		}
		else if(target.getClass() == Eatery.class) {
			eateries[eateries_counter] = target;
			eateries_counter++;
		}
		else if (target.getClass() == Classroom.class) {
			classrooms[classrooms_counter] = target;
			classrooms_counter++;
		}
		else {
			System.out.println("Error..Invalid room type..");
		}
		
		
	}
	
	private Room[] expandCapacity(Room[] target, int target_counter) {
		Room [] newList = new Room[target.length+10];
		for (int i = 0; i<target_counter;i++) {
			newList[i] = target[i];
		}
		return newList;
	
	}
	public Room[] get_washroom() {
		return washrooms;
	}
	
	public Room[] get_eateries() {
		return eateries;
	}
	
	
	public Room[] get_elevator() {
		return elevator;
	}
	
	public Room[] get_classrooms() {
		return classrooms;
	}
}
