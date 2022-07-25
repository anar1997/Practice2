package Main;

import bean.Config;
import util.Menu;
import util.MenuUtil;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Config.initialize();
        MenuUtil.showMenu();

    }

}
