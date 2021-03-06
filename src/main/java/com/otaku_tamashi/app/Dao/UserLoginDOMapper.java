package com.otaku_tamashi.app.Dao;

import com.otaku_tamashi.app.POJO.DO.UserLoginDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login
     *
     * @mbg.generated Sat Apr 06 16:01:24 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login
     *
     * @mbg.generated Sat Apr 06 16:01:24 CST 2019
     */
    int insert(UserLoginDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login
     *
     * @mbg.generated Sat Apr 06 16:01:24 CST 2019
     */
    int insertSelective(UserLoginDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login
     *
     * @mbg.generated Sat Apr 06 16:01:24 CST 2019
     */
    UserLoginDO selectByPrimaryKey(Long id);
    UserLoginDO selectByLogin(@Param(value = "username")String username,@Param(value = "password") String password);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login
     *
     * @mbg.generated Sat Apr 06 16:01:24 CST 2019
     */
    int updateByPrimaryKeySelective(UserLoginDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login
     *
     * @mbg.generated Sat Apr 06 16:01:24 CST 2019
     */
    int updateByPrimaryKey(UserLoginDO record);
}