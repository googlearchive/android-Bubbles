package com.example.android.bubbles.ui.photo

import android.os.Bundle
import android.transition.Fade
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import com.example.android.bubbles.R
import com.example.android.bubbles.getNavigationController

/**
 * Shows the specified [DrawableRes] as a full-screen photo.
 */
class PhotoFragment : Fragment() {

    companion object {
        private const val ARG_PHOTO = "photo"

        fun newInstance(@DrawableRes photo: Int) = PhotoFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_PHOTO, photo)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = Fade()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.photo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val photoResId = arguments?.getInt(ARG_PHOTO)
        if (photoResId == null) {
            fragmentManager?.popBackStack()
            return
        }
        getNavigationController().updateAppBar(hidden = true)
        view.findViewById<ImageView>(R.id.photo).setImageResource(photoResId)
    }
}
