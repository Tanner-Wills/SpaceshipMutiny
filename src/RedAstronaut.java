import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    //Instance Variable
    private String skill; //either inexperienced, experienced, or expert.

    //Constructor
    public RedAstronaut(String name){
        this(name, 15, "experienced");
    }

    public RedAstronaut(String name, int susLevel, String skill){
        super(name, susLevel);
        this.skill = skill;
    }


// ***** RedAstronaut Methods *****
    // Interface Methods
    public void freeze(Player, p){
        return;
    }
    public void sabotage(Player, p){
        return;
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
    }





    }


}



