package bombers.view;

import java.io.FileInputStream;
import java.util.List;
import bombers.model.GameMap;
import bombers.model.Player;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class ViewManager {
    GameMap map;
    Scene scene;
    private GraphicsContext gc;
    List<Player> players;

	public ViewManager(GameMap map, List<Player> players) {
		this.map = map;
		this.players = players;
		this.scene = setupScene();
	}
	
	public Scene getScene() {
		return this.scene;
	}
	
	private Scene setupScene() {
		Canvas canvas = new Canvas();
		canvas.setWidth(map.getDimensions().getWidth());
		canvas.setHeight(map.getDimensions().getHeight());
		gc = canvas.getGraphicsContext2D();
		
		for (Tile tile : map.getTiles()) {
			tile.setGraphicsContext(gc);
		};
		
		Pane root = new Pane();
		root.setPrefSize(map.getDimensions().getWidth(), map.getDimensions().getHeight());
		root.getChildren().add(canvas);

		return new Scene(root, map.getDimensions().getWidth(), map.getDimensions().getHeight());
	}
	
	public void repaintAll() {
		for (Tile tile : map.getTiles()) {
			tile.paint();
		}
		for (Player player : players) {
			gc.drawImage(player.getImage(), player.getPosition().getX(), player.getPosition().getY());
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				System.out.print((i % 2 == 1 && j % 2 == 1)? "O" : "F");
			}
			System.out.println();
		}
	}
}
