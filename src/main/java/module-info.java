module com.example.roydeshaandtwylablackjack {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.roydeshaandtwylablackjack to javafx.fxml;
    exports com.example.roydeshaandtwylablackjack;
}