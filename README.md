####应用
珠宝商运送一批钻石，有黄金强盗准备抢劫，珠宝商雇佣了私人保镖，警察局也派人护送，于是当运输车上路的时候，强盗保镖警察都要观察运输车一举一动，
抽象的观察者
```java

/**
 * Created by SHI on 2017/3/10._````_
 * 抽象的观察者
 */
public interface IWatcher
{
    public void update();
}

```
抽象的被观察者，在其中声明方法（添加、移除观察者，通知观察者）：
```java

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

```

具体的观察者
保镖
```java
/**
 * Created by SHI on 2017/3/10.
 * 保镖
 */
public class Security implements IWatcher {

    @Override
    public void update() {
        System.out.println("运输车有行动，保安贴身保护");
    }

}
```
强盗
```java
/**
 * Created by SHI on 2017/3/10.
 * 强盗
 */
public class Thief implements IWatcher {

    @Override
    public void update() {
        System.out.println("运输车有行动，强盗准备动手");
    }

}
```
警察
```java
/**
 * Created by SHI on 2017/3/10.
 * 警察
 */
public class Police implements IWatcher {

    @Override
    public void update() {
        System.out.println("运输车有行动，警察护航");

    }

}
```
具体的被观察者
运输车
```java
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
```
测试类
```java
public class Main {

    public static void main(String[] args) {

        Transporter transporter = new Transporter();

        Police police = new Police();
        Security security = new Security();
        Thief thief = new Thief();

        transporter.addWatcher(police);
        transporter.addWatcher(security);
        transporter.addWatcher(security);

        transporter.notifyWatchers();

    }
}
```
```输出结果
输出结果：
我是运输车，我有行动，大家请注意
运输车有行动，警察护航
运输车有行动，保安贴身保护
运输车有行动，保安贴身保护
```
