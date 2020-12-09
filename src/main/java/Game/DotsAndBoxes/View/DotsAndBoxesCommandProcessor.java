package Game.DotsAndBoxes.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DotsAndBoxesCommandProcessor {


    public void processingCommand(String inputCommand) {
        while (true) {
            if (inputCommand.equalsIgnoreCase("start dot and boxes game")) {
                //create a 8*8 board
                //start the game
                //start with player with more wins

            } else if (inputCommand.equalsIgnoreCase("end of my turn")) {
                //age zamandar krdm ino barmidaram

            } else if (inputCommand.startsWith("draw line between")) {
                Pattern pattern = Pattern.compile("draw line between (\\d,\\d) and (\\d,\\d)");
                Matcher matcher = pattern.matcher(inputCommand);
                matcher.find();


            } else if (inputCommand.equalsIgnoreCase("show available lines")) {

            } else if (inputCommand.equalsIgnoreCase("show table")) {

            } else if (inputCommand.equalsIgnoreCase("who is next?")){

            } else if (inputCommand.equalsIgnoreCase("show result")){

            } else if (inputCommand.equalsIgnoreCase("show score")){

            }

        }
    }


}
