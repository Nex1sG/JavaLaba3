package building;
import building.Interface.buildStats;
import unlinked.Colour;
import unlinked.Material;

import java.util.ArrayList;
import java.util.Objects;

public class House extends Building implements buildStats{
    final private double x, y, h; // Длина/ширина/высота дома

    private ArrayList<Windows> windows = new ArrayList<>();
    private ArrayList<Walls> walls = new ArrayList<>();
    private ArrayList<Doors> doors = new ArrayList<>();
    private ArrayList<Floors> floors = new ArrayList<>();

    // Инициализация класса House
    public House(Material material, Colour colour, double x, double y, double h){
        super(material, colour);
        this.x = x;
        this.y = y;
        this.h = h;}

    // Инициализация элементов дома
    public void houseConstructor(Material windowsMaterial, Colour windowsColour, int windowsCount,
                                 Material wallsMaterial, Colour wallsColour, int wallsCount,
                                 Material doorsMaterial, Colour doorsColour, int doorsCount,
                                 Material floorsMaterial, Colour floorsColour, int floorsCount){

        try{
            for (int i = 0; i < windowsCount; i++){
                windows.add(new Windows(windowsMaterial, windowsColour));}
            for (int i = 0; i < wallsCount; i++){
                walls.add(new Walls(wallsMaterial, wallsColour));}
            for (int i = 0; i < doorsCount; i++){
                doors.add(new Doors(doorsMaterial, doorsColour));}
            for (int i = 0; i < floorsCount; i++){
                floors.add(new Floors(floorsMaterial, floorsColour));}

        } catch (Exception e){
            System.out.println("В конструкции дома произошла ошибка! " + e.getMessage());
        } finally {System.out.println("Дом построен!");}}

    // Создание get методов для элементов дома
    public ArrayList<Walls> getWalls() {
        return walls;
    }
    public ArrayList<Doors> getDoors() {
        return doors;
    }
    public ArrayList<Floors> getFloors() {
        return floors;
    }
    public ArrayList<Windows> getWindows() {
        return windows;
    }

    // Реализация абстрактного класса
    @Override
    public void changeColour(Colour colour){
        this.colour = colour;}

    @Override
    public void changeMaterial(Material material){
        this.material = material;}

    // Реализация интерфейса buildStats
    public double getSquare(){
        return this.x * this.y;}
    public double getPerimeter(){
        return (this.x + this.y) * 2;}
    public double getVolume(){
        return this.x * this.y * this.h;}


    // Создание элементов дома
    public record Floors(Material material, Colour colour){ }
    public record Walls(Material material, Colour colour){ }
    public record Doors(Material material, Colour colour){ }
    public record Windows(Material material, Colour colour){ }
    // Переопределение методов equals, HashCode, toString
    /**
     * Сравнивает название переданного класса с нашим
     * @param house название переданного класса
     * @return выводи либо true(равны), либо false(не равны)
     */
    @Override
    public boolean equals(Object house){
        return (this.getClass() == house.getClass());}

    /**
     * Возвращает хеш-код HP, intellect, cheerFul
     * @return хеш-код
     */
    @Override
    public int hashCode(){return Objects.hash(this.material, this.colour);}

    /**
     * Метод выводит информацию о состоянии персонажа
     * @return название класса и все поля
     */
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + "{ " +
                "Material: " + this.material +
                "Colour: " + this.colour + "}";}

}
