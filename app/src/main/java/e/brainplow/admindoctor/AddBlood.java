package e.brainplow.admindoctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddBlood extends AppCompatActivity {


    EditText phrname;
    Button upload;
    private DatabaseReference mDatabase;
// ...


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_blood);

        phrname = (EditText)findViewById(R.id.pharname);
        upload = (Button) findViewById(R.id.ButtonUplophardata);


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nam = phrname.getText().toString().trim();

                if (phrname.getText().toString().trim().equalsIgnoreCase("")) {
                    phrname.setError("Please Add Blood Description");
                    return;
                }

                mDatabase = FirebaseDatabase.getInstance().getReference("Blood");





                String userId = mDatabase.push().getKey();

                Blood user = new Blood(nam);

                phrname.setText("");


                Toast.makeText(getApplicationContext(), "Blood Data Uploaded Successfully", Toast.LENGTH_LONG).show();
                mDatabase.child(userId).setValue(user);




            }
        });



    }


}
