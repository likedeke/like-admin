package cn.like.code.server.business.user.service.impl;

import cn.like.code.server.business.user.convert.UserConvert;
import cn.like.code.server.business.user.entity.UserEntity;
import cn.like.code.server.business.user.mapper.UserMapper;
import cn.like.code.server.business.user.pojo.dto.UserDTO;
import cn.like.code.server.business.user.pojo.query.UserQuery;
import cn.like.code.server.business.user.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sika.code.standard.base.convert.BaseConvert;
import com.sika.code.standard.base.service.impl.BaseStandardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author like @email:980650920@qq.com
 * @since 2021-05-15 07:37:04
 */
@Service(value = "userService")
public class UserServiceImpl extends BaseStandardServiceImpl<UserMapper, UserEntity, UserDTO> implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    protected BaseConvert<UserEntity, UserDTO> convert() {
        return UserConvert.INSTANCE;
    }

    @Override
    public boolean checkUserInfo(UserDTO userDTO) {
        return baseMapper.selectCount(Wrappers.<UserEntity>lambdaQuery()
                .eq(UserEntity::getUsername, userDTO.getUsername())
                .or()
                .eq(UserEntity::getPhone, userDTO.getPhone())
                .or()
                .eq(UserEntity::getEmail, userDTO.getEmail())) == 0;
    }

    @Override
    public Integer updateSelectiveById(UserQuery dtoToQuery) {
        return userMapper.updateSelectiveById(dtoToQuery);
    }
}

