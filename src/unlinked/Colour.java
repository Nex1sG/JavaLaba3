package unlinked;

public enum Colour {
    GREEN(15), WHITE(100), BLACK(100),
    YELLOW(40), BLUE(60), PURPLE(65);

    private final int saturation;
    Colour(int saturation){
        this.saturation = saturation;
    }

    public int getSaturation(){
        return this.saturation;}

    @Override
    public String toString() {
        return super.toString().toLowerCase();}
}
