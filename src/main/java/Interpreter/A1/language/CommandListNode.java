package interpreter.a1.language;

import java.util.ArrayList;
import java.util.Iterator;

// <command list> ::= <command>* end
public class CommandListNode extends Node {
    private final ArrayList list = new ArrayList();

    @Override
    public void parse(final Context context) throws ParseException {
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Missing 'end'");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                final Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }

    @Override
    public void execute() throws ExecuteException {
        final Iterator it = list.iterator();
        while (it.hasNext()) {
            ((CommandNode) it.next()).execute();
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
