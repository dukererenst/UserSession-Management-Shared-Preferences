package krunal.com.example.usersessionmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mLogin;

    private SessionManagement mSessionManagement;

    private EditText mUserId,mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSessionManagement = new SessionManagement(getApplication());

        mLogin = findViewById(R.id.buttonLogin);

        mUserId = findViewById(R.id.editTextUserId);

        mPassword = findViewById(R.id.editTextPassword);

        if (mSessionManagement.isLoginCheck()){
            Intent intent = new Intent(this,NextActivity.class);
            startActivity(intent);
        }

        mLogin.setOnClickListener(v -> {

            String getUserId = mUserId.getText().toString().trim();
            String getPassword = mPassword.getText().toString().trim();

            if (!getUserId.matches("") || !getPassword.matches("")){
                mSessionManagement.EditLogin(true);
                Intent intent = new Intent(this,NextActivity.class);
                startActivity(intent);
                finish();

            }else {
                Toast.makeText(this,"Enter User Id and Passeord!",Toast.LENGTH_LONG).show();
                mUserId.setText("");
                mPassword.setText("");
            }

        });

    }
}
