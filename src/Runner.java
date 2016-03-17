/**
 * Created by georgipavlov on 17.03.16.
 */
public class Runner {
    public static void main(String[] args) {
        long waitTime = 1000;
        int howMany = 3;
        long howManyMinutes = 6000;
        Thread runnable =
                new Thread(new ExecuteShellCommandEAPOL(
                        "sudo mdk3",System.currentTimeMillis(),waitTime,howManyMinutes)
                );
        runnable.start();
        for (int i = 0; i < howMany ; i++) {
            new Thread(
                    new ExecuteShellCommandDDOS("sudo mdk3",System.currentTimeMillis(),waitTime,howManyMinutes)
            ).start();
        }
    }
}
