package try_ddd.try_ddd.dolphingui.javafxnofxml.server;


import org.opendolphin.core.comm.Command;
import org.opendolphin.core.server.action.DolphinServerAction;
import org.opendolphin.core.server.comm.ActionRegistry;
import org.opendolphin.core.server.comm.CommandHandler;
import static try_ddd.try_ddd.dolphingui.javafxnofxml.shared.TutorialConstants.*;

import java.util.List;


public class TutorialAction extends DolphinServerAction {

    public void registerIn(ActionRegistry actionRegistry) {
        actionRegistry.register(CMD_LOG, new CommandHandler<Command>() {
            public void handleCommand(Command command, List<Command> response) {
                System.out.println(getServerDolphin().getAt(PM_COMIC).getAt(ATT_TITLE).getValue());
            }
        });
    }
}

