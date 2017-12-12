package com.fanliyan.SpringDataTest;

import com.fanliyan.SpringDataTest.dao.CareRepository;
import com.fanliyan.SpringDataTest.dao.UserRepository;
import com.fanliyan.SpringDataTest.domain.Card;
import com.fanliyan.SpringDataTest.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class oneToOneTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CareRepository careRepository;

    @Test
    public void test() throws Exception{
        careRepository.save(new Card(1, "aaabbbccc"));

        Card card1 = new Card();
        card1.setCardId(1);
        userRepository.save(new User("Test1", 20, card1));

        User user = userRepository.findByName("Test1");
        Card card = user.getCard();
        Assert.assertEquals("aaabbbccc", card.getCardNumber());

        Card care = careRepository.findByCardNumber("aaabbbccc");
        User user_Temp = care.getUser();
        Assert.assertEquals("Test1", user_Temp.getName());

    }
}
