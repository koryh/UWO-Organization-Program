package uwo_map_organization_program;
import java.awt.image.BufferedImage;

public class floor {

	private Room[] rooms;
	private Room[] washrooms;
	private Room[] eateries;
	private Room[] stairwells;
	private Room[] elevator;
	private Room[] classrooms;
	
	private favorites favorite;
	private BufferedImage im;
	public floor (Room[] rooms, favorites inputFavorites, BufferedImage im) {
		this.rooms = rooms;
		this.favorite = inputFavorites;
		this.im = im;
		for (int i = 0; i<rooms.length;i++) {
			// find the type of each room
		}
	}
	
	
	public void set_as_favor (Room target) {
		boolean result = favorite.add_room(target);
		if (result == false) {
			System.out.println("Error..the room is already in the list..");
		}
	}
	
	public Room search (int target) {
		for (int i = 0; i<rooms.length;i++) {
			if (rooms[i].get_roomNumber() == target) {
				return rooms[i];
			}
		}
		return null;
		
	}
	
	public favorites favourites_dropdown () {
		return null;
	}
	
	
	public Room[] get_washroom() {
		return washrooms;
	}
	
	public Room[] get_eateries() {
		return eateries;
	}
	
	public Room[] get_stairwells() {
		return stairwells;
	}
	
	public Room[] get_elevator() {
		return elevator;
	}
	
	public Room[] get_classrooms() {
		return classrooms;
	}
	
	public favorites show_favorites() {
		return favorite;
	}
	
	
	
	
}