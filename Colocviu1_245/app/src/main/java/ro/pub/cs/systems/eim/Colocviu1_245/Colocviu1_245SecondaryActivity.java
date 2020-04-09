package ro.pub.cs.systems.eim.Colocviu1_245;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


public class Colocviu1_245SecondaryActivity extends AppCompatActivity {

    public int sum(String receive) {
        String temp = receive.replace("+","");
        int sum = 0;
        if (temp.equals("")) {
            return 0;
        }
        else {
            for (int i = 0; i < receive.length(); ++i) {
                if (Character.toString(receive.charAt(i)).matches("[0-9?]")) {
                    sum += Character.getNumericValue(receive.charAt(i));
                }
            }
        }
        return sum;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_colocviu1_245_secondary);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.ALL_TERMS)) {
            String allTerms = intent.getStringExtra(Constants.ALL_TERMS);
            System.out.println("TERMS = " + allTerms);
            int sum = sum(allTerms);
            setResult(sum, intent);
            finish();
        }
    }
}
