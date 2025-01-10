package character.Interface;

public interface characterHP {

    // Наносит damage персонажу
    void applyDamage(int damage);

    // Восстанавливает healCount HP персонажу
    void applyHeal(int healCount);

    // Увеличивает maxHP персонажа
    void increaseMaxHP(int HP);

    //Уменьшает maxHP персонажа
    void decreaseMaxHP(int HP);

}
