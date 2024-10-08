package br.com.myworkout.ui.training

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import br.com.myworkout.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imgUrl")
fun imgUrl(imgView: ImageView, url: String?){
    url?.let {
        Glide.with(imgView.context)
                .load(it)
                .apply(RequestOptions().placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
                .into(imgView)
    }
}
