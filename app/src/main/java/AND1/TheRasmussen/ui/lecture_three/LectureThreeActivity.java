package AND1.TheRasmussen.ui.lecture_three;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import AND1.TheRasmussen.R;

public class LectureThreeActivity extends AppCompatActivity {

    private TextView receivedTextView;
    private EditText emailAddress, emailSubject, emailBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lecture_three_activity);

        receivedTextView = findViewById(R.id.lecture_three_received_text);
        emailAddress = findViewById(R.id.lecture_three_email_address);
        emailSubject = findViewById(R.id.lecture_three_email_subject);
        emailBody = findViewById(R.id.lecture_three_email_body);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.containsKey("text")) {
            String newText = bundle.getString("text");
            receivedTextView.setText(newText);
        }

        setTitle("Lecture Three Activity");
    }


    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, emailAddress.getText().toString());
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, emailBody.getText().toString());
        startActivity(intent);
    }
}
