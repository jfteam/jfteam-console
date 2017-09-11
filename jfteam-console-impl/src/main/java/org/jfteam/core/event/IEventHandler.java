package org.jfteam.core.event;

import org.jfteam.core.exception.ApplicationException;

/**
 * Created by fengwenping on 2017/3/15.
 *
 * 事件执行者
 */
public interface IEventHandler<TA extends IEventArgs> {

    void execute(Object sender, TA args) throws ApplicationException;
}
