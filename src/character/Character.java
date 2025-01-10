package character;

public abstract class Character {
        protected double energy, HP, maxHP;

        public Character(double energy, double HP, double maxHP){
            this.energy = energy;
            this.HP = HP;
            this.maxHP = maxHP;
        }

        // Метод run на понижает energy персонажа
        public abstract void run();

        // Метод meditation умеренно повышает характеристику персонажа
        public abstract void meditation();

}
