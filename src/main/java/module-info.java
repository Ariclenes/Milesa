module com.signcorporation.milesa {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.signcorporation.milesa to javafx.fxml;
    exports com.signcorporation.milesa;
}