package utilities;

public class DataHandler {

    public static int convertStringToInt(String str){
        return Integer.parseInt(str.replaceAll("[^0-9]", ""));
    }

}
