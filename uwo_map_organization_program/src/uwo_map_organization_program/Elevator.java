package uwo_map_organization_program;

public class Elevator extends Room{
    private int maximum_weight;
    public Elevator(int room, int flo, String buil, double[] position, String desc, int max) {
        super(room, flo, buil, position, desc);
        maximum_weight = max;
    }
    public int getMaximum_weight(){
        return maximum_weight;
    }

    public void setMaximum_weight(int max){
        maximum_weight = max;
    }
}
