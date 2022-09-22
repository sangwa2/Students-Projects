/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var c = 1;
var global_c = 0;



$(document).ready(() => {


//    alert($('object').height() + ' ' + $('.content').height());


    var path = window.location.pathname;

    var path_box = path.split('/')[2];

    if (path_box === 'content.html') {
        //get the content height
//        var h = $('#content').height();
//        $('.cont_obj').height($('.content').height());
//        height_obj=h;
//        alert('h in content: '+height_obj);
    }
    if (path_box === 'index.html') {

    }

    Homepage.UI();
});

class Homepage {

    static email = '';
    static hide_email2 = false;
    static Init() {
        $('.bottom').hide(0);
        $('.mob_menu')
                .css('height', ' 50px');




    }

    static UI() {
        Homepage.Init();
        Homepage.off();//Hiding the elements with off class
        Homepage.visited_link();
        Homepage.finite_timer();
        Homepage.endless_timer();
        Data_list.delete_click();
        Homepage.manage_margins();
        Homepage.zoom_slide_picture();
        Homepage.book_service();
        $('.humburger').click(() => {
            if ($('.bottom').is(':visible')) {
                $('.bottom').hide(0);
                $('.mob_menu').addClass('small_mob_menu');

                $('.mob_menu')
                        .css('padding-top', ' 10px')
                        .css('display', ' grid')
                        .css('align-items', ' start')
                        .css('height', ' 50px');

            } else {
                $('.bottom').show(0);
                $('.mob_menu')
                        .css('padding-top', ' 10px')
                        .css('display', ' grid')
                        .css('align-items', ' start')
                        .css('height', ' auto');
            }
        });
        $('.home_picture').mouseover(function () {

        });
        $('.home_picture').mouseleave(function () {

        });
    }
    static off() {
        $('.off').hide(0);



        function media(x) {
            if (x.matches) { // If media query matches
                $('.rooms  .overlay').delay(300).show('drop', {direction: 'left'}, 1000);

                $('.left_arrow, .right_arrow').css('top', 55 + '%');


            } else {
                $('.rooms  .overlay').hide(0);
            }
        }

        var x = window.matchMedia("(max-width: 600px)");
        media(x); // Call listener function at run time
        x.addListener(media); // Attach listener function on state changes






    }

    static visited_link() {
        $('.home_links').click(function () {
            $('.home_links').removeClass('visited_link');
            $(this).addClass('visited_link');


        });
    }

    static show_error() {}

    static finite_timer() {
        setTimeout(function () {
            $('.danger').show();
        }, 2500);
    }

    static endless_task() {
        //        console.log('WE are displaying every 2.5 sec!!');


    }

    static show_wait() {

        var bg = $(document.createElement('div'));
        bg.addClass('bg_overlay full_h_left')
                .on('click', function () {
                    $(this).hide(0);
                    $('.dialog, .progress_pane').hide(0);
                })
                .appendTo('body');
        return bg;
    }

    static progress() {
        var win_w = $(window).width();
        var win_h = $(window).height();
        var hw = win_w / 2;
        var hh = win_h / 4 + $(window).scrollTop();
        var dis = Homepage;
        var progress_pane = dis.row('progress_pane brd').css('top', hh).css('left', hw - 100);
        progress_pane.appendTo('body');
        return progress_pane;

    }

    static row(class_name) {
        return $(document.createElement('div')).addClass(class_name);
    }

