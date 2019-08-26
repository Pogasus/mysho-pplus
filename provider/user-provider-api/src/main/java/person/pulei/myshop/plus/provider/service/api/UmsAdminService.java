package person.pulei.myshop.plus.provider.service.api;

import person.pulei.myshop.plus.provider.service.domain.UmsAdmin;

/**
 * 用户管理服务
 * @author LeeSa1
 * @date 2019/8/26
 */
public interface UmsAdminService {

    /**
     * 新增用户
     * @author LeeSa1
     * @date 2019/8/26
     */
    int insert(UmsAdmin umsAdmin);

    /**
     * 获取用户
     * @author LeeSa1
     * @date 2019/8/26
     */
    UmsAdmin get(String username);

    /**
     * 获取用户
     * @author LeeSa1
     * @date 2019/8/26
     */
    UmsAdmin get(UmsAdmin umsAdmin);

    /**
     *更新用户
     * @author LeeSa1
     * @date 2019/8/26
     */
    int update(UmsAdmin umsAdmin);

    /**
     * 修改密码
     * @author LeeSa1
     * @date 2019/8/26
     */
    int modifyPassword(String username, String password);



}
