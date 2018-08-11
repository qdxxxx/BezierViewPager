package qdx.bezierviewpager_compile.util;

import android.content.Context;
import android.widget.ImageView;

public class ImageLoadFactory {
    private static ImageLoadFactory instance;

    public static ImageLoadFactory getInstance() {
        if (instance == null) {
            synchronized (ImageLoadFactory.class) {
                if (instance == null) {
                    instance = new ImageLoadFactory();
                }
            }
        }
        return instance;
    }

    private ImageLoadClient mClient;

    public void setImageClient(ImageLoadClient client) {
        mClient = client;
    }

    public void loadImage(ImageView imageView, Object obj, Context context) {
        mClient.loadImage(imageView, obj, context);
    }

}
