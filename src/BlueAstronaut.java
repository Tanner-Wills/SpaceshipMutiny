import java.util.Arrays;
import java.util.Locale;

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
            if (!getPlayers()[i].isFrozen() ) {
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
        if(this.taskSpeed > 20 && this.numTasks != 0){
            this.numTasks -= 2;
            if(this.numTasks <= 0){
                System.out.println("I have completed all my tasks");
                this.setSusLevel((int)(this.getSusLevel()*0.5));
                this.numTasks = 0;
            }
        } else if (this.numTasks != 0) {
            this.numTasks -= 1;
            if (this.numTasks <= 0) {
                System.out.println("I have completed all my tasks");
                this.setSusLevel((int) (this.getSusLevel() * 0.5));
                this.numTasks = 0;
            }
        }
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof BlueAstronaut){
            if(((BlueAstronaut) o).getName() == this.getName() && ((BlueAstronaut) o).isFrozen() == this.isFrozen() && ((BlueAstronaut) o).getSusLevel() == this.getSusLevel() && ((BlueAstronaut) o).numTasks == this.numTasks && ((BlueAstronaut) o).taskSpeed == this.taskSpeed){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        String myString = super.toString();
        myString += "I have " + this.numTasks + " tasks left over.";
        return  getSusLevel() > 15 ? myString : myString.toUpperCase(Locale.ROOT);
    }


}





