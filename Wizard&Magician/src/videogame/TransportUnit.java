package videogame;

import java.util.HashSet;
import java.util.Set;

public class TransportUnit extends Entity {
  private Set<Entity> set = new HashSet<>();
  //Magician and Transport can be an entity


  public TransportUnit(String name, int lifePoints) {
    super(name, lifePoints);
  }

  public void add(Entity entity) {
    set.add(entity);
  }

  @Override
  protected int propagateDamage(int damageAmount) {
    assert damageAmount > 0;
    int damage;
    int currentPoints = lifePoints; //transport unit's lifepoint
    lifePoints = Math.max(lifePoints - damageAmount, 0);
    damage = Math.min(damageAmount, currentPoints);

    for (Entity e : set) {
      damage += e.propagateDamage(damageAmount / 2);
    }
    return damage;
  }


  @Override
  public int minimumStrikeToDestroy() {
    //the damage needed to destroy the transport + magicians inside
    int highest = lifePoints;
    for (Entity e : set) {
      int damage = e.minimumStrikeToDestroy();
      highest = Math.max(damage * 2, highest);
    }
    return highest;
  }

  @Override
  public String toString() {
    String output = name + "(" + Integer.toString(lifePoints) +") transporting: ";
    Set<String> magicians = new HashSet<>();
    for (Entity e: set){
      String n = e.toString();
      magicians.add(n);
    }
    output += magicians;
    return output;
  }
}