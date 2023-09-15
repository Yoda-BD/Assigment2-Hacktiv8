package com.example.myapps2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView counterTextView;
    private Button incrementButton;
    private EditText editText;
    private int counter = 0;
    private static final String COUNTER_KEY = "counter_key"; // Key for saving the counter state

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        counterTextView = findViewById(R.id.counterTextView);
        incrementButton = findViewById(R.id.incrementButton);
        editText = findViewById(R.id.editText);

        // Set click listener for the increment button
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment the counter
                counter++;
                // Update the counter TextView
                counterTextView.setText("Counter: " + counter);
            }
        });

        // Check if there's a saved instance state and restore it
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTER_KEY);
            counterTextView.setText("Counter: " + counter);
        }
    }

    // Save the current state of the app when necessary
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_KEY, counter); // Save the counter state
    }
}
