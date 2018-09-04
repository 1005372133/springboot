package cn.wmyskxz.springboot.common;

import java.util.List;

public interface BaseDao<T extends BaseEntity> {
    int insert(T var1);

    int insertSelective(T var1);

    int updateByPrimaryKey(T var1);

    int updateByPrimaryKeySelective(T var1);

    T selectByPrimaryKey(Object var1);

    int deleteByPrimaryKey(Object var1);

    List<T> queryByList(BasePage var1);

    int queryByCount(BasePage var1);

    List<T> queryByPage(BasePage var1);
}
