package xin.zhuyao.wechat_app.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import xin.zhuyao.wechat_app.entity.SampleSign;
import xin.zhuyao.wechat_app.repository.SampleSignRepository;
import xin.zhuyao.wechat_app.service.SampleSignService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zy
 * @Date: 2019/4/2 16:28
 * @Version 1.0
 * @Description
 */
@Service
public class SampleSignServiceImpl implements SampleSignService {

    @Autowired
    private SampleSignRepository sampleSignRepository;


    @Override
    public List<SampleSign> findAllByUserName(String uesrName) {
        return sampleSignRepository.findAllByUserName(uesrName).stream().sorted(Comparator.comparing(SampleSign::getCreateDate).reversed()).collect(Collectors.toList());
    }

    @Override
    public List<SampleSign> findAllByUserNameAndSelectDate(String uesrName, LocalDate now) {
        return sampleSignRepository.findAllByUserNameAndSelectDate(uesrName,now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    @Override
    public List<SampleSign> findAllByUserNameAndStatus(String uesrName, int status) {
        return sampleSignRepository.findAllByUserNameAndStatus(uesrName,status);
    }

    @Override
    public Object submitMessage(String listData) {
        List<SampleSign> sampleSignList = JSONObject.parseArray(listData, SampleSign.class);
        for (SampleSign sampleSign : sampleSignList) {
            sampleSign.setStatus(1);
        }
        return sampleSignRepository.saveAll(sampleSignList);
    }
}
