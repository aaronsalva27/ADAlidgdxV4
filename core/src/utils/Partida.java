package utils;

public class Partida implements Comparable<Partida>{
    public static float pointS;
    public static String levelS;

    public float points;
    public String level;

    public Partida() {
    }

    public float getPoints() {
        return points;
    }
    public String getLevel() {
        return level;
    }


    public void setLevel(float level) {
        if(level == -22){
            //System.out.println("Medium");
            this.level = "Medium";
            this.levelS = this.level;
        }else if(level == -35){
            //System.out.println("Harcore");
            this.level = "Hardcore";
            this.levelS = this.level;
        }else{
            //System.out.println("Easy");
            this.level = "Easy";
            this.levelS = this.level;
        }

    }

    public void setPoints(float points) {
        this.points = points;
        this.pointS = this.points;
    }

    @Override
    public int compareTo(Partida item) {

        if (!this.getLevel().equalsIgnoreCase(item.getLevel()))
            return this.getLevel().compareTo(item.getLevel());
        else{
            return  (int)this.getPoints() - (int)item.getPoints();
        }
    }

    @Override
    public String toString() {
        return  "Points: " + this.points +
                "Level: '" + level + '\'' +
                '\n';
    }
}