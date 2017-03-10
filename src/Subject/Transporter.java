package Subject;

import Observer.IWatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHI on 2017/3/10.
 * 运输车，具体的被观察者
 */
public class Transporter implements IWatched {

    private List<IWatcher> list = new ArrayList<IWatcher>();

    @Override
    public void addWatcher(IWatcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(IWatcher watcher) {
        list.remove(watcher);
    }

    @Override
    public void notifyWatchers() {
        System.out.println("我是运输车，我有行动，大家请注意");
        for (IWatcher watcher : list)
        {
            watcher.update();
        }
    }
}
