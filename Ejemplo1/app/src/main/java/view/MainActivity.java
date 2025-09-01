package view;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.ejemplo1.R;

import receiver.AirplaneReceiver;

import viewmodel.AirplaneViewModel;

public class MainActivity extends AppCompatActivity {

    private TextView tvStatus;
    private AirplaneViewModel viewModel;
    private AirplaneReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = findViewById(R.id.tvStatus);

        viewModel = new ViewModelProvider(this).get(AirplaneViewModel.class);


        receiver = new AirplaneReceiver(viewModel);
        registerReceiver(receiver, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));


        viewModel.getAirplaneMode().observe(this, state -> {
            if (state.isEnabled()) {
                tvStatus.setText("Modo avión ACTIVADO");
            } else {
                tvStatus.setText("Modo avión DESACTIVADO");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}