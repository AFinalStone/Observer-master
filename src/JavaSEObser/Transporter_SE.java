package JavaSEObser;

import Observer.IWatcher;
import Subject.IWatched;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by SHI on 2017/3/13.
 * 运输车，具体的被观察者
 */
public class Transporter_SE extends Observable{

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {

        this.state = state;//目标对象状态发生改变

        setChanged();//表示目标对象已经做了更改

        notifyObservers(state);//通知所有观察者
    }

}
