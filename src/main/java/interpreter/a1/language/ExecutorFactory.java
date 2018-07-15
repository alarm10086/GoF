package interpreter.a1.language;

public interface ExecutorFactory {
    public abstract Executor createExecutor(String name);
}
