####一、定义

观察者模式定义了一个一对多的依赖关系，让多个观察者对象同时监听同一个主题对象。
当这个主题状态发生改变时，会通知所有观察者对象，让它们自动更新自己。

####二、类似说明

聊天室程序的创建。服务器创建好后，A、B、C三个客户端连接好公开聊天。A向服务器发送数据，服务器再将数据分别发送给其他在线客户。
也就是说，每个客户端需要更新服务器端的数据。网站上，很多人订阅了“Java主题”的新闻。当有这个主题新闻时，就会将这些新闻发给所有订阅的人。
大家在玩CS游戏时，服务器需要将每个人的方位变化发给所有的客户。

上面这些场景，我们都可以使用观察者模式来处理。
我们可以把多个订阅者、客户称之为观察者；需要同步给多个订阅者的数据封装到对对象中，称之为目标。


####三、模式结构

**1.抽象主题角色(Subject):** 把所有对观察者对象的引用保存在一个集合中，每个抽象主题角色都可以有任意数量的观察者。抽象主题提供一个接口，
可以增加和删除观察者角色，一般用一个抽象类和接口来实现。
                            
**具体主题角色(ConcreteSubject):** 在具体主题内部状态改变时，给所有登记过的观察者发出通知。具体主题角色通常用一个子类实现。

**抽象观察者角色(Observer):** 为所有具体的观察者定义一个接口，在得到主题的通知时更新自己。

**具体观察者角色(ConcreteObserver):** 该角色实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题的状态相协调。
                                      通常用一个子类实现。如果需要，具体观察者角色可以保存一个指向具体主题角色的引用。
                                      
![模式结构图](screen/model_struct.png)              

####四、代码例子
珠宝商运送一批钻石，有黄金强盗准备抢劫，珠宝商雇佣了私人保镖，警察局也派人护送，于是当运输车上路的时候，强盗保镖警察都要观察运输车一举一动，
抽象的观察者
```java

/**
 * Created by SHI on 2017/3/10.
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
开始执行
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

####五、推模式与拉模式

**推模式：** 每次都会把通知以广播的方式发送给所有观察者，所有观察者只能被动接收， 推送的信息通常是主题对象的全部或部分数据 。

**拉模式：** 主题对象在通知观察者的时候，只传递少量信息。如果观察者需要更具体的信息，由观察者主动到主题对象中获取，相当于是观察者从主题
对象中拉数据。一般这种模型的实现中，会把主题对象自身通过update()方法传递给观察者，这样在观察者需要获取数据的时候，就可以通过这个引用来获取了 。

**比较：** 推模式是假定主题对象知道观察者需要的数据；而拉模式是主题对象不知道观察者具体需要什么数据，没有办法的情况下，
干脆把自身传递给观察者，让观察者自己去按需要取值。

####六、使用JavaSE中提供了Java.util.Observable和java.util.Observer来实现观察者模式。


具体的观察者

```java
//警察
public class Police_SE implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Transporter_SE){
            System.out.println("运输车有行动，警察护航，运输车新状态编码为"+((Transporter_SE)o).getState());
        }
    }
}
//保镖
public class Security_SE implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Transporter_SE) {

            System.out.println("运输车有行动，保安贴身保护，运输车新状态编码为"+((Transporter_SE)o).getState());
        }
    }
}
//强盗
public class Thief_SE implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Transporter_SE) {
            System.out.println("运输车有行动，强盗准备动手，运输车新状态编码为"+((Transporter_SE)o).getState());
        }
    }
}
```

具体的被观察者
```java

//运输车，具体的被观察者
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
```
开始执行
```java
public class Main {

    public static void main(String[] args) {

        System.out.println("--------自定义接口观察者模式开始--------");
        Transporter transporter = new Transporter();

        Police police = new Police();
        Security security = new Security();
        Thief thief = new Thief();

        transporter.addWatcher(police);
        transporter.addWatcher(security);
        transporter.addWatcher(security);

        transporter.notifyWatchers();
        System.out.println("--------自定义观察者模式开始--------");
        beginObserverModelByJavaSE();
    }

    private static void beginObserverModelByJavaSE(){
        System.out.println("--------JavaSE接口观察者模式开始--------");

        Transporter_SE transporter_se = new Transporter_SE();

        Police_SE police_se = new Police_SE();
        Security_SE security_se = new Security_SE();
        Thief_SE thief_se = new Thief_SE();

        transporter_se.addObserver(police_se);
        transporter_se.addObserver(security_se);
        transporter_se.addObserver(thief_se);

        transporter_se.setState(100);
        System.out.println("--------JavaSE接口观察者模式开始--------");
    }
}
    
```

```输出结果
--------自定义接口观察者模式开始--------
我是运输车，我有行动，大家请注意
运输车有行动，警察护航
运输车有行动，保安贴身保护
运输车有行动，保安贴身保护
--------自定义观察者模式开始--------
--------JavaSE接口观察者模式开始--------
运输车有行动，强盗准备动手，运输车新状态编码为100
运输车有行动，保安贴身保护，运输车新状态编码为100
运输车有行动，警察护航，运输车新状态编码为100
--------JavaSE接口观察者模式开始--------
```
