package Observer;

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
