package Observer;

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
