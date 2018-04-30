package e.brainplow.admindoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Button doc = (Button)findViewById(R.id.doctor);
        Button pharm = (Button)findViewById(R.id.pharmacy);
        Button hosp = (Button)findViewById(R.id.hospital);
        Button Bloo = (Button)findViewById(R.id.blood);

        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this, MainActivity.class));
            }
        });

        pharm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this, AddPharmacy.class));
            }
        });

        hosp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this, AddHospitals.class));
            }
        });


        Bloo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this, AddBlood.class));
            }
        });




    }
}
