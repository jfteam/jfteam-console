package org.jfteam.console;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fengwenping
 * Date: 2017-08-30
 * Time: 下午9:06
 */
public interface MessageSender {

    Boolean sendMessage(String topic, String message) throws Exception;
}
