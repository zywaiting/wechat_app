package xin.zhuyao.wechat_app.service;

import xin.zhuyao.wechat_app.entity.SampleSign;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: zy
 * @Date: 2019/4/2 16:27
 * @Version 1.0
 * @Description
 */
public interface SampleSignService {
    List<SampleSign> findAllByUserName(String uesrName);

    List<SampleSign> findAllByUserNameAndSelectDate(String uesrName, LocalDate now);

    List<SampleSign> findAllByUserNameAndStatus(String uesrName, int status);

    Object submitMessage(String listData);
}
