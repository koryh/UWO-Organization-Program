package uwo_map_organization_program;

public class Eatery extends Room{
    private int rate;
    public Eatery(String room, int flo, String buil, int[] position, String desc, int r) {
        super(room, flo, buil, position, desc);
        rate = r;
    }

    public int getRate(){
        return rate;
    }

    public void setRate(int r){
        rate = r;
    }
}
