package com.otaku_tamashi.app.Dao;

import com.otaku_tamashi.app.POJO.DO.NewsDO;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Mon Apr 08 19:34:46 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Mon Apr 08 19:34:46 CST 2019
     */
    int insert(NewsDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Mon Apr 08 19:34:46 CST 2019
     */
    int insertSelective(NewsDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Mon Apr 08 19:34:46 CST 2019
     */
    NewsDO selectByPrimaryKey(Long id);
    NewsDO  selectByListId(Long listid);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Mon Apr 08 19:34:46 CST 2019
     */
    int updateByPrimaryKeySelective(NewsDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Mon Apr 08 19:34:46 CST 2019
     */
    int updateByPrimaryKey(NewsDO record);
}