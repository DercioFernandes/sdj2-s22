package dk.via.content;

import java.net.URL;

public class Image implements Content {
    private String title;
    private String caption;
    private URL imageUrl;

    public Image(String title, String caption, URL imageUrl) {
        this.title = title;
        this.caption = caption;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public URL getMediaUrl() {
        return imageUrl;
    }

    public void setImageUrl(URL imageUrl) {
        this.imageUrl = imageUrl;
    }
}
