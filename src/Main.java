import JavaSEObser.Police_SE;
import JavaSEObser.Security_SE;
import JavaSEObser.Thief_SE;
import JavaSEObser.Transporter_SE;
import Observer.Police;
import Observer.Security;
import Observer.Thief;
import Subject.Transporter;

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
