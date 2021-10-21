/*
 * Implementing the service of f_end_class_category.
 *  .
 */
package com.codeguru.g_ultimate.service;

import com.codeguru.g_ultimate.dao.Dao_f_end_class_category;
import com.codeguru.g_ultimate.models.Mdl_f_end_class_category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SANGWA
 */
@Service
public class Srv_f_end_class_category_impl implements Srv_f_end_class_category {

    Dao_f_end_class_category dao_f_end_class_category;

    @Autowired
    public void setDao_f_end_class_category(Dao_f_end_class_category dao_f_end_class_category) {
        this.dao_f_end_class_category = dao_f_end_class_category;
    }

    @Override
    public List<Mdl_f_end_class_category> all_f_end_class_categorys() {
       return dao_f_end_class_category.all_f_end_class_categorys();
    }

    @Override
    public void add_f_end_class_category(Mdl_f_end_class_category f_end_class_category) {
      dao_f_end_class_category.add_f_end_class_category(f_end_class_category);
    }

    @Override
    public void delete_f_end_class_category(int f_end_class_category) {
        dao_f_end_class_category.delete_f_end_class_category(f_end_class_category);
    }

    @Override
    public void update_f_end_class_category(Mdl_f_end_class_category f_end_class_category) {
       dao_f_end_class_category.update_f_end_class_category(f_end_class_category);
    }

    @Override
    public Mdl_f_end_class_category find_f_end_class_categoryBy_id(int f_end_class_category) {
        return dao_f_end_class_category.find_f_end_class_categoryBy_id(f_end_class_category);
    }

    @Override
    public int get_last_f_end_class_category() {
        return dao_f_end_class_category.get_last_f_end_class_category();
    }
 
}
