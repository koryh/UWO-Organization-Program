package uwo_map_organization_program;
import java.awt.image.BufferedImage;

public class floor {

	private Room[] rooms;
	private favorites favorite;
	private BufferedImage im;
	private PointsOfInterest poi;
	public floor (Room[] rooms, favorites inputFavorites, BufferedImage im, PointsOfInterest poi) {
		this.rooms = rooms;
		this.favorite = inputFavorites;
		this.im = im;
		this.poi = poi;
		for (int i = 0; i<rooms.length;i++) {
			poi.add_room(rooms[i]);
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
	
	
	public favorites show_favorites() {
		return favorite;
	}
	
	
	
	
}