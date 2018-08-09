package krunal.com.example.usersessionmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NextActivity extends AppCompatActivity {

    private Button mLogout;

    private SessionManagement mSessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        mSessionManagement = new SessionManagement(getApplication());

        mLogout = findViewById(R.id.buttonLogout);

        mLogout.setOnClickListener(v -> {
            mSessionManagement.EditLogin(false);
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });

    }
}
