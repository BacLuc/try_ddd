package try_ddd.try_ddd.dolphingui.javafxnofxml.shared;

/**
 * Created by lucius on 12.05.17.
 */
public class TutorialConstants {
    public static final String PM_COMIC = unique("comic");
    public static final String ATT_TITLE = "title";
    public static final String ATT_YEAR = "year";
    public static final String ATT_NUM = "number";

    public static final String CMD_LOG = unique("LogOnServer");

    private static String unique(String key) {
        return TutorialConstants.class.getName() + "." + key;
    }
}

