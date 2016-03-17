import java.io.*;

/**
 * Created by georgipavlov on 17.03.16.
 */
public class ExecuteShellCommandEAPOL implements Runnable {

    private String command;
    private long startTime;
    private long waitTime;
    private long howManyMinutes;

    public String executeCommand(String command) {
        StringBuffer output=null;
        while (System.currentTimeMillis() - startTime < howManyMinutes){
        output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;

            while ((line = reader.readLine())!= null) {
                System.out.println("---------------------");
                System.out.println("T2");
                System.out.println(line);
                System.out.println("----------------------");
                output.append(line + "\n");
                if(line.contains("connected")){
                    break;
                }
            }
            p.destroy();
            synchronized(this){
            this.wait(waitTime);}

        } catch (Exception e) {
            e.printStackTrace();
        }
        }

        return output.toString();

    }

    public ExecuteShellCommandEAPOL(String command,long startTime,long waitTime,long howManyMinutes){
        this.command = command;
        this.startTime = startTime;
        this.waitTime = waitTime;
        this.howManyMinutes = howManyMinutes;
    }

    @Override
    public void run() {
        executeCommand(command);
    }
}
