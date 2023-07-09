package com.yihantaiduo.myapplicationrtc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

public class LoadImage {
    private Context mContext;
    private String ImageUrl;
    private ImageView imageView;

    public LoadImage(Context mContext, String imageUrl,ImageView imageView) {
        this.mContext = mContext;
        this.ImageUrl = imageUrl;
        this.imageView=imageView;
    }

    public void showNetworkImage() {
        // 构建一个加载网络图片的建造器
        RequestBuilder<Drawable> builder = Glide.with(mContext).load(ImageUrl);
        RequestOptions options = new RequestOptions(); // 创建Glide的请求选项
//        options.disallowHardwareConfig(); // 关闭硬件加速，防止过大尺寸的图片加载报错
        options.skipMemoryCache(true); // 是否跳过内存缓存（但不影响硬盘缓存）
        options.override(300, 200); // 设置图片的宽高
        // 勾选了占位图
        options.placeholder(R.drawable.ic_launcher_background); // 设置加载开始的占位图
        // 勾选了出错图
        options.error(R.drawable.ic_launcher_foreground); // 设置发生错误的提示图
         // 勾选了原始图
        options.override(Target.SIZE_ORIGINAL); // 展示原始图片
        // 同时缓存原始图片和压缩图片
            options.diskCacheStrategy(DiskCacheStrategy.ALL); // 设置指定的缓存策略
        // 在图像视图上展示网络图片。apply方法表示启用指定的请求选项
        builder.apply(options).into(imageView);
    }

}