    static delete_dialog(top) {

        var dis = Homepage;
        var btn_delete = dis.row('dialog_ok pad hcenter vcenter hand_cursor').on('click', function () {
            $('.data_field').each((index, item) => {
                if ($(item).data('bind') === 'rec1') {
//                    $('.bg_overlay').hide();
                    $('.dialog').css('top', $(window).scrollTop()).hide('drop', {direction: 'up'}, 50);
                }
                dis.progress();
                $('.progress_pane').show();
            });
        }).html('Ok');
        var btn_update = dis.row('dialog_cancel hcenter vcenter hand_cursor pad').on('click', function () {
            $('.bg_overlay').remove();
            $('.dialog').remove();
            $('.progress_pane').hide(0);
        }).html('Cancel');
        var dialog = dis.row('dialog row col_c1 ').append(dis.row('titte pad').html('Comfirmation'))
                .append(dis.row('body row col_c1 ')
                        .append(dis.row('content hcenter').html('Do you really want to delete this record?'))
                        .append(dis.row('buttons row col_c2 bottom_left')
                                .append(btn_update)
                                .append(btn_delete))
                        )
                .css('top', top)
                .appendTo('body').hide(0);
        return dialog;

    }

    static user_form() {
        var userid = 0;
        var mass_id = 0;
        var h = Homepage, txt = $(document.createElement('input')).attr('type', 'text'),
                btn_save = $(document.createElement('input')).attr('type', 'button');
        if (userid === 1) {

        } else if (userid === 0) {//The user is not registered

            //     Mass list
            var user_small_form = h.row('new_user_form');
            var next_sunday_mass = h.row('mass_box row ')
                    .append(h.row('mass_plan_title col_lg_12 hand_cursor col_md_12 col_sm_12 pad').css('font-size', '20px').css('text-transform', 'Capitalize').html('service on 13th-August 2020'))
                    .append(h.row('mass1 mass_data col_lg_3  hand_cursor col_md_3 col_sm_12 hcenter vcenter relate').on('click', ticked).append(h.row('txt').html('9h:00, Peter')).append(h.row('tick top_right')).attr('data-time', '9h:00').attr('data-mass_id', '200'))
                    .append(h.row('mass2 mass_data col_lg_3  hand_cursor col_md_3 col_sm_12 hcenter vcenter relate').on('click', ticked).append(h.row('txt').html('13h:00,  Prince')).append(h.row('tick top_right')).attr('data-time', '13h:00').attr('data-mass_id', '300'))
                    .append(h.row('mass3 mass_data col_lg_3  hand_cursor col_md_3 col_sm_12 hcenter vcenter relate').on('click', ticked).append(h.row('txt').html('16h:00, Patrick')).append(h.row('tick top_right')).attr('data-time', '16h:00').attr('data-mass_id', '450'))
                    .append(h.row('mass4 mass_data col_lg_3  hand_cursor col_md_3 col_sm_12 hcenter vcenter relate').on('click', ticked).append(h.row('txt').html('18h:00, John')).append(h.row('tick top_right')).attr('data-time', '18h:00').attr('data-mass_id', '130'));
            next_sunday_mass.appendTo(user_small_form);
            function ticked() {
                $('.tick').hide(0);
                $(this).children('.tick').show();
                //Get the mass id and the user tel, email
                mass_id = $(this).data('time');
                var emali = Homepage.email;
                var tel = $('.txt_tel').val();
                $('.selection').html('selected mass: ' + mass_id + ' email: ' + emali + ' tel: ' + tel + '');
            }


            //user form 
            user_small_form.append(h.row('title pad').html('Enter your email (You will be sent a verivification code through email)'))
                    .append(h.row('danger email_tel'))
                    .append(
                            h.row('form_row pad row email_2')
                            .append(h.row('label vcenter').text('Email').addClass('col_lg_1 col_md_3 col_sm_12'))
                            .append(txt.addClass('textbox txt_email pad col_lg_11 col_md_9 col_sm_12').attr('placeholder', 'Email'))
                            )
                    .append(
                            h.row('form_row pad row')
                            .append(h.row('label vcenter').text('Telephone').addClass('col_lg_1 col_md_3 col_sm_12'))
                            .append($(document.createElement('input')).attr('type', 'text').addClass('textbox txt_tel pad col_lg_11 col_md_9 col_sm_12').attr('placeholder', 'Telephone'))
                            
                            )
                    .append(h.row('form_row selection  ').html(''))
                    .append(
                            h.row('form_row pad row').append(btn_save.val('Book').addClass('btn pad').on('click', save_booking)
                            )
                            );
            $(user_small_form).hide(0);

            user_small_form.appendTo('body');
            if (Homepage.hide_email2) {
                $('.txt_email').val(Homepage.email);
                $('.txt_email').prop('disabled', true);
            }
        }
        function save_booking() {
            var emali = (Homepage.email !== '') ? Homepage.email : $('.txt_email').val();
            var tel = $('.txt_tel').val();
            alert('Email: ' + emali + ' tel: ' + tel);
            if (emali !== '' && tel !== '') {
                $('.selection').html('Hide email : ' + Homepage.hide_email2 + ' selected mass: <span>' + mass_id + '</span> email: ' + emali + ' tel: ' + tel + '');
            } else {
                $('.danger.email_tel').html('You have to Your email and telephone');
            }
        }

    }
    static endless_timer() {

        setTimeout(function () {
            //work to do
            Homepage.endless_task();
            Homepage.endless_timer();
            $('.room_cats').fadeOut(500);
            $('.room_cat' + c).fadeIn(500);
            console.log(' pic: ' + c);
            if (c === 4) {
                c = 1;
                $('.room_cat' + c).show();
            }

            c += 1;
            global_c += 1;
            

            //Hide the bg after clicking on boook now button
            if (global_c === 1 && Homepage.hide_email2) {//note the globalc is et to zero when the user click the button

                $('.dialog, .progress_pane').hide(0, function () {
                    $('.bg_overlay').css('opacity', '.5').mouseover(function () {
                        $(this).css('cursor', 'pointer');
                    });
                    Homepage.user_form();
                });
            }
        }, 4000);
    }

