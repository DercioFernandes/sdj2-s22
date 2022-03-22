package dk.via.content;

import java.net.URL;

public class YoutubeUploader extends MediaUploader {
    public YoutubeUploader(URL site) {
        super(site);
    }

    @Override
    protected Content createContent(String title, String caption, URL mediaUrl) {
        return new Video(title, caption, mediaUrl);
    }
}
