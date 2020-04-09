package ro.pub.cs.systems.eim.Colocviu1_245;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class  Colocviu1_245MainActivity extends AppCompatActivity {
    EditText nextTerm;
    EditText allTerms;
    Button add;
    String tempTerms = "";
    int modified = 0;
    int sum;
    Button compute;
    private AddButtonListener addButtonListener = new AddButtonListener();
    private class AddButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (!nextTerm.getText().toString().equals("")) {
                String temp = allTerms.getText().toString();
                if (allTerms.getText().toString().equals("")) {
                    temp += nextTerm.getText().toString();
                }
                else {
                    temp += " + " + nextTerm.getText().toString();
                }
                allTerms.setText(temp);
            }

        }
    }

    private ComputeButtonListener computeButtonListener = new ComputeButtonListener();
    private class ComputeButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (!tempTerms.equals(allTerms.getText().toString())) {
                Intent intent = new Intent(getApplicationContext(), Colocviu1_245SecondaryActivity.class);
                tempTerms = allTerms.getText().toString();
                String computeTerms = allTerms.getText().toString();
                intent.putExtra(Constants.ALL_TERMS, computeTerms);
                startActivityForResult(intent, 1);
            }
            else {
                printSum();
            }

        }
    }
    public void printSum() {
        Toast.makeText(this, "The activity returned with result without second activity " + sum, Toast.LENGTH_LONG).show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_245_main);
        nextTerm = (EditText)findViewById(R.id.nextTerm);
        allTerms = (EditText)findViewById(R.id.allTerms);
        add = (Button)findViewById(R.id.addButton);
        add.setOnClickListener(addButtonListener);
        compute = (Button) findViewById(R.id.computeButton);
        compute.setOnClickListener(computeButtonListener);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        EditText nextTerm = (EditText)findViewById(R.id.nextTerm);
        EditText allTerms = (EditText)findViewById(R.id.allTerms);
            savedInstanceState.putString(Constants.NEXT_TERM, nextTerm.getText().toString());
            savedInstanceState.putString(Constants.ALL, allTerms.getText().toString());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode,resultCode,intent);
        if (requestCode == 1) {
            sum = resultCode;
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(Constants.NEXT_TERM)) {
            EditText nextTerm = (EditText)findViewById(R.id.nextTerm);
            nextTerm.setText(savedInstanceState.getString(Constants.NEXT_TERM));
        }
        if (savedInstanceState.containsKey(Constants.ALL)) {
            EditText allTerms = (EditText)findViewById(R.id.allTerms);
            allTerms.setText(savedInstanceState.getString(Constants.ALL));
        }
    }
}
