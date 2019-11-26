package uwo_map_organization_program;

public class Classroom extends Room {
    private int maximum_seats;
    public Classroom(String room, int flo, String buil, int[] position, String desc, int max) {
        super(room, flo, buil, position, desc);
        maximum_seats = max;
    }
    public int getMaximum_seats(){
        return maximum_seats;
    }

    public void setMaximum_seats(int max){
        maximum_seats = max;
    }
}
