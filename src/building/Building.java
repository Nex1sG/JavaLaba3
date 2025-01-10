package building;

import unlinked.Colour;
import unlinked.Material;

public abstract class Building {

    protected Material material;
    protected Colour colour;

    public Building(Material material, Colour colour){
        this.material = material;
        this.colour = colour;
    }

    public abstract void changeColour(Colour colour);
    public abstract void changeMaterial(Material material);

}
