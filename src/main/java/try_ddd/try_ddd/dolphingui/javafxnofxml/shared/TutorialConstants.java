package try_ddd.try_ddd.dolphingui.javafxnofxml.shared;

/**
 * Created by lucius on 12.05.17.
 */
public class TutorialConstants {
    public static final String PM_PERSON = unique("modelId");
    public static final String ATT_FIRSTNAME = "attrId";
    public static final String CMD_LOG = unique("LogOnServer");

    private static String unique(String key) {
        return TutorialConstants.class.getName() + "." + key;
    }
}

