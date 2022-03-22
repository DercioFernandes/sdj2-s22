package dk.via.content;

import java.net.URL;

public class Video implements Content {
    private String title;
    private String caption;
    private URL videoUrl;

    public Video(String title, String caption, URL videoUrl) {
        this.title = title;
        this.caption = caption;
        this.videoUrl = videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public URL getMediaUrl() {
        return videoUrl;
    }

    public void setVideoUrl(URL videoUrl) {
        this.videoUrl = videoUrl;
    }
}
