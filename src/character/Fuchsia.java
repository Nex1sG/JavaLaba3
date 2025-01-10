package character;

import character.Interface.characterHP;
import character.Interface.womanPossibility;
import exceptions.ActionWithDeadCharacter;
import exceptions.CharacterHpBiggerThanMaxHP;

public class Fuchsia extends Character implements characterHP, womanPossibility{
        final int age = 17;
        private double levelOfBeauty, confidence;

        private static Fuchsia instance;

        // Инициализация (поля + abstract методы)
        public Fuchsia(double energy, double HP, double maxHP, double levelOfBeauty, double confidence){
            super(energy, HP, maxHP);
            this.levelOfBeauty = levelOfBeauty;
            this.confidence = confidence;}

         /**
         * Метод static Fuchsia getInstance гарантирует то,
         * что у нашего класс Fuchsia будет только один экземпляр
         * @param energy энергия персонажа
         * @param HP текущее здоровье персонажа
         * @param maxHP максимальное здоровье персонажа
         * @param levelOfBeauty интеллект персонажа
         * @param confidence счастье персонажа
         * @return возвращает только один экземпляр
         */
        public static Fuchsia getInstance(double energy, double HP, double maxHP, double levelOfBeauty, double confidence){
            if (instance == null){
                instance = new Fuchsia(energy, HP, maxHP, levelOfBeauty, confidence);}
            return instance;}

        // Метод выводит в консоль: age, intellect, cheerFul персонажа
        public void getParameters(){
            System.out.println("Возраст " + this.getClass().getSimpleName() + ": " + this.age);
            System.out.println("Красота " + this.getClass().getSimpleName() + ": " + this.levelOfBeauty);
            System.out.println("Уверенность " + this.getClass().getSimpleName() + ": " + this.confidence);
        }

        // Метод переопределяет все параметры, кроме age
        public void setParameters(int energy, int HP, int maxHP, int levelOfBeauty, int confidence){
            this.energy = energy;
            this.HP = HP;
            this.maxHP = maxHP;
            this.levelOfBeauty = levelOfBeauty;
            this.confidence = confidence;}


        // Переопределение методов abstract class Character

        @Override
        public void run() {
        this.energy -= 20;}

        @Override
        public void meditation(){
            this.energy += 20;
            this.HP += 15;
            this.confidence += 5;}


        // Инициализация интерфейса characterLive
        public void applyHeal(int healHP){
            try{
                this.HP += healHP;
                checkingActionWithHealHP();
                System.out.println("HP " + this.getClass().getSimpleName() + " поднято до " + this.HP);}
            catch(Exception e){
                this.HP = maxHP;
                System.out.println(e.getMessage());}}
        public void applyDamage(int damage){
        try{
            checkingActionWithDamage();
            this.HP -= damage;
            System.out.println("HP " + this.getClass().getSimpleName() + " уменьшено до " + this.HP);}
        catch(ActionWithDeadCharacter e){
            this.HP = 0;
            System.out.println(e.getMessage());}}
        public void increaseMaxHP(int differentHP){
        this.maxHP = differentHP;}
        public void decreaseMaxHP(int differentHP){
        this.maxHP = differentHP;}


        // Инициализация интерфейса womanPossibility
        public void magicMakeUp(int levelOfBeauty){
            this.levelOfBeauty += levelOfBeauty;
            System.out.println(this.getClass().getSimpleName() + " похорошела!)");
        }
        public void cry(){
            //Material ...
            this.levelOfBeauty += 1;
            System.out.println(this.getClass().getSimpleName() + " стала выгледять героически! :>");
        }


        // Инициализация private методов обработки
        private void checkingActionWithDamage(){
            if (this.HP <= 0) {
                throw new ActionWithDeadCharacter("Error: ActionWithDeadCharacter", this);}}
        private void checkingActionWithHealHP(){
        if (HP > maxHP | HP < 0){
            throw new CharacterHpBiggerThanMaxHP("Error: CharacterHpBiggerThanMaxHP", this);}}
}
