package model.logic;

public enum OS {
    WINDOWS, MAC, LINUX, ANOTHER;

    public static OS getOperatingSystem(){
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) return WINDOWS;
        else if (os.contains("mac")) return MAC;
        else if (os.contains("linux")) return LINUX;
        else return ANOTHER;
    }
}
