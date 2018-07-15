package interpreter.a1.language;

// <program> ::= program <command list>
public class ProgramNode extends Node {
    private Node commandListNode;

    @Override
    public void parse(final Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public void execute() throws ExecuteException {
        commandListNode.execute();
    }

    @Override
    public String toString() {
        return "[program " + commandListNode + "]";
    }
}
