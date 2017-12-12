package SpringDataTest;

import com.fanliyan.SpringDataTest.Application;
import com.fanliyan.SpringDataTest.SpringData.dao.UserRepository;
import com.fanliyan.SpringDataTest.SpringData.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class exampleTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception{
        userRepository.save(new User("Test1", 10));
        userRepository.save(new User("Test2", 20));
        userRepository.save(new User("Test3", 22));
        userRepository.save(new User("Test4", 25));
        userRepository.save(new User("Test5", 30));


        Assert.assertEquals(5, userRepository.findAll().size());
        Assert.assertEquals(20, userRepository.findByName("Test2").getAge().longValue());
        Assert.assertEquals(22, userRepository.findUser("Test3").getAge().longValue());
        Assert.assertEquals("Test4", userRepository.findByNameAndAge("Test4", 25).getName());
       userRepository.delete(userRepository.findByName("Test5"));

       Assert.assertEquals(4, userRepository.findAll().size());

    }

    @Test
    public void test1() throws Exception{
//        userRepository.save(new User("小张", 18));
//        userRepository.save(new User("小明1", 20));
//        userRepository.save(new User("小明2", 21));
//        userRepository.save(new User("小明3", 22));
//        userRepository.save(new User("小明4", 23));
//        userRepository.save(new User("小明5", 25));
//        userRepository.save(new User("小明6", 24));
//        userRepository.save(new User("小明7", 22));

            User user = new User();
            user.setId(3L);
            user.setName("小南");
            user.setAge(17);
             userRepository.save(user);
         // userRepository.delete(9l);





    }


}
