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
     * @param buildingName
     * @param numOfFloor
     * @param maps
     * @param floors: List of JSONObject (roomJSONList)
     * @return
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
            int roomNum = target.get_roomNumber();
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

    public static JSONObject roomJSON(int roomNumber, int floor, String building, double x_coordinate, double y_coordinate, String description){
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
     * @return: List of Room Objects by reading input JSON file
     */
    public static List<Room> readBuilding(String file) {
        JSONParser jsonParser = new JSONParser();
        List<Room> roomList = new ArrayList<Room>();
        try (FileReader reader = new FileReader(file)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject building = (JSONObject) obj;

            // Get list of floors
            JSONArray floorList = (JSONArray) building.get("floor list") ;
            for (int i = 0; i < floorList.size(); i++){// For each floor...

                JSONObject floor = (JSONObject) floorList.get(i);// Get list of rooms
                JSONArray roomJSONList = (JSONArray) floor.get("room list");
                for (int j = 0; j < roomJSONList.size(); j++) {// For each room...
                    JSONObject JSONroom = (JSONObject) roomJSONList.get(j);// Get room info

                    // Create Room objects
                    int roomNum = (int)JSONroom.get("roomNumber");
                    int floorNum = (int) JSONroom.get("floor");
                    String buildingName = (String) JSONroom.get("building");
                    double x_coordinate = (double) JSONroom.get("x_coordinate");
                    double y_coordinate = (double) JSONroom.get("y_coordinate");
                    String description = (String) JSONroom.get("description");
                    double[] position = {x_coordinate,y_coordinate};
                    Room room = new Room(roomNum,floorNum,buildingName,position, description);

                    // Store room into room list.
                    roomList.add(room);
                }
            }
        }catch (IOException | ParseException e) {
            e.printStackTrace();
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
        int roomNumber = (int) location.get("roomNumber");
        System.out.println(roomNumber);

        //Get floor
        int floor = (int) location.get("floor");
        System.out.println(floor);

        //Get building
        String building = (String) location.get("building");
        System.out.println(building);

        //Get  x coordinates
        double x_coordinate = (double) location.get("x_coordinate");
        System.out.println(x_coordinate);

        //Get  y coordinates
        double y_coordinate = (double) location.get("y_coordinate");
        System.out.println(y_coordinate);

        //Get description
        String description = (String) location.get("description");
        System.out.println(description);


    }

    public static void main(String[] args){
        // Testing programs
        double[] position = {2.22,3.33};
        List<Room> list = new ArrayList<Room>();

        Room room1 = new Room(1,2,"ra",position,"des");
        Room room2 = new Room(2,2,"ra",position,"dsss");
        list.add(room1);
        list.add(room2);

        System.out.println(list.get(1).get_description());
//        readBuilding();

    }
}
