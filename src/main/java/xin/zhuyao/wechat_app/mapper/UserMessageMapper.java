package xin.zhuyao.wechat_app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xin.zhuyao.wechat_app.entity.UserMessage;

/**
 * 实现用户信息
 */
@Mapper
public interface UserMessageMapper {

    //查询用户是否已经存在
    Integer selectCountUserConfigByOpenId(@Param("openId") String openId);
    //插入用户信息
    Integer insterUserConfig(UserMessage userConfig);
    //补全用户信息
    Integer updateUserConfigByOpenId(UserMessage userConfig);
    //查询用户信息
    UserMessage selectByOpenId(@Param("openId") String openId);

}
