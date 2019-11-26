package uwo_map_organization_program;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MetaData {

    /**
     * Generate JSON output file
     * @param: JSONObj that want to store (normally is buildingJSON)
     */
    public static void writeJSON(JSONObject jsonObject){
        try (FileWriter file = new FileWriter("rooms.json")) {
            file.write(jsonObject.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate a JSONObject (building)
     * @param maps: List of maps
     * @param floors: List of JSONObject (roomJSONList)
     * @return : JSONObject (building)
     */
    public static JSONObject buildingJSON(String buildingName, int numOfFloor, String[] maps, JSONObject[] floors){
        JSONObject building = new JSONObject();
        building.put("building name",buildingName);
        building.put("numOfFloor", numOfFloor);

        JSONArray mapList = new JSONArray();
        for (int i = 0; i < maps.length; i++){
            mapList.add(maps[i]);
        }
        building.put("map list",mapList);

        JSONArray floorList = new JSONArray();
        for (int j = 0; j < floors.length; j++){
            floorList.add(floors[j]);
        }
        building.put("floor list", floorList);

        return building;
    }


    public static JSONObject roomJSONList(List<Room> roomList){
        JSONArray roomArray =  new JSONArray();
        JSONObject roomJSONList = new JSONObject();
        for (int i = 0; i < roomList.size(); i++){// Generate list of Room objects
            Room target = roomList.get(i);
            String roomNum = target.get_roomNumber();
            int floor = target.get_floor();
            String building = target.get_building();
            double[] position = target.get_position();
            double x = position[0];
            double y = position[1];
            String description = target.get_description();
            JSONObject roomObj = roomJSON(roomNum, floor, building, x, y, description);
            roomArray.add(roomObj);
        }
        roomJSONList.put("room list",roomArray);
        return roomJSONList;
    }

    public static JSONObject roomJSON(String roomNumber, int floor, String building, double x_coordinate, double y_coordinate, String description){
        JSONObject roomDetails = new JSONObject();
        roomDetails.put("roomNumber", roomNumber);
        roomDetails.put("floor", floor);
        roomDetails.put("building", building);
        roomDetails.put("x_coordinate", x_coordinate);
        roomDetails.put("y_coordinate", y_coordinate);
        roomDetails.put("description", description);
        JSONObject roomObject = new JSONObject();
        roomObject.put("room", roomDetails);

        return roomObject;
    }

    /**
     *
     * @return: A JSONObject which is building
     */
    public static JSONObject readBuilding(String file) {
        JSONParser jsonParser = new JSONParser();
        JSONObject building = new JSONObject();

        try (FileReader reader = new FileReader(file)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            building = (JSONObject) obj;

        }catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return building;
    }

    public static JSONArray getFloorList ( JSONObject building){
        JSONArray floor_list = (JSONArray) building.get("floor numbers");
        return floor_list;
    }

    public static String getMap (JSONObject building, int floorNum){
        String map="";
        JSONArray floorList = (JSONArray) building.get("floor list");
        for (Object flo : floorList) {
            JSONObject floor = (JSONObject) flo;
            int level = (int)floor.get("floor level");
            if (floorNum == level){
                map = (String) floor.get("floor map");
            }
        }
        return map;
    }

    public static List<Room> getFloor(JSONObject building, int floorNum){
        // Get list of floors
        JSONArray floorList = (JSONArray) building.get("floor list");
        List<Room> roomList = new ArrayList<Room>();
        for (Object flo : floorList) {// Search floor number
            JSONObject floor = (JSONObject) flo;// Get list of rooms
            if (floorNum == (int) floor.get("floor level")) {// Floor number matched
                JSONArray roomJSONList = (JSONArray) floor.get("room list");
                for (Object obj : roomJSONList) {// For each room...
                    JSONObject JSONroom = (JSONObject) obj;// Get room info

                    // Create Room objects
                    String roomNum = (String) JSONroom.get("roomNumber");
                    int floorNumber = (int) JSONroom.get("floor");
                    String buildingName = (String) JSONroom.get("building");
                    int x_coordinate = (int) JSONroom.get("x_coordinate");
                    int y_coordinate = (int) JSONroom.get("y_coordinate");
                    String description = (String) JSONroom.get("description");
                    int[] position = {x_coordinate, y_coordinate};
                    if (description.equals("Classroom")){
                        int max = (int)JSONroom.get("maximum_seats");
                        Classroom room = new Classroom(roomNum,floorNum,buildingName,position,description,max);
                        roomList.add(room);
                    } else if (description.equals("Eatery")){
                        int rate = (int) JSONroom.get("rate");
                        Eatery room = new Eatery(roomNum,floorNum,buildingName,position,description,rate);
                        roomList.add(room);
                    }  else if (description.equals("Elevator")){
                        int max = (int) JSONroom.get("maximum_weight");
                        Elevator room = new Elevator(roomNum,floorNum,buildingName,position,description,max);
                        roomList.add(room);
                    } else if (description.equals("Washroom")){
                        String ty = (String) JSONroom.get("type");
                        Washroom room = new Washroom(roomNum,floorNum,buildingName,position,description,ty);
                        roomList.add(room);
                    } else {
                        Room room = new Room(roomNum, floorNum, buildingName, position, description);
                        roomList.add(room);
                    }
                }
            }

        }
        return roomList;
    }

    /**
     * test function
     * @param loca: Which is room JSON object
     */
    private static void parseRoomObject(JSONObject loca) {
        //Get room object within list
        JSONObject location = (JSONObject) loca.get("room");

        //Get room number
        String roomNumber = (String) location.get("roomNumber");
        System.out.println(roomNumber);

        //Get floor
        int floor = (int) location.get("floor");
        System.out.println(floor);

        //Get building
        String building = (String) location.get("building");
        System.out.println(building);

        //Get  x coordinates
        int x_coordinate = (int) location.get("x_coordinate");
        System.out.println(x_coordinate);

        //Get  y coordinates
        int y_coordinate = (int) location.get("y_coordinate");
        System.out.println(y_coordinate);

        //Get description
        String description = (String) location.get("description");
        System.out.println(description);
    }

    public static void main(String[] args){
        // Testing programs
        int[] position = {2,3};
        List<Room> list = new ArrayList<Room>();

        Room room1 = new Room("MC101",2,"ra",position,"des");
        Room room2 = new Room("MC202",2,"ra",position,"dsss");
        list.add(room1);
        list.add(room2);

        System.out.println(list.get(1).get_description());
//        readBuilding();

    }
}