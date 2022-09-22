

$(document).ready(function () {
    save_health();
    save_education();
    save_bank();
    save_profile();

//    alert('js is working');

// delete
delete_bank();
delete_health();
delete_education() ;
});

function save_profile() {

    $('#user_btn_save').click(function (e) {//Happen only when the user clicks the button
        e.preventDefault();

        var txt_search_card = $('#txt_search_card').val();
        var txt_name = $('#txt_name').val();
        var txt_surname = $('#txt_surname').val();
        var txt_account_category = $('#txt_account_category').val();
        var txt_gender = $('#txt_gender').val();
        var txt_tel = $('#txt_tel').val();
        var txt_username = $('#txt_username').val();
        var txt_password = $('#txt_password').val();

        if (txt_search_card !== '' && txt_name !== '' && txt_surname !== '' && txt_account_category !== '' && txt_gender !== '' && txt_tel !== '' && txt_username !== '' && txt_password !== '') {
            var root = $('.root').val();
            var req = 'yes';
            $.post(root + '/users', {txt_search_card: txt_search_card,txt_name: txt_name, txt_surname: txt_surname, txt_account_category: txt_account_category, txt_gender: txt_gender, txt_tel: txt_tel, txt_username: txt_username, txt_password: txt_password}, function (data) {
                console.log('Data: ' + data);
            }).complete(function () {

            });

            $('#txt_profile_id').val('');
            $('#txt_search_card').val('');
            $('#txt_name').val('');
            $('#txt_account_category').val('');
            $('#txt_gender').val('');
            $('#txt_tel').val('');
            $('#txt_username').val('');
            $('#txt_password').val('');
            window.location.reload();
            //Refresh data
        } else {
            alert('You have to enter all the fields!! ');
        }
    });
}
function save_account() {

    var username = $('#txt_username').val();
    var password = $('#txt_password').val();
    var account_category = $('#txt_account_category').val();
    var profile = $('#txt_profile').val();

    if (username !== '' && password !== '' && account_category !== '' && profile !== '') {
        $.ajax({
            type: 'POST',
            url: 'api/new_data/new_account/' + username + '/' + password + '/' + account_category + '/' + profile,
            success: function (result) {

            }
        });
        $('#txt_account_id').val('');
        $('#txt_username').val('');
        $('#txt_password').val('');
        $('#txt_account_category').val('');
        $('#txt_profile').val('');
        //Refresh data
    } else {
        alert('You have to enter all the fields!! ');
    }

}
function save_account_category() {

    var name = $('#txt_name').val();

    if (name !== '') {
        $.ajax({
            type: 'POST',
            url: 'api/new_data/new_account_category/' + name,
            success: function (result) {

            }
        });
        $('#txt_account_category_id').val('');
        $('#txt_name').val('');
        //Refresh data
    } else {
        alert('You have to enter all the fields!! ');
    }
}
function save_bank() {

    $('.bank_btn_save').click(function (e) {//Happen only when the user clicks the button
        e.preventDefault();
//        var bank_id = upd_bank_id;

        var txt_last_transaction_date = $('#txt_last_transaction_date').val();
        var txt_balance = $('#txt_balance').val();
        var txt_account = $('#txt_account').val();

        if (txt_last_transaction_date !== '' && txt_balance !== '' && txt_account !== '') {
            var root = $('.root').val();
            var req = 'yes';
            $.post(root + '/bank', {txt_last_transaction_date: txt_last_transaction_date, txt_balance: txt_balance, txt_account: txt_account}, function (data) {
                console.log('Data: ' + data);
            }).complete(function () {

            });

            $('#txt_bank_id').val('');
            $('#txt_last_transaction_date').val('');
            $('#txt_balance').val('');
            $('#txt_account').val('');
            window.location.reload();
            //Refresh data
        } else {
            alert('You have to enter all the fields!! ');
        }
    });
}
function save_health() {
    $('.health_btn_save').click(function (e) {//Happen only when the user clicks the button
        e.preventDefault();
//        var health_id = upd_health_id;

        var txt_last_check_date = $('#txt_last_check_date').val();
        var txt_hospital_name = $('#txt_hospital_name').val();
        var txt_issue = $('#txt_issue').val();
        var txt_Health_acc = $('#txt_Health_acc').val();

        if (txt_last_check_date !== '' && txt_hospital_name !== '' && txt_issue !== '' && txt_Health_acc !== '') {
            var root = $('.root').val();

            var req = 'yes';
            $.post(root + '/health', {txt_last_check_date: txt_last_check_date, txt_hospital_name: txt_hospital_name, txt_issue: txt_issue, txt_Health_acc: txt_Health_acc}, function (data) {
                console.log('Data: ' + data);
            }).complete(function () {

            });

            $('#txt_last_check_date').val('');
            $('#txt_hospital_name').val('');
            $('#txt_issue').val('');
            $('#txt_Health_acc').val('');
            window.location.reload();
            //Refresh data
        } else {
            alert('You have to enter all the fields!! ');
        }
    });
}
function save_education() {
    $('.educ_btn_save').click(function (e) {//Happen only when the user clicks the button
        e.preventDefault();
//        var education_id = upd_education_id;

        var txt_last_level = $('#txt_last_level').val();
        var txt_school_name = $('#txt_school_name').val();
        var txt_field = $('#txt_field').val();
        var txt_edu_acc = $('#txt_edu_acc').val();


        if (txt_last_level !== '' && txt_school_name !== '' && txt_field !== '' && txt_edu_acc !== '') {
            var root = $('.root').val();
            $.post(root + '/education', {txt_last_level: txt_last_level, txt_school_name: txt_school_name, txt_field: txt_field, txt_edu_acc: txt_edu_acc}, function (data) {
                console.log('Data: ' + data);
            }).complete(function () {

            });
            $('#txt_education_id').val('');
            $('#txt_last_level').val('');
            $('#txt_school_name').val('');
            $('#txt_field').val('');
            $('#txt_edu_acc').val('');
            window.location.reload();
            //Refresh data
        } else {
            alert('You have to enter all the fields!! ');

        }
    });
}
// delete
function delete_bank() {
    $('.link_bank').click(function () {

        var bank_id = $(this).data('bind');
        if (confirm('Do you really want to delete this record?')) {
            $.ajax({
                type: 'get',
                url: $('.root').val() + '/bank?action=delete&bank_id=' + bank_id,
                success: function (data) {
                    alert(data);
                }
            }).done(function () {
                window.location.reload();
            });
        }

        return false;
    });
    }
    
    
    function delete_health() {
    $('.link_health').click(function () {

        var health_id = $(this).data('bind');
        if (confirm('Do you really want to delete this record?')) {
            $.ajax({
                type: 'get',
                url: $('.root').val() + '/health?action=delete&health_id=' + health_id,
                success: function (data) {
                    alert(data);
                }
            }).done(function () {
                window.location.reload();
            });
        }

        return false;
    });
    }
    
    function delete_education() {
    $('.link_education').click(function () {

        var education_id = $(this).data('bind');
        if (confirm('Do you really want to delete this record?')) {
            $.ajax({
                type: 'get',
                url: $('.root').val() + '/education?action=delete&education_id=' + education_id,
                success: function (data) {
                    alert(data);
                }
            }).done(function () {
                window.location.reload();
            });
        }

        return false;
    });
    }

