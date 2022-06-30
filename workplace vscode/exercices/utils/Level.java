package exercices.utils;

public class Level {
    private int level;
    private int exp;

    public Level() {
        this.level=1;
        this.exp=0;
    }

    public int getNextLevelExp() {
        return 1000+200*(level-1);
    }

    public void addExp(int exp) {
        
    }




    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }

    
}
