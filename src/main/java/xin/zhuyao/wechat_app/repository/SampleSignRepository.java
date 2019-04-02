package xin.zhuyao.wechat_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import xin.zhuyao.wechat_app.entity.SampleSign;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: zy
 * @Date: 2019/4/2 12:46
 * @Version 1.0
 * @Description
 */
public interface SampleSignRepository extends JpaRepository<SampleSign, Integer>, JpaSpecificationExecutor<SampleSign> {

    List<SampleSign> findAllByUserName(String uesrName);

    List<SampleSign> findAllByUserNameAndSelectDate(String uesrName, String now);

    List<SampleSign> findAllByUserNameAndStatus(String uesrName, int status);

    List<SampleSign> findAllByStatus(int status);
}
