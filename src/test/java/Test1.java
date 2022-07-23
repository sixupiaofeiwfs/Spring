import com.wfs.config.BeanConfig;
import com.wfs.pojo.*;
import com.wfs.service.CarService;
import com.wfs.service.DogService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");

    /**
     * 示例代码测试创建对象
     */
    @Test
    public void test1() {

        Student student = context.getBean("student", Student.class);

        student.add();
    }


    /**
     * 通过set方法实现注入属性
     */
    @Test
    public void test2(){
        Student student = context.getBean("student", Student.class);

        System.out.println(student);
    }


    /**
     * 通过有参构造器实现注入属性
     */

    @Test
    public void test3(){
        Grade grade = context.getBean("grade", Grade.class);
        System.out.println(grade);
    }


    /**
     * 注入空值或特殊符号
     */
    @Test
    public void test4(){
        Dog dog = context.getBean("dog", Dog.class);
        System.out.println(dog);
    }

    /**
     * 引用外部bean
     */
    @Test
    public void test5(){
        DogService dogService=context.getBean("dogservice",DogService.class);
        dogService.add();
    }

    /**
     * 引用内部bean  级联赋值可以采用引用外部bean的方式注入
     */
    @Test
    public void test6(){
        Emp emp =context.getBean("emp", Emp.class);
        System.out.println(emp);
    }

    /**
     * 注入array list map 类属性
     */
    @Test
    public void test7(){
        Car car = context.getBean("car", Car.class);
        System.out.println(car);
    }


    /**
     * 演示bean的作用域   默认为singleton 结果如下
     * com.wfs.pojo.Student@7bedc48a
     * com.wfs.pojo.Student@7bedc48a
     * 可以通过配置文件修改 代码如下：
     *  <bean id="student" class="com.wfs.pojo.Student" scope="prototype">
     *  结果如下：
     *  com.wfs.pojo.Student@55b0dcab
     * com.wfs.pojo.Student@38afe297
     */

    @Test
    public void  test8(){
        Student student1 = context.getBean("student", Student.class);
        Student student2 = context.getBean("student", Student.class);
        System.out.println(student1);
        System.out.println(student2);
    }


    /**
     * 演示bean的生命周期  这里仅演示5步  实际上生命周期有7步
     * 第一步：通过无参构造方法创建bean的实例
     * 第二步：调用set方法为属性设置值 和对其他bean的引用
     * 第三步：把bean实例传递给bean后置处理器
     * 第四步：调用bean的初始化方法（需要配置）
     * 第五步：把bean实例传递给bean后置处理器
     * 第六步：获取bean对象
     * 第七步：销毁（需要配置销毁方法）
     */



    //注意：测试时要保证该bean的作用域为singleton   原因如下

    /**
     * 对于单实例的bean，会在创建实例的时候调用init-method，在销毁的时候调用destroy-method
     *
     * 对于多实例的bean，创建的时候每个都会调用init-method,但在销毁的时候，不会调用destroy-method，因为多实例的bean，spring在创建以后，就不再对他们的生命周期负责了
     *
     */
    @Test
    public void test9(){
        ClassPathXmlApplicationContext context1=new ClassPathXmlApplicationContext("bean1.xml");
        Student student = context1.getBean("student", Student.class);
        System.out.println("获取到了student实例");
        context1.close();
    }


    /**
     * 演示自动注入  通过byName的方式自动装配时，类中的属性名一定要与bean的id值一样
     */
    @Test
    public void test10(){
        Glass glass = context.getBean("glass", Glass.class);
        System.out.println(glass);
    }


    /**
     * 演示注解的方式注入对象   必须先引入aop依赖（jar包）  然后必须进行扫描
     */

    @Test
    public void test11(){
        Phone phone = context.getBean("phone", Phone.class);
        System.out.println(phone);
    }


    /**
     * 演示使用注解的方式注入对象类型的属性（@Autowired  @Qu   @Resource） 注入普通属性（@Value）说明如下
     * @Autowired 默认使用的是小写类名的方式注入    本测试方法中，如果有多个实现类实现了CarDao接口，就可以通过@Autowired与 @Qualifier配合使用的方法指定具体的实现类，代码如下：
     * @Component(value = "carDaoImpl")对应实现类1     @Component(value = "carDaoImpl2")对应实现类2
     *
     *
     *    @Autowired
     *     @Qualifier(value = "carDaoImpl2")
     *     private CarDao carDao;
     *     通过上述代码指定实现类2为需要注入的属性
     *
     *
     *  也可以通过@Resource属性直接实现@Autowired与 @Qualifier配合使用所实现的功能
     *  使用@Resource 时必须先导入依赖
     *      <dependency>
     *         <groupId>javax.annotation</groupId>
     *         <artifactId>javax.annotation-api</artifactId>
     *         <version>1.3.2</version>
     *     </dependency>
     *
     * @Resource的使用 属性名时name而不是value 代码如下：
     *   @Resource(name = "carDaoImpl2")
     */
    @Test
    public void test12(){
        CarService carService = context.getBean("carService", CarService.class);
        System.out.println(carService.delete());
    }


    /**
     * 演示完全注解的方式（不再依赖配置文件）+  @Value
     * 首先必须创建一个配置类
     * 测试代码中不再使用 ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
     */

    @Test
    public void test13(){
        ApplicationContext context2=new AnnotationConfigApplicationContext(BeanConfig.class);
        Phone phone = context2.getBean("phone", Phone.class);
        System.out.println(phone);

    }

}