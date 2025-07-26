
import MagicWorld_Pages.Mw_SearchPage;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import java.util.Scanner;

public class MagicWorld_Tournament_Automation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("¿Cada cuanto tiempo, en minutos, quieres que se repita el proceso?");
        int automationTime = input.nextInt();
        System.out.println("Indique con 0 si el primer torneo es \"Single Tournament\" o 1 sin es \"Grand Tourment\"");
        int tournamentType = input.nextInt();

        int count = 0;

        while (true){
            sikuliAutomation(automationTime, tournamentType, count);
            count++;
            System.out.println("count = " + count);
            tournamentType = (tournamentType == 0) ? 1 : 0;
            automationTime = 56;
        }
    }

    public static void sikuliAutomation(int automationTime, int tournamentType, int count){
        //This will initialize the screen. We indicate which monitor by providing the monitor-id as parameter. In our case Main monitor "0"
        Screen s = new Screen(0);

        try {

            if(count == 0){
                Thread.sleep((long) automationTime * 60 * 1000);
            }

            //With these lines we will navigate to the Main menu and click on it
            s.find(Mw_SearchPage.Mw_MainButton);
            s.click();
            Thread.sleep(1500);

            //With these lines we will navigate to the Tournament Icon and click on it
            s.find(Mw_SearchPage.Mw_TournamentButton);
            s.click();
            Thread.sleep(1500);

            if(tournamentType == 0){
                //With these lines we will navigate to Single Tournament Icon and click on it
                s.find(Mw_SearchPage.Mw_SingleTournamentImg);
                s.click();
                Thread.sleep(1500);

                //With these lines we will navigate to Join button and click on it
                s.find(Mw_SearchPage.Mw_joinBtn);
                s.click();
                Thread.sleep(1500);
            } else {
                //With these lines we will navigate to Grand Tournament Icon and click on it
                s.find(Mw_SearchPage.Mw_GrandTournamentImg);
                s.click();
                Thread.sleep(1500);

                //With these lines we will navigate to Join button and click on it
                s.find(Mw_SearchPage.Mw_joinBtn);
                s.click();
                Thread.sleep(1500);
            }

            automationTime = 55;
            Thread.sleep((long) automationTime * 60 * 1000);

            //With these lines we will navigate to Continue Button and click on it
            s.find(Mw_SearchPage.Mw_continueBtn);
            s.click();
            Thread.sleep(1500);

            //With these lines we will navigate to Arrow Back Button and click on it
            s.find(Mw_SearchPage.Mw_arrowBackBtn);
            s.click();
            Thread.sleep(1500);

        }catch (FindFailed e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
