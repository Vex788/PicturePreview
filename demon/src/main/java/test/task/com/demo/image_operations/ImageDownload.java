package test.task.com.demo.image_operations;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class ImageDownload {

    private static String download(long id, String pictureUrl) {
        try {
            System.out.println("----------------------------------------------------------------" + id);
            pictureUrl = pictureUrl.replace("\\", "/");
            String pathToPicture = "C:/images/" + id + "_" + new Random().nextInt(1000000) + ".jpg";

            URL url = new URL(pictureUrl);
            InputStream in = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            byte[] buf = new byte[1024];
            int n = 0;

            while (-1 != (n = in.read(buf))) {
                out.write(buf, 0, n);
            }

            out.close();
            in.close();

            byte[] response = out.toByteArray();

            FileOutputStream fos = new FileOutputStream(pathToPicture);

            fos.write(response);
            fos.close();

            return pathToPicture;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Collection<String> download(long id, Collection<String> pictureUrls) {
        File file = new File("/images");

        if (!file.exists()) {
            new File("C:/images").mkdir();
            System.out.println("Directory created: " + file.mkdir());
        }

        Collection<String> pathToPictures = new ArrayList<>();

        for (String picUrl : pictureUrls) {
            pathToPictures.add(download(id, picUrl));
        }

        return pathToPictures;
    }
}
