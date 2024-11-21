package br.sefaz.com.EvidenciaUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EvidenciaUtils {
	static Properties properties;
    public static Properties loadProperties() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("init.properties"));
        return properties;
    }
}

