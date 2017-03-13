package JavaSEObser;

import Observer.IWatcher;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by SHI on 2017/3/13.
 * 强盗
 */
public class Thief_SE implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Transporter_SE) {
            System.out.println("运输车有行动，强盗准备动手，运输车新状态编码为"+((Transporter_SE)o).getState());
        }
    }
}
