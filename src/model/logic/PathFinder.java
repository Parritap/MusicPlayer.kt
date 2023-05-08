package model.logic;

public class PathFinder {

    public static String getMusicFolderPath() {
        var os = OS.getOperatingSystem(); //Where OS is an ENUM.
        var userName = System.getProperty("user.name");

        return switch (os) {
            case WINDOWS -> "C:\\Users\\" + userName + "\\Music";
            case MAC -> "/Users/" + userName + "/Music";
            case LINUX -> "/home/" + userName + "/Music";
            default -> "/home/" + userName + "/Music";
        };

    }
}
