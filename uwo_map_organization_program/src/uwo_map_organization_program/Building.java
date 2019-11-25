package uwo_map_organization_program;

import java.util.List;

public class Building {
	
	List<floor> floor_list;
	String[] floor_num_list;
	int counter;
	int num_of_floor;
	String buildingName;
	public Building (List<floor> floor_list, String buildingName) {
		this.buildingName = buildingName;
		this.floor_list = floor_list;
		this.num_of_floor = this.floor_list.size();
		counter = 0;
		floor_num_list = new String[10];
		for(int i = 0; i<floor_list.size();i++) {
			floor_num_list[counter] = floor_list.get(i).floor_num;
			counter ++;
		}
	}
	
	public String[] get_floor_num_list() {
		return this.floor_num_list;
	}
	
	public int get_num_of_floor () {
		return this.num_of_floor;
	}
	
	public floor search_floor (String input) {
		for (int i = 0;i<floor_list.size();i++) {
			if (floor_list.get(i).get_floor_num() == input) {
				return floor_list.get(i);
			}
		}
		return null;
	}
	
	public String get_building_name() {
		return this.buildingName;
	}
}
