package com.xiaolan.glidedemo

import android.graphics.Color
import android.graphics.PointF
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import jp.wasabeef.glide.transformations.*
import jp.wasabeef.glide.transformations.gpu.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
        Glide.with(this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551699797871&di=e7b8956e495da82353ee9cdbf1618b51&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201403%2F18%2F20140318161736_eiheB.jpeg")
                .placeholder(R.mipmap.wd_head)
                .apply(bitmapTransform(vignetteFilterTransformation))
                .transition(withCrossFade(2000))
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(iv)
    }
}
