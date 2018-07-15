package interpreter.a1.language;

public class InterpreterFacade implements Executor {
    private final ExecutorFactory factory;
    private Context context;
    private Node programNode;

    public InterpreterFacade(final ExecutorFactory factory) {
        this.factory = factory;
    }

    public boolean parse(final String text) {
        boolean ok = true;
        this.context = new Context(text);
        this.context.setExecutorFactory(factory);
        this.programNode = new ProgramNode();
        try {
            programNode.parse(context);
            System.out.println(programNode.toString());
        } catch (final ParseException e) {
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }

    @Override
    public void execute() throws ExecuteException {
        try {
            programNode.execute();
        } catch (final ExecuteException e) {
            e.printStackTrace();
        }
    }
}
