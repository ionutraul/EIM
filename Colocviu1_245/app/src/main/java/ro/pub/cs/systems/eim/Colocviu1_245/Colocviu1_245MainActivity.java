package ro.pub.cs.systems.eim.Colocviu1_245;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class  Colocviu1_245MainActivity extends AppCompatActivity {
    EditText nextTerm;
    EditText allTerms;
    Button add;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_245_main);
        nextTerm = (EditText)findViewById(R.id.nextTerm);
        allTerms = (EditText)findViewById(R.id.allTerms);
        add = (Button)findViewById(R.id.addButton);
        add.setOnClickListener(addButtonListener);
        compute = (Button) findViewById(R.id.computeButton);
    }
}
