import Observer.Police;
import Observer.Security;
import Observer.Thief;
import Subject.Transporter;

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
