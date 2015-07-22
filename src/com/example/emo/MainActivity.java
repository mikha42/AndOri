package com.example.emo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity implements SensorEventListener {
	  private SensorManager mSensorManager;
	  private Sensor mOri;

	  @Override
	  public final void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	    mOri = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
	    Log.d("Outb","Sensor Activity created");
	  }

	  @Override
	  public final void onAccuracyChanged(Sensor sensor, int accuracy) {
	    // Do something here if sensor accuracy changes.
	  }

	  @Override
	  public final void onSensorChanged(SensorEvent event) {
	    float Orix = event.values[0];
	    float Oriy = event.values[1];
	    float Oriz = event.values[2];
	    TextView outx = (TextView)findViewById(R.id.Infox);
	    TextView outy = (TextView)findViewById(R.id.Infoy);
	    TextView outz = (TextView)findViewById(R.id.Infoz);
	    outx.setText(String.valueOf(Math.round(Orix)));
	    outy.setText(String.valueOf(Math.round(Oriy)));
	    outz.setText(String.valueOf(Math.round(Oriz)));
	  }

	  @Override
	  protected void onResume() {
	    super.onResume();
	    mSensorManager.registerListener(this, mOri, SensorManager.SENSOR_DELAY_NORMAL);
	    Log.d("Outb","Sensor resume");
	  }

	  @Override
	  protected void onPause() {
	    super.onPause();
	    mSensorManager.unregisterListener(this);
	    Log.d("Outb","Sensor Paused");
	  }
	}
