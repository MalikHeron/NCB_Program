package ncb.program;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CheckConnectivity {
    public static int doCheck() {
        int available = -1;

        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Internet is connected");
            available = 0;
        } catch (IOException e) {
            System.out.println("Internet is not connected");
            return -1;
        }

        return available;
    }
}
