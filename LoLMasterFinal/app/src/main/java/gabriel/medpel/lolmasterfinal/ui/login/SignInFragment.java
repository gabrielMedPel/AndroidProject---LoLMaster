package gabriel.medpel.lolmasterfinal.ui.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import gabriel.medpel.lolmasterfinal.R;
import gabriel.medpel.lolmasterfinal.models.User;

public class SignInFragment extends Fragment {

    Button btnRegister;
    EditText etName, etEmailSign,etPasswordSign;

    FirebaseAuth auth;
    DatabaseReference myReff;

    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        auth = FirebaseAuth.getInstance();
        myReff = FirebaseDatabase.getInstance().getReference();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sing_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnRegister = view.findViewById(R.id.btnRegister);
        etName = view.findViewById(R.id.etName);
        etEmailSign = view.findViewById(R.id.etEmailSign);
        etPasswordSign = view.findViewById(R.id.etPasswordSign);


        btnRegister.setOnClickListener(v -> {
            if (etEmailSign.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "You must type the e-mail.", Toast.LENGTH_SHORT).show();
            }else if (etPasswordSign.getText().toString().length() < 6){
                Toast.makeText(getContext(), "Password must have at least 6 digits.", Toast.LENGTH_SHORT).show();
            }else if (etName.getText().toString().isEmpty()) {
                Toast.makeText(getContext(), "Please Tell us your name !.", Toast.LENGTH_SHORT).show();
            }else {
                auth.createUserWithEmailAndPassword(etEmailSign.getText().toString(),etPasswordSign.getText().toString())
                        .addOnCompleteListener(getActivity(), task -> {
                            if (task.isSuccessful()){
                                Toast.makeText(getContext(), "Successfully Registered", Toast.LENGTH_LONG).show();

                                User user = new User(etName.getText().toString(),etEmailSign.getText().toString());

                                myReff.child("users").child(auth.getCurrentUser().getUid()).setValue(user);

                                getFragmentManager().popBackStack();
                            }else{
                                Toast.makeText(getContext(), "Registration Failed! Try Again", Toast.LENGTH_LONG).show();
                            }
                        });
            }

        });
    }
}