/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Front_layouts;

/**
 *
 * By SANGWA At CODEGURU LTD. sangwa22@gmail.com using hp
 */
public class Front_layouts {

    public String bg_overlay() {
        return "<div class=\"overlay  off \"> This is overlay    </div>";
    }

    public String delete_dialog() {
        return "   <div class=\"delete_dialog off\">\n"
                + "            <div class=\"delete_dialog_title\">Title</div>\n"
                + "            <div class=\"delete_dialog_contents\">Contents</div>\n"
                + "            <div class=\"delete_dialog_btns\">\n"
                + "                <div class=\"delete_dialog_yes\">yes</div>\n"
                + "                <div class=\"delete_dialog_no\">No</div>\n"
                + "            </div>\n"
                + "</div>";
    }
}
