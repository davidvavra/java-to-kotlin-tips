package me.vavra.javatokotlintips

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import java.util.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    private lateinit var mModel: Model
    private var mGitHubUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mModel = loadData()
        updateBottomText()
        findViewById(R.id.vFab).setOnClickListener {
            showData()
            mGitHubUrl = "github.com/davidvavra/java-to-kotlin-tips"
            updateBottomText()
            if (checkNotNull(mGitHubUrl, {"Github URL is empty"}).length > 2) {
                vBottomText.setTextColor(Color.BLUE)
            }
            info("Button pressed")
            alert("Good?") {
                positiveButton("Yep") {
                    toast("Great!")
                }
                negativeButton("Nope") {
                    email("david@vavra.me", "Send feedback")
                }
            }.show()
        }
    }

    private fun loadData(): Model {
        return Model("David Vávra", ArrayList(Arrays.asList(
                "Founder & CEO at Step Up Labs",
                "Android lead of Settle Up",
                "Google Developer Expert for Android",
                "Organizer of GDG Prague and DevFest Prague"
        )), "twitter.com/vavradav", "medium.com/@david.vavra")
    }

    private fun showData() {
        vName.text = mModel.name
        mModel.titles?.let {
            vTitles.removeAllViews()
            for (title in it) {
                val textView = TextView(this)
                textView.text = title
                vTitles.addView(textView)
            }
        }
        vLogo.show()
        ifNotNull(mModel.twitter, mModel.medium) {
            twitter, medium ->
            vTwitter.text = twitter.toLowerCase()
            vMedium.text = medium.toLowerCase()
        }
    }

    private fun updateBottomText() {
        vBottomText.text = mGitHubUrl ?: "Push the button"
    }
}
