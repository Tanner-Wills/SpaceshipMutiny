import javax.swing.text.html.HTMLDocument;

public class Gameplay {

    public static void main(String[] args) {
        BlueAstronaut Bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut Heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut Albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut Angel = new BlueAstronaut("Angel", 0, 1, 0);

        RedAstronaut Liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut Suspi = new RedAstronaut("Suspicious Person", 100, "expert");

        //1
        Liam.sabotage(Bob);
        System.out.println(Bob.toString());
        //System.out.println(Bob.isFrozen());

        //2
        Liam.freeze(Suspi);
        System.out.println(Suspi.toString());

        //3
        Liam.freeze(Albert);
        System.out.println(Albert.toString());
        //System.out.println(Albert.isFrozen());

        //4
        Albert.emergencyMeeting();
        //5
        Suspi.emergencyMeeting();
        //6
        Bob.emergencyMeeting();
        System.out.println(Suspi.toString());

        //7
        Heath.completeTask();
        System.out.println(Heath.toString());

        //8
        Heath.completeTask();
        Heath.completeTask();
        System.out.println(Heath.toString());

        Heath.completeTask();
        System.out.println(Heath.toString());

        Liam.freeze(Angel);
        System.out.println(Angel.toString());

        Liam.sabotage(Bob);
        Liam.sabotage(Bob);
        System.out.println(Bob.toString());

        System.out.println(Liam.toString());

        //12
        Liam.freeze(Bob);
        System.out.println(Bob.toString());

        //13
        Liam.sabotage(Heath);
        Liam.sabotage(Heath);
        Liam.sabotage(Heath);
        Liam.sabotage(Heath);
        Liam.sabotage(Heath);
        System.out.println(Heath.toString());

        Liam.freeze(Heath);



    }


}
