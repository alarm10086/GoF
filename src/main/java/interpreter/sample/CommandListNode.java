package interpreter.sample;

import java.util.ArrayList;

// <command list> ::= <command>* end
public class CommandListNode extends Node {
    private final ArrayList<CommandNode> list = new ArrayList();

    @Override
    public void parse(final Context context) throws ParseException {
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Missing 'end'");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                final CommandNode commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
