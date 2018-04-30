package e.brainplow.admindoctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPharmacy extends AppCompatActivity {


    EditText phrname, pharad, pharcont;
    Button upload;
    private DatabaseReference mDatabase;
// ...


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pharmacy);

        phrname = (EditText)findViewById(R.id.pharname);
        pharad = (EditText)findViewById(R.id.pharadd);
        pharcont = (EditText)findViewById(R.id.pharcont);
        upload = (Button) findViewById(R.id.ButtonUplophardata);



        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nam = phrname.getText().toString().trim();
                String add = pharad.getText().toString().trim();
                String con = pharcont.getText().toString().trim();

                if (phrname.getText().toString().trim().equalsIgnoreCase("")) {
                    phrname.setError("Please Enter Pharmacy Name");
                    return;
                }
                if (pharad.getText().toString().trim().equalsIgnoreCase("")) {
                    pharad.setError("Please enter Pharmacy Address");
                    return;
                }
                if (pharcont.getText().toString().trim().equalsIgnoreCase("")) {
                    pharcont.setError("Please Enter Pharmacy Contact Details");
                    return;
                }

                mDatabase = FirebaseDatabase.getInstance().getReference("Pharmacy");





                String userId = mDatabase.push().getKey();

                Pharmacy user = new Pharmacy(nam, add, con);

                phrname.setText("");
                pharad.setText("");
                pharcont.setText("");

                Toast.makeText(getApplicationContext(), "Pharmacy Data Uploaded Successfully", Toast.LENGTH_LONG).show();

                mDatabase.child(userId).setValue(user);




            }
        });



    }


}
