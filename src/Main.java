import building.Pocket;
import building.House;
import building.PocketLaunchArea;
import building.Gate;
import building.Fence;
import character.Fuchsia;
import character.Seledochka;
import character.Znayka;
import unlinked.Colour;
import unlinked.Material;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Создание персонажей
        Znayka znayka = Znayka.getInstance(Math.random()*200, Math.random()*200,
                Math.random()*200, Math.random()*40, Math.random()*10);

        Fuchsia fuchsia = Fuchsia.getInstance(Math.random()*100, Math.random()*100,
                Math.random()*150, Math.random()*50, Math.random()*1000);

        Seledochka seledochka = Seledochka.getInstance(Math.random()*500, Math.random()*50,
                Math.random()*100, Math.random()*40, Math.random()*20);

        // Создание строений
        Pocket pocket = new Pocket(Material.STONE, Colour.GREEN,
                Math.random() * 150, Math.random()*600, true);

        House house = new House(Material.WOOD, Colour.BLUE,
                Math.random() * 300, Math.random()* 200, Math.random() * 400);

        PocketLaunchArea pocketLaunchArea = new PocketLaunchArea(Material.BRICK, Colour.BLACK,
                Math.random() * 300, Math.random()* 200, Math.random() * 5,
                false, true);

        Gate gate = new Gate(Material.WOOD, Colour.WHITE,
                Math.random() * 20, Math.random()* 10, Math.random(), false);

        Fence fence = new Fence(Material.WOOD, Colour.PURPLE,
                Math.random() * 1000, Math.random()* 10, Math.random()*70, false);

        // Ход событий
        znayka.sleeping(8);
        znayka.takeMindDeep(2);

        System.out.println("Знайка проверяет ракету: ");

        if (pocketLaunchArea.checkPocket()){
            System.out.println("Ракета стоит на базе");
        }
        else{
            System.out.println("Ракеты нет на базе");
            pocket.startFlying();
            znayka.taskSolver(1);
        }

        System.out.println("Знайка выбегает из дома!");

        znayka.run();

        System.out.println("Прежде, чем уйти, знайка нажимает на кнопку на заборе!");
        if (fence.isElectric()) {
            fence.onElectricShield();}
        else{
            fence.offElectricShield();}

        if (!gate.isOpen()){
            gate.openTheDoor();}
        System.out.println("Знайка выбегает с участка и закрывает калитку!");
        gate.closeTheDoor();

        System.out.println("Знайка пришел на площадь и стал искать ракету!");
        pocketLaunchArea.checkField();

        System.out.println("Вдруг, к знайке подбежали Фуксия и Селёдочка");
        fuchsia.run();
        seledochka.run();

        fuchsia.cry();
        seledochka.cry();
        znayka.meditation();

        System.out.println("Конец нашей части истории!");
    }
}