package interpreter.a1.language;

import java.util.StringTokenizer;

public class Context implements ExecutorFactory {
    private ExecutorFactory factory;
    private final StringTokenizer tokenizer;
    private String currentToken;

    public Context(final String text) {
        tokenizer = new StringTokenizer(text);
        nextToken();
    }

    public String nextToken() {
        if (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
        return currentToken;
    }

    public String currentToken() {
        return currentToken;
    }

    public void skipToken(final String token) throws ParseException {
        if (!token.equals(currentToken)) {
            throw new ParseException(
                    "Warning: " + token + " is expected, but " + currentToken + " is found.");
        }
        nextToken();
    }

    public int currentNumber() throws ParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch (final NumberFormatException e) {
            throw new ParseException("Warning: " + e);
        }
        return number;
    }

    public void setExecutorFactory(final ExecutorFactory factory) {
        this.factory = factory;
    }

    @Override
    public Executor createExecutor(final String name) {
        return factory.createExecutor(name);
    }
}
