module com.example.java_lab4fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java_lab4fx to javafx.fxml;
    exports com.example.java_lab4fx;
}