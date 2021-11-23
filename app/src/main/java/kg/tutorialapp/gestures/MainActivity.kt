package kg.tutorialapp.gestures

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.abs

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener{
    var showTextView :(TextView) = findViewById(R.id.showAction)

    lateinit var gestureDetector: GestureDetector
    var x2:Float = 0.0f
    var x1:Float = 0.0f
    var y2:Float = 0.0f
    var y1:Float = 0.0f

    companion object{
        const val MIN_DISTANCE = 150
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gestureDetector = GestureDetector(this, this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        setContentView(R.layout.activity_main)
        gestureDetector.onTouchEvent(event)

        when (event?.action){
            0->
            {
                x1=event.x
                y1=event.y
            }
            1->
            {
                x2=event.x
                y2=event.y

                val valueX:Float = x2-x1
                val valueY:Float = y2-y1
                if (abs(valueX)> MIN_DISTANCE)
                {
                    if (x2>x1)
                    {
                        showTextView?.setText("Right Swipe")
                    }
                    else
                    {
                        showTextView?.setText("Left Swipe")
                    }
                }
                else if (abs(valueY)> MIN_DISTANCE)
                {
                    if (y2>y1) showTextView?.setText("Bottom swipe")

                    else showTextView?.setText("TOP Swipe")
                }
            }
        }

        return super.onTouchEvent(event)

    }

    override fun onDown(e: MotionEvent?): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    override fun onShowPress(e: MotionEvent?) {
        //TODO("Not yet implemented")
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        //TODO("Not yet implemented")
        return false
    }

    override fun onLongPress(e: MotionEvent?) {
        //TODO("Not yet implemented")
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
       // TODO("Not yet implemented")
        return false
    }
}