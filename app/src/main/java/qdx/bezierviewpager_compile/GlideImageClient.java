package qdx.bezierviewpager_compile;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import qdx.bezierviewpager_compile.util.ImageLoadClient;

public class GlideImageClient extends ImageLoadClient {
    @Override
    public void loadImage(ImageView imageView, Object obj, Context context) {
        Glide.with(context).load(obj).into(imageView);
    }
}
