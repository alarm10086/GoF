package adapter.a2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileProperties extends Properties implements FileIO {

    @Override
    public void readFromFile(final String filename) throws IOException {
        load(new FileInputStream(filename));
    }

    @Override
    public void writeToFile(final String filename) throws IOException {
        store(new FileOutputStream(filename), "written by FileProperties");
    }

    @Override
    public void setValue(final String key, final String value) {
        setProperty(key, value);
    }

    @Override
    public String getValue(final String key) {
        return getProperty(key, "");
    }
}
