package pl.ozodbek.viewpager2fragmentspractice.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T) =
    lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater.invoke(layoutInflater)
    }


inline fun <reified T : ViewBinding> ViewGroup.viewBinding(
    crossinline inflate: (LayoutInflater, ViewGroup, Boolean) -> T,
): T {
    return inflate(LayoutInflater.from(context), this, false)
}


fun <T : ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T) =
    FragmentViewBindingDelegate(this, viewBindingFactory)
