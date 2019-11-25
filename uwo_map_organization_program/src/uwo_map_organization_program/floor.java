package uwo_map_organization_program;
import java.awt.image.BufferedImage;
import java.util.List;

public class floor {

	private List<Room> rooms;
	private favorites favorite;
	private BufferedImage im;
	private PointsOfInterest poi;
	String floor_num;
	public floor (List<Room> rooms, favorites inputFavorites, BufferedImage im, PointsOfInterest poi, String floor_num) {
		this.rooms = rooms;
		this.favorite = inputFavorites;
		this.im = im;
		this.poi = poi;
		this.floor_num = floor_num;
		for (int i = 0; i<rooms.size() ;i++) {
			poi.add_room(rooms.get(i));
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
			if (rooms.get(i).get_roomNumber() == target) {
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
	
	public String get_floor_num () {
		return this.floor_num;
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
	
	
	
}