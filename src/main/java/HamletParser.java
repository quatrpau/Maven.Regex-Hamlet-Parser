import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }
    public String changeHamToLeon(String orig){
        String temp = orig;
        //caps
        temp = (Pattern.compile("\\bHAMLET")).matcher(temp).replaceAll("LEON");
        //lowercase
        temp = (Pattern.compile("\\bHamlet")).matcher(temp).replaceAll("Leon");
        this.hamletData = temp;
        return temp;
    }
    public String changeHoratToTariq(String orig){
        String temp = orig;
        //caps
        temp = Pattern.compile("\\bHORATIO").matcher(temp).replaceAll("TARIQ");
        //lowercase
        temp = Pattern.compile("\\bHoratio").matcher(temp).replaceAll("Tariq");
        this.hamletData = temp;
        return temp;
    }

}
