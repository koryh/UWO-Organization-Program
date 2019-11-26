package uwo_map_organization_program;

public class Room {
    private String room_number;
    private int floor;
    private String building;
    private int x_coordinate;
    private int y_coordinate;
    private String description;

    public Room(String room, int flo, String buil, int[] position, String desc){
        room_number = room;
        floor = flo;
        building = buil;
        x_coordinate = position[0];
        y_coordinate = position[1];
        description = desc;

    }
    public String get_roomNumber(){
        return room_number;
    }

    public int get_floor(){
        return floor;
    }

    public String get_building(){
        return building;
    }

    public double[] get_position(){
        double[] position = new double[0];
        position[0]=x_coordinate;
        position[1]=y_coordinate;
        return position;
    }

    public String get_description(){
        return description;
    }

    public void setRoom_number(String num){
        room_number = num;
    }

    public void setFloor(int num){
        floor = num;
    }

    public void setBuilding(String str){
        building = str;
    }

    public void setPosition(int[] position){
        x_coordinate = position[0];
        y_coordinate = position[1];
    }

    public void setDescription(String des){
        description = des;
    }

}
