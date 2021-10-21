package com.codeguru.g_ultimate.service;

import com.codeguru.g_ultimate.models.Mdl_f_end_data_list_template;
import java.util.List;

/**
 *
 * For author SANGWA  
 sangwa22@gmail.com 
 */
public interface Srv_f_end_data_list_template {

    public List<Mdl_f_end_data_list_template> all_f_end_data_list_templates();
    
    public void add_f_end_data_list_template(Mdl_f_end_data_list_template f_end_data_list_template);

    public void delete_f_end_data_list_template(int f_end_data_list_template);

    public void update_f_end_data_list_template(Mdl_f_end_data_list_template f_end_data_list_template);

    
    public Mdl_f_end_data_list_template find_f_end_data_list_templateBy_id(int f_end_data_list_template);
    
    public int get_last_f_end_data_list_template();
}
