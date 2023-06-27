package org.dog.server.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.dog.server.annotation.DistributedLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Odin
 * @Date: 2023/6/22 02:15
 * @Description:
 */

@Component
@Slf4j
public class ScheduledTask {

    @DistributedLock
    // cron表达式,来控制定时执行时间,这里是每5秒执行一次本方法,业务逻辑可以进行在此方法内进行书写
    @Scheduled(cron = "0/5 * * * * ?")
    public void task01() throws InterruptedException {
        Thread.sleep(15000);
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        log.error("{} - 定时任务执行啦",sdf.format(new Date()));
    }
}
