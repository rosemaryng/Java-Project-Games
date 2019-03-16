package videogame;

public class Magician extends Entity implements SpellCaster {

  public Magician(String name, int lifePoints) {
    super(name, lifePoints);
  }

  @Override
  public int getStrength() {
    return lifePoints*2;

  }

  @Override
  public int propagateDamage(int damageAmount) {
    assert damageAmount > 0;
    int currentPoints = lifePoints;
    lifePoints = Math.max(lifePoints - damageAmount, 0);
    return Math.min(damageAmount, currentPoints);
  }

  @Override
  public int minimumStrikeToDestroy() {
    return lifePoints;
  }

  @Override
  public String toString() {
    String points = Integer.toString(lifePoints);
    String statement = name + "(" + points + ")";
    return statement;
  }
}
