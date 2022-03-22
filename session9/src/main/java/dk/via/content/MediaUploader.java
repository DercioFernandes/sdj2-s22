package dk.via.content;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public abstract class MediaUploader {
    private URL site;

    public MediaUploader(URL site) {
        this.site = site;
    }

    private void uploadContent(Content content) throws IOException {
        URLConnection connection = site.openConnection();
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        try {
            outputStream.write(content.getTitle().getBytes());
            outputStream.write(content.getCaption().getBytes());
            outputStream.write(0x7b); // I don't actually know how to do this. Probably JSON.
        } finally {
            outputStream.close();
        }
    }

    protected abstract Content createContent(String title, String caption, URL mediaUrl);

    public void upload(String title, String caption, URL mediaUrl) throws IOException {
        Content content = createContent(title, caption, mediaUrl);
        uploadContent(content);
    }
}
