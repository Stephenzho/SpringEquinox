package cn.shuyiio.springequinox.service.v2;

import cn.shuyiio.springequinox.dao.AccountDao;
import cn.shuyiio.springequinox.dao.ItemDao;

/**
 * @author zhoushuyi
 * @since 2018/8/18
 */
public class PetPostService2 {

    private AccountDao accountDao;
    private ItemDao itemDao;
    private String name;

    private int version;


    public PetPostService2(AccountDao accountDao, ItemDao itemDao, String name, int version) {
        this.accountDao = accountDao;
        this.itemDao = itemDao;
        this.name = name;
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
