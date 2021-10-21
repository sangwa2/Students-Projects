package com.codeguru.g_ultimate.dao;

import com.codeguru.g_ultimate.models.Mdl_rel_query_category;
import java.util.List;

/**
 *
 * @author SANGWA
 */
public interface Dao_rel_query_category {

    public List<Mdl_rel_query_category> all_rel_query_categorys();

    public void add_rel_query_category(Mdl_rel_query_category rel_query_category);

    public void delete_rel_query_category(int rel_query_category);

    public void update_rel_query_category(Mdl_rel_query_category rel_query_category);

    public Mdl_rel_query_category find_rel_query_categoryBy_id(int rel_query_category);

    public int querycategoryid_by_categoryname(String name);

    public int get_last_rel_query_category();
}