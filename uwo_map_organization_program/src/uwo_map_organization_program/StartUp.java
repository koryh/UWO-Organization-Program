package uwo_map_organization_program;

import java.util.ArrayList;
import java.util.List;

public class StartUp {

	List<Building> building_list;
	public StartUp() {
		double [] temp = {2.2,5.5};
		Room room1 = new Room ("MC101", 1, "Middlesex", temp, "This is discription");
		Room room2 = new Room ("MC102", 1, "Middlesex", temp, "This is discription");
		List<Room> room_list = new ArrayList<Room>();
		room_list.add(room1);
		room_list.add(room2);
		favorites fav = new favorites();
		floor floor1 = new floor (room_list,fav, null, null, "1");
		List<floor> floor_list = new ArrayList<floor>();
		floor_list.add(floor1);
		Building building1 = new Building(floor_list, "Middlesex");
		building_list = new ArrayList<Building>();
		building_list.add(building1);
		
	}
	
	public String[] get_building_list() {
		String[] result = new String[20];
		int counter = 0;
		for (int i = 0; i<building_list.size();i++) {
			result[counter] = building_list.get(i).get_building_name();
			counter++;
		}
		return result;
	}
}
