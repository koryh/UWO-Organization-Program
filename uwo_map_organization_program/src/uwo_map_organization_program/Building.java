package uwo_map_organization_program;

import java.util.ArrayList;
import java.util.List;

public class Building {
	
	List<floor> floor_list;
	String[] floor_num_list;
	int[] floor_num_list_int;
	int counter;
	int num_of_floor;
	String buildingName;
	public Building (String buildingName) {
		this.buildingName = buildingName;
		this.floor_list = new ArrayList<floor>();
		this.num_of_floor = this.floor_list.size();
		counter = 0;
		floor_num_list = new String[10];
		for(int i = 0; i<floor_list.size();i++) {
			floor_num_list_int[counter] = floor_list.get(i).get_floor_num();
			floor_num_list[counter] = floor_list.get(i).get_floor_num_string();
			counter ++;
		}
	}
	
	public void add_floor(floor new_floor) {
		floor_list.add(new_floor);
	}
	
	public String[] get_floor_num_list() {
		return this.floor_num_list;
	}
	
	public int get_num_of_floor () {
		return this.num_of_floor;
	}
	
	public floor search_floor (String input) {
		for (int i = 0;i<floor_list.size();i++) {
			if (floor_list.get(i).get_floor_num_string().equals(input)) {
				return floor_list.get(i);
			}
		}
		return null;
	}
	
	public String get_building_name() {
		return this.buildingName;
	}
}
