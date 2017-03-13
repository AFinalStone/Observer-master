package JavaSEObser;

import Observer.IWatcher;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by SHI on 2017/3/13.
 * 保镖
 */
public class Security_SE implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Transporter_SE) {

            System.out.println("运输车有行动，保安贴身保护，运输车新状态编码为"+((Transporter_SE)o).getState());
        }
    }
}
