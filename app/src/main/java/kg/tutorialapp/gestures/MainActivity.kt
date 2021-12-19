package kg.tutorialapp.gestures

import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import java.lang.Math.abs

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener{
    private lateinit var showTextView : TextView
    private lateinit var gestureDetector: GestureDetectorCompat

    private var x2:Float = 0.0f
    private var x1:Float = 0.0f
    private var y2:Float = 0.0f
    private var y1:Float = 0.0f

    companion object{
        const val MIN_DISTANCE = 150
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showTextView = findViewById(R.id.showAction)
        gestureDetector = GestureDetectorCompat(this, this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e("MainActivity", "onTouchEvent event= $event")
        return gestureDetector.onTouchEvent(event)

    }

    override fun onDown(e: MotionEvent?): Boolean {
        showTextView.text = "onDown\n x= ${e?.x}, y= ${e?.y}"
        return true
    }

    override fun onShowPress(e: MotionEvent?) {
        showTextView.text = "onShowPress\n x= ${e?.x}, y= ${e?.y}"
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        showTextView.text = "onSingleTapUp\n x= ${e?.x}, y= ${e?.y}"
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        showTextView.text = "onScroll\n e1= ${e1}, \n e2= ${e2}"
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        showTextView.text = "onLongPress\n x= ${e?.x}, y= ${e?.y}"
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        showTextView.text = "onFling\n e1= ${e1}, \n e2= ${e2}"
        return true
    }
}
