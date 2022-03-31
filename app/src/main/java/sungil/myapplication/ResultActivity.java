package sungil.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
	Context mContext;
	TextView str_result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		mContext = this;
		str_result = findViewById(R.id.str_result);
		str_result.setText("");

		Intent intent = getIntent();
		if (null != intent) {
			double dAverage = intent.getDoubleExtra("score_average", -1);
//			Toast.makeText(mContext, Double.toString(score_average), Toast.LENGTH_SHORT).show();
			char cHakjum = 'F';

			if (dAverage > 90 && dAverage <= 100) {
				cHakjum = 'A';
			} else if (dAverage > 80 && dAverage <= 90) {
				cHakjum = 'B';
			} else if (dAverage > 70 && dAverage <= 80) {
				cHakjum = 'C';
			} else if (dAverage > 60 && dAverage <= 70) {
				cHakjum = 'D';
			}

			switch (cHakjum) {
				case 'A':
					str_result.setText("A학점입니다\n\"성적 우수상\"\n축하합니다~~!!");
					break;
				case 'B':
					str_result.setText("B학점입니다\n\"장려상\"");
					break;
				default:
					str_result.setText(cHakjum+"학점입니다\n\"격려상\"");
					break;
			}
		}
	}
}