package b_ioc.springtest;

public class AutoWiringService {
    public AutoWiringDAO autoWiringDAO;

    public void setAutoWiringDAO(AutoWiringDAO autoWiringDAO) {
        this.autoWiringDAO = autoWiringDAO;
    }

    public void say(String word){
        autoWiringDAO.say(word);
    }
}
