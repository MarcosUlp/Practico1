package receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import viewmodel.AirplaneViewModel;

public class AirplaneReceiver extends BroadcastReceiver {
/*
Clase especial de android que recibe el evento cuando se cambia el estado del "Modo avion"
en el onReceive se verifica el estado y se actua en consecuencia:
true: solo muestra un mensaje
false: abre la app de llamadas Intent.ACTION_DIAL
 */
    private final AirplaneViewModel viewModel;

    public AirplaneReceiver(AirplaneViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent != null && Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            boolean state = intent.getBooleanExtra("state", false);
            Log.d("AirplaneReceiver", "Modo avión cambiado: " + state);
            viewModel.setAirplaneMode(state);

            if (!state) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:2665034499"));
                dialIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(dialIntent);
            }
        }
    }
}