package viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import model.AirplaneModeModel;

public class AirplaneViewModel extends ViewModel {
/**/
    private final MutableLiveData<AirplaneModeModel> airplaneMode = new MutableLiveData<>();

    public LiveData<AirplaneModeModel> getAirplaneMode() {
        return airplaneMode;
    }

    public void setAirplaneMode(boolean enabled) {
        airplaneMode.setValue(new AirplaneModeModel(enabled));
    }
}
