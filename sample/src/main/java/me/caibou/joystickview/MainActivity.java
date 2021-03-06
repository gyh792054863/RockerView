package me.caibou.joystickview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import me.caibou.rockerview.DirectionView;
import me.caibou.rockerview.JoystickView;

public class MainActivity extends AppCompatActivity {

    private TextView tvAngle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvAngle = findViewById(R.id.tv_angle);

        JoystickView joystickView = findViewById(R.id.joystick_control);
        joystickView.setAngleUpdateListener(new JoystickView.OnAngleUpdateListener() {
            @Override
            public void onAngleUpdate(double angle, int action) {
                if (action == JoystickView.ACTION_RELEASE){
                    tvAngle.setText("");
                } else {
                    tvAngle.setText(getString(R.string.angle, angle));
                }
            }
        });

        DirectionView directionView = findViewById(R.id.direct_control);
        directionView.setDirectionChangeListener(new DirectionView.DirectionChangeListener() {
            @Override
            public void onDirectChange(DirectionView.Direction direction) {
                tvAngle.setText(direction.toString());
            }
        });
    }
}
