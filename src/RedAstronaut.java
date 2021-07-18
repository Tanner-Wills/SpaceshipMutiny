import java.util.Arrays;
import java.util.Locale;

public class RedAstronaut extends Player implements Impostor{
    //Instance Variable
    private String skill; //either inexperienced, experienced, or expert.

    //Constructor
    public RedAstronaut(String name) {
        this(name, 15, "experienced");
    }

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
    }


// ***** RedAstronaut Getters *****
    public String getSkill(){
        return this.skill;
    }
// ***** RedAstronaut Methods *****
    // Interface Methods
    public void freeze(Player p) {
        //Can't freeze another impostor, can't freeze an already frozen player, and can't call .freeze if they are already frozen.
        if (p instanceof RedAstronaut || p.isFrozen() || this.isFrozen()) {
            return;
        }
        //Can only freeze if their susLevel is less than the chosen player's susLevel
        if (this.getSusLevel() < p.getSusLevel()) {
            p.setFrozen(true);
            gameOver();
        } else {
            this.setSusLevel(this.getSusLevel() * 2);
        }
    }

    public void sabotage(Player p){
        //Can't freeze another impostor, can't freeze an already frozen player, and can't call .freeze if they are already frozen.
        if (p instanceof RedAstronaut || p.isFrozen() || this.isFrozen()) {
            return;
        }
        //TODO: check if need to round up or down
        if(this.getSusLevel() < 20){
            p.setSusLevel((int)(p.getSusLevel() * 1.5));
        } else {
            p.setSusLevel((int)(p.getSusLevel() * 1.25));
        }
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof RedAstronaut){
            if(((RedAstronaut) o).getName() == this.getName() && ((RedAstronaut) o).isFrozen() == this.isFrozen() && ((RedAstronaut) o).getSusLevel() == this.getSusLevel() && ((RedAstronaut) o).getSkill() == this.getSkill()){
                return true;
            }
        }
        return false;
    }
    public String toString(){
        String myString = super.toString();
        myString += "I am an " + this.getSkill() + " player!";
        return  getSusLevel() > 20 ? myString : myString.toUpperCase(Locale.ROOT);
    }


    // Super Class Methods
    public void emergencyMeeting() {
        if (this.isFrozen()) {
            return;
        }
        //sort players by increasing order of susLevel
        Arrays.sort(getPlayers());

        //Identify player with highest susLevel (NOT frozen, NOT RedAstronaut)
        //If two highest susLevels are equal, no one gets frozen.
        Player[] suspects = new Player[2];
        int index = 0;

        for (int i = getPlayers().length - 1; i >= 0; i--) {
            if (!getPlayers()[i].isFrozen() && getPlayers()[i].getName() != this.getName()) {
                suspects[index] = getPlayers()[i];
                index++;
            }
            if (index == 2) {
                break;
            }
        }
        if (suspects[0] != null) {
            if (suspects[1] == null || suspects[0].getSusLevel() != suspects[1].getSusLevel()) {
                suspects[0].setFrozen(true);
            }
        }
        gameOver();
    }

}





