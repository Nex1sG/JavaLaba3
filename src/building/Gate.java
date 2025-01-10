package building;
import building.Interface.buildStats;
import character.Character;
import unlinked.Colour;
import unlinked.Material;

public class Gate extends Building implements buildStats {
    final private double x, y, h; //Длина/ширина/высота забора
    private boolean isOpen; // Электрическая защита

    // Инициализация класса Gate
    public Gate(Material material, Colour colour, double x, double y, double h, boolean isOpen) {
        super(material, colour);
        this.x = x;
        this.y = y;
        this.h = h;
        this.isOpen = isOpen;
    }

    // Инициализация методов класса Gate
    public void openTheDoor() {
        if (this.isOpen) {
            System.out.println("Мега-калитка уже открыта!");
        } else {
            System.out.println("Мега-калитка открыта!");
            this.isOpen = true;
        }
    }
    public void closeTheDoor() {
        if (!this.isOpen) {
            System.out.println("Мега-калитка уже закрыта!");
        } else {
            System.out.println("Мега-калитка закрыта!");
            this.isOpen = false;
        }
    }
    public boolean isOpen() {
        return this.isOpen;
    }

    // Реализация абстрактного класса
    @Override
    public void changeColour(Colour colour) {
        this.colour = colour;}

    @Override
    public void changeMaterial(Material material) {
        this.material = material;}

    // Реализация интерфейса buildStats
    public double getSquare() {
        return this.x * this.y;}
    public double getPerimeter() {
        return (this.x + this.y) * 2;}
    public double getVolume() {
        return this.x * this.y * this.h;}

}