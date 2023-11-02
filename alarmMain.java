import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.io.File;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

public class alarmMain {

    Timer clock;

    public alarmMain(int sec) {
        clock = new Timer();
        clock.schedule(new runtime(), sec);

    }

    class runtime extends TimerTask {

        public void run() {
            System.out.println("Joke's over, You're dead" + "\n");
            int count=15,limit=100;
//
            JFrame frame = new JFrame();
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Catch me if you can");
            label.setOpaque(true);
            panel.add(label);
            panel.setBorder(BorderFactory.createEmptyBorder(100,200,100,200));
            panel.setLayout(new GridLayout(1,1));
            frame.add(panel, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Sussy Baka");
            frame.pack();
            while (count>0){
                File lol = new File("C:\\Users\\Harsh\\IdeaProjects\\alarm_harsh\\src\\sound.wav");


                try{
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(lol));
                clip.start();
                } catch (Exception e){
                    e.printStackTrace();
                }


                int x = (int)Math.floor(Math.random()*(500+1)+0);
                int y = (int)Math.floor(Math.random()*(500+1)+0);
                frame.setVisible(true);
                frame.setLocation(x, y);
                count--;
                try{

                    Thread.sleep(300);        //Runs after delay
                }catch(InterruptedException ex){
                    break;
                }
                frame.setVisible(false);
                frame.dispose();
            }

            frame.setVisible(true);
            clock.cancel();
        }
    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter time in seconds- ");
        int seconds= sc.nextInt()*1000;


//        int seconds=1000;

//        Scanner obj = new Scanner(System.in);
//        System.out.println("Enter Time in seconds"+"\n");
//        seconds = obj.nextInt();
        new alarmMain(seconds);
        System.out.println("Reminder Set for 5 second"+"\n");
    }
}

//        Runtime.getRuntime().exec("taskkill /F /PID 827");
