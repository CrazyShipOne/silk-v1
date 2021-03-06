package com.spark.bitrade.jobhandler.lock;

import com.spark.bitrade.config.LockConfig;
import com.spark.bitrade.service.ILockDetailService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
  * 解锁节点产品job
  * @author tansitao
  * @time 2018/12/28 13:52 
  */
@JobHandler(value="quantifyUnLockJobHandler")
@Component
public class QuantifyUnLockJobHandler extends IJobHandler {

	@Autowired
	private LockConfig lockConfig;

	@Autowired
	private ILockDetailService lockDetailService;

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		//解锁节点产品活动中满足解锁条件的锁仓记录
		XxlJobLogger.log("======节点产品活动解锁job, 开始解锁======");
		lockDetailService.unlockQuantifyActivity(lockConfig.getUnlockNum());
		XxlJobLogger.log("======节点产品活动解锁job, 解锁完毕======");
		return SUCCESS;
	}

}