    static manage_margins() {
        $('.mt').each((index, item) => {
            console.log('add margin top: ' + index + ' classes: ' + $(this).attr('class'));

            $(item).css('margin-top', $(this).data('mt') + 'px');
        });
    }

    static zoom_slide_picture() {
        var win_width = $(window).width();
        var left_space = (win_width - 600) / 2;
        //img div
        var img = $(document.createElement('div'))
                .addClass('zoom_img no_select');

        var parent_pic = '';
        var count = 1;

        $('.zoom_icon').click(function () {
            count += 1;

            var src = (parent_pic === 'cat1')
                    ? 'pic_30.jpeg' : (parent_pic === 'cat2')
                    ? 'pic_18.jpeg' : 'pic_14.jpeg';

            parent_pic = $(this).parent('.pic_cards').data('pic');

            Homepage.show_wait();
            //img tag
            img.appendTo('body');
            var img_tag = $(document.createElement('img')).addClass('img_tag no_select').attr('height', 500).attr('width', 800)
                    .attr('src', 'images/' + $(this).parent('.pic_cards').data('pic'));
            img_tag.appendTo(img);

            var img_height = $(img_tag).height() / 2;
            var win_width = $(window).width();
            var img_left = (win_width - $(img_tag).attr('width')) / 2;

            //Description div

            var descr = Homepage.row('img_descr').css('top', img_height * 2 + 30);
            descr.appendTo('body');

            //Book now
            var book_now_link = Homepage.row('book_now_link top_right pad hand_cursor').html('Book now').appendTo(img).on('click', go_booking);

            //Arrows
            var arrow_box = Homepage.row('arrow_box')
                    .addClass('full_left').css('position', 'absolute').css('z-index', 11).css('left', 0).css('top', img_height - 64)
                    .append(Homepage.row('left_arrow').css('width', 70).addClass('full_h_left').on('click', left_arrow_click))
                    .append(Homepage.row('right_arrow').css('width', 70).addClass('full_h_right').on('click', right_rrow_click))
                    .appendTo(img);

            //Change the bg on click and the opacity to darker
            $('.bg_overlay').css('opacity', '0.9');
            $('.bg_overlay').click(function () {
                $('.zoom_img').hide(0);
                $(arrow_box).remove();
                $(img_tag).remove();
                $(descr).hide();
            }).mouseover(function () {
                $(this).css('cursor', 'pointer');
            });
            $('.zoom_img').show(0);

            function show_descr() {
                $(descr).hide(0).show('drop', {direction: 'down'}, 200);
            }
            function left_arrow_click() {
                if (parent_pic === 'cat1') {
                    $('.img_tag').attr('src', 'images/' + $('.cat2').data('pic'));
                    $(descr).html($('.cat2').children('.bottom_left').html());
                    show_descr();
                    parent_pic = 'cat2';
                } else if (parent_pic === 'cat2') {
                    $('.img_tag').attr('src', 'images/' + $('.cat3').data('pic'));
                    $(descr).html($('.cat3').children('.bottom_left').html());
                    show_descr();
                    parent_pic = 'cat3';
                } else {
                    $('.img_tag').attr('src', 'images/' + $('.cat1').data('pic'));
                    $(descr).html($('.cat1').children('.bottom_left').html());
                    show_descr();
                    parent_pic = 'cat1';
                }
            }
            function right_rrow_click() {
                if (parent_pic === 'cat3') {
                    $('.img_tag').attr('src', 'images/' + $('.cat2').data('pic'));
                    $(descr).html($('.cat2').children('.bottom_left').html());
                    show_descr();
                    parent_pic = 'cat2';
                } else if (parent_pic === 'cat2') {
                    $('.img_tag').attr('src', 'images/' + $('.cat1').data('pic'));
                    $(descr).html($('.cat1').children('.bottom_left').html());
                    show_descr();
                    parent_pic = 'cat1';
                } else {
                    $('.img_tag').attr('src', 'images/' + $('.cat3').data('pic'));
                    $(descr).html($('.cat3').children('.bottom_left').html());
                    show_descr();
                    parent_pic = 'cat3';
                }
            }

            function go_booking() {

                window.location.replace('http://localhost:8383/Cchristus_front/booking_page.html?cat=' + parent_pic);
                $('.display_post').html('We have posted this, ...');
            }
        });

    }

