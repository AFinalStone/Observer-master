package Subject;

import Observer.IWatcher;

/**
 * Created by SHI on 2017/3/10.
 * 抽象的被观察者，拥有添加，移除，通知观察者的接口
 */
public interface IWatched
{
    public void addWatcher(IWatcher watcher);

    public void removeWatcher(IWatcher watcher);

    public void notifyWatchers();
}