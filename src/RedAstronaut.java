public class RedAstronaut extends Player implements Impostor {
    //Instance Variable
    private String skill; //either inexperienced, experienced, or expert.

    //Constructor
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
    public void emergencyMeeting(){
        return;
    }


}



