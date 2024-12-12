module org.example.umlgen {
    requires javafx.controls;
//    requires javafx.fxml;


    opens umlgen to javafx.controls;
    exports umlgen;
}