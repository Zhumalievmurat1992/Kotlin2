package kg.geektech.kotlin2.extension

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import java.util.*

fun Context.urlValidation(uri: String): Boolean {
    if (isUri(Uri.parse(uri)).equals("image")) {
        return true
    }
    return false


}


fun Context.isUri(uri: Uri): String? {
    val img: String? = if (ContentResolver.SCHEME_CONTENT == uri.scheme) {
        val controlR: ContentResolver = this.contentResolver
        controlR.getType(uri)

    } else {
        val extention = MimeTypeMap.getFileExtensionFromUrl(
            uri.toString()
        )
        MimeTypeMap.getSingleton().getMimeTypeFromExtension(
            extention.lowercase(Locale.ENGLISH)
        )
    }

        val imageArray = img?.split("/")?.toTypedArray()
    if (!imageArray.isNullOrEmpty()){
        return imageArray[0]
    }
    return null
}

