package JavaSEObser;

import Observer.IWatcher;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by SHI on 2017/3/13.
 * 警察
 */
public class Police_SE implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Transporter_SE){
            System.out.println("运输车有行动，警察护航，运输车新状态编码为"+((Transporter_SE)o).getState());
        }
    }
}
