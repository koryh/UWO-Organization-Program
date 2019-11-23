package uwo_map_organization_program;

public class favorites{
	private Room[] favor_point;
	private int top;
	private final int array_ini_size = 10;
	public favorites () {
		favor_point = new Room[array_ini_size];
		top = 0;
	}
	
	public favorites(int size) {
		favor_point = new Room [size];
		top = 0;
	}
	
	public boolean check_room (Room target) {
		for (int i = 0; i<top; i++) {
			if (favor_point[i].get_roomNumber() == target.get_roomNumber()) {
				if (favor_point[i].get_building().equals(target.get_building())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean add_room (Room target) {
		if (check_room(target)==true) {
			return false;
		}
		if (top == favor_point.length) {
			Room [] newList = new Room[favor_point.length+10];
			for (int i = 0; i<top;i++) {
				newList[i] = favor_point[i];
			}
			favor_point = newList;
		}
		favor_point[top] = target;
		top ++;
		return true;
	}
	
	public boolean delete_room (Room target) {
		if (check_room(target)==false) {
			return false;
		}
		for (int i = 0;i<top; i++) {
			if (favor_point[i].get_roomNumber() == target.get_roomNumber()) {
				if (favor_point[i].get_building().equals(target.get_building())){
					for (int j = i; j<favor_point.length-1; j++) {
						favor_point[j] = favor_point[j+1];
					}
					favor_point[top-1] = null;
					top --;
					return true;
				}
			}
		}
		return false;
	}
	
}