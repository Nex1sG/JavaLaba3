package building;
import building.Interface.buildStats;
import character.Character;
import unlinked.Colour;
import unlinked.Material;

public class Fence extends Building implements buildStats{
    final private double x, y, h; // Длина/ширина/высота дома
    private boolean isElectric; // Электрическая защита

    // Инициализация класса Fence
    public Fence(Material material, Colour colour, double x, double y, double h, boolean isElectric){
        super(material, colour);
        this.x = x;
        this.y = y;
        this.h = h;
        this.isElectric = isElectric;}

    // Инициализация методов класса Fence
    /**
     * Проверяет включено ли электрическая защита у стен
     * @return boolean - Да или Нет
     */
    public boolean isElectric(){
        return this.isElectric;}
    public void onElectricShield(){
        if (!this.isElectric){
            System.out.println("Могучее электрическое поле уже включено!");}
        else{
            System.out.println("Могучее электрическое поле включено!");
            this.isElectric = true;
        }
    }
    public void offElectricShield(){
        if (!this.isElectric){
            System.out.println("Могучее электрическое поле уже выключено!");}
        else{
            System.out.println("Могучее электрическое поле выключено!");
            this.isElectric = false;
        }
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



}
