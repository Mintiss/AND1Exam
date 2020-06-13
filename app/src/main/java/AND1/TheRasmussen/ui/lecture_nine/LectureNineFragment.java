package AND1.TheRasmussen.ui.lecture_nine;

import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import AND1.TheRasmussen.R;

public class LectureNineFragment extends Fragment implements View.OnClickListener {

    private View view;
    private EditText registerEmail, registerPassword, registerConfirmPassword, loginEmail, loginPassword;
    private Button loginButton, registerButton, logOutButton;
    private TextView profileUserId, profileEmail, isLoggedin;
    private FirebaseAuth auth;

    public static LectureNineFragment newInstance() {
        return new LectureNineFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lecture_nine, container, false);

        registerButton = view.findViewById(R.id.lecture_nine_register_button);
        loginButton = view.findViewById(R.id.lecture_nine_login_button);
        logOutButton = view.findViewById(R.id.lecture_nine_profile_logout_button);

        registerButton.setOnClickListener(this);
        logOutButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);

        registerEmail = view.findViewById(R.id.lecture_nine_register_email);
        registerPassword = view.findViewById(R.id.lecture_nine_register_password);
        registerConfirmPassword = view.findViewById(R.id.lecture_nine_register_password_confirm);
        loginEmail = view.findViewById(R.id.lecture_nine_login_email);
        loginPassword = view.findViewById(R.id.lecture_nine_login_password);

        profileEmail = view.findViewById(R.id.lecture_nine_profile_user_email);
        profileUserId = view.findViewById(R.id.lecture_nine_profile_user_id);
        isLoggedin = view.findViewById(R.id.lecture_nine_profile_logged_in);

        auth = FirebaseAuth.getInstance();

        if(auth.getCurrentUser() != null)
        {
            profileUserId.setText(auth.getUid());
            profileEmail.setText(auth.getCurrentUser().getEmail());
            isLoggedin.setText("Yes");
            Toast.makeText(getContext(), "Logged in Automatically", Toast.LENGTH_SHORT).show();
        }
        else {
            profileUserId.setText("None");
            profileEmail.setText("None");
            isLoggedin.setText("No");
        }

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lecture_nine_register_button:
                final String email = registerEmail.getText().toString(), password = registerPassword.getText().toString(), confirmPass = registerConfirmPassword.getText().toString();
                if((email == null || email.equals("")) || (password == null || password.equals("")) || (confirmPass == null || confirmPass.equals(""))){
                    Toast.makeText(getContext(), "Cannot have empty fields", Toast.LENGTH_SHORT).show();
                    break;
                }
                else if(!password.equals(confirmPass)){
                    Toast.makeText(getContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                    break;
                }
                else if (password.length() < 8){
                    Toast.makeText(getContext(), "Password minimum length is 8 characters", Toast.LENGTH_SHORT).show();
                    break;
                }
                else if (!email.contains("@")){
                    Toast.makeText(getContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
                    break;
                }
                else {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getContext(), "User Created", Toast.LENGTH_SHORT).show();
                                profileEmail.setText(email);
                                profileUserId.setText(auth.getUid());
                                isLoggedin.setText("Yes");
                                registerEmail.setText("");
                                registerConfirmPassword.setText("");
                                registerConfirmPassword.setText("");
                                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                            }
                            else
                                Toast.makeText(getContext(), "Error:" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                break;
            case R.id.lecture_nine_login_button:
                if(loginPassword.getText().toString().equals("") || loginEmail.getText().toString().equals(""))
                    Toast.makeText(getContext(), "Cannot have empty fields", Toast.LENGTH_SHORT).show();
                else {
                    auth.signInWithEmailAndPassword(loginEmail.getText().toString(), loginPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getContext(), "Logged in", Toast.LENGTH_SHORT).show();
                                profileUserId.setText(auth.getUid());
                                profileEmail.setText(loginEmail.getText().toString());
                                isLoggedin.setText("Yes");
                                loginEmail.setText("");
                                loginPassword.setText("");
                                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                            }
                        }
                    });
                }
                break;
            case R.id.lecture_nine_profile_logout_button:
                if(auth.getCurrentUser() != null){
                    FirebaseAuth.getInstance().signOut();
                    profileUserId.setText("None");
                    profileEmail.setText("None");
                    isLoggedin.setText("No");
                    Toast.makeText(getContext(), "Logged out", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getContext(), "User not logged in", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
