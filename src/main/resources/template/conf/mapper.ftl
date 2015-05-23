<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${model?lower_case}">
    <select id="list" resultType="${model?lower_case}">
        SELECT *
        FROM ${db}.${model}
        ORDER BY id
    </select>
    <select id="search" resultType="${model?lower_case}">
        SELECT *
        FROM ${db}.${model}
        WHERE id = ${'#'}{id}
    </select>
    <select id="fuzzy" parameterType="java.util.Map" resultType="${model?lower_case}">
        SELECT * FROM ${db}.${model}
        <where>
        <#assign keys = properties?keys>
        <#list keys as key>
            <if test="${key} != null and ${key} != ''"><#if key_index != 0>AND </#if>${key} LIKE "%"${'#'}{${key}}"%"</if>
        </#list>
        </where>
    </select>
    <update id="modify">
        UPDATE ${db}.${model}
        SET
        <#assign keys = properties?keys>
        <#list keys as key>
            ${key} = ${'#'}{${key}}<#if key_has_next>, </#if>
        </#list>
        WHERE id = ${'#'}{id}
    </update>
    <delete id="remove">
        DELETE FROM ${db}.${model}
        WHERE id = ${'#'}{id}
    </delete>
    <insert id="add" parameterType="${model}" useGeneratedKeys="true" keyProperty="id">
        INSERT INTO ${db}.${model} (
        <#assign keys = properties?keys>
        <#list keys as key>
            ${key}<#if key_has_next>, </#if>
        </#list>
        )
        VALUES (
        <#assign keys = properties?keys>
        <#list keys as key>
            ${'#'}{${key}}<#if key_has_next>, </#if>
        </#list>
        );
    </insert>
</mapper>