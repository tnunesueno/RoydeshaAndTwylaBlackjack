module com.example.roydeshaandtwylablackjack {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.roydeshaandtwylablackjack to javafx.fxml;
    exports com.example.roydeshaandtwylablackjack;
}