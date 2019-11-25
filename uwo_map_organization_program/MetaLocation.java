import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class MetaLocation {

//    private int room_number;
//    private int floor;
//    private String building;
//    private double x_coordinate;
//    private double y_coordinate;
//    private String description;
    public static void writeJSON(int roomNumber, int floor, String building, double x_coordinate, double y_coordinate, String description){
        JSONObject roomDetails = new JSONObject();
        roomDetails.put("roomNumber", roomNumber);
        roomDetails.put("floor", floor);
        roomDetails.put("building", building);
        roomDetails.put("x_coordinate", x_coordinate);
        roomDetails.put("y_coordinate", y_coordinate);
        roomDetails.put("description", description);

        JSONObject roomObject = new JSONObject();
        roomObject.put("room", roomDetails);
        JSONArray roomList =  new JSONArray();
        roomList.add(roomObject);
        try (FileWriter file = new FileWriter("rooms.json")) {

            file.write(roomList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readJSON() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("rooms.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray roomList = (JSONArray) obj;
            System.out.println(roomList);
            //Iterate over employee array
            roomList.forEach( emp -> parseRoomObject( (JSONObject) emp ) );


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void readBuilding() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("building.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject building = (JSONObject) obj;

            // Get list of floors
            JSONArray floorList = (JSONArray) building.get("floor list") ;
            for (int i = 0; i < floorList.size(); i++){// For each floor...
                JSONObject floor = (JSONObject) floorList.get(i);// Get list of rooms
                JSONArray roomList = (JSONArray) floor.get("room list");
                for (int j = 0; j < roomList.size(); j++) {// For each room...
                    JSONObject room = (JSONObject) roomList.get(j);// Get room info
                    System.out.println(room);
                }
            }
            //Iterate over employee array
//            floorList.forEach( floor -> parseRoomObject( (JSONObject) floor ) );
        }catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void readFloor(JSONObject floor){

    }

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
        readBuilding();
    }
}
