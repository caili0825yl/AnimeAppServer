package com.otaku_tamashi.app.Dao;

import com.otaku_tamashi.app.POJO.DO.AnimeDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table animelist
     *
     * @mbg.generated Sat Apr 06 16:01:24 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table animelist
     *
     * @mbg.generated Sat Apr 06 16:01:24 CST 2019
     */
    int insert(AnimeDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table animelist
     *
     * @mbg.generated Sat Apr 06 16:01:24 CST 2019
     */
    int insertSelective(AnimeDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table animelist
     *
     * @mbg.generated Sat Apr 06 16:01:24 CST 2019
     */
    AnimeDO selectByPrimaryKey(Long id);
    List<AnimeDO> selectAll();
    Long selectByName(String name);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table animelist
     *
     * @mbg.generated Sat Apr 06 16:01:24 CST 2019
     */
    int updateByPrimaryKeySelective(AnimeDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table animelist
     *
     * @mbg.generated Sat Apr 06 16:01:24 CST 2019
     */
    int updateByPrimaryKey(AnimeDO record);
}