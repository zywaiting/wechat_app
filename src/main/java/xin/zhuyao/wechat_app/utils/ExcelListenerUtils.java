package xin.zhuyao.wechat_app.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/* 解析监听器，
 * 每解析一行会回调invoke()方法。
 * 整个excel解析结束会执行doAfterAllAnalysed()方法
 *
 * 下面只是我写的一个样例而已，可以根据自己的逻辑修改该类。
 */
@Slf4j
@Getter
public class ExcelListenerUtils extends AnalysisEventListener {

    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<Object> datas = new ArrayList<Object>();
    public void invoke(Object object, AnalysisContext context) {
//        log.info("当前行：{}",context.getCurrentRowNum());
//        log.info("object：{}",object);
        datas.add(object);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
        doSomething(object);//根据自己业务做处理
    }
    private void doSomething(Object object) {
//        System.out.println(object.toString());
//        String[] split = object.toString().split(",");
        //1、入库调用接口
    }
    public void doAfterAllAnalysed(AnalysisContext context) {
        // datas.clear();//解析结束销毁不用的资源
    }
}
