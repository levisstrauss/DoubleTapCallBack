package edu.psu.jjb24.callbackexamplebutton;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class DoubleTapButton extends AppCompatButton{

    public interface OnDoubleTapListener{
        void onDoubleTap(long elapsed);
    }

    private long mLastClickTime = 0;
    private static final long DOUBLE_TAP_MAX_INTERVAL = 1000;
    private OnDoubleTapListener listener;

    public DoubleTapButton(@NonNull Context context) {
        super(context);
    }

    public DoubleTapButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DoubleTapButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnDoubleTapListener(OnDoubleTapListener listener){
        this.listener = listener;
    }
    @Override
    public boolean callOnClick() {
        if (SystemClock.elapsedRealtime() - mLastClickTime > DOUBLE_TAP_MAX_INTERVAL) {
            mLastClickTime = SystemClock.elapsedRealtime();
            return super.callOnClick();
        }
        else {
            if(listener != null){
                listener.onDoubleTap(SystemClock.elapsedRealtime() - mLastClickTime);
            }
            mLastClickTime = 0;
            return true;
        }
    }

    @Override
    public boolean performClick() {
        if (SystemClock.elapsedRealtime() - mLastClickTime > DOUBLE_TAP_MAX_INTERVAL) {
            mLastClickTime = SystemClock.elapsedRealtime();
            return super.performClick();
        }
        else {
            if (this.listener != null){
                listener.onDoubleTap(SystemClock.elapsedRealtime() - mLastClickTime);
            }
            mLastClickTime = 0;
            return true;
        }
    }

}
