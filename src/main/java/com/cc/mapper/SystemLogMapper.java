package com.cc.mapper;

import com.cc.entity.Day7Chart;
import com.cc.entity.SystemLog;

import java.util.List;

/**
 * system_log
 */
public interface SystemLogMapper {


    /**
     * 根据条件 查询全部listPageAccount
     */

    public List<SystemLog> listPageSystemLog(SystemLog systemLog);

    /**
     * 获取SystemLog的数量
     */
    public Integer getSystemLogCount();


    public void insert(SystemLog systemLog);

    /**
     * 有条件的更新
     */

    public void insertSelective(SystemLog systemLog);

    /**
     * 根据主键有条件的更新
     */

    public void updateByPrimaryKeySelective(SystemLog systemLog);

    /**
     * 根据主键查询(唯一)
     */
    public SystemLog getSystemLogById(Integer id);

    /**
     * 根据根据条件查询SystemLog
     */
    public List<SystemLog> listSystemLog(SystemLog systemLog);

    /**
     * 更新SystemLog
     */
    public void updateSystemLog(SystemLog systemLog);

    /**
     * 很据实体类删除
     */

    public void deleteSystemLog(SystemLog systemLog);

    /**
     * 根据主键删除
     */
    public void deleteSystemLogByIds(String[] id);

    public List<Day7Chart> count7Day();

    public Integer sum(SystemLog systemLog);


}