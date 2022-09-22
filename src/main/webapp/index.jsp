<%-- 
    Document   : index
    Created on : May 27, 2020, 10:47:11 PM
    Author     : SANGWA
--%>

<%@include file="header_footer/directives.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
      <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v4.1.1">

        <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/navbars/">

        <!-- Bootstrap core CSS -->
        <link href="${root}/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
            .navbar a{
                color: #0e2c39;font-weight: 400;
            }
        </style>        <title>Home</title>
    </head>
    <body class="homepage">

        <%@include file="header_footer/sessionless_header.jsp" %>

        <div class="content cont_obj">
            <div class="breadcrumb vcenter pad">
                <a href="index.html">  Home </a>   / 
            </div>

            <div class="home_picture">
                <div class="text_over">
                    <div class="big">Book a seat in a church service</div>
                    <div class="small">Be aware of Covid-19</div>
                    <div class="mass_book row row_c3 ">
                        <div>
                            <form action="action">
                                <input type="email" class="textbox txt_email1" placeholder="Enter email (example@gmail.com)" required name="name"   />
                            </form>      
                        </div>
                        <div >
                            <button type="submit" class="btn_service">    Book Now  </button>
                        </div>
                        <div  class="row row_c2 mt_15 andalso"> 
                            <div class="  txt">And also you can book, ...</div>
                            <div class="row pt_30 room_hall">
                                <div class="col_lg_6 col_md_6 col_sm_6 vcenter relate rm">Room <span> </span></div>
                                <div class="col_lg_6 col_md_6 col_sm_6 vcenter relate hl">Hall <span> At best price</span> </div>
                            </div>
                        </div>
                    </div>

                </div>    
            </div>


            <div class="row row_title w_sml">
                <div class="col_lg_12 col_md_12 col_sm_12   vcenter hcenter pad_2"><h2>Only few steps required to get started</h2></div>
            </div>
            <div class="row  w_sml pad shortcut small_vgap  brd_c ">
                <div class="col_lg_4 col_md_4 col_sm_12 relate titles  "><h3>Church service</h3> </div>
                <div class="col_lg_4 col_md_4 col_sm_12 relate  titles  "><h3>Rooms for stay</h3> </div>
                <div class="col_lg_4 col_md_4 col_sm_12 relate titles "><h3>Hall for rent</h3> </div>
                <div class="col_lg_4 col_md_4 col_sm_10 relate   rooms pic1" title="Book to attend a church service">
                    <span class="overlay off">Church service</span>
                    <!--<button class="pad small_w_90 bigger_mass ">Book a Church service</button>--> 
                </div>
                <div class="col_lg_4 col_md_4 col_sm_10 relate rooms  pic2 brd_c" title="Book a room if you want to stay">
                    <span class="overlay off"> Rooms  </span>
                    <div class="room_cats room_cat1 abs1 " >
                        <div data-bind="cat1" data-pic="pic_14.jpeg" class="relate pic_cards cat1" >
                            <div data-bind="cat1" class="zoom_icon hand_cursor abs "  title="Click to zoom"> </div>
                            <div class="bottom_left  pad" >Rfr 30,000 single - Rfr 40,000 couple</div>
                        </div>
                    </div>
                    <div class="room_cats room_cat2 abs2">
                        <div data-bind="cat2" data-pic="pic_30.jpeg" class="relate pic_cards cat2">
                            <div data-bind="cat2"  class="zoom_icon hand_cursor abs" title="Click to zoom"> </div>
                            <div class="bottom_left pad" >Rfr 18,000 single - Rfr 25,000 couple</div>
                        </div>
                    </div>
                    <div class="room_cats room_cat3 abs3" >
                        <div data-bind="cat3" data-pic="pic_18.jpeg" class="relate pic_cards cat3">
                            <div data-bind="cat3"  class="zoom_icon hand_cursor abs" title="Click to zoom"> </div>
                            <div class="bottom_left pad" >Rfr 14,000 single - Rfr 18,000 couple</div>
                        </div>
                    </div>

                    <!--<button class="pad small_w_90 bigger_hotel ">Book a room</button>-->
                </div>
                <div class="col_lg_4 col_md_4 col_sm_10  rooms  pic3 relate" title="Bokk ahall for events (Parties, meeting,  etc)">
                    <span class="overlay off">Halls (meetings, parties, etc)</span>
                    <div data-bind="cat3"  class="zoom_icon hand_cursor abs bottom_left" title="Click to zoom"> </div>
                    <!--<button class="pad small_w_90 bigger_hall ">Book a hall</button>-->
                </div>
            </div>


        </div>


        <%@include file="header_footer/footer.jsp" %>


        <script src="${root}/web_scripts/db.js" type="text/javascript"></script>
  <script>
            var h = 0;
            $(document).ready(() => {
                h = height_obj;
                get_h();
                $('.rooms').mouseover(function () {
//                    $(this).children('button').show('drop', {direction: 'down'}, 400);
//                    $(this).children('button').css('opacity', '1');
                });
                $('.rooms').mouseleave(function () {
//                    $(this).children('button').css('opacity', '0');
                });
                show_room_hall();
                //You content

                $('#copy').html('Copyrights' + new Date().year());
            });


            function show_room_hall() {


                $(window).load(function () {
                    $('.rm').show('drop', {direction: 'down'}, 400).delay(400, function () {
                        $('.hl').show('drop', {direction: 'down'}, 400, function () {
                            $('.hl').css('display', 'grid');
                            $('.hl').css('align-items', 'center');
                        });

                        $('.rm, .hl').css('display', 'grid');
                        $('.rm').css('align-items', 'center');
                    });
                });

            }
            function get_h() {
                setTimeout(function () {
                    get_h();
                    console.log('self file: ' + h);
                }, 1500);
            }
        </script>    </body>
</html>

