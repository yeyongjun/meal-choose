package com.develop.meal.dao.dao;

import com.sinafenqi.commons.BaseJdbcUtils;
import com.sinafenqi.commons.model.Criteria;
import com.sinafenqi.commons.model.JdbcResult;
import com.sinafenqi.commons.model.PageRequest;
import com.sinafenqi.commons.model.PageResponse;
import com.develop.meal.dao.po.UserPo;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class UserDao {
    private final static String TABLE_NAME = "user";
    private Map<String, String> dbMapping = new HashMap<>();
    @Resource(name = "templateSample")
    private JdbcTemplate template;

    @PostConstruct
    public void init() {
        dbMapping.put("id", "id");
        dbMapping.put("name", "name");
        dbMapping.put("gender", "gender");
        dbMapping.put("idCard", "id_card");
        dbMapping.put("mobile", "mobile");
        dbMapping.put("realNameStatus", "real_name_status");
        dbMapping.put("email", "email");
        dbMapping.put("createdAt", "created_at");
        dbMapping.put("updatedAt", "updated_at");
    }

    public boolean insert(UserPo user) {
        JdbcResult jdbcResult = BaseJdbcUtils.getInsert(getTable(), user, dbMapping);
        return template.update(jdbcResult.getSql(), jdbcResult.getParams()) == 1;
    }

    public boolean insertIgnore(UserPo user) {
        JdbcResult jdbcResult = BaseJdbcUtils.getInsertIgnore(getTable(), user, dbMapping);
        return template.update(jdbcResult.getSql(), jdbcResult.getParams()) == 1;
    }

    /**
     * @return true when insert
     */
    public boolean insertOrUpdate(UserPo user) {
        JdbcResult jdbcResult = BaseJdbcUtils.getInsertOrUpdate(getTable(), user, dbMapping);
        return template.update(jdbcResult.getSql(), jdbcResult.getParams()) == 1;
    }

    public int batchInsert(List<UserPo> users) {
        JdbcResult jdbcResult = BaseJdbcUtils.getBatchInsert(getTable(), users, dbMapping);
        return IntStream.of(template.batchUpdate(jdbcResult.getSql(), jdbcResult.getBatchParams())).sum();
    }

    public boolean update(UserPo user) {
        JdbcResult jdbcResult = BaseJdbcUtils.getUpdate(getTable(), user, dbMapping, "id");
        return template.update(jdbcResult.getSql(), jdbcResult.getParams()) == 1;
    }

    public boolean patch(UserPo user) {
        JdbcResult jdbcResult = BaseJdbcUtils.getPatch(getTable(), user, dbMapping, "id");
        return template.update(jdbcResult.getSql(), jdbcResult.getParams()) == 1;
    }

    public UserPo get(String id) {
        JdbcResult jdbcResult = BaseJdbcUtils.getSelect(getTable(), Criteria.column("id").eq(id));
        try {
            Map<String, Object> dbRow = template.queryForMap(jdbcResult.getSql(), jdbcResult.getParams());
            return BaseJdbcUtils.dbRowToPo(dbRow, dbMapping, UserPo.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public UserPo getOrInsert(UserPo user) {
        UserPo po = this.get(user.getId());
        if (po == null) {
            if (!this.insertIgnore(user)) {
                return this.get(user.getId());
            }
            return user;
        }
        return po;
    }

    public PageResponse<UserPo> getPage(PageRequest pageRequest) {
        JdbcResult jdbcResult = BaseJdbcUtils.getSelectForCount(getTable(), (Criteria) null);
        Integer total = template.queryForObject(jdbcResult.getSql(), jdbcResult.getParams(), Integer.class);
        if(total == 0) {
            return new PageResponse<>(0, null);
        }

        jdbcResult = BaseJdbcUtils.getSelect(getTable(), (Criteria) null, pageRequest);
        List<UserPo> datas = template.queryForList(jdbcResult.getSql(), jdbcResult.getParams()).stream()
                .map(dbRow -> BaseJdbcUtils.dbRowToPo(dbRow, dbMapping, UserPo.class))
                .collect(Collectors.toList());
        return new PageResponse<>(total, datas);
    }

    public int delete(String id) {
        JdbcResult jdbcResult = BaseJdbcUtils.getDelete(getTable(), Criteria.column("id").eq(id));
        return template.update(jdbcResult.getSql(), jdbcResult.getParams());
    }

    private String getTable() {
        return TABLE_NAME;
    }
}