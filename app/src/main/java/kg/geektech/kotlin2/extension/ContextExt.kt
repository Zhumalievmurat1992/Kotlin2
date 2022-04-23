package kg.geektech.kotlin2.extension

import android.content.Context
import android.widget.Toast

fun Context.showToast(massage: String){
    Toast.makeText(this,massage,Toast.LENGTH_SHORT).show()
}