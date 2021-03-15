package h_transaction._1.boardcast.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//1. 七种事务的传播行为

/**2. 事务的隔离级别
 * 事务之间具有隔离的特性，使多个事务之间不产生影响
 * 不考虑隔离性，多个事务之间会引发以下问题：
 * 1）脏读：一个未提交的事务，读取到了另一个未提交的事务中的数据。如两个事务对同一个数据做修改。会导致修改的结果与预期的不一致
 * 2）不可重复读：一个未提交的事务，读取到了另一个已经提交事务后的数据，导致未提交的事务每次读取的结果都不一样
 * 3）虚读：一个未提交的事务，读到了另一个已经提交的事务中添加的数据
 *
 * 事务的隔离级别：
 *                              脏读  不可重复读   幻读
 * READ_UNCOMMITTED(读未提交)     有      有       有
 * READ_COMMITTED(读已提交)       无      有       有
 * REPEATABLE_READ(可重复读)      无      无       有
 * SERIALIZABLE(串行化)           无      无       无
 * */
@Transactional(
        //不设置的话，默认是？？？
        propagation = Propagation.REQUIRED,
        //不设置的话，默认是REPEATABLE_READ
        isolation = Isolation.REPEATABLE_READ,
        //以s为单位，不设置为-1
        timeout = -1,
        //是否只读，默认是false，表示可以增删改查，true只可以读
        readOnly = true,
        //设置出现哪些异常，进行事务的回滚
        rollbackFor = NullPointerException.class,
        //设置出现那些异常，不进行回滚
        noRollbackFor = NumberFormatException.class
)
public class UserService {

}
