package building;
import building.Interface.buildStats;
import unlinked.Colour;
import unlinked.Material;

public class PocketLaunchArea extends Building implements buildStats {
    final private double  x, y, h;// Длина/ширина/высота дома
    private boolean hasPocket;
    private boolean hasLaunchTraces;

    // Инициализация класса House
    public PocketLaunchArea(Material material, Colour colour,
                            double x, double y, double h,
                            boolean hasPocket, boolean hasLaunchTraces){
        super(material, colour);
        this.x = x;
        this.y = y;
        this.h = h;
        this.hasPocket = hasPocket;
        this.hasLaunchTraces = hasLaunchTraces;}

    // Инициализация методов класса PocketLaunchArea
    /**
     *  Метод проверяет, запущена ли ракета?
     * @return вовзращает boolean - Да или Нет
     */
    public boolean checkPocket(){
        if (this.hasPocket){
            System.out.println("Ракета уже запущена!");
            return true;}
        else{
            System.out.println("Ракета на месте!");
            return false;}
    }

    /**
     *  Метод проверяет, есть ли следы запуска ракеты?
     * @return возвращает - Да или Нет
     */
    public boolean checkField(){
        if (this.hasLaunchTraces){
            System.out.println("Есть следы запуска ракеты!");
            return true;
        }
        else{
            System.out.println("Нет следов запуска ракеты!");
            return false;}
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
