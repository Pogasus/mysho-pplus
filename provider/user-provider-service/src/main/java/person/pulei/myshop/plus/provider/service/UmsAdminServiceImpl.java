package person.pulei.myshop.plus.provider.service;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import person.pulei.myshop.plus.provider.mapper.UmsAdminMapper;
import person.pulei.myshop.plus.provider.service.api.UmsAdminService;
import person.pulei.myshop.plus.provider.service.domain.UmsAdmin;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户管理服务
 *
 * @author LeeSa1
 * @date 2019/8/26 15:16
 */
@Service(value = "1.0.0")
public class UmsAdminServiceImpl implements UmsAdminService {

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 用户注册
     * @param umsAdmin
     * @return
     */
    @Override
    public int insert(UmsAdmin umsAdmin) {
        return umsAdminMapper.insert(umsAdmin);
    }

    /**
     * 获取用户
     * @param username
     * @return
     */
    @Override
    public UmsAdmin get(String username) {
        Example example = new Example(UmsAdmin.class);
        example.createCriteria().andEqualTo("username", username);
        UmsAdmin umsAdmin = umsAdminMapper.selectOneByExample(example);
        return umsAdmin;
    }

    /**
     * 获取用户
     * @param umsAdmin
     * @return
     */
    @Override
    public UmsAdmin get(UmsAdmin umsAdmin) {
        return umsAdminMapper.selectOne(umsAdmin);
    }

    /**
     * 修改用户
     * @param umsAdmin
     * @return
     */
    @Override
    public int update(UmsAdmin umsAdmin) {
        UmsAdmin oldAdmin = get(umsAdmin.getUsername());

        oldAdmin.setEmail(umsAdmin.getEmail());
        oldAdmin.setNickName(umsAdmin.getNickName());
        oldAdmin.setNote(umsAdmin.getNote());
        oldAdmin.setStatus(umsAdmin.getStatus());

        return umsAdminMapper.updateByPrimaryKey(oldAdmin);
    }

    /**
     * 修改密码
     * @param username
     * @param password
     * @return
     */
    @Override
    public int modifyPassword(String username, String password) {
        UmsAdmin umsAdmin = get(username);
        umsAdmin.setPassword(passwordEncoder.encode(password));
        return umsAdminMapper.updateByPrimaryKey(umsAdmin);
    }

    /**
     * 初始化用户对象
     *
     * @param umsAdmin {@link UmsAdmin}
     */
    private void initUmsAdmin(UmsAdmin umsAdmin) {
        // 初始化创建时间
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());

        // 初始化状态
        if (umsAdmin.getStatus() == null) {
            umsAdmin.setStatus(0);
        }

        // 密码加密
        umsAdmin.setPassword(passwordEncoder.encode(umsAdmin.getPassword()));
    }

}
