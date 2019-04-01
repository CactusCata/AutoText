package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AutoTextController {

	private int clickPlusAmount = 0;
	
	@FXML
	private TextField text_0, text_1, text_2, text_3, text_4, text_5, key_0, key_1, key_2, key_3, key_4, key_5;
	@FXML
	private Button plus_0, plus_1, plus_2, plus_3, plus_4, minus_0, minus_1, minus_2, minus_3, minus_4;
	
	@FXML
	public void click(MouseEvent event) {
		TextField[] texts = {text_0, text_1, text_2, text_3, text_4, text_5};
		TextField[] keys = {key_0, key_1, key_2, key_3, key_4, key_5};
		Button[] plus = {plus_0, plus_1, plus_2, plus_3};
		Button[] minus = {minus_0, minus_1, minus_2, minus_3};
		String idButton = ((Button)event.getSource()).getId();
		if(idButton.startsWith("plus")) {
			if(clickPlusAmount <= 4) {
				clickPlusAmount++;
				texts[clickPlusAmount].setVisible(true);
				keys[clickPlusAmount].setVisible(true);
				minus[clickPlusAmount - 1].setVisible(true);
				plus[clickPlusAmount].setVisible(true);
			}
		} else {
			int minusCount = Integer.valueOf(idButton.replaceAll("\\D", ""));
			for(int i = minusCount; i < clickPlusAmount; i++) {
				texts[i].setText(texts[i + 1].getText());
				keys[i].setText(keys[i + 1].getText());
			}
			texts[clickPlusAmount].setText("");
			texts[clickPlusAmount].setVisible(false);
			keys[clickPlusAmount].setText("");
			keys[clickPlusAmount].setVisible(false);
			plus[clickPlusAmount].setVisible(false);
			plus[clickPlusAmount - 1].setVisible(true);
			minus[clickPlusAmount - 1].setVisible(false);
			clickPlusAmount--;
		}
	}
	
}
