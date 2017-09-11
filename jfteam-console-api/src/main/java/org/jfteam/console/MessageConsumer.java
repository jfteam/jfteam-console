package org.jfteam.console;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fengwenping
 * Date: 2017-08-30
 * Time: 下午10:52
 */
public interface MessageConsumer {

    Boolean execute(String topic) throws Exception;
}
