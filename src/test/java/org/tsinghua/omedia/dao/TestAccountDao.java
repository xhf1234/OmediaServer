package org.tsinghua.omedia.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = { "classpath:web-context.xml" })
@SuppressWarnings("unused")
public class TestAccountDao extends AbstractTestNGSpringContextTests {
    private Logger logger = Logger.getLogger(TestAccountDao.class);

    @Autowired
    private AccountDao accountDao;
    
    @Test
    public void testGetAccount() {
//        Account account;
//        try {
//            account = accountDao.getAccount("xhf1234");
//            Assert.assertNotNull(account);
//            logger.info(account.toString());
//        } catch (DbException e) {
//            logger.error("test get account failed!", e);
//            Assert.assertTrue(false);
//        }
    }
    
    @Test
    public void testSearchAccounts() {
//        try {
//            List<Account> list = accountDao.searchAccounts(" �� x sdf");
//            for(Account e:list) {
//                logger.info(e);
//            }
//        } catch (DbException e) {
//            logger.error("test search accounts failed!", e);
//            Assert.assertTrue(false);
//        }
    }
}
