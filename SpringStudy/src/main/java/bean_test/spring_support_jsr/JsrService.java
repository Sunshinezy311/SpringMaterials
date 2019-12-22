package bean_test.spring_support_jsr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;


//@Service
@Named
//JSR330中的Named和Compoments以及Service是等价的
public class JsrService {

    //不添加注解会出现空指针异常，因此需要添加Resource注解，注意这个注解是javax.annotation中提供的，需要在maven中配置一下
//    @Resource
//    @Autowired
    //Autowired和JSR250中的javax.annotation的resource是等价的
//    @Inject
    //JSR330中的INject和Resource是等价的
    private JsrDAO jsrDAO;

//    @Resource
    @Inject
    public void setJsrDAO(@Named("jsrDAO") JsrDAO jsrDAO) {
        this.jsrDAO = jsrDAO;
    }

//    public JsrService(JsrDAO jsrDAO) {
//        this.jsrDAO = jsrDAO;
//    }

    @PostConstruct
    public void init(){
        System.out.println("JsrService init!");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("JsrService destroyed!");
    }

    public void save() {
        System.out.println("This is JsrDao, prepare to using JsrDAO");
        jsrDAO.save();

    }
}
