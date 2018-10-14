package com.goebuy.service.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goebuy.entity.event.Activity;

import java.util.List;

/**
 * 索引参数与命名参数 
 * @author Administrator
 *
 */
@Repository
public interface ActivityService extends JpaRepository<Activity, Integer> {
    /**
     * 删除事件标记为已删除
     *
     * @param id
     */
    @Modifying      // 说明该方法是修改操作
    @Query("update Activity t set t.deleted=true where t.id=:id")
    void deleteById(@Param("id") Integer id);

    /**
     * 根据商户id获取事件列表
     *
     * @param merchantId
     * @param deleted true 已删除事件，false 未删除事件
     * @return
     */
    List<Activity> findByCreatorAndDeleted(Integer merchantId, Boolean deleted);
}
