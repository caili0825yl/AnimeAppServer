package com.otaku_tamashi.app.POJO.DO;

import java.util.Date;

public class NewsListDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newslist.id
     *
     * @mbg.generated Mon Apr 08 12:35:05 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newslist.type
     *
     * @mbg.generated Mon Apr 08 12:35:05 CST 2019
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newslist.title
     *
     * @mbg.generated Mon Apr 08 12:35:05 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newslist.font
     *
     * @mbg.generated Mon Apr 08 12:35:05 CST 2019
     */
    private String font;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column newslist.date
     *
     * @mbg.generated Mon Apr 08 12:35:05 CST 2019
     */
    private Date date;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newslist.id
     *
     * @return the value of newslist.id
     *
     * @mbg.generated Mon Apr 08 12:35:05 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newslist.id
     *
     * @param id the value for newslist.id
     *
     * @mbg.generated Mon Apr 08 12:35:05 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newslist.type
     *
     * @return the value of newslist.type
     *
     * @mbg.generated Mon Apr 08 12:35:05 CST 2019
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newslist.type
     *
     * @param type the value for newslist.type
     *
     * @mbg.generated Mon Apr 08 12:35:05 CST 2019
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newslist.title
     *
     * @return the value of newslist.title
     *
     * @mbg.generated Mon Apr 08 12:35:05 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newslist.title
     *
     * @param title the value for newslist.title
     *
     * @mbg.generated Mon Apr 08 12:35:05 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newslist.font
     *
     * @return the value of newslist.font
     *
     * @mbg.generated Mon Apr 08 12:35:05 CST 2019
     */
    public String getFont() {
        return font;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newslist.font
     *
     * @param font the value for newslist.font
     *
     * @mbg.generated Mon Apr 08 12:35:05 CST 2019
     */
    public void setFont(String font) {
        this.font = font == null ? null : font.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column newslist.date
     *
     * @return the value of newslist.date
     *
     * @mbg.generated Mon Apr 08 12:35:05 CST 2019
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column newslist.date
     *
     * @param date the value for newslist.date
     *
     * @mbg.generated Mon Apr 08 12:35:05 CST 2019
     */
    public void setDate(Date date) {
        this.date = date;
    }
}