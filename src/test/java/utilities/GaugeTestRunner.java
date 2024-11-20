package utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GaugeTestRunner {
    public static void main(String[] args) {
        try {
            String tag = "success"; // Örnek tag
            String gaugeProjectPath = System.getProperty("user.dir"); // Proje dizini
            System.out.println(gaugeProjectPath);
            String command = "gauge run specs --tags " + tag;

            Process process = Runtime.getRuntime().exec(command, null, new java.io.File(gaugeProjectPath));
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Gauge testleri başarıyla tamamlandı.");
            } else {
                System.err.println("Gauge testleri başarısız oldu. Çıkış kodu: " + exitCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Gauge testlerini çalıştırırken bir hata oluştu.");
        }
    }
}
