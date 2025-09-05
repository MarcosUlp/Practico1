package model;
/*
basicamente es un contenedor de estado
por lo general esta clase contiene datos de la aplicacion
 */
public class AirplaneModeModel {
    private boolean enabled;

    public AirplaneModeModel(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
