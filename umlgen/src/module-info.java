module org.example.umlgen {
    requires javafx.controls;
//    requires javafx.fxml;


    opens umlgen to javafx.controls;
    exports umlgen;
    exports umlgen.vue;
    opens umlgen.vue to javafx.controls;
    exports umlgen.test;
    opens umlgen.test to javafx.controls;
}