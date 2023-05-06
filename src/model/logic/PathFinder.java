package model.logic;

public class PathFinder {

    public static String getMusicFolderPath() {
        var os = Singleton.getOperatingSystem();

        switch (os){
            case MAC -> {return "/Users/" + System.getProperty("user.name") + "/Music";}
            case WINDOWS -> {return "C:\\Users\\" + System.getProperty("user.name") + "\\Music";}
            case LINUX -> {return "/home/" + System.getProperty("user.name") + "/Music";}
            default -> {return "";}
        }

    }
}
