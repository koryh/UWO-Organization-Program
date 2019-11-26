package uwo_map_organization_program;
import java.awt.image.BufferedImage;
import java.util.List;

public class floor {

	private List<Room> rooms;
	private favorites favorite;
	private String im;
	private PointsOfInterest poi;
	private int floor_num;
	private String floor_num_string;
	public floor (List<Room> rooms, favorites inputFavorites, String im, PointsOfInterest poi, int floor_num) {
		this.rooms = rooms;
		this.favorite = inputFavorites;
		this.im = im;
		this.poi = poi;
		this.floor_num = floor_num;
		this.floor_num_string = String.valueOf(floor_num_string);
		for (int i = 0; i<rooms.size() ;i++) {
			if (rooms.get(i).getClass() == Washroom.class) {
				poi.add_room_washroom((Washroom) rooms.get(i));
			}
			else if (rooms.get(i).getClass() == Elevator.class) {
				poi.add_room_elevator((Elevator) rooms.get(i));
			}
			else if(rooms.get(i).getClass() == Eatery.class) {
				poi.add_room_eatery((Eatery)rooms.get(i));
			}
			else if (rooms.get(i).getClass() == Classroom.class) {
				poi.add_room_classroom((Classroom) rooms.get(i));
			}
			else {
				poi.add_room(rooms.get(i));
			}
		}
	}
	
	
	public void set_as_favor (Room target) {
		boolean result = favorite.add_room(target);
		if (result == false) {
			System.out.println("Error..the room is already in the list..");
		}
	}
	
	public Room search (String target) {
		for (int i = 0; i<rooms.size();i++) {
			if (rooms.get(i).get_roomNumber().equals(target)) {
				return rooms.get(i);
			}
		}
		return null;
		
	}
	
	public favorites favourites_dropdown () {
		return null;
	}
	
	
	public favorites show_favorites() {
		return favorite;
	}
	
	public int get_floor_num () {
		return this.floor_num;
	}

	public String get_floor_num_string() {
		return this.floor_num_string;
	}
	public String[] get_room_num_list () {
		String[] result = new String[100];
		int counter = 0;
		for (int i = 0; i<rooms.size();i++) {
			result[counter] = rooms.get(i).get_roomNumber();
			counter++;
		}
		return result;
	}
	
	public String get_img() {
		return this.im;
	}
	
}