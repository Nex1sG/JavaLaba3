package unlinked;
import java.lang.String;

public enum Material {
    WOOD(0.15), COBBLESTONE(0.2), STONE(0.25),
    BRICK(0.3), OBSIDIAN(0.8), WATER(1),
    LAVA(1), SAND(0.01), GRASS(0.05);

    private final double enduranceCoefficient;

    Material(double enduranceCoefficient){
        this.enduranceCoefficient = enduranceCoefficient;} // Почему запрещены модификаторы доступа?

    public double getEnduranceCoefficient(){
        return this.enduranceCoefficient;}

    @Override
    public String toString() {
        return super.toString().toLowerCase();}
}
