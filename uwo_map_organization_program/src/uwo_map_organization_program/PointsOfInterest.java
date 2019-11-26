package uwo_map_organization_program;

import java.util.ArrayList;
import java.util.List;

public class PointsOfInterest {

	private List<Washroom> washrooms;
	private List<Eatery> eateries;
	private List<Elevator> elevator;
	private List<Classroom> classrooms;
	private List<Room> rooms;
	
	public PointsOfInterest() {
		washrooms = new ArrayList<Washroom>();
		eateries = new ArrayList<Eatery>();
		elevator = new ArrayList<Elevator>();
		classrooms = new ArrayList<Classroom>();
		rooms = new ArrayList<Room>();

	}
	
	public void add_room_washroom(Washroom target) {
		
		washrooms.add(target);
		
	}
	
	public void add_room_eatery(Eatery target) {
		eateries.add(target);
	}
	
	public void add_room_elevator (Elevator target) {
		elevator.add(target);
	}
	
	public void add_room_classroom (Classroom target) {
		classrooms.add(target);
	}
	
	public void add_room (Room target) {
		rooms.add(target);
	}

	public List<Washroom> get_washroom() {
		return washrooms;
	}
	
	public List<Eatery> get_eateries() {
		return eateries;
	}
	
	
	public List<Elevator> get_elevator() {
		return elevator;
	}
	
	public List<Classroom> get_classrooms() {
		return classrooms;
	}
	
	public int get_washroom_num () {
		return washrooms.size();
	}
	
	public int get_eateries_num () {
		return eateries.size();
	}
	
	public int get_elevator_num() {
		return elevator.size();
	}
	
	public int get_classrooms_num() {
		return classrooms.size();
	}
	
}
