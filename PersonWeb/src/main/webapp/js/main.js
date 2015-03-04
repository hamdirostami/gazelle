function dateInitialize() {
    $(".date_picker").datepicker({
        dateFormat: 'yy/mm/dd',
        changeMonth: true,
        changeYear: true,
        showOn: 'button',
        buttonImage: 'img/calendar.png',
        buttonImageOnly: true
    });
    $(".date_picker").mask("9999/99/99", {placeholder: "yyyy/mm/dd"});
}

function isNumberKey() {

        var charCode = window.event.keyCode;
        // 31: Unit Separator
        // 48: 0
        // 57: 9
        if (charCode > 31 && (charCode < 48 || charCode > 57) && !(charCode == 46)) {
            window.event.preventDefault();

    }
}

function openDialog(dialogName){
    openModalDialog([{name:'dialogName', value:dialogName}]);
}