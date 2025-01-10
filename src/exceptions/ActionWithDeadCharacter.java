package exceptions;
import character.Interface.characterHP;

public class ActionWithDeadCharacter extends RuntimeException {

    characterHP characterHP;

    public ActionWithDeadCharacter(String message, characterHP characterHP) {
        super(message);
        this.characterHP = characterHP;}

    @Override
    public String getMessage() {
        return super.getMessage() + String.format("Attempting an action with a dead %s\n", this.characterHP.getClass().getSimpleName());
    }
}
