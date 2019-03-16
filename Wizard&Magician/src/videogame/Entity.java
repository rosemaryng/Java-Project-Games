package videogame;

public abstract class Entity {

	protected String name;
	protected int lifePoints = 0;

	public Entity(String name, int lifePoints) {
		assert(lifePoints >= 0);
		this.name = name;
		this.lifePoints = lifePoints;
	}

	public final boolean isAlive() {
		return this.lifePoints > 0;
	}
	
	public final int applySpell(SpellCaster spellCaster) {
		return this.propagateDamage(spellCaster.getStrength());
	}
	
	protected abstract int propagateDamage(int damageAmount);


	public abstract int minimumStrikeToDestroy();

	
}
