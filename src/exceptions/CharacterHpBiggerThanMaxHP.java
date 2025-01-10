package exceptions;
import character.Character;
import character.Interface.characterHP;

public class CharacterHpBiggerThanMaxHP extends RuntimeException {

    characterHP characterHP;

    public CharacterHpBiggerThanMaxHP(String message, characterHP characterHP){
        super(message);
        this.characterHP = characterHP;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + String.format("Attempting get HP bigger than maxHP from %s\n", this.characterHP.getClass().getSimpleName());
    }

}
