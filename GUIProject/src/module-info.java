module GUIProject {
	requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	
	opens hust.soict.dsai.javafx to javafx.graphics, javafx.fxml;

}
