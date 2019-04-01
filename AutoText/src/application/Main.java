package application;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	private static Parent root;

	@Override
	public void start(Stage primaryStage) {
		try {
			root = FXMLLoader.load(super.getClass().getResource("/AutoText.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("AutoText");
			primaryStage.setResizable(false);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/res/icon.jpg")));
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Node> addAllGroup(int id) {
		List<Node> nodes = new ArrayList<>();
		for (Node node : root.getChildrenUnmodifiable()) {
			if (node.getId().contains(Integer.toString(id))) nodes.add(node);
		}
		return nodes;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
