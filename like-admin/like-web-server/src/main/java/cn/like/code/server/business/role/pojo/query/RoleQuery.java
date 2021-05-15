package cn.like.code.server.business.role.pojo.query;

import com.sika.code.standard.base.pojo.query.BaseStandardQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 * 权限表 查询类
 * </p>
 *
 * @author like @email:980650920@qq.com
 * @since 2021-05-15 07:37:04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RoleQuery extends BaseStandardQuery implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 数据表id
     */
    protected Long roleId;
    /**
     * 角色名称
     */
    protected String roleName;
    /**
     * 角色权限字符串
     */
    protected String roleKey;
    /**
     * 显示顺序
     */
    protected Integer roleSort;
    /**
     * id列表
     */
    protected Set<Long> ids;

}

