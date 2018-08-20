package cn.shuyiio.springequinox.service.v2;

import cn.shuyiio.springequinox.dao.AccountDao;
import cn.shuyiio.springequinox.dao.ItemDao;

/**
 * @author zhoushuyi
 * @since 2018/8/18
 */
public class PetPostSerivce2 {

    private AccountDao accountDao;
    private ItemDao itemDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }
}
