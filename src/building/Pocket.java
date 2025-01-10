package building;


import unlinked.Colour;
import unlinked.Material;

public class Pocket extends Building{
    private double speed, height;
    private boolean isFlying;

    // Инициализация класса Pocket
    public Pocket(Material material, Colour colour, double speed,
                  double height, boolean isFlying){
        super(material, colour);
        this.speed = speed;
        this.height = height;
        this.isFlying = isFlying;
    }

    // Инициализация методов класса Pocket
    /**
     * Проверяет, улетела ли ракета?
     * @return bollean - Да или Нет
     */
    public boolean isFlying(){
        return this.isFlying;}

    /**
     * Запускает ракету и ставит isFlying = true
     * Если ракета уже запущена, то ничего не меняется
     */
    public void startFlying(){
        if (isFlying){
            System.out.println("Ракета уже взлетела!");}
        else{
            System.out.println("Ракета запущена!");
            this.isFlying = true;}}

    /**
     * Определяет какую высоту можно набрать за время
     * @param second - сколько секунд ракета летит
     * @return высоту, которую преодолела ракета
     */
    public double getHeight(int second){
        return (speed * second) + height;}

    // Реализация абстрактного класса
    @Override
    public void changeColour(Colour colour){
        this.colour = colour;}

    @Override
    public void changeMaterial(Material material){
        this.material = material;}



}

