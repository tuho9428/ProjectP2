module ProjectPhareII {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.naming;

	opens application to javafx.graphics, javafx.fxml;
}
