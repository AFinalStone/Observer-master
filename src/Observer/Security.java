package Observer;

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
