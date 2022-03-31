package sungil.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	Context mContext;
	EditText score_korean, score_english, score_math, score_history;
	Button btn_average, btn_result;
	TextView score_average;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();

		btn_average.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getAverage();
			}
		});

		btn_result.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (getAverage()) {
					Intent intent = new Intent(mContext, ResultActivity.class);
					intent.putExtra("score_average", Double.parseDouble(score_average.getText().toString()));
					mContext.startActivity(intent);
				}
			}
		});
	}

	private void initViews() {
		mContext = this;
		score_korean = findViewById(R.id.score_korean);
		score_english = findViewById(R.id.score_english);
		score_math = findViewById(R.id.score_math);
		score_history = findViewById(R.id.score_history);
		btn_average = findViewById(R.id.btn_average);
		score_average = findViewById(R.id.score_average);
		btn_result = findViewById(R.id.btn_result);
		score_average.setText("");
	}

	public boolean getAverage() {
		if (
				score_korean.getText().toString().equals("")
						|| score_english.getText().toString().equals("")
						|| score_math.getText().toString().equals("")
						|| score_history.getText().toString().equals("")
		) {
			Toast.makeText(mContext, "모든 값을 입력해주세요~!", Toast.LENGTH_SHORT).show();
			return false;
		}
		double dAverage = (
				Integer.parseInt(score_korean.getText().toString())
						+ Integer.parseInt(score_english.getText().toString())
						+ Integer.parseInt(score_math.getText().toString())
						+ Integer.parseInt(score_history.getText().toString())
		) / 4.0;
		score_average.setText(Double.toString(dAverage));
		return true;
	}
}