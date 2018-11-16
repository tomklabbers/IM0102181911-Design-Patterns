package actions;

import java.awt.Toolkit;

public class SystemBeepAction extends ActionDecorator {

	@Override
	public void executeAction() {
		Toolkit.getDefaultToolkit().beep();	
	}

}
