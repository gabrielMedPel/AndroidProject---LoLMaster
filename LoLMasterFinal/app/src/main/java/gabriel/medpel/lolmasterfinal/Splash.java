package gabriel.medpel.lolmasterfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import gabriel.medpel.lolmasterfinal.ui.login.LoginActivity;

public class Splash extends AppCompatActivity {

    ImageView ivSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivSplash = findViewById(R.id.ivSplash);

        ivSplash.postDelayed(() -> {
            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
            if(currentUser != null){
                startActivity(new Intent(this, MainScreenActivity.class));
            }else{
                startActivity(new Intent(this, LoginActivity.class));
            }
        }, 3000);

    }
}