    static media() {
        function media(x) {
            if (x.matches) { // If media query matches



            } else {
                document.body.style.backgroundColor = "pink";
            }
        }

        var x = window.matchMedia("(max-width: 600px)");
        media(x); // Call listener function at run time
        x.addListener(media); // Attach listener function on state changes
    }

    static book_service() {
        $('.btn_service').click(() => {
            if ($('.txt_email1').val() !== '') {
                global_c = 0;
                Homepage.show_wait();
                Homepage.progress();
                Homepage.email = $('.txt_email1').val();
                Homepage.hide_email2 = true;
                $('.progress_pane').css('z-index', 12);
                $('.bg_overlay').click(function () {
                    $('.new_user_form').hide(0);
                });
            } else {
                $('.txt_email1').css('background-color', '#f1b2b2');
                $('.txt_email1').keyup(function () {
                    $('.txt_email1').css('background-color', '#fff');
                });
            }
        });
        $('.room1').click(function () {
            Homepage.show_wait();
       
            Homepage.hide_email2 = false;
            $('.progress_pane').css('z-index', 12);
            Homepage.user_form();
            $('.bg_overlay').click(function () {
                $('.new_user_form').hide(0);
            });
        });
    }
}

class Forms {
}

class Data_list {

    static delete_click() {
        $('.opt > .btn_delete').click(function () {
            if ($('.dialog').length > 0) {
                Homepage.show_wait();
                $('.dialog').css('top', $(window).scrollTop()).show('drop', {direction: 'up'}, 200);
            } else {
                Homepage.show_wait();
                Homepage.delete_dialog($(window).scrollTop());
                $('.dialog').css('top', $(window).scrollTop()).show('drop', {direction: 'up'}, 200);
            }

            return false;
        });

    }
    static update_click() {
        $('.opt > .btn_update').click(function () {
            console.log('About to Update the thing');
        });
    }
}