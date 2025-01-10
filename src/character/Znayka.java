package character;
import character.Interface.characterHP;
import exceptions.ActionWithDeadCharacter;
import exceptions.CharacterHpBiggerThanMaxHP;

import java.util.Objects;

public class Znayka extends Character implements characterHP{
        final static int age = 20;
        private double intellect, cheerFul;

        private static Znayka instance;

        // Инициализация класса Znayka: energy, HP, maxHP, intellect, cheerFul
        public Znayka(double energy, double HP, double maxHP, double intellect, double cheerFul){
                super(energy, HP, maxHP);
                try{
                    checkingActionWithHealHP();
                    this.intellect = intellect;
                    this.cheerFul = cheerFul;}
                catch(Exception e){
                    System.out.println("dont try set HP bigger thank maxHP!!!!!!");
                    this.HP = 1;
                    this.maxHP = 100;}}

         /**
         * Метод static Znayka getInstance гарантирует то,
         * что у нашего класс Znayka будет только один экземпляр
         * @param energy энергия персонажа
         * @param HP текущее здоровье персонажа
         * @param maxHP максимальное здоровье персонажа
         * @param intellect интеллект персонажа
         * @param cheerFul счастье персонажа
         * @return возвращает только один экземпляр
         */
        public static Znayka getInstance(double energy, double HP, double maxHP, double intellect, double cheerFul){
            try{
                if (instance == null){
                    instance = new Znayka(energy, HP, maxHP, intellect, cheerFul);}
                return instance;}
            catch (Exception e) {
                System.out.println(e.getMessage());
                return null;}}


        /**
         * Этот метод считает, сколько может решить задач Znayka
         * и сколько он потратит на это энергии, увеличивает intellect
         * @param countOfTask Количество поставленных задач
         */
        public void taskSolver(int countOfTask){
            if (this.energy > countOfTask * 5){
                System.out.println(this.getClass().getSimpleName() + " смог выполнить все " + countOfTask + " задач!");
                this.energy -= countOfTask * 5;
                this.intellect += countOfTask;}
            else{
                double countOfAbleTask = this.energy / 5;
                this.energy -= countOfAbleTask * 5;
                this.intellect += countOfAbleTask;
                System.out.println(this.getClass().getSimpleName() + " смог выполнить только " + countOfAbleTask + " задач");}}

         /**
         * Этот метод восстанавливает HP(5 единиц в час)
         * и energy в зависимости от параметра(5 | 10 единиц в час)
         * @param hoursOfDream Количество часов сна
         */
        public void sleeping(int hoursOfDream){
            if (hoursOfDream <= 10){
                this.energy += hoursOfDream * 10;
                System.out.println("Энергия " + getClass().getSimpleName() + " восполнена до " + this.energy);}
            else{
                this.energy += hoursOfDream * 5;
                System.out.println("Энергия " + getClass().getSimpleName() + " восполнена до " + this.energy);}
            this.HP += hoursOfDream * 5;}

        /**
        * Этот метод повышает cheerFul и intellect (1/3 единиц за час)
        * и восстанавливает энергию(1 единиц за час)
        * @param hoursOfTake Количество часов погружения в себя
        */
        public void takeMindDeep(int hoursOfTake){
            this.cheerFul += (double)hoursOfTake / 3;
            this.intellect += (double)hoursOfTake / 3;
            this.energy += hoursOfTake;
            System.out.println(this.getClass().getSimpleName() + " переосознал свою жизнь!");
        }

        // Метод выводит в консоль: age, intellect, cheerFul персонажа
        public void getParameters(){
            System.out.println("Возраст: " + age);
            System.out.println("Интеллект: " + this.intellect);
            System.out.println("Счастье: " + this.cheerFul);}

        // Метод переопределяет все параметры, кроме age
        public void setParameters(int energy, int HP, int maxHP, int intellect, int cheerFul){
            this.energy = energy;
            this.HP =  HP;
            this.maxHP = maxHP;
            this.intellect = intellect;
            this.cheerFul = cheerFul;}


        // Переопределение методов abstract class Character

        @Override
        public void run() {
        this.energy -= 20;}

        @Override
        public void meditation(){
        energy += 20;
        intellect += 5;

        if ((HP + 15) <= maxHP){HP += 15;}
        else{
            HP = maxHP;
            System.out.println("HP достигло максимального значения");}}


        // Инициализация интерфейса characterLive
        public void applyHeal(int healHP){
            try{
                this.HP += healHP;
                checkingActionWithHealHP();
                System.out.println("HP " + this.getClass().getSimpleName() + " поднято до " + this.HP);}
            catch(Exception e){
                this.HP = maxHP;
                System.out.println("HP stat set to " + maxHP + " HP");
                System.out.println(e.getMessage());}}
        public void applyDamage(int damage){
            try{
                checkingActionWithDamage();
                this.HP -= damage;
                System.out.println("HP " + this.getClass().getSimpleName() + " уменьшено до " + this.HP);}
            catch(ActionWithDeadCharacter e){
                this.HP = 0;
                System.out.println("HP stat set to 0 HP");
                System.out.println(e.getMessage());}}


        public void increaseMaxHP(int differentHP){
            this.maxHP = differentHP;}
        public void decreaseMaxHP(int differentHP){
            this.maxHP = differentHP;}


        // Переопределение методов equals, HashCode, toString

         /**
         * Сравнивает название переданного класса с нашимь
         * @param person название переданного класса
         * @return выводи либо true(равны), либо false(не равны)
         */
        @Override
        public boolean equals(Object person){
            return (this.getClass() == person.getClass());}

         /**
         * Возвращает хеш-код HP, intellect, cheerFul
         * @return хеш-код
         */
        @Override
        public int hashCode(){return Objects.hash(this.HP, this.intellect, this.cheerFul);}

         /**
         * Метод выводит информацию о состоянии персонажа
         * @return название класса и все поля
         */
        @Override
        public String toString(){
            return this.getClass().getSimpleName() + "{ " +
                     " energy: " + this.energy +
                     " HP: " + this.HP +
                     " maxHP: " + this.maxHP +
                     " intellect: " + this.intellect +
                     " cheerFul: " + this.cheerFul + "}";}


        // Инициализация private методов обработки
        private void checkingActionWithDamage(){
            if (this.HP <= 0) {
            throw new ActionWithDeadCharacter("Error: ActionWithDeadCharacter", this);}}
        private void checkingActionWithHealHP(){
            if (HP > maxHP | HP < 0){
                throw new CharacterHpBiggerThanMaxHP("Error: CharacterHpBiggerThanMaxHP", this);}}

}
