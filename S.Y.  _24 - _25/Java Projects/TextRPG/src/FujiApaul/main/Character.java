package FujiApaul.main;
public abstract class Character 
{
    //Variables / Attributes all characters have 
    public String name;
    public int maxHP, hp, xp;

    //Constructor for character
    public Character(String name, int maxhP, int xp)
    {
        this.name = name;
        this.maxHP = maxhP;
        this.xp =  xp;
        this.hp = maxhP;
    }

    //methods every character has
    public abstract int attack();
    public abstract int defend();
}
