package com.luna.jpa.entity.base;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 实体通用父类
 * </p>
 *
 * @package: com.luna.orm.jpa.entity.base
 * @description: 实体通用父类
 * @author: yangkai.shen
 * @date: Created in 2018/11/7 14:01
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditModel implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", nullable = false, updatable = false)
    @CreatedDate
    private Date createTime;

    /**
     * 上次更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_time", nullable = false)
    @LastModifiedDate
    private Date lastUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
