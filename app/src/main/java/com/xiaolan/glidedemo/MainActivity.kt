package com.xiaolan.glidedemo

import android.graphics.Color
import android.graphics.PointF
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.xiaolan.glidedemo.imageloader.ImageLoader
import jp.wasabeef.glide.transformations.*
import jp.wasabeef.glide.transformations.gpu.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorFilterTransformation = ColorFilterTransformation(Color.argb(80, 255, 0, 0))
        val cropCircleTransformation = CropCircleTransformation()
        val cropSquareTransformation = CropSquareTransformation()
        //黑白
        val grayscaleTransformation = GrayscaleTransformation()
        //遮罩
        val maskTransformation = MaskTransformation(R.mipmap.mask_starfish)
        //毛玻璃
        val supportRSBlurTransformation = SupportRSBlurTransformation(25, 1)
        val blurTransformation = BlurTransformation(25, 1)
        //
        val toonFilterTransformation = ToonFilterTransformation()
        //老照片
        val sepiaFilterTransformation = SepiaFilterTransformation()
        //对比度
        val contrastFilterTransformation = ContrastFilterTransformation(2.0f)
        //底片
        val invertFilterTransformation = InvertFilterTransformation()
        //马赛克
        val pixelationFilterTransformation = PixelationFilterTransformation(20f)
        //素描
        val sketchFilterTransformation = SketchFilterTransformation()
        //旋涡
        val swirlFilterTransformation = SwirlFilterTransformation(0.5f, 1.0f, PointF(0.5f, 0.5f))
        //亮
        val bitmapTransform = BrightnessFilterTransformation(0.5f)
        //油画
        val kuwaharaFilterTransformation = KuwaharaFilterTransformation(25)
        //晕影
        val vignetteFilterTransformation = VignetteFilterTransformation(PointF(0.5f, 0.5f),
                floatArrayOf(0.0f, 0.0f, 0.0f), 0f, 0.75f)

        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
//        Glide.with(this)
//                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551699797871&di=e7b8956e495da82353ee9cdbf1618b51&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201403%2F18%2F20140318161736_eiheB.jpeg")
//                .placeholder(R.mipmap.wd_head)
//                .apply(bitmapTransform(sketchFilterTransformation))
//                .transition(withCrossFade(500))
//                .skipMemoryCache(false)
//                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
//                .into(iv)

        //油画
        val kuwaharaFilterTransformation = KuwaharaFilterTransformation(25)
        //素描
        val colorFilterTransformation = ColorFilterTransformation(Color.argb(80, 255, 0, 0))
        val sketchFilterTransformation = SketchFilterTransformation()
        //黑白
        val grayscaleTransformation = GrayscaleTransformation()
        var url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1552368477&di=23e623d7026c69a5d8c3258796fcd39a&imgtype=jpg&er=1&src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201708%2F16%2F094005ckuchkctc5cdq6kc.jpg"
//        var url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551772191205&di=a7d6e95c77f0b019a79f54bd6141a127&imgtype=0&src=http%3A%2F%2Fww2.sinaimg.cn%2Flarge%2F6d12d5e0gw1eyrzslqng3g20jg0atx6p.gif"
//        var url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551766082278&di=610f05bb0723f7bac65cb6d53f1da9e9&imgtype=0&src=http%3A%2F%2Fmat1.gtimg.com%2F2014%2Fgif%2Fmasailuo%2F05.gif"
//        var url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551765815238&di=7ffb6fcd1d5b741ebd5188444d1aa172&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201610%2F24%2F20161024131608_mHF5x.gif"
//        val url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551699797871&di=e7b8956e495da82353ee9cdbf1618b51&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201403%2F18%2F20140318161736_eiheB.jpeg"


//        progressBar.visibility = View.VISIBLE
//
        val load1 = Glide.with(this)
//                .asGif()
                .load(url)
                .thumbnail(Glide.with(this)
//                        .asGif()
                        .load(url)
                        .override(60, 60)
                        .apply(bitmapTransform(grayscaleTransformation)))
                .apply(bitmapTransform(grayscaleTransformation))
//                .transition(withCrossFade(500))
//                .skipMemoryCache(true)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .listener(object : RequestListener<Drawable> {
//                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
////                        progressBar.visibility = View.GONE
//                        return false
//                    }
//
//                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
////                        progressBar.visibility = View.GONE
//                        return false
//                    }
//                })
//                .into(iv)

//        iv.load(url,R.mipmap.ic_launcher,0) { isComplete, percentage, bytesRead, totalBytes ->
//            if (isComplete) {
//                progress.visibility = View.GONE
//            } else {
//                progress.visibility = View.VISIBLE
//                progress.progress = percentage
//            }
//        }

//        iv.imageLoader.listener(url) { isComplete, percentage, bytesRead, totalBytes ->
//            if (isComplete) {
//                progress.visibility = View.GONE
//            } else {
//                progress.visibility = View.VISIBLE
//                progress.progress = percentage
//            }
//        }
//                .glideRequest.diskCacheStrategy(DiskCacheStrategy.NONE)
//                .skipMemoryCache(true)
//                .load(url)
//                .into(iv)

        val load = ImageLoader.create(iv)
                .listener(url) { isComplete, percentage, bytesRead, totalBytes ->
                    if (isComplete) {
                        progress.visibility = View.GONE
                        Log.e("tag", "progress:$percentage")
                    } else {
                        progress.visibility = View.VISIBLE
                        progress.progress = percentage
                        Log.e("tag", "progress:$percentage")
                    }
                }

                .glideRequest
//                .load(url,R.mipmap.ic_launcher,grayscaleTransformation)
                .thumbnail(Glide.with(this)
                        .load(url)
                        .override(60, 60)
                        .apply(bitmapTransform(grayscaleTransformation)))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(false)
                .transition(withCrossFade(500))
    }
}
