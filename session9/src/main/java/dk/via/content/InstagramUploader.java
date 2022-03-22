package dk.via.content;

import java.net.URL;

public class InstagramUploader extends MediaUploader {
    public InstagramUploader(URL site) {
        super(site);
    }

    @Override
    protected Content createContent(String title, String caption, URL mediaUrl) {
        return new Image(title, caption, mediaUrl);
    }
}
