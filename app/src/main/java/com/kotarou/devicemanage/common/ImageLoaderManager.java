package com.kotarou.devicemanage.common;

import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

import com.kotarou.devicemanage.MyApplication;

/**
 * Created by Administrator on 2016/8/31.
 */
public class ImageLoaderManager {
    private static ImageLoaderManager mInstance;

    public static ImageLoaderManager getInstance() {
        if (mInstance == null) {
            synchronized (ImageLoaderManager.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoaderManager();
                }
            }
        }
        return mInstance;
    }

    public ImageLoaderManager() {
        if (mInstance == null) {
            //采用自定义配置
            ImageLoader.getInstance().init(customImageLoaderConfig(MyApplication.getContext()));

            //采用默认配置
            //ImageLoader.getInstance().init(defaultImageLoaderConfig());
        }
    }

    //Image-loader框架默认配置
    private ImageLoaderConfiguration defaultImageLoaderConfig() {
        return ImageLoaderConfiguration.createDefault(MyApplication.getContext());
    }

    //Image-loader框架自定义配置
    private ImageLoaderConfiguration customImageLoaderConfig(Context context) {
        File cacheDir = StorageUtils.getCacheDirectory(context);  //缓存文件夹路径
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480, 800) // default = device screen dimensions 内存缓存文件的最大长宽
                //.memoryCache(new LruMemoryCache(2 * 1024 * 1024)) //可以通过自己的内存缓存实现
                //.memoryCache(new WeakMemoryCache())
                .memoryCacheSize(2 * 1024 * 1024)  // 内存缓存的最大值
                .memoryCacheSizePercentage(13) // default

                .diskCacheSize(50 * 1024 * 1024) // 50 Mb sd卡(本地)缓存的最大值
                .diskCacheFileCount(100)  // 可以缓存的文件数量
                // default为使用HASHCODE对UIL进行加密命名， 还可以用MD5(new Md5FileNameGenerator())加密
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                //.diskCacheExtraOptions(480, 800, null)  // 本地缓存的详细信息(缓存的最大长宽)，最好不要设置这个

                .threadPoolSize(3) // default  线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2) // default 设置当前线程的优先级
                .denyCacheImageMultipleSizesInMemory()
                .imageDownloader(new BaseImageDownloader(context)) // default
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                .writeDebugLogs() // 打印debug log
                .build(); //开始构建
        return config;
    }


    /**
     * 缩放类型mageScaleType:
     EXACTLY :图像将完全按比例缩小的目标大小
     EXACTLY_STRETCHED:图片会缩放到目标大小完全
     IN_SAMPLE_INT:图像将被二次采样的整数倍
     IN_SAMPLE_POWER_OF_2:图片将降低2倍，直到下一减少步骤，使图像更小的目标大小
     NONE:图片不会调整
     */
    /**
     *  显示方式displayer：
     RoundedBitmapDisplayer（int roundPixels）设置圆角图片
     FakeBitmapDisplayer（）这个类什么都没做
     FadeInBitmapDisplayer（int durationMillis）设置图片渐显的时间
     SimpleBitmapDisplayer()正常显示一张图片
     */
}