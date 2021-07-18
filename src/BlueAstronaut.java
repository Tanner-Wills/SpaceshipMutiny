import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate{

    //Instance Variable
    private int numTasks;
    private int taskSpeed;

    //Constructor
    public BlueAstronaut(String name) {
        this(name, 15, 6, 10);
    }

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }



    // ***** BlueAstronaut Methods *****
    // Interface Methods


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

    @Override
    public void completeTask() {
        if(this.isFrozen()){
            return;
        }

}


}




        }
