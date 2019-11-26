package uwo_map_organization_program;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StartUp {

	List<Building> building_list;
	PointsOfInterest poi;
	favorites fav;
	public StartUp() {
		MetaData start = new MetaData();
		poi = new PointsOfInterest();
		fav = new favorites();
		JSONObject inputJson = start.readBuilding("json/test.json");
		String buildingName = (String) inputJson.get("building name");
		Building build = new Building(buildingName);
		int numOfFloor = (int) inputJson.get("numOfFloor");
		JSONArray floor_index = (JSONArray) inputJson.get("floor numbers");
		for (Object temp:floor_index) {
			int current_floor = (int) temp;
			List<Room> room_list = start.getFloor(inputJson, current_floor);
			String img = start.getMap(inputJson, current_floor);
			floor floor_obj = new floor(room_list,fav,img,poi, current_floor);
			build.add_floor(floor_obj);
			for (int i = 0; i<room_list.size();i++) {
				Room current_visiting = room_list.get(i);
				if (current_visiting.getClass() == Washroom.class) {
					poi.add_room_washroom((Washroom)current_visiting); 
				}
				else if (current_visiting.getClass() == Elevator.class) {
					poi.add_room_elevator((Elevator) current_visiting);
				}
				else if(current_visiting.getClass() == Eatery.class) {
					poi.add_room_eatery((Eatery)current_visiting);
				}
				else if (current_visiting.getClass() == Classroom.class) {
					poi.add_room_classroom((Classroom)current_visiting);
				}
			}
		}
	
	
		
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
	
	public Building search_building (String target) {
		for (int i = 0; i<building_list.size();i++) {
			if (building_list.get(i).get_building_name().equals(target)) {
				return building_list.get(i);
			}
		}
		return null;
	}
	
	public PointsOfInterest get_poi() {
		return poi;
	}
	
}
