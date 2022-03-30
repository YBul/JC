package lesson6;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpClient {
    public static void main(String[] args) {
//        <сетевой_протокол>://<имя_хоста>:<номер_порта>/<действительный_путь_к_файлу>
        try {
            URL geekbrainsURL = new URL("https://geekbrains.ru/courses");

            System.out.println("Протокол: " + geekbrainsURL.getProtocol());
            System.out.println("Порт: " + geekbrainsURL.getPort());
            System.out.println("Хост: " + geekbrainsURL.getHost());
            System.out.println("Файл: " +geekbrainsURL.getFile());

            HttpURLConnection urlConnection = (HttpURLConnection) geekbrainsURL.openConnection();

            System.out.println("Метод запроса " + urlConnection.getRequestMethod());
            System.out.println("Код ответа " + urlConnection.getResponseCode());
            System.out.println("Ответное сообщение " + urlConnection.getResponseMessage());

            Map<String, List<String>> headers = urlConnection.getHeaderFields();
            for (String k : headers.keySet()) {
                System.out.println("Ключ: " + k + " значение: " + headers.get(k));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
