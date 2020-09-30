module FUN {
    requires javafx.controls;
    requires javafx.fxml;
    requires BackEnd;

    opens FUN to javafx.fxml;
    exports FUN;
}